/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.uni.math.daofactory;

/**
 *
 * @author user
 */
public interface DaoFactory {
    
    public void setSourceOfData(SourceOfData source);
    
    public SourceOfData getSource();
    
}
