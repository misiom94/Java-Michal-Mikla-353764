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
import pl.lodz.uni.math.bank.Account;
import pl.lodz.uni.math.bank.Client;
import pl.lodz.uni.math.exceptions.EmptyBankAccountDescriptionException;
import pl.lodz.uni.math.exceptions.WrongBankAccountNumberException;

/**
 *
 * @author user
 */
public class AccountTest {
    private static Client firstClientMock;
    private static Account firstClientAccount;
    private static Account firstClientAccountMock;
    private static Account wrongAccount;
    
    @BeforeClass
    public static void setTestAccount() throws WrongBankAccountNumberException, EmptyBankAccountDescriptionException{
        firstClientMock = EasyMock.createMock(Client.class);
        EasyMock.expect(firstClientMock.getID()).andReturn(1).anyTimes();
        EasyMock.expect(firstClientMock.getName()).andReturn("First").anyTimes();
        EasyMock.replay(firstClientMock);
        firstClientAccount = new Account("123456789012345","description",firstClientMock);
        firstClientAccountMock = EasyMock.createMock(Account.class);
        EasyMock.expect(firstClientAccountMock.getNumber()).andReturn("123456789012345").anyTimes();
        EasyMock.expect(firstClientAccountMock.getDecription()).andReturn("description").anyTimes();
        EasyMock.expect(firstClientAccountMock.getClient()).andReturn(firstClientMock).anyTimes();
        EasyMock.replay(firstClientAccountMock);
    }
    
    @Test
    public void testAccountConstructor(){
        assertEquals(firstClientAccountMock.getNumber(),firstClientAccount.getNumber());
        assertEquals(firstClientAccountMock.getClient(),firstClientMock);
    }
    
    @Test
    public void testAccountWithNoClient(){
        Account noClientAccount = new Account();
        assertEquals(null,noClientAccount.getClient());
    }
    
    @Test(expected = WrongBankAccountNumberException.class)
    public void testAccountWithWrongLengthNumber() throws WrongBankAccountNumberException, EmptyBankAccountDescriptionException{
        wrongAccount = new Account("12345678901234567890","description",firstClientMock);
    }
    
    @Test(expected = WrongBankAccountNumberException.class)
    public void testAccountWithWrongNumber() throws WrongBankAccountNumberException, EmptyBankAccountDescriptionException{
        wrongAccount = new Account("123456789012E45","description",firstClientMock);
    }
    
//    @Test(expected = EmptyBankAccountDescriptionException.class)
//    public void testAccountWithEmptyDescription() throws EmptyBankAccountDescriptionException, WrongBankAccountNumberException {
//        wrongAccount = new Account("123456789012E45","",firstClientMock);
//    }
}
