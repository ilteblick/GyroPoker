/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.course.gyropokerclient.controllers;

import by.bsuir.course.gyropokerclient.entity.Packet;
import by.bsuir.course.gyropokerclient.logic.ConnectionHandler;
import by.bsuir.course.gyropokerclient.logic.FramesHandler;

/**
 *
 * @author Admin
 */
public class MessageController {
    public void execute(Packet packet){
        switch(packet.getHeader()){
            case "ServerRunning":{
                ConnectionHandler.getInstance().succcessConnection();
                break;
            }
            case "LoginResponse":{
                if("Success".equals(packet.getInfo().get(0))){
                    ConnectionHandler.getInstance().succesLogin(packet);
                }
                break;
            }
            
            case "TableInfo":{
                if("success".equals(packet.getInfo().get(0))){
                    ConnectionHandler.getInstance().tableInfo(packet);
                }
                break;
            }
            case "Change":{
                if("success".equals(packet.getInfo().get(0))){
                    ConnectionHandler.getInstance().makeChanges(packet);
                }
                break;
            }
        }
    }
}
