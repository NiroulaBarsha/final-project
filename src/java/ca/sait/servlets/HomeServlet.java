
package ca.sait.servlets;

import ca.sait.models.User;
import ca.sait.services.RoleService;
import ca.sait.services.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeServlet extends HttpServlet {

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
        User user = us.get(email);
        request.setAttribute("user",user);
        
        String action = request.getParameter("action");
        
        if (action != null && action.equals("unactive")) {
            us.update(user.getEmail(),false,user.getFirstName(),user.getLastName(),user.getPassword(),user.getRole());
            response.sendRedirect("login");
            return;
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/Home.jsp").forward(request, response);
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
        RoleService rs = new RoleService();
            
        String fName = request.getParameter("firstName");
        String lName = request.getParameter("lastName");
        String password = request.getParameter("password");      

        us.update(email,true,fName,lName,password,rs.get(2));
        request.setAttribute("editEnable", null);
        response.sendRedirect("home");
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
