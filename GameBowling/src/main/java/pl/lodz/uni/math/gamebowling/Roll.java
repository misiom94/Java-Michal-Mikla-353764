/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.uni.math.gamebowling;

import java.util.Random;

/**
 *
 * @author user
 */
public class Roll {
    
    Random generator = new Random();
    int score;
    
    public Roll(){
        score = 0;
    }
    
    public Roll(int pins){
        score = pins;
    }
    
    public Integer getScore(){
        return score;
    }
}
