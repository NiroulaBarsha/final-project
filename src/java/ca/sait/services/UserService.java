package ca.sait.services;

import ca.sait.database.UserDB;
import ca.sait.models.Role;
import java.sql.SQLException;
import java.util.List;
import ca.sait.models.User;

public class UserService {
    public List<User> getAll() {
        UserDB userDB = new UserDB();
        List<User> users = null;
        try {
            users = userDB.getAll();
        } catch(SQLException ex) {
            System.err.println(ex);
        }
        
        return users;
    }
    public User get(String email) {
        UserDB userDB = new UserDB();
        User user = null;
        try {
            user = userDB.get(email);
            
        } catch(SQLException ex) {
            System.err.println(ex);
        }
        return user;
    }

    
    public void create(String email, boolean active, String firstName, String lastName, String password, Role role) {
        UserDB userDB = new UserDB();
        User user = new User(email, active, firstName, lastName, password);
        user.setRole(role);
        try {
            userDB.create(user);
        } catch(SQLException ex) {
            System.err.println(ex);
        }
        
    }
    
    public void update(String email, boolean active, String firstName, String lastName, String password, Role role) {
        UserDB userDB = new UserDB();
        try {
            User user = userDB.get(email);
            user.setActive(active);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setPassword(password);
            user.setRole(role);
            userDB.update(user);
        } catch(SQLException ex) {
            System.err.println(ex);
        }
        
    }
    
    public void delete(String email) {
        UserDB userDB = new UserDB();
        try {
            User user = userDB.get(email);
            userDB.delete(user);
        } catch(SQLException ex) {
            System.err.println(ex);
        }
    }
}
