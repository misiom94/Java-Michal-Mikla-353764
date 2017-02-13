/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.uni.math.bank;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import pl.lodz.uni.math.exceptions.*;

/**
 *
 * @author user
 */
public class Client {
    
    Logger logger = Logger.getRootLogger();
    private Integer ID;
    private String name;
    private List<Account> accountList;
    private Integer wireoutNumber;
    
    public Client(Integer id, String name) throws WrongClientNameException{
        if(!checkNameLength(name)){
            throw new WrongClientNameException();
        }
        else{
            this.ID = id;
            this.name = name;
            this.accountList = new ArrayList<Account>();
            this.wireoutNumber = 1000;
            logger.info("Client with ID: " + ID + " created...");
        }
    }
    public void addAcount(String number, String description) throws WrongBankAccountNumberException, EmptyBankAccountDescriptionException{
        Account account = new Account(number, description, this);
        accountList.add(account);
    }
    
    public Account getAccount(String number){
        for(Account acc : accountList){
            if(acc.getNumber().equals(number)){
                return acc;
            }
        }
        return new Account();
    }
    

    private boolean checkNameLength(String name) {
        if(name.length() < 2 || name.length()> 30)
        {
            return false;
        }
        return true;
    }

    public Integer getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public Integer getWireoutNumber() {
        return wireoutNumber;
    }
    public void setID(Integer ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    public void setWireoutNumber(Integer wireoutNumber) {
        this.wireoutNumber = wireoutNumber;
    }
    
}
