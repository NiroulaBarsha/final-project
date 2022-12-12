package ca.sait.database;

import java.sql.SQLException;
import java.util.*;
import javax.persistence.*;
import ca.sait.models.Category;
public class CategoryDB {
    public List<Category> getAll() throws SQLException {
        List<Category> categories;
        EntityManagerFactory emFactory = DBUtil.getEmFactory();
        
        EntityManager em = emFactory.createEntityManager();
        try {
            categories = em.createNamedQuery("Category.findAll", Category.class).getResultList();
        } finally {
            em.close();
        }
        return categories;
    }
    public Category get(Integer categoryId) throws SQLException{
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            Category category = em.find(Category.class, categoryId);
            return category;
        } finally {
            em.close();
        }
    }
    
    public void create(Category category) throws SQLException{
        EntityManagerFactory emFactory = DBUtil.getEmFactory();
        
        EntityManager em = emFactory.createEntityManager();
        
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.persist(category);
            trans.commit();
        } catch (Exception ex) {
            trans.rollback();
        } finally {
            em.close();
        }
        
    }
    
    public void update(Category category) throws SQLException {
        EntityManagerFactory emFactory = DBUtil.getEmFactory();
        
        EntityManager em = emFactory.createEntityManager();
        
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.merge(category);
            trans.commit();
        } catch (Exception ex) {
            trans.rollback();
        } finally {
            em.close();
        }
        
    }
    
    public void delete(Category category) throws SQLException {
        EntityManagerFactory emFactory = DBUtil.getEmFactory();
        
        EntityManager em = emFactory.createEntityManager();
        
        EntityTransaction trans = em.getTransaction();
        
        Category ref = em.find(Category.class, category.getCategoryId());
        
        
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
