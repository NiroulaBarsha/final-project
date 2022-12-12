package ca.sait.database;

import java.sql.SQLException;
import java.util.*;
import javax.persistence.*;
import ca.sait.models.Role;

public class RoleDB {
    public List<Role> getAll() throws SQLException {
        List<Role> roles;
        EntityManagerFactory emFactory = DBUtil.getEmFactory();
        
        EntityManager em = emFactory.createEntityManager();
        try {
            roles = em.createNamedQuery("Role.findAll", Role.class).getResultList();
        } finally {
            em.close();
        }
        return roles;
    }
    public Role get(Integer roleId) throws SQLException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            Role role = em.find(Role.class, roleId);
            return role;
        } finally {
            em.close();
        }
    }
    
    public void create(Role role) throws SQLException{
        EntityManagerFactory emFactory = DBUtil.getEmFactory();
        
        EntityManager em = emFactory.createEntityManager();
        
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.persist(role);
            trans.commit();
        } catch (Exception ex) {
            trans.rollback();
        } finally {
            em.close();
        }
        
    }
    
    public void update(Role role) throws SQLException {
        EntityManagerFactory emFactory = DBUtil.getEmFactory();
        
        EntityManager em = emFactory.createEntityManager();
        
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.merge(role);
            trans.commit();
        } catch (Exception ex) {
            trans.rollback();
        } finally {
            em.close();
        }
        
    }
    
    public void delete(Role role) throws SQLException {
        EntityManagerFactory emFactory = DBUtil.getEmFactory();
        
        EntityManager em = emFactory.createEntityManager();
        
        EntityTransaction trans = em.getTransaction();
        
        Role ref = em.find(Role.class, role.getRoleId());
        
        
        try {
            trans.begin();
            em.remove(ref);
            trans.commit();
        } catch (Exception ex) {
            trans.rollback();
        } finally {
            em.close();
        }
    }
}
