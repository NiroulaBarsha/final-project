package ca.sait.database;

import java.sql.SQLException;
import java.util.*;
import javax.persistence.*;
import ca.sait.models.Item;

public class ItemDB {
    public List<Item> getAll() throws SQLException {
        List<Item> items = null;
        EntityManagerFactory emFactory = DBUtil.getEmFactory();
        
        EntityManager em = emFactory.createEntityManager();
        try {
            items = em.createNamedQuery("Item.findAll", Item.class).getResultList();
        } finally {
            em.close();
        }
        return items;
    }
    public List<Item> getAllOf(String email) throws SQLException {
        List<Item> items = new ArrayList<>();
        EntityManagerFactory emFactory = DBUtil.getEmFactory();
        
        EntityManager em = emFactory.createEntityManager();
        try {
             for(Item item: em.createNamedQuery("Item.findAll", Item.class).getResultList()) {
                 if (item.getOwner().getEmail().equals(email)) {
                     items.add(item);
                 }
             }
        } finally {
            em.close();
        }
        return items;
    }
    public Item get(Integer itemId) throws SQLException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            Item item = em.find(Item.class, itemId);
            return item;
        } finally {
            em.close();
        }
    }
    
    public void create(Item item) throws SQLException{
        EntityManagerFactory emFactory = DBUtil.getEmFactory();
        
        EntityManager em = emFactory.createEntityManager();
        
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.persist(item);
            trans.commit();
        } catch (Exception ex) {
            trans.rollback();
        } finally {
            em.close();
        }
        
    }
    
    public void update(Item item) throws SQLException {
        EntityManagerFactory emFactory = DBUtil.getEmFactory();
        
        EntityManager em = emFactory.createEntityManager();
        
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.merge(item);
            trans.commit();
        } catch (Exception ex) {
            trans.rollback();
        } finally {
            em.close();
        }
        
    }
    
    public void delete(Item item) throws SQLException {
        EntityManagerFactory emFactory = DBUtil.getEmFactory();
        
        EntityManager em = emFactory.createEntityManager();
        
        EntityTransaction trans = em.getTransaction();
        
        Item ref = em.find(Item.class, item.getItemId());
        
        
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
