<%-- 
    Document   : homepage
    Created on : Dec 25, 2023, 12:00:59 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import ="entity.user" %>
<%@page import ="jakarta.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            user u = (user)session.getAttribute("account");
            if(u==null){%>
        <h1>Dang nhap de tiep tuc</h1>
        <a href="login.jsp" style="text-decoration: none;">Dang nhap ngay</a>
        <%}else{%>
        <h1>hello <%=u.getFullName()%></h1>
        <a href="homeURL?service=logout">Dang xuat</a><br/><br/>
        <%if(u.getRenterID()==1){%>
        <a style="text-decoration: none; font-size: 20px;" href="renterCarURL">Xe cua ban</a>
        <%} else {%>
        <form action="homeURL" method="">
            <input type="hidden" name="service" value="car"/>
            <button type="submit">Tro thanh chu xe</button>
        </form>
        <%}}%>

    </body>
</html>
