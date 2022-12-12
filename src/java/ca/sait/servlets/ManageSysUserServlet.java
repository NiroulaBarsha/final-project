package ca.sait.servlets;

import ca.sait.models.Role;
import ca.sait.models.User;
import ca.sait.services.RoleService;
import ca.sait.services.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ManageSysUserServlet extends HttpServlet {

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
        UserService us = new UserService();
        RoleService rs = new RoleService();
        
        List<User> users = us.getAll();
        request.setAttribute("users", users);
        
        List<Role> roles = rs.getAll();
        request.setAttribute("roles", roles);
        
        String action = request.getParameter("action");
        
        if (action != null && action.equals("edit")) {
            String email = request.getParameter("user").replaceAll("\\s+", "+");
            request.setAttribute("editEnable", email);
            User user = us.get(email);
            request.setAttribute("editUser", user);
        } else if (action != null && action.equals("delete")) {
            String email = request.getParameter("user").replaceAll("\\s+", "+");
            us.delete(email);
            response.sendRedirect("managesysuser");
            return;
        } else if (action != null && action.equals("cancel")) {
            request.setAttribute("editEnable", null);
        }
        getServletContext().getRequestDispatcher("/WEB-INF/ManageSysUser.jsp").forward(request, response);
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
        UserService us = new UserService();
        RoleService rs = new RoleService();

        boolean active;
        
        String action = request.getParameter("action");
        
        if (action != null && action.equals("add")) {

            String email = request.getParameter("email");
            String fname = request.getParameter("firstName");
            String lname = request.getParameter("lastName");
            String password = request.getParameter("password");
            String role = request.getParameter("role");
            String inputActive = request.getParameter("active");

            active = inputActive != null && inputActive.equals("1");
            Role parseRole = rs.get(Integer.parseInt(role));
            
            us.create(email,active,fname,lname,password,parseRole);
            response.sendRedirect("managesysuser");
            return;
        } else if (action != null && action.equals("update")) {
            String email = request.getParameter("email").replaceAll("\\s+", "+");
            String fname = request.getParameter("firstName");
            String lname = request.getParameter("lastName");
            String password = request.getParameter("password");
            String role = request.getParameter("role");
            String inputActive = request.getParameter("active");
            
            
            active = inputActive != null && inputActive.equals("1");
            Role parseRole = rs.get(Integer.parseInt(role));
            
            us.update(email,active,fname,lname,password,parseRole);
            request.setAttribute("editEnable", null);
            response.sendRedirect("managesysuser");
            return;
        }
        getServletContext().getRequestDispatcher("/WEB-INF/ManageSysUser.jsp").forward(request, response);
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
