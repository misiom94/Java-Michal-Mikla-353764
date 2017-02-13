/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.uni.math.transactions;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import pl.lodz.uni.math.bank.Account;
import pl.lodz.uni.math.bank.Client;
import pl.lodz.uni.math.exceptions.*;


public abstract class Transaction {
    
    private Client client;
    private Account account;
    private BigDecimal moneySum;
    private String description;
    private Date date;
    private TransactionType transactionType;
    private Integer transactionNumber;
    
    public Transaction(Client client, Account account, double moneySum, String description,
            TransactionType transactionType, Integer transactionNumber) throws NotExistAccountException, WrongClientOwnerException{
        if(account.getClient()==null){
            throw new NotExistAccountException();
        }
        else if(!account.getClient().equals(client)){
            throw new WrongClientOwnerException();
        }
        else{
            this.client = client;
            this.account = account;
            this.moneySum = new BigDecimal(moneySum);
            this.description = description;
            Date date = new Date();
            this.date = date;
            this.transactionType = transactionType;
            this.transactionNumber = transactionNumber;
        }
    }
    public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Account getBankAccount() {
		return account;
	}

	public void setBankAccount(Account account) {
		this.account = account;
	}

	public double getMoneySum() {
		return moneySum.doubleValue();
	}

	public void setMoneySum(double moneySum) {
		this.moneySum = new BigDecimal(moneySum);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}
	

	public Integer getTransactionNumber() {
		return transactionNumber;
	}

	public void setTransactionNumber(Integer transactionNumber) {
		this.transactionNumber = transactionNumber;
	}
    
    
}
