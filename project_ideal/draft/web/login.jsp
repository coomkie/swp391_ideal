<%-- 
    Document   : login
    Created on : Dec 25, 2023, 12:08:26 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div style="font-size: 30px; text-align: center; margin: 20px 445px; margin-top: 100px;
             background-image: linear-gradient(to left, violet, indigo, blue, green, yellow, orange, red);   -webkit-background-clip: text;
             color: transparent;
             ">Lam on dang nhap</div>
        <div style="margin: 0px 540px;">
            <%
                                      Cookie[] cookies = request.getCookies();
                                      String userName = "";
                                       String passWord = "";
                                       if (cookies != null) {
                                       for (Cookie c : cookies) {
                                         if (c.getName().equals("USERNAME")) {
                                         userName = c.getValue();
                                       }
                                       if (c.getName().equals("PASSWORD")) {
                                         passWord = c.getValue();
                                       }
                                       }
            %>
            <form action="UserURL" method="POST">
                <div>Ten dang nhap</div><input type="text" name="username" value="<%=userName%>"/>
                <div>Mat khau</div><input type="password" name="password" value="<%=passWord%>"/>
                <span>Remember</span><input type="checkbox" name="remember"/><br/><br/>
                <input type="submit" value="submit"/>
            </form>
            <%} else {%>
            <form action="UserURL" method="POST">
                <div>Ten dang nhap</div><input type="text" name="username"/>
                <div>Mat khau</div><input type="password" name="password"/>
                <span>Remember</span><input type="checkbox" name="remember"/><br/><br/>
                <input type="submit" value="submit"/>
            </form>
            <%}%>
        </div>
    </body>
</html>
