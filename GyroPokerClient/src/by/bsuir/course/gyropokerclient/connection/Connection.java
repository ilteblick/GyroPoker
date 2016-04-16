/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.course.gyropokerclient.connection;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Connection extends Thread{
    private final int port = 1300;
    private String address = "127.0.0.1";
    public Socket socket;
    private Sender sender;
    private Reciever reciever;
    
    public Connection() throws IOException{
        start();
        
    }
    
    @Override
    public void run(){
        try {
            socket = new Socket(address, port);
            sender = new Sender(socket);
            reciever = new Reciever(socket);
        } catch (IOException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Sender getSender(){
        return this.sender;
    }
}
