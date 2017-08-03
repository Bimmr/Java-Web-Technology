<%-- 
    Document   : TDRBAddBook
    Created on : Feb 8, 2017, 5:01:46 PM
    Author     : tdolman9843
--%>
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
            <h1>Add a Book</h1>
            <p style="color: red">${error}</p>
            <form method="post" action="TDRBAddBook">
                <table>
                    <tr>
                        <td><label for="txtCode">Code</label></td>
                        <td><input type="text" id="txtCode" name="txtCode"  
                                   style ="width: 200px" 
                                   value ="${book.code}" ></td>
                    </tr>
                    <tr>
                        <td><label for="txtDescription">Description</label></td>
                        <td><input type="text" id="txtDes" name="txtDescription"
                                   style ="width: 300px" 
                                   value ="${book.description}"></td>
                    </tr>
                    <tr>
                        <td><label for="txtQuantity">Quantity</label></td>
                        <td><input type="text" id="txtQua" name="txtQuantity"
                                   style ="width: 100px" 
                                   value ="${book.quantity}"></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <input type="submit" name="btnAction" 
                                   value="Submit"/>
                            <a href="TDRBDisplayBooks">
                                <input type="button" name="btnAction" 
                                       value="Cancel"></a>
                        </td>
                    </tr>
                </table>
            </form>

        </section>

        <jsp:include page="Parts/TDRBFooter.jsp" />
    </body>
</html>