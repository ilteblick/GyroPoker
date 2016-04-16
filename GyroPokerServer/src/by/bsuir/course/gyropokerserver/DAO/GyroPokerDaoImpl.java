/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.course.gyropokerserver.DAO;

import by.bsuir.course.gyropokerserver.Entity.Player;
import by.bsuir.course.gyropokerserver.utils.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class GyroPokerDaoImpl implements gyroPokerDao{
    
    private static GyroPokerDaoImpl instance;
    
    private Connection con = Database.getConnection();
    
    private GyroPokerDaoImpl(){
        
    }
    
    public static GyroPokerDaoImpl getInstance(){
        if(instance == null){
            instance = new GyroPokerDaoImpl();
        }
        return instance;              
    }
    
    
    @Override
    public boolean checkLogin(String login, String password) {
        try {
            String query = "SELECT A_Password = ? as res FROM gyropokerdb.account where A_Nickname = ?";
            PreparedStatement prs = con.prepareStatement(query);
            prs.setString(1, password);
            prs.setString(2, login);
            ResultSet rs = prs.executeQuery();
            rs.next();
            if(rs.getInt("res") == 1){
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(GyroPokerDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Player getPlayerById(String login) {
        try {
            String query = "SELECT * FROM gyropokerdb.account where A_Nickname = ?";
            PreparedStatement prs = con.prepareStatement(query);
            prs.setString(1, login);
            ResultSet rs = prs.executeQuery();
            rs.next();
            Player player = new Player();
            player.nick = rs.getString("A_Nickname");
            player.name = rs.getString("A_Name");
            player.surename = rs.getString("A_Surename");
            player.email = rs.getString("A_Email");
            player.address = rs.getString("A_address");
            player.phone = rs.getString("A_phone");
            player.balance = rs.getDouble("A_balance");
            player.playMoney = rs.getDouble("A_PlayMoney_balance");
            
            return player;
        } catch (SQLException ex) {
            Logger.getLogger(GyroPokerDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
