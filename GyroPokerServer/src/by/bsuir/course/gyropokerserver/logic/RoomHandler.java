/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.course.gyropokerserver.logic;

import by.bsuir.course.gyropokerserver.DAO.GyroPokerDaoImpl;
import by.bsuir.course.gyropokerserver.Entity.Packet;
import by.bsuir.course.gyropokerserver.Entity.Player;

/**
 *
 * @author Admin
 */
public class RoomHandler {
    
    public RoomHandler(){
        
    }
    
    
    public String checkLoginInfo(Packet packet){
        String name = packet.getInfo().get(0);
        String password = packet.getInfo().get(1);
        boolean result = GyroPokerDaoImpl.getInstance().checkLogin(name, password);
        StringBuilder sb = new StringBuilder();
        if(result){
            Player player = GyroPokerDaoImpl.getInstance().getPlayerById(name);
            return ("LoginResponse:Success:" + player.nick + ":" + player.name +
                    ":" + player.surename + ":" + player.address + ":" + 
                    player.phone + ":" + player.email + ":" + Double.toString(player.balance) +
                    ":" + Double.toString(player.playMoney));
        }else{
            return "LoginResponse:Failed";
        }
    }
}
