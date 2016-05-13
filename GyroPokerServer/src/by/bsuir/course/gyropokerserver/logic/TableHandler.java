/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.course.gyropokerserver.logic;

import by.bsuir.course.gyropokerserver.Entity.Table;
import by.bsuir.course.gyropokerserver.Entity.TableList;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class TableHandler {

    public ArrayList<String> getTableInfo(String name) {
        ArrayList<String> list = new ArrayList<>();
        for (Table table : TableList.tables) {
            if (table.name.equals(name)) {                
                list.add("TableInfo:success:" + table.toString());
                return list;
            }
        }
        return null;
    }

    public ArrayList<String> fold(String name, Integer place){
        ArrayList<String> list = new ArrayList<>();
        for (Table table : TableList.tables) {
            if (table.name.equals(name)) {
                table.fold(place);
                boolean end = table.checkEndGame();
                if(end){
                    table.endGame();
                    list.add("Change:success:" + table.toString());
                    list.add("Change:newGame:"+ table.name +":" + table.startNewGame());
                    table.betBlinds();
                    list.add("Change:success:" + table.toString());
                }else{
                    boolean result = table.nextTurn();
                    if(result){
                        
                    }else{
                        list.add("Change:success:" + table.toString());
                    }
                }
                return list;
            }
        }
        return null;
    }
    
    
    public ArrayList<String> seatToTable(String name, String nick, Integer place, Integer amount) {
        ArrayList<String> list = new ArrayList<>();
        for (Table table : TableList.tables) {
            if (table.name.equals(name)) {
                boolean result = table.Seat(nick, place, amount);               
                list.add("Change:success:" + table.toString());
                if(result){
                    list.add("Change:newGame:"+ table.name +":" + table.startNewGame());
                    table.betBlinds();
                    list.add("Change:success:" + table.toString());
                }
                return list;
            }
        }
        return null;
    }

    public ArrayList<String> standUP(String name, Integer place) {
        ArrayList<String> list = new ArrayList<>();
        for (Table table : TableList.tables) {
            if (table.name.equals(name)) {
                table.standUp(place);
                list.add("Change:success:" + table.toString());
                return list;
            }
        }
        return null;
    }
}
