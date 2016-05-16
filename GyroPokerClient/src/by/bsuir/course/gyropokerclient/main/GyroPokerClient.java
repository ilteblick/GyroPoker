/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.course.gyropokerclient.main;

import by.bsuir.course.gyropokerclient.controllers.ConnectionController;
import by.bsuir.course.gyropokerclient.logic.FramesHandler;
import java.io.IOException;

/**
 *
 * @author Admin
 */
public class GyroPokerClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        FramesHandler.getInstance().showConnectionFrame();
        ConnectionController cc = new ConnectionController();
        cc.execute("New connection");
    }
    
}
