/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.uni.math.gamebowling;

import java.util.Random;
import org.apache.log4j.Logger;

/**
 *
 * @author user
 */
public class Game {
    
    Frame[] frames =  new Frame[11];
    BonusFrame bonusFrame;
    Roll firsBonusRoll = new Roll();
    Roll secondBonusRoll = new Roll();
    Random generator = new Random();
    int finalScore = 0;
    Logger logger = Logger.getRootLogger();
    
    public void setFirstBonusRoll(Roll firstBonusRoll){
        this.firsBonusRoll = firstBonusRoll;
    }
    
    public void setSecondBonusRoll(Roll secondBonusRoll){
        this.secondBonusRoll = secondBonusRoll;
    }
    
    public Integer startGame(Roll firstRoll, Roll secondRoll) throws FrameException{
        
        for(int i=0; i<10; i++){
            frames[i] = new Frame(firstRoll, secondRoll);
        }
        return getGameScore(frames)
    }
    
    public void isLastStrike(Frame frame, Roll firstBonusRoll, Roll secondBonusRoll){
        if(frame.isStrike()){
            frame.setFrameScore(frame.getFrameScore() + (firstBonusRoll.getScore())+ (secondBonusRoll.getScore()));
            frames[10] = new BonusFrame(firstBonusRoll, secondBonusRoll);
        }
    }

    
}
