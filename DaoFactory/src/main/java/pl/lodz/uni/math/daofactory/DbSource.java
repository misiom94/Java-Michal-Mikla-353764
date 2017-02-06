/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.uni.math.daofactory;

import java.util.List;
import org.easymock.EasyMock;
import pl.lodz.uni.math.user.User;

/**
 *
 * @author user
 */
public class DbSource implements Source {
    
    private User userMock = EasyMock.createMock(User.class);
    private static DbSource databaseSource = new DbSource();
    
    public static DbSource getInstance(){
        return databaseSource;
    }
    

    @Override
    public List<User> selectAllUsers() {
        
        List<User> listUserMock = EasyMock.mock(List.class);
        EasyMock.expect(listUserMock.size()).andReturn(1).anyTimes();
        EasyMock.expect(listUserMock.get(1)).andReturn(userMock).anyTimes();
        EasyMock.replay(listUserMock);
        
        return listUserMock;
    }

    @Override
    public User selectUserByID(int id) {
        EasyMock.expect(userMock.getID()).andReturn(id).anyTimes();
        EasyMock.expect(userMock.getName()).andReturn("DataBase").anyTimes();
        EasyMock.replay(userMock);

        return userMock;
    }
    
}
