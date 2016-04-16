/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.course.gyropokerclient.entity;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Packet {
    
    private String header;
    
    private ArrayList<String> info = new ArrayList<>();

    /**
     * Get the value of string
     *
     * @return the value of string
     */
    public ArrayList<String> getInfo() {
        return info;
    }

    /**
     * Set the value of string
     *
     * @param string new value of string
     */
    public void setInfo(ArrayList<String> string) {
        this.info = string;
    }

    /**
     * Get the value of header
     *
     * @return the value of header
     */
    public String getHeader() {
        return header;
    }

    /**
     * Set the value of header
     *
     * @param header new value of header
     */
    public void setHeader(String header) {
        this.header = header;
    }

}
