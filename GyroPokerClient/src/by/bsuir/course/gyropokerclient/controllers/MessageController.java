/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.course.gyropokerclient.controllers;

import by.bsuir.course.gyropokerclient.logic.ConnectionHandler;

/**
 *
 * @author Admin
 */
public class MessageController {
    public void execute(String msg){
        switch(msg){
            case "ServerRunning":{
                ConnectionHandler.getInstance().succcessConnection();
            }
        }
    }
}
