<%-- 
    Document   : ComprobacionNino
    Created on : 22-feb-2015, 13:46:43
    Author     : Ger
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio</title>
    </head>
    <body>         
        <div id="search_section">
            <form action="Controller?opID=ResultadoNino" method="POST">
            Cantidad en dinero:<input type="number" name="numeroDado"/>€
            <input type="submit" value="Comprobar" />
            </form>
        </div>
    </body>
</html>

