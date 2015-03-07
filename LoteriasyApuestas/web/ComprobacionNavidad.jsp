<%-- 
    Document   : Principal
    Created on : 18-feb-2015, 11:28:08
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
            
            <form action="Controller?opID=ResultadoNavidad" method="POST">
            Numero:<input type="number" name="numeroDado"/>
            Cantidad en dinero:<input type="number" name="cantidadDinero"  step="any"/>€
            <input type="submit" value="Comprobar" />
            <select name="fecha">
                    <option value="2015-03-07">07-03-2015</option>
                    <option value="2014-12-21">21-12-2014</option>
                    <option value="2013-12-21">21-12-2013</option>
            </select> 
            </form>
        </div>
    </body>
</html>
