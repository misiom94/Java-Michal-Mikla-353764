/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.uni.math.gamebowling;
import pl.lodz.uni.math.exception.*;


import java.util.Random;
import org.apache.log4j.Logger;

public class Game {
    
    Frame[] frames =  new Frame[11];
    BonusFrame bonusFrame;
    Roll firstBonusRoll = new Roll();
    Roll secondBonusRoll = new Roll();
    Random generator = new Random();
    int finalScore = 0;
    Logger logger = Logger.getRootLogger();
    
    public void setFirstBonusRoll(Roll firstBonusRoll){
        this.firstBonusRoll = firstBonusRoll;
    }
    
    public void setSecondBonusRoll(Roll secondBonusRoll){
        this.secondBonusRoll = secondBonusRoll;
    }
    
    public Integer startGame(Roll firstRoll, Roll secondRoll) throws FrameException, RollException{
        
        for(int i=0; i<10; i++){
            frames[i] = new Frame(firstRoll, secondRoll);
        }
        return getGameScore(frames);
    }
    
    public void isLastStrike(Frame frame, Roll firstBonusRoll, Roll secondBonusRoll) throws RollException{
        if(frame.isStrike()){
            frame.setFrameScore(frame.getFrameScore() + (firstBonusRoll.getScore())+ (secondBonusRoll.getScore()));
            frames[10] = new BonusFrame(firstBonusRoll, secondBonusRoll);
        }
    }
    
    public Integer startGame(Frame[] frames) throws RollException{
        this.frames = frames;
        return getGameScore(frames);
    }
    
    public void calculate() throws RollException {
        
        calculateLastRoll(frames[9]);
        for(int i=8; i>=0; --i){
            if(frames[i].isStrike()){
                sumWhenStrike(frames[i],frames[i+1],frames[i+2]);    
            }
            if(frames[i].isSpare()){
                sumWhenSpare(frames[i],frames[i+1]);
            }
        }
    }
    
    public void calculateLastRoll(Frame frame) throws RollException{
        isLastStrike(frame, firstBonusRoll,secondBonusRoll);
        isLastSpare(frame, firstBonusRoll);
    }
    
    public void isLastSpare(Frame frame, Roll firstBonusRoll) throws RollException{
        if(frame.isSpare()){
            bonusFrame = new BonusFrame(firstBonusRoll, new Roll());
            frames[10] = bonusFrame;
        }
    }
    
    public void sumWhenStrike(Frame actualFrame, Frame firstFrame, Frame secondFrame){
        if(firstFrame.isStrike()){
            actualFrame.setFrameScore(
                    actualFrame.getFrameScore() + firstFrame.getFirstRollScore() + secondFrame.getFirstRollScore());
        }else{
            actualFrame.setFrameScore(
                    actualFrame.getFrameScore() + firstFrame.getFirstRollScore() + secondFrame.getSecondRollScore());
        }
    }
    
    public void sumWhenSpare(Frame actualFrame, Frame nextFrame){
        actualFrame.setFrameScore(actualFrame.getFrameScore()+nextFrame.getFirstRollScore());
    }
    
    public int getGameScore(Frame[] frames) throws RollException{
        calculate();
        finalScore = 0;
        for(int i=0 ; i<10 ;i++){
            finalScore = finalScore + frames[i].getFrameScore();
        }
        return finalScore;
    }
    
    
    
    

    
}
