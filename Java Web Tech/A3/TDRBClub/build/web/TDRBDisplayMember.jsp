<%-- 
    Document   : TDRBDisplayMember
    Created on : Jan 25, 2017, 4:28:31 PM
    Author     : rbimm5674
--%>
<jsp:include page="Parts/TDRBBanner.jsp"/>

<section>
    <h1>Thanks for joining our club!</h1>
    <br>
    <p>Here is the information you entered</p>
    <table>
        <tr>
            <td><strong>Full Name:</strong></td>
            <td>${param.name}</td>
        </tr>
        <tr>
            <td><strong>Email:</strong></td>
            <td>${param.email}</td>
        </tr>
        <tr>
            <td><strong>Phone:</strong></td>
            <td>${param.phone}</td>
        </tr>
        <tr>
            <td><strong>Program:</strong></td>
            <td>${param.prog}</td>
        </tr>
        <tr>
            <td><strong>Level:</strong></td>
            <td>${param.level}</td>
        </tr>
    </table>
    <p>To register another member, click on the Beck button in your browser 
        or the return button shown below.</p>
    <a href="TDRBRegister.jsp"><input type="button" value="Return"></a>
</section>

<jsp:include page="Parts/TDRBFooter.jsp" />
</body>
</html>