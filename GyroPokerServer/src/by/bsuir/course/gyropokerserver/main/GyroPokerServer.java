/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.course.gyropokerserver.main;

import by.bsuir.course.gyropokerserver.Entity.Table;
import by.bsuir.course.gyropokerserver.Entity.TableList;
import by.bsuir.course.gyropokerserver.connection.Server;

/**
 *
 * @author Admin
 */
public class GyroPokerServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Table table1 = new Table("1", 1, 2);
        Table table2 = new Table("2", 2, 4);
        
        TableList.tables.add(table1);
        TableList.tables.add(table2);
        
        
        Server server = new Server();
    }
    
}
