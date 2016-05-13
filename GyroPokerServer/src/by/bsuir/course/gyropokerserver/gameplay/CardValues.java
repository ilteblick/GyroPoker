/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.course.gyropokerserver.gameplay;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Admin
 */
public class CardValues {
//    public static String[] suits = {"h","d","s","c"};
//    public static String[] ranks = {"a","k","q","j","t","9","8","7","6","5","4","3","2"};
    public ArrayList<String> values;
    public String[] tmp ={
            "ah","kh","qh","jh","th","9h","8h","7h","6h","5h","4h","3h","2h",
            "ad","kd","qd","jd","td","9d","8d","7d","6d","5d","4d","3d","2d",
            "as","ks","qs","js","ts","9s","8s","7s","6s","5s","4s","3s","2s",
            "ac","kc","qc","jc","tc","9c","8c","7c","6c","5c","4c","3c","2c"
        };
    public CardValues(){
        this.values = new ArrayList<>(Arrays.asList(tmp));
    }
    
}
