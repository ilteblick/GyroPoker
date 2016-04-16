/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.course.gyropokerserver.DAO;

import by.bsuir.course.gyropokerserver.Entity.Player;

/**
 *
 * @author Admin
 */
public interface gyroPokerDao {
    public boolean checkLogin(String login, String password);
    public Player getPlayerById(String login);
}
