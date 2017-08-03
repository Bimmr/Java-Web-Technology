<%-- 
    Document   : index
    Created on : Jan 25, 2017, 3:35:08 PM
    Author     : rbimm5674
--%>


<!doctype html>

<html>
    
    <%@page contentType="text/html" pageEncoding="utf-8"%>
<head>
    <meta charset="utf-8">
    <title>TDRB Computer Programming Club</title>
    <link rel="stylesheet" href="styles/main.css">
</head>

<body>
    <jsp:include page="Parts/TDRBBanner.jsp"/>

<section>
    <h1>Java Web Technologies Section 1</h1>
    <br>
    <p>Pair Programming Team:</p>
    <br>
    <h2>Assignment 3</h2>
    <br>
    <h1>Driver: Tim Dolman</h1>
    <h1>Observer: Randy Bimm</h1>
    <br>
    <br>
    <p>Current Date and Time:</p>
    <br>
    <p><strong><%= new java.util.Date()%></strong></p>
</section>

<jsp:include page="Parts/TDRBFooter.jsp" />
</body>
</html>


