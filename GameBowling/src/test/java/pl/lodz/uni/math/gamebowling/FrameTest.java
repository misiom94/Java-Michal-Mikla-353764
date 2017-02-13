/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.uni.math.gamebowling;
import org.apache.log4j.BasicConfigurator;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import pl.lodz.uni.math.exception.*;

/**
 *
 * @author user
 */
public class FrameTest {
    
    Frame frame;
    Frame exceptionFrame;
    Frame strikeFrame;
    Frame spareFrame;
    
    public FrameTest() throws FrameException,RollException {
        
    }
    
    @BeforeClass
    public static void setUpClass(){
        BasicConfigurator.configure();
    }
    
    @AfterClass
    public static void tearDownClass(){
        
    }
    
    @Before
    public void setUp() throws FrameException, RollException{
        frame = new Frame(new Roll(4),new Roll(4));
        strikeFrame = new Frame(new Roll(10),new Roll());
        spareFrame = new Frame(new Roll(3),new Roll(7));
    }
    
    @After
    public void tearDown(){
        
    }
    
    @Test
    public void frameScoreTest(){
        assertEquals((Integer) 8, frame.getFrameScore());
    }
    
    @Test(expected = FrameException.class)
    public void testBadRoll() throws FrameException, RollException{
        exceptionFrame = new Frame(new Roll(7),new Roll(5));
    }
    
    @Test
    public void testSetFirstRoll() throws RollException{
        frame.setFirstRoll(new Roll(5));
        assertEquals((Integer)5, frame.getFrameScore());
    }
    
    @Test
    public void testSetSecondRoll() throws RollException{
        frame.setSecondRoll(new Roll(7));
        assertEquals((Integer)7, frame.getSecondRollScore());
    }
    
    @Test
    public void testGetSecondRollWithStrike(){
        assertEquals((Integer)0,strikeFrame.getSecondRollScore());
    }
    
    @Test
    public void testIsStrike(){
        assertEquals(true,strikeFrame.isStrike());
    }
    
    @Test 
    public void testIsSpare(){
        assertEquals(true,spareFrame.isSpare());
    }
}
