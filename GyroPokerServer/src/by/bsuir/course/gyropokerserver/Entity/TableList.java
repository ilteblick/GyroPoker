/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.course.gyropokerserver.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author Admin
 */
public class TableList {    
    public static CopyOnWriteArrayList<Table> tables = new CopyOnWriteArrayList<>();

    public static CopyOnWriteArrayList getTables(){
        return tables;
    }
    
    /**
     *
     * @return
     */
    public static String info(){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<tables.size();i++){
            Table t = tables.get(i);
            sb.append(t.name)
                    .append(":")
                    .append(Integer.toString(t.small))
                    .append("/")
                    .append(Integer.toString(t.big))
                    .append(":")
                    .append(Integer.toString(t.players))
                    .append(":");
        }
        return sb.toString();
    }
}
