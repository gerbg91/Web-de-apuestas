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
        <div class="login">
            <h4>*Solo acceso a los administradores</h4>
        <form action="Controller?opID=Entrada" method="POST">
            Administrador:<input type="text" name="usuario"/>
            Password:<input type="password" name="password"/>
            <input type="submit" value="Acceder" />
        </form>
        </div>
    </body>
</html>
