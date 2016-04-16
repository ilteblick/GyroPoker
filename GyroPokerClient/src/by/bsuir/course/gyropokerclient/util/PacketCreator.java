/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.course.gyropokerclient.util;


import by.bsuir.course.gyropokerclient.entity.Packet;
import java.util.StringTokenizer;

/**
 *
 * @author Admin
 */
public class PacketCreator {
    public Packet createPacket(String message){
        Packet packet = new Packet();
        StringTokenizer st = new StringTokenizer(message, ":");
        packet.setHeader(st.nextToken());
        while(st.hasMoreTokens()){
            packet.getInfo().add(st.nextToken());
        }
        return packet;
    }
    
    
}
