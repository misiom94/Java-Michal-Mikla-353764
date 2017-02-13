package pl.lodz.uni.math.transactions;

import java.math.BigDecimal;
import pl.lodz.uni.math.exceptions.NotExistAccountException;
import pl.lodz.uni.math.exceptions.WrongClientOwnerException;

public class Deposit extends Transaction {
    
    public Deposit(ValuesForTransaction valuesForTransaction) throws NotExistAccountException, WrongClientOwnerException{
        super(valuesForTransaction.getClient(),valuesForTransaction.getAccount(), valuesForTransaction.getMoneySum(),
                valuesForTransaction.getDescription(), valuesForTransaction.getTransactionType(), valuesForTransaction.getTransactionNumber());
                
        BigDecimal newAmount = valuesForTransaction.getAccount().getAmount().add(new BigDecimal(valuesForTransaction.getMoneySum()));
        valuesForTransaction.getAccount().setAmount(newAmount);
    }
    
    
}
