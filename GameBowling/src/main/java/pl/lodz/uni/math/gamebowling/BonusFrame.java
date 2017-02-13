package pl.lodz.uni.math.gamebowling;


public class BonusFrame extends Frame{
    
    Roll firstRoll;
    Roll secondRoll;
    int framescore;

    public BonusFrame(Roll firstRoll, Roll secondRoll) throws FrameException {
        
        this.firstRoll = firstRoll;
        this.secondRoll = secondRoll;
        framescore = firstRoll.getScore() + secondRoll.getScore();
    }

   
    
    public Integer getFirstRollScore()
    {
        return firstRoll.getScore();
    }
    
    public void setFirstRoll(Roll firstRoll)
    {
        this.firstRoll = firstRoll;
    }
    
    public Integer getSecondRollScore()
    {
        return secondRoll.getScore();
    }
    
    public void setSecondRoll(Roll secondRoll)
    {
        this.secondRoll = secondRoll;
    }
    
    public Integer getFrameScore()
    {
        return framescore;
    }
    
    public void setFrameScore(int frameScore)
    {
        this.framescore = framescore;
    }
}
