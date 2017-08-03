/**
 * TDRBLoanServlet.java
 * 3/5/2017
 * Randy Bimm
 */
package club.admin;

import club.business.Member;
import club.data.MemberDB;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author rbimm5674
 *
 */
public class TDRBMemberAdminController extends HttpServlet {

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

        // ------------------------------------------------------------
        //TODO: Add delete
        // ------------------------------------------------------------
        //Variables
        ServletContext context = getServletContext();
        String path = "/TDRBDisplayMembers.jsp";

        //Get the action
        String action = request.getParameter("action");
        if (action == null) {
            action = "displayMembers";
        }
        
        //Display
        if (action.equals("displayMembers")) {
            request.setAttribute("members", MemberDB.selectMembers());
        } //Update (Seperate to keep error msg from showing right away)
        else if (action.equals("updateMember")) {
            path = "/TDRBMember.jsp";
            Member member = MemberDB.selectMember(request.getParameter("emailAddress"));
            request.setAttribute("member", member);
            request.setAttribute("action", "validateUpdate");
            request.setAttribute("method", "POST");
        } //Add (Seperate to keep error msg from showing right away)
        else if (action.equals("addMember")) {
            path = "/TDRBMember.jsp";
            request.setAttribute("action", "validateAdd");
            request.setAttribute("method", "GET");
        } //Delete
        else if (action.equals("deleteMember")) {
            Member member = MemberDB.selectMember(request.getParameter("emailAddress"));
            request.setAttribute("member", member);
            String confirm = request.getParameter("confirm");
            
            //Confirm delete
            if (confirm != null && confirm.equals("yes")) {
                MemberDB.delete(member);
                JOptionPane.showMessageDialog(null, "Member had been deleted.");
                request.setAttribute("action", "displayMembers");
            }//Don't Delete
            else if (confirm != null && confirm.equals("no")) {
                request.setAttribute("members", MemberDB.selectMembers());
                request.setAttribute("action", "displayMembers");
                path = "/TDRBDisplayMembers.jsp";
            } else {
                path = "/TDRBConfirmMemberDelete.jsp";
            }
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

        ServletContext context = getServletContext();
        String path = "/TDRBDisplayMembers.jsp";

        //Get the action
        String action = request.getParameter("action");
        context.log(action);

        if (action.equals("validateAdd")) {

            //Get all fields
            String name = (String) request.getParameter("name");
            String email = (String) request.getParameter("email");
            String phone = (String) request.getParameter("phone");
            String itProgram = (String) request.getParameter("progam");
            String errorMsg = "";

            //Get year
            int yearLevel = 0;
            if ((String) request.getParameter("level") != null) {
                yearLevel = Integer.parseInt(
                        (String) request.getParameter("level"));
            }

            //Create the member
            Member member = new Member(name, email);
            member.setPhoneNumber(phone);
            member.setProgramName(itProgram);
            member.setYearLevel(yearLevel);

            //Check if the member is valid
            if (!member.isValid()) {
                errorMsg += "Member information is not valid. "
                        + "You must enter a valid name and email.";
            }

            //If there is an error, inform and keep data
            if (!errorMsg.equals("")) {
                request.setAttribute("error", errorMsg);
                request.setAttribute("member", member);
                request.setAttribute("action", action);
                path = "/TDRBMember.jsp";
            } //If there is no error, add them, and forward accordingly
            else {

                if (MemberDB.emailExists(email)) {
                    JOptionPane.showMessageDialog(null, "Email already exists, updated existing record.");
                    MemberDB.update(member);
                } else {
                    MemberDB.insert(member);
                }
                request.setAttribute("members", MemberDB.selectMembers());
                request.setAttribute("action", "displayMembers");
                path = "/TDRBDisplayMembers.jsp";
            }
            context.getRequestDispatcher(path).forward(request, response);
        } else {
            processRequest(request, response);
        }
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

        ServletContext context = getServletContext();
        String path = "/TDRBDisplayMembers.jsp";

        //Get the action
        String action = request.getParameter("action");
        if (action.equals("validateUpdate")) {

            //Get all fields
            String name = (String) request.getParameter("name");
            String email = (String) request.getParameter("email");
            String phone = (String) request.getParameter("phone");
            String itProgram = (String) request.getParameter("progam");
            String errorMsg = "";

            //Get year
            int yearLevel = 0;
            if ((String) request.getParameter("level") != null) {
                yearLevel = Integer.parseInt(
                        (String) request.getParameter("level"));
            }

            //Create the member
            Member member = new Member(name, email);
            member.setPhoneNumber(phone);
            member.setProgramName(itProgram);
            member.setYearLevel(yearLevel);

            //Check if the member is valid
            if (!member.isValid()) {
                errorMsg += "Member information is not valid. "
                        + "You must enter a valid name and email.";
            }

            //If there is an error, inform and keep data
            if (!errorMsg.equals("")) {
                request.setAttribute("error", errorMsg);
                request.setAttribute("member", member);
                request.setAttribute("action", action);
                path = "/TDRBMember.jsp";
            } //If there is no error, add them, and forward accordingly
            else {
                //If not able to update, then insert
                if (MemberDB.update(member) == 0) {
                    JOptionPane.showMessageDialog(null, "Email doesn't exist, created new record.");
                    MemberDB.insert(member);
                }
                request.setAttribute("members", MemberDB.selectMembers());
                request.setAttribute("action", "displayMembers");
                path = "/TDRBDisplayMembers.jsp";
            }

            context.getRequestDispatcher(path).forward(request, response);
        } else {
            processRequest(request, response);
        }
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
