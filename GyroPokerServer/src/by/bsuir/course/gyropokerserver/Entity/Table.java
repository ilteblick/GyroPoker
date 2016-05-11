/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.course.gyropokerserver.Entity;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Table {

    public String name;//table name
    public int small;// SB
    public int big;//BB

    public int players;//player count
    
    public int pot;//pot
    
    private ArrayList<String> seats = new ArrayList<>(6);
    private ArrayList<Integer> cash = new ArrayList<>(6);
    private ArrayList<Integer> bets = new ArrayList<>(6);
    private ArrayList<Boolean> status = new ArrayList<>(6);

    public Table(String name, int small, int big) {
        this.name = name;
        this.small = small;
        this.big = big;
        this.players = 0;
        for(int i=0;i<6;i++){
            seats.add("0");
            cash.add(-1);
            bets.add(-1);
            status.add(false);
        }
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.name)
                .append(":")
                .append(Integer.toString(this.small))
                .append("/")
                .append(Integer.toString(this.big))
                .append(":");
        for(int i=0;i<6;i++){
            sb.append(seats.get(i))
                    .append(Integer.toString(cash.get(i)))
                    .append(":")
                    .append(Integer.toString(bets.get(i)))
                    .append(":")
                    .append(Boolean.toString(status.get(i)))
                    .append(":");
        }
        sb.append(Integer.toString(this.pot));
        return sb.toString();
    }
}
