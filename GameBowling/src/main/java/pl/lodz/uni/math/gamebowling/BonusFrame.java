package pl.lodz.uni.math.gamebowling;
import pl.lodz.uni.math.exception.*;


public class BonusFrame extends Frame{
    
    Roll firstRoll;
    Roll secondRoll;
    int frameScore;

  
    public BonusFrame(Roll firstRoll, Roll secondRoll) throws RollException
	{
		
		this.firstRoll=firstRoll;
		this.secondRoll=secondRoll;
		frameScore=firstRoll.getScore()+secondRoll.getScore();
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
        return frameScore;
    }
    
    public void setFrameScore(int frameScore)
    {
        this.frameScore = frameScore;
    }
}
