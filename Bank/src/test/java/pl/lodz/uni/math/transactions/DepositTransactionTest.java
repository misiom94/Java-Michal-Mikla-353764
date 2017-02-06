package pl.lodz.uni.math.transactions;

import java.math.BigDecimal;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import pl.lodz.uni.math.bank.Client;
import pl.lodz.uni.math.exceptions.EmptyBankAccountDescriptionException;
import pl.lodz.uni.math.exceptions.NotExistAccountException;
import pl.lodz.uni.math.exceptions.WrongBankAccountNumberException;
import pl.lodz.uni.math.exceptions.WrongClientNameException;
import pl.lodz.uni.math.exceptions.WrongClientOwnerException;

public class DepositTransactionTest {
    private static Client testClient;
    
    @BeforeClass
    public static void setClientForTests() throws WrongClientNameException, WrongBankAccountNumberException, EmptyBankAccountDescriptionException{
        testClient = new Client(1,"TestClient");
        testClient.addAcount("123456789012345", "testDescription");
        testClient.getAccount("123456789012345").setAmount(new BigDecimal(2000));
    }
    @Test
    public void testDepositDoTransaction() throws NotExistAccountException, WrongClientOwnerException{
            ValuesForTransaction valuesForTransaction = new ValuesForTransaction(testClient, 
                            testClient.getAccount("123456789012345"), 1000, 
                            "description", TransactionType.DEPOSIT, testClient.getAccount("123456789012345").getCheckNumber());
            new Deposit(valuesForTransaction);

    }
    @Test
	public void testDepositReturnAccountAmount(){
		assertEquals(testClient.getAccount("123456789012345").getAmount(),new BigDecimal(3000));
		
	}

}
