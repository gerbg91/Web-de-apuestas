<%-- 
    Document   : Resultado
    Created on : 18-feb-2015, 11:49:36
    Author     : Ger
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>¡Has ganado!</h1> 
        <% float _premio = (float)request.getAttribute("Premio"); %>
        Te ha tocado: <%=_premio %>
    </body>
</html>
