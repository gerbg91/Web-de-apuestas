<%-- 
    Document   : login
    Created on : 14-mar-2015, 10:12:29
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
        <form action="Controller?opID=Entrada" method="POST">
            Usuario:<input type="text" name="usuario"/>
            Password:<input type="password" name="password"/>
            <input type="submit" value="Entrar" />
        </form>
    </body>
</html>
