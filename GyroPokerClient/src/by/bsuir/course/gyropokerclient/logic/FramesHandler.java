/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.course.gyropokerclient.logic;

import by.bsuir.course.gyropokerclient.connection.Connection;
import by.bsuir.course.gyropokerclient.entity.Player;
import by.bsuir.course.gyropokerclient.entity.Table;
import by.bsuir.course.gyropokerclient.view.ConnectionFrame;
import by.bsuir.course.gyropokerclient.view.LobbyFrame;
import by.bsuir.course.gyropokerclient.view.LoginFrame;
import by.bsuir.course.gyropokerclient.view.TableFrame;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class FramesHandler {
    private ConnectionFrame cf;
    private LoginFrame lf;
    private LobbyFrame lobby;
    private static FramesHandler instance;
    
    private ArrayList<TableFrame> tables = new ArrayList<>();
    
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
    
    public void showLobbyFrame(Connection con, ArrayList<String> info){
        Player player = new Player();
        player.nick = info.get(1);
        player.name = info.get(2);
        player.surename = info.get(3);
        player.address = info.get(4);
        player.phone = info.get(5);
        player.email = info.get(6);
        player.balance = Double.parseDouble(info.get(7));
        player.playMoney = Double.parseDouble(info.get(8));
        
        Table t1 = new Table(info.get(9), info.get(10), info.get(11));
        Table t2 = new Table(info.get(12), info.get(13), info.get(14));
        
        ArrayList<Table> tables = new ArrayList<>();
        tables.add(t1);
        tables.add(t2);
        lobby = new LobbyFrame(
            con,
            player,
            tables
        );
        
        
        
        lobby.show();
    }
    
    public void showTable(Connection con,ArrayList<String> info){
        
    }
    
    
    public void closeLobbyFrame(){
        lobby.dispose();
    }
    
    
}
