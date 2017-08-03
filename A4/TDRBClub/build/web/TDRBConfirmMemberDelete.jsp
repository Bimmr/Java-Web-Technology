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
        <h1>Do you want to delete this member?</h1>
        <table>
            <tr>
                <td>Full Name:</td>
                <td>${member.fullName}</td>
            </tr>
            <tr>
                <td>Email:</td>
                <td>${member.emailAddress}</td>
            </tr>
            <tr>
                <td>Phone:</td>
                <td>${member.phoneNumber}</td>
            </tr>
            <tr>
                <td>Program:</td>
                <td>${member.programName}</td>
            </tr>
            <tr>
                <td>Year:</td>
                <td>${member.yearLevel}</td>
            </tr>
        </table>
        <br>
        
        <a href="TDRBMemberAdmin?action=deleteMember&emailAddress=<c:out value="${member.emailAddress}"/>&confirm=yes"><input type="button" value="Yes"></a>
        <a href="TDRBMemberAdmin?action=deleteMember&emailAddress=<c:out value="${member.emailAddress}"/>&confirm=no"><input type="button" value="No"></a>
    </section>

    <jsp:include page="Parts/TDRBFooter.jsp" />
</body>
</html>