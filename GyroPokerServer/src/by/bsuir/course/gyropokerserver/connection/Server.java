/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.course.gyropokerserver.connection;

import by.bsuir.course.gyropokerserver.Entity.ConnectionList;
import by.bsuir.course.gyropokerserver.logic.ConnectionHandler;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Server extends Thread{
    private static int port = 1300;
    private ServerSocket serverSocket;
    
    public Server(){
        start();
    }
    
    @Override
    public void run(){
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Started!!!");
            while(true){
                Socket socket = serverSocket.accept();
                //ConnectionHandler.getInstance().newConnection(socket);
                Connection con = new Connection(socket);
                ConnectionList.getInstance().add(con);
                //connectionList.add(con);
                System.out.println("new");
                //con.sender.SendToClient("ServerRunning");
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
