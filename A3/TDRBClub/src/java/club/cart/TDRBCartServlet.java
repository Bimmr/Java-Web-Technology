/**
 * TDRBCartServlet.java
 * 3/15/2017
 * Randy Bimm
 */
package club.cart;

import club.business.Book;
import club.business.ECart;
import club.business.ELoan;
import club.data.BookIO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TDRBCartServlet extends HttpServlet {

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
        HttpSession session = request.getSession(true);
        String action = request.getParameter("action");
        String code = request.getParameter("code");
        String url = "/TDRBECart.jsp";

        //Check if action exists
        if (action != null) {

            //If there is a code, and action is reserve.
            // Reserve the book by adding to the cart
            if (code != null && action.equals("reserve")) {
                getCart(session).addItem(BookIO.getBook(code,
                        context.getRealPath(
                                context.getInitParameter("booksFilePath")))
                );
                //Remove the book from the loan list
                ELoan.subtractFromQOH(
                        (ArrayList) context.getAttribute("loanItems"), code, 1);
            } //If action equals back, send to the load page
            else if (action.equals("back")) {
                url = "/TDRBLoan";
            }
        }

        //Count the total of books in the cart
        int total = 0;
        for (Book b : getCart(session).getItems()) {
            total += b.getQuantity();
        }
        request.setAttribute("total", total);

        context.getRequestDispatcher(url).forward(request, response);

    }

    public static ECart getCart(HttpSession session) {

        ECart cart;
        if (session.getAttribute("cart") == null) {
            session.setAttribute("cart", new ECart());
        }
        cart = (ECart) session.getAttribute("cart");
        return cart;
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
