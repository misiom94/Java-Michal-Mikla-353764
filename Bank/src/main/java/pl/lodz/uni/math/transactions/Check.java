/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.uni.math.transactions;

import java.math.BigDecimal;
import pl.lodz.uni.math.exceptions.AccountNotEnoughMoneyException;
import pl.lodz.uni.math.exceptions.NotExistAccountException;
import pl.lodz.uni.math.exceptions.WrongClientOwnerException;

/**
 *
 * @author user
 */
public class Check extends Transaction {
    
    public Check(ValuesForTransaction valuesForTransaction) throws NotExistAccountException, WrongClientOwnerException, AccountNotEnoughMoneyException{
        super(valuesForTransaction.getClient(), valuesForTransaction.getAccount(), valuesForTransaction.getMoneySum(),
                valuesForTransaction.getDescription(), valuesForTransaction.getTransactionType(),
                valuesForTransaction.getTransactionNumber());
        if(valuesForTransaction.getAccount().getAmount().doubleValue() < valuesForTransaction.getMoneySum())
        {
            throw new AccountNotEnoughMoneyException();
        }
        else{
            BigDecimal newAccountAmount = valuesForTransaction.getAccount().getAmount().subtract(new BigDecimal(valuesForTransaction.getMoneySum()));
            valuesForTransaction.getAccount().setAmount(newAccountAmount);
            super.addToTransactionHistory(this);
        }
        
    }
    
    
    
}
