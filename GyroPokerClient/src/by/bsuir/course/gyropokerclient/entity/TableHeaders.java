/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.course.gyropokerclient.entity;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class TableHeaders {
    private List<String> headers = new ArrayList<>();
    
    public TableHeaders(){
        headers.add("Name");
        headers.add("Limits");
        headers.add("Players"); 
    }
    
    public ArrayList<String> getHeaders(){
        return (ArrayList) headers;
    }
}
