/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.course.gyropokerserver.connection;

import by.bsuir.course.gyropokerserver.Entity.ConnectionList;
import by.bsuir.course.gyropokerserver.Entity.Packet;
import by.bsuir.course.gyropokerserver.controllers.MessageController;
import by.bsuir.course.gyropokerserver.utils.PacketCreator;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Reciever extends Thread {

    private DataInputStream dis;
    private MessageController msgCtrl = new MessageController();
    private Socket socket;
    private Sender sender;

    public Reciever(Socket socket, Sender sender) throws IOException {
        this.socket = socket;
        this.sender = sender;
        dis = new DataInputStream(socket.getInputStream());
        start();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Reciever.class.getName()).log(Level.SEVERE, null, ex);
        }
        sender.SendToClient("ServerRunning");

        try {
            String msg;

            while (true) {
                try {
                    msg = dis.readUTF();
                    if ("Close".equals(msg)) {
                        break;
                    }
                    if (msg != null) {
                        PacketCreator creator = new PacketCreator();
                        Packet packet = creator.createPacket(msg);
                        ArrayList<String> responses = msgCtrl.execute(packet);
                        for (String response : responses) {
                            //String response = msgCtrl.execute(packet);
                            if (response.substring(0, 6).equals("Change")) {
                                ConnectionList.getInstance().stream().forEach((connection) -> {
                                    connection.sender.SendToClient(response);
                                });

                            } else {
                                sender.SendToClient(response);
                            }
                            Thread.sleep(100);
                        }

                    }
                } catch (IOException ex) {
                    Logger.getLogger(Reciever.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Reciever.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            dis.close();
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(Reciever.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
