package pl.lodz.uni.math.transactions;

import pl.lodz.uni.math.bank.Account;
import pl.lodz.uni.math.bank.Client;

public class ValuesForTransaction {
    
    private Client client;
    private Account account;
    private double moneySum;
    private TransactionType transactionType;
    private Integer transactionNumber;
    private String description;
    
    public ValuesForTransaction(Client client, Account account, double moneySum, String decription,
            TransactionType transactionType, Integer transactionNumber){
        this.client = client;
        this.account = account;
        this.moneySum = moneySum;
        this.transactionType = transactionType;
        this.transactionNumber = transactionNumber;
        this.description = description;
    }
    public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Account getAccount() {
		return account;
	}

	public void setBankAccount(Account account) {
		this.account = account;
	}

	public double getMoneySum() {
		return moneySum;
	}

	public void setMoneySum(double moneySum) {
		this.moneySum = moneySum;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
