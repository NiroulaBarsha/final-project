package ca.sait.services;

import ca.sait.database.CategoryDB;
import java.sql.SQLException;
import java.util.List;
import ca.sait.models.Category;

public class CategoryService {
    public List<Category> getAll() {
        CategoryDB categoryDB = new CategoryDB();
        List<Category> categories = null;
        try {
            categories = categoryDB.getAll();
        } catch(SQLException ex) {
            System.err.println(ex);
        }
        
        return categories;
    }
    public Category get(int id) {
        CategoryDB categoryDB = new CategoryDB();
        Category category = null;
        try {
            category = categoryDB.get(id);
        } catch(SQLException ex) {
            System.err.println(ex);
        }
        return category;
    }
    
    public void create(int id, String name) {
        CategoryDB categoryDB = new CategoryDB();
        Category category = new Category(id,name);
        try {
            categoryDB.create(category);
        } catch(SQLException ex) {
            System.err.println(ex);
        }
        
    }
    
    public void update(int id, String name) {
        CategoryDB categoryDB = new CategoryDB();
        try {
            Category category = categoryDB.get(id);
            category.setCategoryName(name);
            categoryDB.update(category);
        } catch(SQLException ex) {
            System.err.println(ex);
        }
        
    }
    
    public void delete(int id) {
        CategoryDB categoryDB = new CategoryDB();
        try {
            Category category = categoryDB.get(id);
            categoryDB.delete(category);
        } catch(SQLException ex) {
            System.err.println(ex);
        }
    }
}
