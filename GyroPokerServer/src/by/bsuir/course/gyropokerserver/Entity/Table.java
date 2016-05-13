/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.course.gyropokerserver.Entity;

import by.bsuir.course.gyropokerserver.gameplay.Deal;
import by.bsuir.course.gyropokerserver.gameplay.Hand;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Admin
 */
public class Table implements TableActions {

    private Deal deal;

    private int buttonPosition = 0;
    private int turn = 0;
    private int actionPosition;
    private int gamePhase;//0pre 1flop 2turn 3river

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
    //true-showdown false- next phase
    public String changePhase() {
        int tmp = 0;
        this.turn = this.buttonPosition;
        while (tmp < 2) {
            this.turn = (this.turn - 1) % 7 + (this.turn - 1) / 7;
            if(this.turn == 0){
                this.turn=6;
            }
            if (this.status.get(this.turn - 1).equals(true)) {
                tmp++;
            }
        }

        this.actionPosition = this.turn;

        for (int i = 0; i < 6; i++) {
            if (this.status.get(i).equals(true)) {
                this.pot += this.bets.get(i);
                this.bets.remove(i);
                this.bets.add(i, 0);
            }
        }
        
        String response = this.deal.next(this.gamePhase);
        this.gamePhase++;
        
        return response;
    }

    public void fold(Integer place) {
        status.remove(place - 1);
        status.add(place - 1, false);
    }

    public void raise(Integer place, Integer raise) {
        this.actionPosition = place;

        Integer cash = this.cash.get(place - 1) - raise + this.bets.get(place - 1);

        this.bets.remove(place - 1);
        this.bets.add(place - 1, raise);

        this.cash.remove(place - 1);
        this.cash.add(place - 1, cash);
    }

    public void call(Integer place) {
        Integer bets = Collections.max(this.bets);
        Integer toCall = bets - this.bets.get(place - 1);
        Integer cash = this.cash.get(place - 1) - toCall;

        this.cash.remove(place - 1);
        this.cash.add(place - 1, cash);
        this.bets.remove(place - 1);
        this.bets.add(place - 1, bets);
    }

    public boolean checkEndGame() {
        int tmp = 0;
        for (int i = 0; i < 6; i++) {
            if (this.status.get(i).equals(true)) {
                tmp++;
            }
        }
        return tmp == 1;
    }

    public boolean nextTurn() {
        while (true) {
            this.turn = (this.turn + 1) % 7 + (this.turn + 1) / 7;
            if (this.status.get(this.turn - 1).equals(true)) {
                return this.turn == this.actionPosition;
            }
        }
    }

    public void endGame() {
        for (int i = 0; i < 6; i++) {
            if (this.status.get(i).equals(true)) {
                int bets = 0;
                for (int j = 0; j < 6; j++) {
                    if (!this.seats.get(j).equals("0")) {
                        bets += this.bets.get(j);
                        this.bets.remove(j);
                        this.bets.add(j, 0);
                        this.status.remove(j);
                        this.status.add(j, true);
                    }
                }
                bets += this.cash.get(i);
                this.cash.remove(i);
                this.cash.add(i, bets + this.pot);
                break;
            }
        }
        this.pot = 0;
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
            if (tmp == 2) {
                this.isGameRunning = true;
                return true;
            }
        } else {
            return false;
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
                int bet = this.bets.get(blind - 1);
                int cash = this.cash.get(blind - 1);
                this.bets.remove(blind - 1);
                this.bets.add(blind - 1, bet + this.small);
                this.cash.remove(blind - 1);
                this.cash.add(blind - 1, cash - this.small);
                tmp++;
            }
        }
        while (tmp == 1) {
            blind = (blind + 1) % 7 + (blind + 1) / 7;
            if (!this.seats.get(blind - 1).equals("0")) {
                int bet = this.bets.get(blind - 1);
                int cash = this.cash.get(blind - 1);
                this.bets.remove(blind - 1);
                this.bets.add(blind - 1, bet + this.big);
                this.cash.remove(blind - 1);
                this.cash.add(blind - 1, cash - this.big);
                this.actionPosition = blind;
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
        this.gamePhase = 0;

        for (int i = 0; i < 6; i++) {
            if (!this.seats.get(i).equals("0")) {
                this.status.remove(i);
                this.status.add(i, true);
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
            } while (this.seats.get(this.buttonPosition - 1).equals("0"));
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
