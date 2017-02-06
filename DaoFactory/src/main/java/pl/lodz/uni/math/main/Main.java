/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.uni.math.main;

import java.util.logging.Logger;
import pl.lodz.uni.math.daofactory.DaoFactory;
import pl.lodz.uni.math.daofactory.SourceOfData;

public class Main {

 public static void main(String[] args) {
        
        Logger logger = Logger.getLogger(Main.class.getName());
    	
    	DaoFactory daoFactory = new DaoFactory();
    	daoFactory.setDataSource(SourceOfData.DB);
    	daoFactory.getSourceOfData().selectUserByID(1);
    	daoFactory.getSourceOfData().selectAllUsers();
    	DaoFactory daoFactory2 = new DaoFactory();
    	daoFactory2.setDataSource(SourceOfData.DB);
    	if(daoFactory.getSourceOfData().getClass().equals(daoFactory2.getSourceOfData().getClass())){
    		logger.info("Works");
    	}
    }
    
}
