/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.course.gyropokerserver.controllers;

import by.bsuir.course.gyropokerserver.Entity.Packet;
import by.bsuir.course.gyropokerserver.logic.RoomHandler;

/**
 *
 * @author Admin
 */
public class MessageController {
    RoomHandler rh = new RoomHandler();
    
    public String execute(Packet packet){
        switch(packet.getHeader()){
            case "Login":{
                return rh.checkLoginInfo(packet);
                
            }
            default:return"";
        }
    }
}
