<%-- 
    Document   : TDRBDisplayMember
    Created on : Apr 5, 2017, 4:28:31 PM
    Author     : rbimm5674
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
        <h1>New Member Registration Form</h1>
        <br>

        <p style="color: red">${error}</p>
        <form action="TDRBMemberAdmin?action=<c:out value="${action}"/>" method="${method}">
            <input type="hidden" name="action" 
                   value="<c:out value="${action}"/>">
            <label for="name">Full Name: </label>
            <input name="name" id="name" type="text" style="width:200px" 
                   value="${member.fullName}">
            <br>
            <label for="email">Email: </label>
            <input name="email" id="email" type="text" style="width:300px"
                   value="${member.emailAddress}">
            <br>
            <label for="phone">Phone: </label>
            <input name="phone" id="phone" type="text"style="width:100px"
                   value="${member.phoneNumber}">
            <br>
            <label for="prog">IT Program </label>
            <select name="progam" id="progam">
                <option value="CAD" >CAD</option>
                <option value="CP">CP</option>
                <option value = "CPA" default>CPA</option>
                <option value="ITID">ITID</option>
                <option value="ITSS">ITSS</option>
                <option value="MSD">MSD</option>
                <option value="Other">Other</option>
            </select>
            <br>
            <label for="level">Year Level </label>
            <select name="level" id="level">
                <option value="1" default>1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
            </select>
            <br>
            <div style="margin-left: 115px">
                <button type="submit">Save</button>
                <button type="reset">Reset</button>
            </div>
        </form>
    </section>
    <jsp:include page="Parts/TDRBFooter.jsp" />
</body>
</html>