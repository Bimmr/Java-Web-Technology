/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package club.admin;

import club.business.Book;
import club.data.BookIO;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rbimm5674
 */
public class TDRBAddBookServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        //Remember everything
        request.setAttribute("code", 
                request.getParameter("txtCode"));
        request.setAttribute("description", 
                request.getParameter("txtDescription"));
        request.setAttribute("quantity", 
                request.getParameter("txtQuantity"));
        
        //Variables
        ServletContext context = getServletContext();
        String path = "/TDRBAddBook.jsp";
        String errors = "";

        //Paramaters
        String code = request.getParameter("txtCode");
        String description = request.getParameter("txtDescription");
        int quantity = -1;

        //Try and parse the int
        try {
            quantity = Integer.parseInt(request.getParameter("txtQuantity"));
        } catch (NumberFormatException e) {
        }

        //Check code
        if (code == null || code.isEmpty()) {
            errors += "Book code is required.<br>";
        }

        //Check description
        if (description == null || description.isEmpty()
                || description.length() < 2) {
            errors += "Description must have at least 2 characters.<br>";
        }

        //Check quantity
        if (quantity <= 0) {
            errors += "Quantity must be a positive number.<br>";
        }

        //If no errors have been found then add the book
        if (errors.isEmpty()) {
            path = "/TDRBDisplayBooks";
            BookIO.insert(new Book(code, description, quantity),
                    context.getRealPath("/WEB-INF/books.txt"));
        }
        //Add the errors to the request
        request.setAttribute("errors", errors);

        //Forward
        context.getRequestDispatcher(path)
                .forward(request, response);
    }

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
        processRequest(request, response);
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
        processRequest(request, response);
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
