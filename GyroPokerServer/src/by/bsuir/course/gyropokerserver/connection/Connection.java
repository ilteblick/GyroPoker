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
    private DataOutputStream dos;
    
    public Connection(Socket socket) throws IOException{
        this.socket = socket;
        dos = new DataOutputStream(socket.getOutputStream());
    }
    
    public void send() throws IOException{
        dos.writeUTF("ServerRunning");
    }
}
