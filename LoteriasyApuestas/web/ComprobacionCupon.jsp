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
        <link href="css/calendario.css" type="text/css" rel="stylesheet">
        <script src="js/calendar.js" type="text/javascript"></script>
        <script src="js/calendar-es.js" type="text/javascript"></script>
        <script src="js/calendar-setup.js" type="text/javascript"></script> 
    </head>
    <body>         
        <div class="publi_comprobacion">Publicidad</div>
        <div class="comprobacion">
            <form action="Controller?opID=ResultadoCupon" method="POST">
                Numero:<input type="number" name="numeroDado"/>
                Serie:<input type="number" name="serieDado"/>
                Fecha del Sorteo:
                <input type="text" name="ingreso" id="ingreso" value="yyyy-mm-dd" />
                <img src="css/images/calendario.png" width="16" height="16" border="0" title="Fecha Inicial" id="lanzador">
                <input type="submit" value="Comprobar" />
            </form>
        </div>
        <div class="publicidad_web">
            <div class="text_publicidad">
                <p class="p1">Siguenos ahora en Facebook o Twitter</p>
                <p class="p2">Y recuerda que la <b class="b1">SUERTE</b><a class="trebol"></a></p> 
                <p class="p3">esta siempre de nuestra parte.</p>
            </div>             
        </div>
        <script type="text/javascript">
            Calendar.setup({
                inputField: "ingreso",
                ifFormat: "%Y-%m-%d",
                button: "lanzador"
            });
        </script> 
    </body>
</html>

