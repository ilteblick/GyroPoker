/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.course.gyropokerserver.combination;

import by.bsuir.course.gyropokerserver.gameplay.Card;
import by.bsuir.course.gyropokerserver.gameplay.Deal;
import by.bsuir.course.gyropokerserver.gameplay.Hand;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 *
 * @author Admin
 */
public class WinnerFinder {
    Deal deal;
    private ArrayList<CombinationResult> list = new ArrayList<>();
    
    public WinnerFinder(Deal deal){
        this.deal = deal;
    }
    
    public int findWinner(){
        for(int i=0;i<6;i++){
            if(this.deal.hands.get(i).first == null){
                list.add(new CombinationResult(0));
            }else{
                list.add(checkRanking(this.deal.hands.get(i)));
            }
        }
        
        int winner = 0;
        CombinationResult cb = new CombinationResult(10);
        
        for(CombinationResult combination: list){
            if(combination.combination != 0){//
                if(combination.combination < cb.combination){
                    cb = combination;
                    winner = list.indexOf(combination);
                }else{
                if(combination.combination == cb.combination){
                    if(combination.additionals != 0){
                        if(combination.additionals > cb.additionals){
                            cb = combination;
                            winner = list.indexOf(combination);
                        }else{
                            if(combination.additionals == cb.additionals){
                                winner = list.indexOf(combination)*10 + list.indexOf(cb);
                            }
                        }
                    }
                }}
            }
        }
        
        return winner;
    }
    
    private CombinationResult checkRanking(Hand hand){
        ArrayList<CardUtil> table = new ArrayList<>();
        deal.desk.deskCards.stream().forEach((card) -> {
            table.add(new CardUtil(card.card.substring(0, 1), card.card.substring(1, 1)));
        });
        table.add(new CardUtil(hand.first.card.substring(0,1),hand.first.card.substring(1,1)));
        table.add(new CardUtil(hand.second.card.substring(0,1),hand.second.card.substring(1,1)));
        
        Collections.sort(table, (CardUtil o1,CardUtil o2) -> o2.card - o1.card);
        
        if(isRoyal(table)){
            return new CombinationResult(1);
        }
        if(isFour(table)){
            return new CombinationResult(2);
        }
        if(isFull(table)){
            return new CombinationResult(3);
        }
        if(isSuited(table)){
            CombinationResult cr = new CombinationResult(4);
            cr.additionals = table.get(0).card;
            return cr;
        }
        if(isStreight(table)){
            return new CombinationResult(5);
        }
        
        if(isThree(table)){
            return new CombinationResult(6);                    
        }
        
        if(isTwo(table)){
            CombinationResult cr = new CombinationResult(7);
            cr.additionals = table.get(0).card;
            return cr;
        }
        if(isPair(table)){
            CombinationResult cr = new CombinationResult(8);
            cr.additionals = table.get(0).card;
            return cr;
        }
        CombinationResult cr = new CombinationResult(9);
        cr.additionals = table.get(0).card + table.get(1).card + table.get(2).card
                + table.get(3).card + table.get(4).card; 
        return cr;
    }
    
    private boolean isSuited(ArrayList<CardUtil> table){
        int s=0,d=0,c=0,h=0;
        for(CardUtil card: table){
            switch (card.s){
                case 1:{
                    s++;
                    break;
                }
                case 2:{
                    d++;
                    break;
                }
                case 3:{
                    c++;
                    break;
                }
                case 4:{
                    h++;
                    break;
                }
            }
        }
        return (c>4)||(d>4)||(s>4)||(h>4);
    }
    
    
    private boolean isRoyal(ArrayList<CardUtil> table){
        if(!this.isSuited(table))
            return false;
        return (table.get(0).card == 14) && (table.get(0).card == 14);
    }
    
    private boolean isFour(ArrayList<CardUtil> table){
        return ((table.get(0).card == table.get(3).card) ||
                (table.get(1).card == table.get(4).card) ||
                (table.get(2).card == table.get(5).card) ||
                (table.get(3).card == table.get(6).card));
    }
    
    private boolean isFull(ArrayList<CardUtil> table){
        return ((table.get(0).card == table.get(2).card) && ((table.get(3).card == table.get(4).card)) ||
                (table.get(0).card == table.get(2).card) && ((table.get(4).card == table.get(5).card)) ||
                (table.get(0).card == table.get(2).card) && ((table.get(5).card == table.get(6).card)) ||
                (table.get(1).card == table.get(3).card) && ((table.get(4).card == table.get(5).card)) ||
                (table.get(1).card == table.get(3).card) && ((table.get(5).card == table.get(6).card)) ||
                (table.get(2).card == table.get(4).card) && ((table.get(0).card == table.get(1).card)) ||
                (table.get(2).card == table.get(4).card) && ((table.get(5).card == table.get(6).card)) ||
                (table.get(3).card == table.get(5).card) && ((table.get(0).card == table.get(1).card)) ||
                (table.get(3).card == table.get(5).card) && ((table.get(1).card == table.get(2).card)) ||
                (table.get(4).card == table.get(6).card) && ((table.get(0).card == table.get(1).card)) ||
                (table.get(4).card == table.get(6).card) && ((table.get(1).card == table.get(2).card)) ||
                (table.get(4).card == table.get(6).card) && ((table.get(2).card == table.get(3).card)));
    }
    
    private boolean isStreight(ArrayList<CardUtil> table){
        
      return false;
    }
    
    private boolean isThree(ArrayList<CardUtil> table){
        return ((table.get(0).card == table.get(2).card) ||
                (table.get(1).card == table.get(3).card) ||
                (table.get(2).card == table.get(4).card) ||
                (table.get(3).card == table.get(5).card) ||
                (table.get(4).card == table.get(6).card)) ;
    }
    
    private boolean isTwo(ArrayList<CardUtil> table){
        int tmp=0;
        for(int i=0;i<6;i++){
            if(table.get(i).card == table.get(i+1).card){
                tmp++;
            }
        }
        return tmp > 1;
        
    }
    
    private boolean isPair(ArrayList<CardUtil> table){
        int tmp=0;
        for(int i=0;i<6;i++){
            if(table.get(i).card == table.get(i+1).card){
                tmp++;
            }
        }
        return tmp > 0;
        
    }
}
