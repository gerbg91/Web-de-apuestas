<%-- 
    Document   : Principal
    Created on : 18-feb-2015, 11:28:08
    Author     : Ger
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" src="js/funcion.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio</title>
    </head>
    <body>         
        <div id="search_section">
            <form action="Controller?opID=Comprobacion" method="POST">
            <input type="number" name="numeroDado"/>
            <select name="tipoApuesta">    
                <option value="decimo" selected="selected">Decimo</option>
                <option value="boleto">boleto</option>
                <option value="once">Once</option>
            </select>
            <input type="submit" value="Comprobar" />
            </form>
        </div>
    </body>
</html>
