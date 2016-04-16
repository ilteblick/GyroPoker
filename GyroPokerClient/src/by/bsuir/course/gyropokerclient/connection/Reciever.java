/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.course.gyropokerclient.connection;

import by.bsuir.course.gyropokerclient.controllers.MessageController;
import by.bsuir.course.gyropokerclient.util.PacketCreator;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Reciever extends Thread{
    private Socket socket;
    private DataInputStream dis;
    private MessageController msgCtrl;
    
    
    public Reciever(Socket socket) throws IOException{
        this.socket = socket;
        msgCtrl = new MessageController();
        this.dis = new DataInputStream(socket.getInputStream());
        start();
    }
    
    @Override
    public void run(){
        String msg;
        PacketCreator creator = new PacketCreator();
        while(true){
            try {
                
                msg = dis.readUTF();
                msgCtrl.execute(creator.createPacket(msg));
            } catch (IOException ex) {
                Logger.getLogger(Reciever.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
