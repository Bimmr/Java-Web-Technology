<%-- 
    Document   : TDRBRegister
    Created on : Jan 25, 2017, 4:28:31 PM
    Author     : rbimm5674
--%>
<%@page contentType="text/html" pageEncoding="utf-8"%>
<html>
    
    
<head>
    <meta charset="utf-8">
    <title>TDRB Computer Programming Club</title>
    <link rel="stylesheet" href="styles/main.css">
</head>
<jsp:include page="Parts/TDRBBanner.jsp"/>

<section>
    <h1>New Member Registration Form</h1>
    <br>

    <form action="TDRBDisplayMember.jsp" method="POST">
        <label for="name">Full Name: </label>
        <input name="name" id="name" type="text" required style="width:200px">
        <br>
        <label for="email">Email: </label>
        <input name="email" id="email" type="text" required style="width:300px">
        <br>
        <label for="phone">Phone: </label>
        <input name="phone" id="phone" type="text"style="width:100px">
        <br>
        <label for="prog">IT Program </label>
        <select name="prog" id="prog">
            <option default>CAD</option>
            <option default>CP</option>
            <option default>CPA</option>
            <option default>ITID</option>
            <option default>ITSS</option>
            <option default>MSD</option>
            <option default>Other</option>
        </select>
        <br>
        <label for="level">Year Level </label>
        <select name="level" id="level">
            <option default>1</option>
            <option>2</option>
            <option>3</option>
            <option>4</option>
        </select>
        <br>
        <div style="margin-left: 115px">
            <button type="submit">Register Now!</button>
            <button type="reset">Reset</button>
        </div>
    </form>
</section>

<jsp:include page="Parts/TDRBFooter.jsp" />
</body>
</html>