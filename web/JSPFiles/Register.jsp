<%-- 
    Document   : RegisterSevlet
    Created on : 10/07/2017, 23:02:57
    Author     : maimonlior
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    <body>
        <form name="registerForm" method="post" action="../Servlets/RegisterServlet">
            First Name:<input type="text" name="firstName"/><br/>
            Last Name:<input type="text" name="lastName"/><br/>
            address: <input type="test" name="address"/><br/>
            Your Birth-Date: <input type="date" name="birthDate"/><br/>
            Choose User Name:<input type="text" name="userName"/><br/>
            Choose Password:<input type="password" name="password"/><br/>
            Email:<input type="text" name="email" /><br/>
            Language: <select name="language">
                <option>Hebrew</option>
                <option>Hindi</option>
                <option>English</option>
                <option>French</option>
            </select> <br/>
            <input type="submit" value="Submit"/>
            
            <div class="imgcontainer">
                <h3>I remember my user and password...</h3>
                <a href="../JSPFiles/Login.jsp">
                <img src="../Images/Wellcome/login.jpg" alt="Login" class="login">
              </a>
            </div>

        </form>
        
    </body>
</html>
