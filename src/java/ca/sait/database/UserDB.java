package ca.sait.database;

import java.sql.SQLException;
import java.util.*;
import javax.persistence.*;
import ca.sait.models.User;

public class UserDB {
    public List<User> getAll() throws SQLException {
        List<User> users;
        EntityManagerFactory emFactory = DBUtil.getEmFactory();
        
        EntityManager em = emFactory.createEntityManager();
        try {
            users = em.createNamedQuery("User.findAll", User.class).getResultList();
        } finally {
            em.close();
        }
        return users;
    }
    public User get(String email) throws SQLException{
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            User user = em.find(User.class, email);
            return user;
        } finally {
            em.close();
        }
    }
    
    public void create(User user) throws SQLException{
        EntityManagerFactory emFactory = DBUtil.getEmFactory();
        
        EntityManager em = emFactory.createEntityManager();
        
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.persist(user);
            trans.commit();
        } catch (Exception ex) {
            trans.rollback();
        } finally {
            em.close();
        }
        
    }
    
    public void update(User user) throws SQLException {
        EntityManagerFactory emFactory = DBUtil.getEmFactory();
        
        EntityManager em = emFactory.createEntityManager();
        
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.merge(user);
            trans.commit();
        } catch (Exception ex) {
            trans.rollback();
        } finally {
            em.close();
        }
        
    }
    
    public void delete(User user) throws SQLException {
        EntityManagerFactory emFactory = DBUtil.getEmFactory();
        
        EntityManager em = emFactory.createEntityManager();
        
        EntityTransaction trans = em.getTransaction();
        
        User ref = em.find(User.class, user.getEmail());
        
        
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
