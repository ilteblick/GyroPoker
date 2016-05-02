/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.course.gyropokerserver.controllers;

import by.bsuir.course.gyropokerserver.Entity.Packet;
import by.bsuir.course.gyropokerserver.logic.RoomHandler;
import by.bsuir.course.gyropokerserver.logic.TableHandler;

/**
 *
 * @author Admin
 */
public class MessageController {
    RoomHandler rh = new RoomHandler();
    TableHandler th = new TableHandler();
    
    public String execute(Packet packet){
        switch(packet.getHeader()){
            case "Login":{
                return rh.checkLoginInfo(packet);
                
            }
            case "TableInfo":{
                return th.getTableInfo(packet.getInfo().get(0));
            }
            default:return"";
        }
    }
}
