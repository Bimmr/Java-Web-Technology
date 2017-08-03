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
 * @author tdolman9843
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

        //Setup variables
        ServletContext context = getServletContext();
        String action = request.getParameter("btnAction");
        String error = "";
        String path = "/TDRBAddBook.jsp";

        String code = request.getParameter("txtCode");
        String description = request.getParameter("txtDescription");
        String quantityString = request.getParameter("txtQuantity");
        int quantity = -1;

        //Safety check for action
        if (action == null) {
            action = "";
        }

        //Check the action to see if we're adding a new book
        if (action.equals("Submit")) {

            //Check code
            if (code == null || code.isEmpty()) {
                error += "Book code is required<br>";
            }
            //Check description
            if (description == null || description.length() < 2) {
                error += "Description must have at least 2 characters<br>";
            }

            //Try and parse the quantity
            if (quantityString != null && !quantityString.isEmpty()) {
                quantity = Integer.parseInt(quantityString);
            }

            //Check quantity
            if (quantity <= 0) {
                error += "Quantity must be a postive number<br>";
            }

            //If there is no error, 
            //  add the book and forward to the TDRBDisplayBooks servlet
            if (error.equals("")) {
                path = "/TDRBDisplayBooks";
                BookIO.insert(new Book(code, description, quantity),
                        context.getRealPath("/WEB-INF/books.txt"));
            } else {
                //If error, add error, and book object to request
                request.setAttribute("error", error);
                request.setAttribute("book", 
                        new Book(code, description, quantity));
            }
        } else {
            path = "/TDRBDisplayBooks";
        }
        
        context.getRequestDispatcher(path).forward(request, response);
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
