
import org.apache.log4j.Logger;

import pl.lodz.uni.math.bank.Bank;
import pl.lodz.uni.math.bank.Client;
import pl.lodz.uni.math.exceptions.AccountNotEnoughMoneyException;
import pl.lodz.uni.math.exceptions.EmptyBankAccountDescriptionException;
import pl.lodz.uni.math.exceptions.NotExistAccountException;
import pl.lodz.uni.math.exceptions.WrongBankAccountNumberException;
import pl.lodz.uni.math.exceptions.WrongClientNameException;
import pl.lodz.uni.math.exceptions.WrongClientOwnerException;

public class Main {

	private static Logger logger = Logger.getLogger(Main.class.getName());
	
	public static void main(String[] args) throws WrongClientNameException, WrongBankAccountNumberException, EmptyBankAccountDescriptionException, NotExistAccountException, WrongClientOwnerException, AccountNotEnoughMoneyException {
		Bank bankING = new Bank("ING");
		
		Client client1 = new Client(1, "One");
		Client client2 = new Client(2, "Two");
		
		bankING.addClient(client1);
		bankING.addClient(client2);
		
		
		logger.info(bankING.getClientsList().get(0).getName());
		logger.info(bankING.getClientsList().get(1).getName());
		
		client1.addAcount("123456789012345", "description");
		client2.addAcount("123456789012346", "description");
		
		client1.getAccount("123456789012345").doDeposit(1000.00, "description");
		
		logger.info(client1.getAccount("123456789012345").getAmount());
		
		client1.getAccount("123456789012345").doCheck(10.00, "description");
		
		logger.info(client1.getAccount("123456789012345").getAmount());
		
		client1.getAccount("123456789012345").doWireout(600.00, "description", client2.getAccount("123456789012346"), "Poland", "123456");
		
		logger.info(client1.getAccount("123456789012345").getAmount());
		logger.info(client2.getAccount("123456789012346").getAmount());
		
		if(bankING.getClientsList().get(0).equals(client1) && bankING.getClientsList().get(1).equals(client2)){
			logger.info("Good");
		}
	}

}
