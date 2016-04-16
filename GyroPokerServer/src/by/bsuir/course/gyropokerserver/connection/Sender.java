/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.course.gyropokerserver.connection;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Sender {
    private Socket socket;
    private DataOutputStream dos;
    
    
   public Sender(Socket socket) throws IOException{
       this.socket = socket;
       dos = new DataOutputStream(socket.getOutputStream());
   }
   
   public DataOutputStream getDos(){
       return this.dos;
   }
   
   
   public void SendToClient(String msg){
        try {
            dos.writeUTF(msg);
        } catch (IOException ex) {
            Logger.getLogger(Sender.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
}
