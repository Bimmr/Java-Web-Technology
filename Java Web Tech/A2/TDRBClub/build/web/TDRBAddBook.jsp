<%-- 
    Document   : TDRBAddBook
    Created on : Feb 8, 2017, 5:01:46 PM
    Author     : tdolman9843
--%>

<%@page contentType="text/html" pageEncoding="utf-8"%>
<!doctype html>

<html>
    <head>
        <meta charset="utf-8">
        <title>TDRB Computer Programming Club</title>
        <link rel="stylesheet" href="styles/main.css">
    </head>

    <body>

        <jsp:include page="Parts/TDRBBanner.jsp"/>

        <section>
            <h1>Add a Book</h1>

            <p style="color:red">${requestScope.errors}</p>
            <form id="frmAdd" method="POST" action="TDRBAddBook">
                <table>
                    <tr>
                        <td><label for="txtCode">Code:</label></td>
                        <td><input type="text" name="txtCode" id="txtCode" 
                                   style="width: 200px" 
                                   value=${book.code}></td>
                    </tr>

                    <tr>
                        <td><label for="txtDescription">Description</label></td>
                        <td><input type="text" name="txtDescription" 
                                   id="txtDescription" style="width: 300px" 
                                   value=${book.description}></td>
                    </tr>
                    <tr>
                        <td><label for="txtQuantity">Quantity</label></td>
                        <td><input type="text" name="txtQuantity" 
                                   id="txtQuantity" style="width: 100px" 
                                   value=${book.quantity}></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <input type="submit" value="Save">
                            <a href="TDRBDisplayBooks">
                                <input type="button" value="Cancel">
                            </a>
                        </td>
                    </tr>
                </table>
            </form>
        </section>

        <jsp:include page="Parts/TDRBFooter.jsp" />

    </body>
</html>