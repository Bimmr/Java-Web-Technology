<%-- 
    Document   : TDRBDisplayBooks
    Created on : Feb 8, 2017, 4:46:43 PM
    Author     : tdolman9843
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="utf-8"%>
<html>


    <head>
        <meta charset="utf-8">
        <title>TDRB Computer Programming Club</title>
        <link rel="stylesheet" href="styles/main.css">
    </head>
    <jsp:include page="Parts/TDRBBanner.jsp"/>

    <section>
        <h1> List of Books </h1>
        <table>
            <tr>
                <th>Code</th>
                <th>Description</th>
                <th>Quantity</th>
            </tr>
            <c:forEach var="book" items="${books}">
                <tr>
                    <td>${book.code}</td>
                    <td>${book.description}</td>
                    <td>${book.quantity} </td>
                </tr>
            </c:forEach>
        </table>
        <form method="get" action="TDRBAddBook.jsp">
            <button type="submit">Add Book</button>
        </form>

    </section>

    <jsp:include page="Parts/TDRBFooter.jsp" />
</body>
</html>