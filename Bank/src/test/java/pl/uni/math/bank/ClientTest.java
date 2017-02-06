/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.uni.math.bank;

import org.easymock.EasyMock;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import pl.lodz.uni.math.bank.Client;
import pl.lodz.uni.math.exceptions.EmptyBankAccountDescriptionException;
import pl.lodz.uni.math.exceptions.WrongBankAccountNumberException;
import pl.lodz.uni.math.exceptions.WrongClientNameException;

/**
 *
 * @author user
 */
public class ClientTest {
    private static Client testClient;
    private static Client testClientMock;
    private static Client wrongTestClient;
    
    @BeforeClass
    public static void setTestClients() throws WrongClientNameException, WrongBankAccountNumberException, EmptyBankAccountDescriptionException{
        testClient = new Client(1,"First");
        testClient.addAcount("123456789012345", "testDescription");
        testClientMock = EasyMock.createMock(Client.class);
        EasyMock.expect(testClientMock.getID()).andReturn(1).anyTimes();
        EasyMock.expect(testClientMock.getName()).andReturn("First").anyTimes();
        EasyMock.expect(testClientMock.getAccount("123456789012345")).
                andReturn(testClient.getAccount("123456789012345")).anyTimes();
        EasyMock.replay(testClientMock);
    }
    @Test
    public void testClientConstructorId(){
        assertEquals(testClientMock.getID(),testClient.getID());
        
    }
    
    @Test
    public void testClientConstructorName(){
        assertEquals(testClientMock.getName(), testClient.getName());
    }
    
    @Test(expected = WrongClientNameException.class)
    public void testClientShortLengthName() throws WrongClientNameException{
        wrongTestClient = new Client(2,"A");
    }
    
    @Test(expected = WrongClientNameException.class)
    public void testClientLongLengthName() throws WrongClientNameException{
        wrongTestClient = new Client(2,"Adasjcznmdasjleuioewqioewqhdjkhdaskjnsakdsaouequoewqhewkjndasjkheuiuqwehjkasdb");
    }
    
    @Test
    public void testAddAccount(){
        assertEquals(testClient.getAccount("123456789012345").getNumber(), 
                testClientMock.getAccount("123456789012345").getNumber());
        assertEquals(testClient.getAccount("123456789012345").getDecription(), 
                testClientMock.getAccount("123456789012345").getDecription());
    }
    
    @Test
    public void testGetAccout(){
        assertEquals(testClient.getAccount("123456789012345").getClient(), testClient);
    }
    
    
    
    
    
}
