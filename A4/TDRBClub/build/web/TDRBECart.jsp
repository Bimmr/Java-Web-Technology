<%-- 
    Document   : ECart
    Created on : March 8, 2017, 4:15:35 PM
    Author     : rbimm5674
--%>


<!doctype html>
<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
    <head>
        <meta charset="utf-8">
        <title>TDRB Computer Programming Club</title>
        <link rel="stylesheet" href="styles/main.css">
    </head>

    <body>
        <jsp:include page="Parts/TDRBBanner.jsp"/>

        <section>

            <table>
                <tr><h2>Your Loan Cart</h2></tr>
                <tr>
                    <th>Code</th>
                    <th>Description</th>
                    <th>Quantity</th>
                </tr>
                <c:forEach var="item" items="${sessionScope.cart.items}">
                    <tr>
                        <td>${item.code}</td>
                        <td>${item.description}</td>
                        <td>${item.quantity}</td>
                    </tr>
                </c:forEach>
            </table>
            <table style="margin-left: 200px">
                <tr>
                    <td>Total:</td>
                    <td>${total}</td>
                </tr>
            </table>

                <h2><a href="TDRBClearCart">Clear The Cart</a></h2>
                <h2><a href="TDRBCart?action=back" >Return to ELoan</a></h2>

        </section>

        <jsp:include page="Parts/TDRBFooter.jsp" />
    </body>
</html>


