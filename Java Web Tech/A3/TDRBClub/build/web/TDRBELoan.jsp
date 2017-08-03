<%-- 
    Document   : ELoan
    Created on : March 8, 2017, 2:55:00 PM
    Author     : rbimm5674
--%>

<!doctype html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="utf-8"%>
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
                <tr>
                    <th>Code</th>
                    <th>Description</th>
                    <th>QOH</th>
                    <th>Action</th>
                </tr>
                <c:forEach var="item" items="${applicationScope.loanItems}">
                    <tr>
                        <td>${item.code}</td>
                        <td>${item.description}</td>
                        <td>${item.quantity}</td>
                        <td>${item.quantity == 0 ? "N/A": 
                              ('<a href=\'TDRBCart?action=reserve&code=')
                              .concat(item.code).concat('\'>Reserve</a>')}</td>
                    </tr>
                </c:forEach>
            </table>
        </section>

        <jsp:include page="Parts/TDRBFooter.jsp" />
    </body>
</html>


