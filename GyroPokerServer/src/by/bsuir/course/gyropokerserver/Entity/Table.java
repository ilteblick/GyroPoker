/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.course.gyropokerserver.Entity;

import by.bsuir.course.gyropokerserver.gameplay.Deal;
import by.bsuir.course.gyropokerserver.gameplay.Hand;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Table implements TableActions {

    private Deal deal;

    private int buttonPosition = 0;
    private int turn = 0;
    
    
    public String name;//table name
    public int small;// SB
    public int big;//BB

    private boolean isGameRunning = false;

    public int players;//player count

    public int pot;//pot

    private ArrayList<String> seats = new ArrayList<>(6);
    private ArrayList<Integer> cash = new ArrayList<>(6);
    private ArrayList<Integer> bets = new ArrayList<>(6);
    private ArrayList<Boolean> status = new ArrayList<>(6);

    public Table(String name, int small, int big) {
        this.name = name;
        this.small = small;
        this.big = big;
        this.players = 0;
        for (int i = 0; i < 6; i++) {
            seats.add("0");
            cash.add(-1);
            bets.add(-1);
            status.add(false);
        }
    }

    @Override
    public void standUp(int place) {
        seats.remove(place - 1);
        cash.remove(place - 1);
        bets.remove(place - 1);
        status.remove(place - 1);

        seats.add(place - 1, "0");
        cash.add(place - 1, -1);
        bets.add(place - 1, -1);
        status.add(place - 1, false);
    }

    @Override
    public boolean Seat(String nick, int place, Integer amouth) {
        seats.remove(place - 1);
        seats.add(place - 1, nick);
        cash.remove(place - 1);
        cash.add(place - 1, amouth);
        bets.remove(place - 1);
        bets.add(place - 1, 0);
        int tmp = 0;
        if (isGameRunning == false) {
            for (String seat : this.seats) {
                if (!seat.equals("0")) {
                    tmp++;
                }
            }
            if (tmp > 1) {
                this.isGameRunning = true;
            }
        }

        return this.isGameRunning;

    }

    @Override
    public void betBlinds() {
        int tmp = 0;
        int blind = this.buttonPosition;
        while (tmp == 0) {
            blind = (blind + 1) % 7 + (blind + 1) / 7;
            if (!this.seats.get(blind - 1).equals("0")) {
                int bet = this.bets.get(blind-1);
                int cash = this.cash.get(blind-1);
                this.bets.remove(blind - 1);
                this.bets.add(blind -1,bet + this.small);
                this.cash.remove(blind - 1);
                this.cash.add(blind -1,cash - this.small);
                tmp++;
            }
        }
        while (tmp == 1) {
            blind = (blind + 1) % 7 + (blind + 1) / 7;
            if (!this.seats.get(blind - 1).equals("0")) {
                int bet = this.bets.get(blind-1);
                int cash = this.cash.get(blind-1);
                this.bets.remove(blind - 1);
                this.bets.add(blind -1,bet + this.big);
                this.cash.remove(blind - 1);
                this.cash.add(blind -1,cash - this.big);
                tmp++;
            }
        }
        
        while (tmp == 2) {
            blind = (blind + 1) % 7 + (blind + 1) / 7;
            if (this.status.get(blind - 1).equals(true)) {
                this.turn = blind;
                tmp++;
            }
        }       
    }

    @Override
    public String startNewGame() {
        for(int i=0;i<6;i++){
            if(!this.seats.get(i).equals("0")){
                this.status.remove(i);
                this.status.add(i,true);
            }
        }
        
        
        if (this.buttonPosition == 0) {
            for (int i = 0; i < this.seats.size(); i++) {
                if (!this.seats.get(i).equals("0")) {
                    buttonPosition = i + 1;
                    break;
                }
            }
        } else {
            do {
                buttonPosition = (buttonPosition + 1) % 7 + (buttonPosition + 1) / 7;
            } while (!this.seats.get(this.buttonPosition - 1).equals("0"));
        }
        this.deal = new Deal(seats);
        deal.newDeal();
        StringBuilder stringBuilder = new StringBuilder();
        for (Hand hand : deal.hands) {
            if (hand.first == null) {
                stringBuilder.append("Z")
                        .append(":")
                        .append("Z")
                        .append(":");
            } else {
                stringBuilder.append(hand.first.card)
                        .append(":")
                        .append(hand.second.card)
                        .append(":");
            }

        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name)
                .append(":")
                .append(Integer.toString(this.small))
                .append("/")
                .append(Integer.toString(this.big))
                .append(":");
        for (int i = 0; i < 6; i++) {
            sb.append(seats.get(i))
                    .append(":")
                    .append(Integer.toString(cash.get(i)))
                    .append(":")
                    .append(Integer.toString(bets.get(i)))
                    .append(":")
                    .append(Boolean.toString(status.get(i)))
                    .append(":");
        }
        sb.append(Integer.toString(this.pot))
                .append(":")
                .append(Integer.toString(this.turn));
        return sb.toString();
    }
}
