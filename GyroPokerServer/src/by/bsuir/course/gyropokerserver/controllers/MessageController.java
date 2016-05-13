/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.course.gyropokerserver.controllers;

import by.bsuir.course.gyropokerserver.Entity.Packet;
import by.bsuir.course.gyropokerserver.logic.RoomHandler;
import by.bsuir.course.gyropokerserver.logic.TableHandler;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class MessageController {
    RoomHandler rh = new RoomHandler();
    TableHandler th = new TableHandler();
    
    public ArrayList<String> execute(Packet packet){
        switch(packet.getHeader()){
            case "Login":{
                return rh.checkLoginInfo(packet);
                
            }
            case "TableInfo":{
                return th.getTableInfo(packet.getInfo().get(0));
            }
            
            case "Seat":{
                return th.seatToTable(packet.getInfo().get(0),
                        packet.getInfo().get(1),
                        Integer.parseInt(packet.getInfo().get(2)),
                        Integer.parseInt(packet.getInfo().get(3)));
            }
            case "StandUP":{
                return th.standUP(packet.getInfo().get(0),
                        Integer.parseInt(packet.getInfo().get(1)));
            }
            default:return null;
        }
    }
}
