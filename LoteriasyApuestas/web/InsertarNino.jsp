<%@page import="Entidades.Nino"%>
<%@page import="Entidades.Navidad"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="search_section">
            <jsp:include page="menu.jsp" />
            <div class="intrucciones">
                <h3>Instrucciones</h3>
                Se DEBEN colocar TODOS los premios 
                <br>
                -Para el primer premio , segundo , tercero, escribir los cinco números.
                <br>
                -Para los premios de cuatro cifras, escribir los cuatro ultimos números.
                <br>
                -Para los premios de tres cifras escribir los tres ultimos numeros.
                <br>
                -Para el premios de dos cifras, escribir los dos números del final.
                <br>
                -Para los reintegros escribir solo el numero correspondiente.
                <br>
                -En todos se debera colocar la cantidad el premio en euros, la cantidad en premios sera en relacion a un euro jugado.
            </div>
            
            <h4>Elimina un número</h4>
            <form action="Controller?opID=InsertarNinoEliminar" method="POST">
                Numero:<input type="number" name="numeroDado"/>
                <select name="TipoLoteria">
                    <option value="PrimerPremio">Primer Premio</option>
                    <option value="SegundoPremio">Segundo Premio</option>
                    <option value="TercerPremio">Tercer Premio</option>
                    <option value="TerminacionCuatroCifras">Tercer Premio</option>
                    <option value="TerminacionDosCifras">Tercer Premio</option>
                    <option value="TerminacionUltimaCifra">Terminacion ultima cifra del primer premio</option>
                    <option value="PrimeraCifraPrimero">Primera cifra del primer premio</option>
                    <option value="PrimeraCifraSegundo">Primera cifra del segundo premio</option>
                </select> 
                <br><input type="text" name="ingreso" id="ingreso" placeholder="yyyy-mm-dd" required = "required"/>
                 <img src="css/images/calendario.png" width="16" height="16" border="0" title="Fecha Inicial" id="lanzador"> 
                <input type="submit" value="Comprobar" />
       
            </form>
            
            <h4>Añadir un número</h4>
            <form action="Controller?opID=InsertarNino" method="POST">
                Numero:<input type="number" name="numeroDado"/>
                <select name="TipoLoteria">
                    <option value="PrimerPremio">Primer Premio</option>
                    <option value="SegundoPremio">Segundo Premio</option>
                    <option value="TercerPremio">Tercer Premio</option>
                    <option value="TerminacionCuatroCifras">Tercer Premio</option>
                    <option value="TerminacionDosCifras">Tercer Premio</option>
                    <option value="TerminacionUltimaCifra">Terminacion ultima cifra del primer premio</option>
                    <option value="PrimeraCifraPrimero">Primera cifra del primer premio</option>
                    <option value="PrimeraCifraSegundo">Primera cifra del segundo premio</option>
                </select> 
                <br><input type="text" name="ingreso" id="ingreso" placeholder="yyyy-mm-dd" required = "required"/>
                 <img src="css/images/calendario.png" width="16" height="16" border="0" title="Fecha Inicial" id="lanzador"> 
                Cantidad en euros:<input type="number" name="cantidadDinero"  step="any" required = "required"/>€
                 <input type="submit" value="Comprobar" />
            </form>
            <h4>Busqueda</h4>
            <form action="Controller?opID=BuscarNino" method="POST">
                Buscar por numero: <input type="number" name="buscar"/> 
                <input type="submit" value="buscar" />
            </form> 
             <form action="Controller?opID=BuscarFechaNino" method="POST">
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
                                Nino _numero = (Nino) _lista.get(i);
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
    </body>
</html>
