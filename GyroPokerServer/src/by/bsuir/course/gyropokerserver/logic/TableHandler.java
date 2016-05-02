/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.course.gyropokerserver.logic;

import by.bsuir.course.gyropokerserver.Entity.Table;
import by.bsuir.course.gyropokerserver.Entity.TableList;

/**
 *
 * @author Admin
 */
public class TableHandler {
    public String getTableInfo(String name){
        for(Table table: TableList.tables){
            if(table.name.equals(name)){
                return("TableInfo:success:"+table.toString());
            }
        }
        return "";
    }
}
