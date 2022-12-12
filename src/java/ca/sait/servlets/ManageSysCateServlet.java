package ca.sait.servlets;

import ca.sait.models.Category;
import ca.sait.services.CategoryService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ManageSysCateServlet extends HttpServlet {

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
        CategoryService cs = new CategoryService();
        
        List<Category> categories = cs.getAll();
        request.setAttribute("categories", categories);
        
        String action = request.getParameter("action");
        
        if (action != null && action.equals("edit")) {
            String id = request.getParameter("category");
            request.setAttribute("editEnable", id);
            Category category = cs.get(Integer.parseInt(id));
            request.setAttribute("editCategory", category);
        } else if (action != null && action.equals("cancel")) {
            request.setAttribute("editEnable", null);
        }
        getServletContext().getRequestDispatcher("/WEB-INF/ManageSysCate.jsp").forward(request, response);
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
        CategoryService cs = new CategoryService();
        List<Category> categories = cs.getAll();
        
        String action = request.getParameter("action");
        
        if (action != null && action.equals("add")) {
            String name = request.getParameter("category");
            int categoryId = categories.get(categories.size() - 1).getCategoryId() + 1;

            cs.create(categoryId, name);
            response.sendRedirect("managesyscate");
            return;
        } else if (action != null && action.equals("update")) {
            String id = request.getParameter("id");
            
            String name = request.getParameter("category");
            int categoryId = Integer.parseInt(id);
             
            cs.update(categoryId, name);
            request.setAttribute("editEnable", null);
            response.sendRedirect("managesyscate");
            return;
        }
        getServletContext().getRequestDispatcher("/WEB-INF/ManageSysCate.jsp").forward(request, response);
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
