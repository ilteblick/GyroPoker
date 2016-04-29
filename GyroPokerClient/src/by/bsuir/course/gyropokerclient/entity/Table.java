/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.course.gyropokerclient.entity;

/**
 *
 * @author Admin
 */
public class Table {

    public String name;//table name
    public String limits;// 

    public String players;//player count

    public Table(String name, String limits, String players) {
        this.name = name;
        this.limits = limits;
        this.players = players;
    }
}
