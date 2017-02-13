/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.uni.math.bank;

import pl.lodz.uni.math.exceptions.AccountNotEnoughMoneyException;
import pl.lodz.uni.math.exceptions.EmptyBankAccountDescriptionException;
import pl.lodz.uni.math.exceptions.NotExistAccountException;

import java.math.BigDecimal;
import java.util.ArrayList;

import pl.lodz.uni.math.exceptions.WrongBankAccountNumberException;
import pl.lodz.uni.math.exceptions.WrongClientOwnerException;
import pl.lodz.uni.math.transactions.Check;
import pl.lodz.uni.math.transactions.Deposit;
import pl.lodz.uni.math.transactions.Transaction;
import pl.lodz.uni.math.transactions.TransactionType;
import pl.lodz.uni.math.transactions.ValuesForTransaction;
import pl.lodz.uni.math.transactions.Wireout;

/**
 *
 * @author user
 */
public class Account {
    
    private String number;
    private String decription;
    private Client client;
    private BigDecimal amount;
    private Integer depositNumber;
    private Integer checkNumber;
    private ArrayList<Transaction> transactionHistory;
    
    public Account(){
        this.decription = "No account created";
    }
    
    public Account(String number, String description, Client client) throws WrongBankAccountNumberException, EmptyBankAccountDescriptionException
    {
        if(!checkBankAccountNumber(number) || !validBankAccount(number)){
            throw new WrongBankAccountNumberException();
        }
        else if(description == ""){
            throw new EmptyBankAccountDescriptionException();
        }
        else{
            this.number = number;
            this.decription = description;
            this.client = client;
            this.amount = new BigDecimal(0);
            this.depositNumber = 10000;
            this.checkNumber = 1000;
            transactionHistory = new ArrayList<Transaction>();
        }
    }
    
    private boolean checkBankAccountNumber(String number){
        if(number.length()!=15)
        {
            return false;
        }
        return true;
    }

    private boolean validBankAccount(String number) {
        char[] numbersTab = number.toCharArray();
        for(char numberValue : numbersTab){
            if(Character.isAlphabetic(numberValue)){
                return false;
            }
        }
        return true;
    }
    
    public void doDeposit(Double moneySum, String description) throws NotExistAccountException, WrongClientOwnerException{
    	ValuesForTransaction valuesForTransaction = new ValuesForTransaction(client, this, moneySum, 
    			decription, TransactionType.DEPOSIT, getDepositNumber());
    	Transaction deposit = new Deposit(valuesForTransaction);
    	transactionHistory.add(deposit);
    	setDepositNumber(depositNumber+1);
    }
    
    public void doCheck(Double moneySum, String description) throws NotExistAccountException, WrongClientOwnerException, AccountNotEnoughMoneyException{
    	ValuesForTransaction valuesForTransaction = new ValuesForTransaction(client, this, moneySum,
    			description, TransactionType.CHECK, getCheckNumber());
    	Transaction check = new Check(valuesForTransaction);
    	transactionHistory.add(check);
    	setCheckNumber(checkNumber++);
    }
    
    public void doWireout(Double moneySum, String description, Account toAccount, String country, String swift) throws NotExistAccountException, WrongClientOwnerException, EmptyBankAccountDescriptionException{
    	ValuesForTransaction valuesForTransaction = new ValuesForTransaction(client, this, moneySum,
    			description, TransactionType.WIREOUT, client.getWireoutNumber());
    	Transaction wireout = new Wireout(valuesForTransaction, toAccount, country, swift);
    	transactionHistory.add(wireout);
    	client.setWireoutNumber(client.getWireoutNumber()+1);
    }
    
    public void setNumber(String number) {
        this.number = number;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setDepositNumber(Integer depositNumber) {
        this.depositNumber = depositNumber;
    }

    public void setCheckNumber(Integer checkNumber) {
        this.checkNumber = checkNumber;
    }
    public String getNumber() {
        return number;
    }

    public String getDecription() {
        return decription;
    }

    public Client getClient() {
        return client;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Integer getDepositNumber() {
        return depositNumber;
    }

    public Integer getCheckNumber() {
        return checkNumber;
    }

	public ArrayList<Transaction> getTransactionHistory() {
		return transactionHistory;
	}

	public void setTransactionHistory(ArrayList<Transaction> transactionHistory) {
		this.transactionHistory = transactionHistory;
	}
    
    
    
}
