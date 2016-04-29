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
public class Table {

    public String name;//table name
    public int small;// SB
    public int big;//BB

    public int players;//player count

    public Table(String name, int small, int big) {
        this.name = name;
        this.small = small;
        this.big = big;
        this.players = 0;
    }
}
