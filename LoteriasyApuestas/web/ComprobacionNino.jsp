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
             <form action="Controller?opID=ResultadoNino" method="POST">
            Numero:<input type="number" name="numeroDado"/>
            Cantidad en dinero:<input type="number" name="cantidadDinero"  step="any"/>€
            <input type="submit" value="Comprobar" />
            <select name="fecha">
                <option value="2015-01-06">06-06-2015</option>
            </select> 
            </form>
        </div>
        <div class="publicidad_web">Publicidad Web</div>
    </body>
</html>

