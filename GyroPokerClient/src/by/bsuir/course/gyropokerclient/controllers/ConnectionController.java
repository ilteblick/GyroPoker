/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.course.gyropokerclient.controllers;

import by.bsuir.course.gyropokerclient.logic.ConnectionHandler;
import java.io.IOException;

/**
 *
 * @author Admin
 */
public class ConnectionController {
    
    
    public void execute(String msg) throws IOException{
        switch(msg){
            case "New connection":{
                ConnectionHandler.getInstance().newConnection();
            } 
        }
    }
}
