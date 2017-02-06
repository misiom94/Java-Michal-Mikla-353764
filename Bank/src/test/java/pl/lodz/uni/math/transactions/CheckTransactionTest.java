/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.uni.math.transactions;

import java.math.BigDecimal;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import pl.lodz.uni.math.bank.Client;
import pl.lodz.uni.math.exceptions.AccountNotEnoughMoneyException;
import pl.lodz.uni.math.exceptions.EmptyBankAccountDescriptionException;
import pl.lodz.uni.math.exceptions.NotExistAccountException;
import pl.lodz.uni.math.exceptions.WrongBankAccountNumberException;
import pl.lodz.uni.math.exceptions.WrongClientNameException;
import pl.lodz.uni.math.exceptions.WrongClientOwnerException;


public class CheckTransactionTest {
    
    private static Client testClient;
    
    @BeforeClass
    public static void setClientForTests() throws WrongClientNameException, WrongBankAccountNumberException, EmptyBankAccountDescriptionException{
        testClient = new Client(1,"TestClient");
        testClient.addAcount("123456789012345", "testDescription");
        testClient.getAccount("123456789012345").setAmount(new BigDecimal(2000));
    }
    @Test
    public void testCheckTransaction() throws NotExistAccountException, WrongClientOwnerException, AccountNotEnoughMoneyException
    {
        ValuesForTransaction valuesForTransaction = new ValuesForTransaction(testClient, testClient.getAccount("123456789012345"),
                1000, "testDescription", TransactionType.CHECK, testClient.getAccount("123456789012345").getCheckNumber());
        new Check(valuesForTransaction);
    }
    @Test
	public void testCheckReturnAccountAmount(){
		assertEquals(testClient.getAccount("123456789012345").getAmount(),new BigDecimal(1000));
		
	}
    @Test(expected=AccountNotEnoughMoneyException.class)
	public void testCheckNotEnoughMoney() throws NotExistAccountException, WrongClientOwnerException, AccountNotEnoughMoneyException{
		ValuesForTransaction valuesForTransaction = new ValuesForTransaction(testClient, 
				testClient.getAccount("123456789012345"), 10000, 
				"description", TransactionType.CHECK, testClient.getAccount("123456789012345").getCheckNumber());
		new Check(valuesForTransaction);
		
	}
    
    
}
