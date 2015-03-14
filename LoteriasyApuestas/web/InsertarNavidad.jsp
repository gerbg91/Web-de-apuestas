

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
            <h4>Modificaciones</h4>
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
                <input type="radio" name="opcion" value="eliminar" />Eliminar
                <input type="radio" name="opcion" value="anadir" />Añadir
            </form>
            <h4>Busqueda</h4>
            <form action="Controller?opID=BuscarNavidad" method="POST">
                Buscar por numero: <input type="number" name="buscar"/> 
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
    </body>
</html>
