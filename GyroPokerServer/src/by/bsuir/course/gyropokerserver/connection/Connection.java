/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.course.gyropokerserver.connection;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Admin
 */
public class Connection extends Thread{
    
    private Socket socket;
    private Reciever reciever;
    public Sender sender;
    
    public Connection(Socket socket) throws IOException{
        this.socket = socket;
        this.sender = new Sender(socket);
        this.reciever = new Reciever(socket,sender);
    }
}
