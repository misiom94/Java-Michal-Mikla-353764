package pl.lodz.uni.math.transactions;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;

import pl.lodz.uni.math.bank.Account;
import pl.lodz.uni.math.bank.Client;
import pl.lodz.uni.math.exceptions.EmptyBankAccountDescriptionException;
import pl.lodz.uni.math.exceptions.NotExistAccountException;
import pl.lodz.uni.math.exceptions.WrongBankAccountNumberException;
import pl.lodz.uni.math.exceptions.WrongClientNameException;
import pl.lodz.uni.math.exceptions.WrongClientOwnerException;

public class TransactionTest {
    
    private static Client firstClient;
    private static Client secondClient;
    private static Transaction testTransaction;
    private static List<Transaction> testTransactionList = new ArrayList<Transaction>();
    
    @BeforeClass
    public static void setTestClients() throws WrongClientNameException, WrongBankAccountNumberException, EmptyBankAccountDescriptionException, NotExistAccountException, WrongClientOwnerException{
        firstClient = new Client(1, "First");
        firstClient.addAcount("123456789012345", "description");
        firstClient.getAccount("123456789012345").setAmount(new BigDecimal(2000));
        secondClient = new Client(2,"Second");
        secondClient.addAcount("123456789012346", "description");
        
        ValuesForTransaction valuesForTransaction = new ValuesForTransaction(firstClient, 
				firstClient.getAccount("123456789012345"), 1000, 
				"description", TransactionType.DEPOSIT, firstClient.getAccount("123456789012345").getCheckNumber());
		testTransaction = new Deposit(valuesForTransaction);
		
		testTransactionList.add(testTransaction);
    }
    @Test
    public void testTransactionHistory(){
        assertEquals(testTransactionList,testTransaction.getClientTransactionHistory(firstClient));
    }
    @Test(expected=WrongClientOwnerException.class)
	public void testTransactionWrongAccountOwner() throws NotExistAccountException, WrongClientOwnerException{
		ValuesForTransaction valuesForTransaction = new ValuesForTransaction(firstClient, 
				secondClient.getAccount("123456789012346"), 1000, 
				"description", TransactionType.DEPOSIT, firstClient.getAccount("123456789012345").getCheckNumber());
		new Deposit(valuesForTransaction);
		
	}
    @Test(expected=NotExistAccountException.class)
	public void testDepositReturnAccountAmount() throws NotExistAccountException, WrongClientOwnerException{
		ValuesForTransaction valuesForTransaction = new ValuesForTransaction(firstClient, 
				new Account(), 1000, 
				"description", TransactionType.DEPOSIT, firstClient.getAccount("123456789012345").getCheckNumber());
		new Deposit(valuesForTransaction);
	}
}
