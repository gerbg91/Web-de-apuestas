<%-- 
    Document   : InsertarNavidad
    Created on : 13-mar-2015, 17:06:51
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
        <div id="search_section">
            <form action="Controller?opID=InsertarNavidad" method="POST">
                Numero:<input type="number" name="numeroDado"/>
                <select name="TipoLoteria">
                    <option value="PrimerPremio">Premio Gordo</option>
                    <option value="SegundoPremio">Segundo Premio</option>
                    <option value="TercerPremio">Tercer Premio</option>
                </select> 
                Premio en euros:<input type="number" name="cantidadDinero"  step="any"/>€
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
