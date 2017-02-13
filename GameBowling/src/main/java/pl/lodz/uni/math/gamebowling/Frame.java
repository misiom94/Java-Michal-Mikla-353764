package pl.lodz.uni.math.gamebowling;

import java.util.Random;
import org.apache.log4j.Logger;

public class Frame {
    
    private Roll firstRoll;
    private Roll secondRoll;
    private int frameScore;
    private int pinsRemain;
    private boolean spare = false;
    private boolean strike = false;
    private static final int maxPins = 10;
    
    public Frame(Roll firstRoll, Roll secondRoll) throws FrameException
    {
        setFrameScore(firstRoll.getScore() + secondRoll.getScore());
        if(frameScore > 10)
        {
            throw new FrameException();
        }
        setFirstRoll(firstRoll);
        if(!this.isStrike()){
            setSecondRoll(secondRoll);
        }
    }
    
    public boolean isStrike(){
        return strike;
    }
    
    public boolean isSpare(){
        return spare;
    }
    
    public void setFirstRoll(Roll firstRoll) {
        this.firstRoll = firstRoll;
        if (firstRoll.getScore() == maxPins) {
                strike = true;
        }
        setFrameScore(this.firstRoll.getScore());
    }
    
    public void setSecondRoll(Roll secondRoll){
        this.secondRoll = secondRoll;
        setFrameScore(firstRoll.getScore()+secondRoll.getScore());
        if(frameScore==10)
        {
            spare=true;
        }
    }
    public void setFrameScore(int frameScore){
        this.frameScore = frameScore;
    }
    
    public Integer getFrameScore(){
        return frameScore;
    }
    
}
