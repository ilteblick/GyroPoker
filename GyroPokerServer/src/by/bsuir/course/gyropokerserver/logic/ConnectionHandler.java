/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.course.gyropokerserver.logic;

import by.bsuir.course.gyropokerserver.Entity.ConnectionList;
import by.bsuir.course.gyropokerserver.connection.Connection;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Admin
 */
public class ConnectionHandler {
    private static ConnectionHandler instance;
    
    private ConnectionHandler(){
        
    }
    
    public static ConnectionHandler getInstance(){
        if(instance == null){
            instance = new ConnectionHandler();
        }
        return instance;
    }
    
    
    
    public void newConnection(Socket socket) throws IOException{
        Connection con = new Connection(socket);
        ConnectionList.getInstance().add(con);
        con.sender.SendToClient("ServerRunning");
    }
}
