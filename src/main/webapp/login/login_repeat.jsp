
<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>

<body>
<form action="${pageContext.request.contextPath}/register">
    <input type="submit" style="background-color:Goldenrod;color:White;"
           value="Register"/>
</form>
<div align="center">
    <h1>Login Form</h1>
    <p style="color:red">Email or password is incorrect</p>
    <form action="<%=request.getContextPath()%>/login" method="post">
        <table style="with: 100%">
            <tr>
                <td>Email</td>
                <td><label>
                    <input type="text" name="email" />
                </label></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><label>
                    <input type="password" name="password" />
                </label></td>
            </tr>
        </table>
        <input type="submit" style="background-color:LimeGreen;color:black;" value="Submit" />
    </form>
</div>
</body>
</html>