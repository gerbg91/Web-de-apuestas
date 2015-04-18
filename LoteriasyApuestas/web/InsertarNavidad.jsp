

<%@page import="Entidades.Navidad"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/calendario.css" type="text/css" rel="stylesheet">
        <script src="js/calendar.js" type="text/javascript"></script>
        <script src="js/calendar-es.js" type="text/javascript"></script>
        <script src="js/calendar-setup.js" type="text/javascript"></script> 
    </head>
    <body>
        <jsp:include page="menu.jsp" />
        <div class="intrucciones">
            <h3>Instrucciones</h3>
            Se DEBEN colocar TODOS los premios 
            <br>
            -Para el primer premio , segundo , tercero, los dos cuartos, los ocho quuintos premios, y las pedreas, los cinco números.
            <br>
            -Para los aproximaciones, los cincos numeros.
            <br>
            -Para las centenas escribir solo los tres ultimos numeros del final
            <br>
            -Para las dos ultimas cifras escribir los dos ultimos numeros del final.
            <br>
            -Para el premio de tres cifras, los tres números del final.
            <br>
            -Para el premio de dos cifras, los dos números del final.
            <br>
            -Para los reintegros escribir solo el numero correspondiente.
            <br>
            -En todos se debera colocar la cantidad el premio en euros, la cantidad en premios sera en relacion a un euro jugado.
        </div>
        <div class="modificaciones">
            <h4>Elimina un número</h4>
            <form action="Controller?opID=InsertarNavidadEliminar" method="POST">
                 Numero:<input type="number" name="numeroDado"/>
                <br> <select name="TipoLoteria">
                    <option value="PrimerPremio">Primer Premio</option>
                    <option value="SegundoPremio">Segundo Premio</option>
                    <option value="TercerPremio">Tercer Premio</option>
                    <option value="CuartoPremio">Cuarto Premio</option>
                    <option value="QuintoPremio">Quinto Premio</option>
                    <option value="Pedrea">Tercer Premio</option>
                    <option value="AproxPrimerPremioSuperior">Aproximacion primer premio superior</option>
                    <option value="AproxPrimerPremioInferior">Aproximacion primer premio inferior</option>
                    <option value="AproxSegundoPremioSuperior">Aproximacion segundo premio superior</option>
                    <option value="AproxSegundoPremioInferior">Aproximacion segundo premio inferior</option>
                    <option value="AproxTercerPremioSuperior">Aproximacion tercer premio superior</option>
                    <option value="AproxTercerPremioInferior">Aproximacion tercer premio inferior</option>
                    <option value="PrimerPremioCentenas">Primer premio centenas</option>
                    <option value="SegundoPremioCentenas">Segundo premio centenas</option>
                    <option value="TercerPremioCentenas">Tercer premio centenas</option>
                    <option value="CuartoPremioCentenas">Cuarto premio centenas</option>
                    <option value="PrimerPremioDecenas">Primer premio decenas</option>
                    <option value="SegundoPremioDecenas">Segundo premio decenas</option>
                    <option value="TercerPremioDecenas">Tercer premio decenas</option>
                    <option value="Reintegro">Reintegro</option>
                </select>            
                 <br><input type="text" name="ingreso" id="ingreso" placeholder="yyyy-mm-dd" required = "required"/>
                 <img src="css/images/calendario.png" width="16" height="16" border="0" title="Fecha Inicial" id="lanzador"> 
                 <br><input type="submit" value="Accionar" />
            </form>
            <h4>Añade un número</h4>
            <form action="Controller?opID=InsertarNavidad" method="POST">
                Numero:<input type="number" name="numeroDado"/>
                <select name="TipoLoteria">
                    <option value="PrimerPremio">Primer Premio</option>
                    <option value="SegundoPremio">Segundo Premio</option>
                    <option value="TercerPremio">Tercer Premio</option>
                    <option value="CuartoPremio">Cuarto Premio</option>
                    <option value="QuintoPremio">Quinto Premio</option>
                    <option value="Pedrea">Tercer Premio</option>
                    <option value="AproxPrimerPremioSuperior">Aproximacion primer premio superior</option>
                    <option value="AproxPrimerPremioInferior">Aproximacion primer premio inferior</option>
                    <option value="AproxSegundoPremioSuperior">Aproximacion segundo premio superior</option>
                    <option value="AproxSegundoPremioInferior">Aproximacion segundo premio inferior</option>
                    <option value="AproxTercerPremioSuperior">Aproximacion tercer premio superior</option>
                    <option value="AproxTercerPremioInferior">Aproximacion tercer premio inferior</option>
                    <option value="PrimerPremioCentenas">Primer premio centenas</option>
                    <option value="SegundoPremioCentenas">Segundo premio centenas</option>
                    <option value="TercerPremioCentenas">Tercer premio centenas</option>
                    <option value="CuartoPremioCentenas">Cuarto premio centenas</option>
                    <option value="PrimerPremioDecenas">Primer premio decenas</option>
                    <option value="SegundoPremioDecenas">Segundo premio decenas</option>
                    <option value="TercerPremioDecenas">Tercer premio decenas</option>
                    <option value="Reintegro">Reintegro</option>
                </select>            
                <input type="text" name="ingreso" id="ingreso" placeholder="yyyy-mm-dd" required = "required"/>
                <img src="css/images/calendario.png" width="16" height="16" border="0" title="Fecha Inicial" id="lanzador"> 
                Cantidad en euros:<input type="number" name="cantidadDinero"  step="any" required = "required"/>€
                <input type="submit" value="Accionar" />
            </form>
            <h4>Busqueda</h4>
            <form action="Controller?opID=BuscarNavidad" method="POST">
                Buscar por numero: <input type="number" name="buscar"/> 
                <input type="submit" value="buscar" />
            </form> 
            <form action="Controller?opID=BuscarFechaNavidad" method="POST">
                Buscar por fecha:
                <input type="text" name="fecha" placeholder="yyyy-MM-dd"/>
                <input type="submit" value="buscar" />
            </form> 
            <div class="results_table">
                <table>
                    <tr> 
                        <% ArrayList _lista = (ArrayList) request.getAttribute("NumerosBuscados");
                            if (_lista != null) {
                                for (int i = 0; i < _lista.size(); i++) {
                                    Navidad _numero = (Navidad) _lista.get(i);
                        %>            
                        <td><%=_numero.getNumero()%></td>
                        <td><%=_numero.getNombre()%></td>  
                        <td><%=_numero.getPremios()%></td>
                        <td><%=_numero.getFecha()%></td> 
                    </tr>
                    <%
                            }
                        }
                    %>

                </table>
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
