package ca.sait.services;

import ca.sait.database.ItemDB;
import ca.sait.models.Category;
import java.sql.SQLException;
import java.util.List;
import ca.sait.models.Item;
import ca.sait.models.User;

public class ItemService {
    public List<Item> getAll() {
        ItemDB itemDB = new ItemDB();
        List<Item> items = null;
        try {
            items = itemDB.getAll();
        } catch(SQLException ex) {
            System.err.println(ex);
        }
        
        return items;
    }
    public List<Item> getAllOf(String email) {
        ItemDB itemDB = new ItemDB();
        List<Item> items = null;
        try {
            items = itemDB.getAllOf(email);
        } catch(SQLException ex) {
            System.err.println(ex);
        }
        
        return items;
    }
    public Item get(int id) {
        ItemDB itemDB = new ItemDB();
        Item item = null;
        try {
            item = itemDB.get(id);
            
        } catch(SQLException ex) {
            System.err.println(ex);
        }
        return item;
    }
    
    public void create(int id, String name, double price, Category category, User owner) {
        ItemDB itemDB = new ItemDB();
        Item item = new Item(id, name,price);
        item.setCategory(category);
        item.setOwner(owner);
        try {
            itemDB.create(item);
        } catch(SQLException ex) {
            System.err.println(ex);
        }
        
    }
    
    public void update(int id, String name, double price, Category category, User owner) {
        ItemDB itemDB = new ItemDB();
        try {
            Item item = itemDB.get(id);
            item.setItemName(name);
            item.setPrice(price);
            item.setCategory(category);
            item.setOwner(owner);
            itemDB.update(item);
        } catch(SQLException ex) {
            System.err.println(ex);
        }
        
    }
    
    public void delete(int id) {
        ItemDB itemDB = new ItemDB();
        try {
            Item item = itemDB.get(id);
            itemDB.delete(item);
        } catch(SQLException ex) {
            System.err.println(ex);
        }
    }
}
