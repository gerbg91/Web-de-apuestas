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
        <div class="publi_comprobacion">Publicidad</div>
        <div class="comprobacion">
             <form action="Controller?opID=ResultadoCupon" method="POST">
            Numero:<input type="number" name="numeroDado"/>
            Serie:<input type="number" name="serieDado"/>
            <input type="submit" value="Comprobar" />
            <select name="fecha">
                    <option value="2015-03-13">13-03-2015</option>
                    <option value="2014-12-21">21-12-2014</option>
                    <option value="2013-12-21">21-12-2013</option>
            </select> 
            </form>
        </div>
        <div class="publicidad_web">Publicidad Web</div>
    </body>
</html>

