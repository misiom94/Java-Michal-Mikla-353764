/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.uni.math.bank;

import pl.lodz.uni.math.exceptions.EmptyBankAccountDescriptionException;
import java.math.BigDecimal;
import pl.lodz.uni.math.exceptions.WrongBankAccountNumberException;

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
    
}
