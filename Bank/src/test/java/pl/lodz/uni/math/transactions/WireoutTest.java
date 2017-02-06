/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.uni.math.transactions;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import pl.lodz.uni.math.bank.Account;
import pl.lodz.uni.math.bank.Client;
import pl.lodz.uni.math.exceptions.AccountNotEnoughMoneyException;
import pl.lodz.uni.math.exceptions.EmptyBankAccountDescriptionException;
import pl.lodz.uni.math.exceptions.NotExistAccountException;
import pl.lodz.uni.math.exceptions.WrongBankAccountNumberException;
import pl.lodz.uni.math.exceptions.WrongClientNameException;
import pl.lodz.uni.math.exceptions.WrongClientOwnerException;

/**
 *
 * @author user
 */
public class WireoutTest {
    private static Client firstClient;
    private static Client secondClient;
    
    @BeforeClass
    public static void setTestClients() throws WrongClientNameException, WrongBankAccountNumberException, EmptyBankAccountDescriptionException, NotExistAccountException, WrongClientOwnerException{
        firstClient = new Client(1, "First");
        firstClient.addAcount("123456789012345", "description");
        firstClient.getAccount("123456789012345").setAmount(new BigDecimal(2000));
        
        secondClient = new Client(2,"Second");
        secondClient.addAcount("123456789012346", "description");
        secondClient.getAccount("123456789012346").setAmount(new BigDecimal(1000));
    }
    @Test
    public void testWireoutDoTransaction() throws NotExistAccountException, WrongClientOwnerException, EmptyBankAccountDescriptionException{
            firstClient.getAccount("123456789012345").setAmount(new BigDecimal(2000));
            ValuesForTransaction valuesForTransaction = new ValuesForTransaction(firstClient, 
                            firstClient.getAccount("123456789012345"), 1000, 
                            "description", TransactionType.CHECK, firstClient.getAccount("123456789012345").getCheckNumber());
            new Wireout(valuesForTransaction,secondClient.getAccount("123456789012346"),"12345","12345");

    }

    @Test
    public void testWireoutReturnAccountAmount(){
            assertEquals(firstClient.getAccount("123456789012345").getAmount(),new BigDecimal(1000));
            assertEquals(secondClient.getAccount("123456789012346").getAmount(),new BigDecimal(2000));
    }
    
}

