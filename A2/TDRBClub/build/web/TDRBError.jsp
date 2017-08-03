<%-- 
    Document   : TDRBError
    Created on : Feb 15, 2017, 5:53:00 PM
    Author     : rbimm5674
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

        <h1>Java Error</h1>
        <p>Sorry, Java has thrown an exception.</p>
        <p>To continue, click the Back button.</p>

        <h2>Details</h2>
        <p>Type: ${pageContext.exception["class"]}</p>
        <p>Message: ${pageContext.exception.message}</p>

        <jsp:include page="Parts/TDRBFooter.jsp"/>
    </body>
</html>
