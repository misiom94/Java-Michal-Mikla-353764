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
public class XmlSource implements Source {
    
    private User userMock;
    List<User> listUserMock = EasyMock.mock(List.class);
    private static XmlSource xmlInstance = null;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(XmlSource.class.getName());
    
    public static XmlSource getInstance() {
		if(xmlInstance==null){
                    xmlInstance = new XmlSource();
                }
                return xmlInstance;
	}
    
    public List<User> selectAllUsers() {
        
        EasyMock.expect(listUserMock.size()).andReturn(1).anyTimes();
        EasyMock.expect(listUserMock.get(1)).andReturn(userMock).anyTimes();
        EasyMock.replay(listUserMock);

        return listUserMock;

    }

    public User selectUserByID(Integer id) {
    	userMock = EasyMock.createMock(User.class);
        EasyMock.expect(userMock.getID()).andReturn(id).anyTimes();
        EasyMock.replay(userMock);

        return userMock;
    }
    
}
