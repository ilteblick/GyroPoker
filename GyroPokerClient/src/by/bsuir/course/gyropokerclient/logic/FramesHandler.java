/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.course.gyropokerclient.logic;

import by.bsuir.course.gyropokerclient.connection.Connection;
import by.bsuir.course.gyropokerclient.view.ConnectionFrame;
import by.bsuir.course.gyropokerclient.view.LoginFrame;

/**
 *
 * @author Admin
 */
public class FramesHandler {
    private ConnectionFrame cf;
    private LoginFrame lf;
    private static FramesHandler instance;
    
    private FramesHandler(){
        
    }
    
    public static FramesHandler getInstance(){
        if(instance == null){
            instance = new FramesHandler();
        }
        return instance;
    }
    
    public void showConnectionFrame(){
        cf = new ConnectionFrame();
        cf.show();
    }
    
    public void closeConnectionFrame(){
        cf.dispose();
    }
    
    public void showLoginFrame(Connection con){
        lf = new LoginFrame(con);
        lf.show();
    }
    
    public void closeLoginFrame(){
        lf.dispose();
    }
}
