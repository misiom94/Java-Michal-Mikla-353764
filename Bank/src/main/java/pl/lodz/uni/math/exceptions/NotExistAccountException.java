/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.uni.math.exceptions;

public class NotExistAccountException extends Exception{
    @Override
    public String getMessage(){
        return "Account does not exist!";
    }
    
    
}
