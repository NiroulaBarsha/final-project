package ca.sait.services;

import ca.sait.database.RoleDB;
import java.sql.SQLException;
import java.util.List;
import ca.sait.models.Role;

public class RoleService {
    public List<Role> getAll() {
        RoleDB roleDB = new RoleDB();
        List<Role> roles = null;
        try {
            roles = roleDB.getAll();
        } catch(SQLException ex) {
            System.err.println(ex);
        }
        
        return roles;
    }
    public Role get(int id) {
        RoleDB roleDB = new RoleDB();
        Role role = null;
        try {
            role = roleDB.get(id);
        } catch(SQLException ex) {
            System.err.println(ex);
        }
        return role;
    }
    
    public void create(int id, String name) {
        RoleDB roleDB = new RoleDB();
        Role role = new Role(id, name);
        try {
            roleDB.create(role);
        } catch(SQLException ex) {
            System.err.println(ex);
        }
        
    }
    
    public void update(int id, String name) {
        RoleDB roleDB = new RoleDB();
        try {
            Role role = roleDB.get(id);
            role.setRoleName(name);
            roleDB.update(role);
        } catch(SQLException ex) {
            System.err.println(ex);
        }
        
    }
    
    public void delete(int id) {
        RoleDB roleDB = new RoleDB();
        try {
            Role role = roleDB.get(id);
            roleDB.delete(role);
        } catch(SQLException ex) {
            System.err.println(ex);
        }
    }
}
