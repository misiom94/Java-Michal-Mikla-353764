/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.uni.math.exceptions;

/**
 *
 * @author user
 */
public class EmptyBankAccountDescriptionException extends Exception {

    @Override
	public String getMessage() {
		
		return "Bank account description is null or empty";
		
	}
    
}
