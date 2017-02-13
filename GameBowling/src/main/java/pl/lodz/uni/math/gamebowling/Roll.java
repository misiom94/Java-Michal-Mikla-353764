/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.uni.math.gamebowling;

import java.util.Random;
import pl.lodz.uni.math.exception.RollException;

public class Roll {
    
    int score;
    
    public Roll(){
        score = 0;
    }
    
   public Roll(int pins) throws RollException {
		if (pins > 10) {
			throw new RollException();
		}
		score = pins;
	}
    
    public Integer getScore(){
        return score;
    }
}
