package pl.lodz.uni.math.main;

import java.util.logging.Logger;
import pl.lodz.uni.math.daofactory.Factory;
import pl.lodz.uni.math.daofactory.SourceOfData;

public class Main {

 public static void main(String[] args) {
        
       Logger logger = Logger.getLogger(Main.class.getName());
     
     Factory daoFactory = new Factory();
     daoFactory.setDataSource(SourceOfData.DB);
     daoFactory.getSourceOfData().selectUserByID(1);
     daoFactory.getSourceOfData().selectAllUsers();
        
     Factory daoFactory2 = new Factory();
     daoFactory2.setDataSource(SourceOfData.DB);
     daoFactory2.getSourceOfData().selectUserByID(1);
     daoFactory2.getSourceOfData().selectAllUsers();
      
     if(daoFactory.getSourceOfData().getClass().equals(daoFactory2.getSourceOfData().getClass())){
      logger.info("Works");
     }
        
        if(daoFactory2.getSourceOfData().getClass().equals(daoFactory2.getSourceOfData().getClass())){
      logger.info("Works");
    }
    
}
}
