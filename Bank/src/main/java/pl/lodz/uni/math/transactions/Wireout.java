/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.uni.math.transactions;

import java.math.BigDecimal;
import pl.lodz.uni.math.bank.Account;
import pl.lodz.uni.math.exceptions.*;

/**
 *
 * @author user
 */
public class Wireout extends Transaction {
    private String country;
    private String swift;
    private Account account;
    
    public Wireout(ValuesForTransaction valuesForTransaction, Account toAccount, String country, String swift ) throws NotExistAccountException, WrongClientOwnerException, EmptyBankAccountDescriptionException{
        super(valuesForTransaction.getClient(), valuesForTransaction.getAccount(), 
                valuesForTransaction.getMoneySum(), valuesForTransaction.getDescription(),
                valuesForTransaction.getTransactionType(),valuesForTransaction.getTransactionNumber());
        if(toAccount.getClient()==null){
            throw new NotExistAccountException();
        }
        else{
            if(valuesForTransaction.getAccount().getAmount().doubleValue() < valuesForTransaction.getMoneySum()){
                throw new EmptyBankAccountDescriptionException();
            }
            else{
                this.country = country;
                this.swift = swift;
                this.account = toAccount;
                BigDecimal setAmountToSend = valuesForTransaction.getAccount().getAmount().subtract(
                        new BigDecimal(valuesForTransaction.getMoneySum()));
                valuesForTransaction.getAccount().setAmount(setAmountToSend);
                BigDecimal setAmountToGet = account.getAmount().add(new BigDecimal(valuesForTransaction.getMoneySum()));
                account.setAmount(setAmountToGet);
            }
            
        }
        
    }
    
    
}
