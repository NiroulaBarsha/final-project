package ca.sait.servlets;

import ca.sait.models.Category;
import ca.sait.models.Item;
import ca.sait.models.User;
import ca.sait.services.CategoryService;
import ca.sait.services.ItemService;
import ca.sait.services.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InventoryServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = (String) request.getSession().getAttribute("email");
        UserService us = new UserService();
        ItemService is = new ItemService();
        CategoryService cs = new CategoryService();
        
        String name = us.get(email).getLastName() + " " + us.get(email).getFirstName();
        request.setAttribute("name", name);
        
        List<Item> items = is.getAllOf(email);
        request.setAttribute("items", items);
        
        if(items.isEmpty()) {
            request.setAttribute("message", "No items");
        }
        
        List<Category> categories = cs.getAll();
        request.setAttribute("categories", categories);
        
        String action = request.getParameter("action");
        
        if (action != null && action.equals("edit")) {
            String id = request.getParameter("item");
            request.setAttribute("editEnable", id);
            Item item = is.get(Integer.parseInt(id));
            request.setAttribute("editItem", item);
        } else if (action != null && action.equals("delete")) {
            String id = request.getParameter("item");
            is.delete(Integer.parseInt(id));
            response.sendRedirect("inventory");
            return;
        } else if (action != null && action.equals("cancel")) {
            request.setAttribute("editEnable", null);
        }
        
       getServletContext().getRequestDispatcher("/WEB-INF/Inventory.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = (String) request.getSession().getAttribute("email");
        
        UserService us = new UserService();
        ItemService is = new ItemService();
        CategoryService cs = new CategoryService();
        
        User user = us.get(email);
        List<Item> items = is.getAll();
        
        String action = request.getParameter("action");
        
        if (action != null && action.equals("add")) {

            String category = request.getParameter("category");
            String name = request.getParameter("name");
            String price = request.getParameter("price");
            
            if(Double.parseDouble(price) < 0) {
                response.sendRedirect("inventory");
                return;
            }
            
            int id = items.get(items.size() - 1).getItemId() + 1;
            Category parseCategory = cs.get(Integer.parseInt(category));
            double parsePrice = Double.parseDouble(price);

            is.create(id, name, parsePrice,parseCategory,user);
            response.sendRedirect("inventory");
            return;
        } else if (action != null && action.equals("update")) {
            String id = request.getParameter("id");
            String category = request.getParameter("category");
            String name = request.getParameter("name");
            String price = request.getParameter("price");
            
            int parseId = Integer.parseInt(id);
            double parsePrice = Double.parseDouble(price);
            Category parseCategory = cs.get(Integer.parseInt(category));

            is.update(parseId,name,parsePrice,parseCategory,user);
            request.setAttribute("editEnable", null);
            response.sendRedirect("inventory");
            return;
        }
        getServletContext().getRequestDispatcher("/WEB-INF/Inventory.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
