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
        <link href="css/calendario.css" type="text/css" rel="stylesheet">
        <script src="js/calendar.js" type="text/javascript"></script>
        <script src="js/calendar-es.js" type="text/javascript"></script>
        <script src="js/calendar-setup.js" type="text/javascript"></script> 

    </head>
    <body>        
        <div class="publi_comprobacion">Publicidad</div>
        <div class="comprobacion">
            <form action="Controller?opID=ResultadoNavidad" method="POST">
                Numero:<input type="number" name="numeroDado"/>
                Cantidad en dinero:<input type="number" name="cantidadDinero"  step="any"/>€
                <input type="submit" value="Comprobar" />
                <input type="text" name="ingreso" id="ingreso" value="yyyy-mm-dd" />
                <img src="css/images/calendario.png" width="16" height="16" border="0" title="Fecha Inicial" id="lanzador"> 
            </form>
        </div>
        <div class="publicidad_web">Publicidad Web</div>
        <script type="text/javascript">
            Calendar.setup({
                inputField: "ingreso",
                ifFormat: "%Y-%m-%d",
                button: "lanzador"
            });
        </script> 
    </body>
</html>
