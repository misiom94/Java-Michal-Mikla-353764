/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.uni.math.daofactory;

import java.util.List;
import pl.lodz.uni.math.user.User;

/**
 *
 * @author user
 */
public interface Source {
    
    public List<User> selectAllUsers();
    public User selectUserByID(int id);
    
}
