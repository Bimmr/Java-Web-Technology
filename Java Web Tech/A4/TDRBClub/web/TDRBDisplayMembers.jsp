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
        <h1>List of Members</h1>
        <br>
        <table>
            <tr>
                <th>Email</th>
                <th>Program</th>
                <th>Year</th>
            </tr>
            <c:forEach var="member" items="${members}">
                <tr>
                    <td>${member.emailAddress}</td>
                    <td>${member.programName}</td>
                    <td>${member.yearLevel}</td>
                    <td><a href="TDRBMemberAdmin?action=updateMember&emailAddress=<c:out value="${member.emailAddress}"/>">Update</a> </td>
                    <td><a href="TDRBMemberAdmin?action=deleteMember&emailAddress=<c:out value="${member.emailAddress}"/>">Delete</a> </td>
                </tr>
            </c:forEach>
        </table>    
        <a href="TDRBMemberAdmin?action=addMember"><input type="button" value="Add Member"></a>
    </section>

    <jsp:include page="Parts/TDRBFooter.jsp" />
</body>
</html>