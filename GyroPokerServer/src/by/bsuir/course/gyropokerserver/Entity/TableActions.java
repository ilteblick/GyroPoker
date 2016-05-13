/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.course.gyropokerserver.Entity;

/**
 *
 * @author Admin
 */
public interface TableActions {
    public void standUp(int place);
    public boolean Seat(String nick, int place, Integer amouth);
    public String startNewGame();
    public void betBlinds();
}
