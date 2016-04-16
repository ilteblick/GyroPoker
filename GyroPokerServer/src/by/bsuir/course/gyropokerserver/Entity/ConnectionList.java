/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.course.gyropokerserver.Entity;

import by.bsuir.course.gyropokerserver.connection.Connection;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author Admin
 */
public class ConnectionList {
    public static CopyOnWriteArrayList<Connection> list;
    
    public static CopyOnWriteArrayList<Connection> getInstance(){
        if(list == null){
            list = new CopyOnWriteArrayList<>();
            
        }
        return list;
    }
}
