/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.course.gyropokerclient.logic;

import by.bsuir.course.gyropokerclient.connection.Connection;
import by.bsuir.course.gyropokerclient.entity.Packet;
import java.io.IOException;

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
    
    
    Connection con;
    
    public void newConnection() throws IOException{
        con = new Connection();
    }
    
    
    public Connection getConnection(){
        return con;
    }
    
    public void succcessConnection(){
        FramesHandler.getInstance().closeConnectionFrame();
        FramesHandler.getInstance().showLoginFrame(con);
    }
    
    public void succesLogin(Packet packet){
        FramesHandler.getInstance().closeLoginFrame();
        FramesHandler.getInstance().showLobbyFrame(
                con,packet.getInfo()
        );
        
    }
    
    
    public void tableInfo(Packet packet){
        FramesHandler.getInstance().showTable(con, packet.getInfo());
    }
    
    public void makeChanges(Packet packet){
        FramesHandler.getInstance().redrawTable(packet.getInfo());
    }
    
    
}
