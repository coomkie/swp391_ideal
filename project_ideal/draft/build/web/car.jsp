<%-- 
    Document   : car
    Created on : Dec 25, 2023, 10:19:32 AM
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
        <h2>Dang ki chu xe</h2>
        <form action="carURL">
            Hang xe<input type="text" name="CarBrandID"/><br/>
            ten xe<input type="text" name="carName"/><br/>
            Gia tien thue 1 ngay<input type="text" name="CarPricePerDay"/><br/>
            loai nhien lieu tieu thu<input type="text" name="FuelType"/><br/>
            Bien so xe <input type="text" name="CarLicense"/><br/>
            <button type="submit">thanh chu xe ngay</button>
        </form>
    </body>
</html>
