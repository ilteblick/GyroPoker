/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.course.gyropokerserver.combination;

/**
 *
 * @author Admin
 */
public class CardUtil {
    
    public int card;
    public int s;

    public CardUtil(String card, String s){
        switch(card){
            case "2":{
                this.card  = 2;
                break;
            }
            case "3":{
                this.card  = 3;
                break;
            }
            case "4":{
                this.card  = 4;
                break;
            }
            case "5":{
                this.card  = 5;
                break;
            }
            case "6":{
                this.card  = 6;
                break;
            }
            case "7":{
                this.card  = 7;
                break;
            }
            case "8":{
                this.card  = 8;
                break;
            }
            case "9":{
                this.card  = 9;
                break;
            }
            case "t":{
                this.card  = 10;
                break;
            }
            case "j":{
                this.card  = 11;
                break;
            }
            case "q":{
                this.card  = 12;
                break;
            }
            case "k":{
                this.card  = 13;
                break;
            }
            case "a":{
                this.card  = 14;
                break;
            }
        }
        switch (s){
            case "d":{
                this.card  = 1;
                break;
            }
            case "c":{
                this.card  = 2;
                break;
            }
            case "h":{
                this.card  = 3;
                break;
            }
            case "s":{
                this.card  = 4;
                break;
            }
        }
    }
}
