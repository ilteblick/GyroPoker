/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.course.gyropokerserver.gameplay;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Admin
 */
public class Deal {
    public Desk desk;
    public ArrayList<Hand> hands = new ArrayList<>();
    private ArrayList<String> seats;
    private CardValues cardValues;
    private Random rnd = new Random();
    
    public Deal(ArrayList<String> seats){
        this.seats = seats;
    }
    
    public void newDeal(){        
        this.cardValues = new CardValues();
        for(String seat: seats){
            if(seat.equals("0")){
                Hand hand = new Hand();
                hands.add(hand);
            }else{
                int number = rnd.nextInt(cardValues.values.size()-1);
                Card firstCard = new Card(cardValues.values.get(number));
                cardValues.values.remove(number);
                number = rnd.nextInt(cardValues.values.size()-1);
                Card secondCard = new Card(cardValues.values.get(number));
                cardValues.values.remove(number);
                Hand hand = new Hand(firstCard,secondCard);
                hands.add(hand);
            }
        }
    }
}
