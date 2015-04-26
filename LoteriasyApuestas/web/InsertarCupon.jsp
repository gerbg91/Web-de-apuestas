

<%@page import="Entidades.Cupon"%>
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
                -Para el premio de cinco cifras los cinco números.
                <br>
                -Para el premio de cinco cifras anterior, los cinco números.
                <br>
                -Para el premio de cinco cifras posterior, los cinco números.
                <br>
                -Para el premio de cuatro cifras, los cuatro números del final.
                <br>
                -Para el premio de tres cifras, los tres números del final.
                <br>
                -Para el premio de dos cifras, los dos números del final.
                <br>
                -Para el premio de la ultima cifra del primer premio, la ultima cifra.
                <br>
                -Para el premio de la primera cifra del primer premio, la primera cifra.
                <br>
                -En relacion a los a los numeros introducidos se debe colocar su premio en euros.
            </div>
            <h4>Eliminar un numero</h4>
            <div class="form">  
                <form action="Controller?opID=InsertarCuponEliminar" method="POST">
                    Numero:<input type="number" name="numeroDado"/>
                    <select name="TipoLoteria">
                        <option value="CincoCifras">Cinco Cifras</option>
                        <option value="CincoCifrasAnterior"> Cinco cifras anterior</option>
                        <option value="CincoPosterior">Cinco cifras posterior</option>
                        <option value="CuatroCifras">Cuatro ultimas cifras</option>
                        <option value="TresCifras">Tres ultimas cifras</option>
                        <option value="DosCifras">Dos ultimas cifras</option>
                        <option value="UltimaCifra">Ultima cifra del primer premio</option>
                        <option value="PrimeraCifra">Primera cifra del primer premio</option>
                        <option value="Serie">Serie</option>
                    </select> 
                    <input type="text" name="ingreso" id="ingreso" placeholder="yyyy-mm-dd" required = "required"/>
                    <img src="css/images/calendario.png" width="16" height="16" border="0" title="Fecha Inicial" id="lanzador">
                    <input type="submit" value="Comprobar" />
                </form>
                
                 <h4>Añadir un numero</h4>
            <div class="form">  
            <form action="Controller?opID=InsertarCupon" method="POST">
                Numero:<input type="number" name="numeroDado"/>
                <select name="TipoLoteria">
                    <option value="CincoCifras">Cinco Cifras</option>
                    <option value="CincoCifrasAnterior"> Cinco cifras anterior</option>
                    <option value="CincoPosterior">Cinco cifras posterior</option>
                    <option value="CuatroCifras">Cuatro ultimas cifras</option>
                    <option value="TresCifras">Tres ultimas cifras</option>
                    <option value="DosCifras">Dos ultimas cifras</option>
                    <option value="UltimaCifra">Ultima cifra del primer premio</option>
                    <option value="PrimeraCifra">Primera cifra del primer premio</option>
                    <option value="Serie">Serie</option>
                </select> 
                <input type="text" name="ingreso" id="ingreso" placeholder="yyyy-mm-dd" required = "required"/>
                <img src="css/images/calendario.png" width="16" height="16" border="0" title="Fecha Inicial" id="lanzador">
                Premio en euros:<input type="number" name="cantidadDinero"  step="any"/>€
                
                <input type="submit" value="Comprobar" />
            </form>
                
                 <h4>Busqueda</h4>
            <form action="Controller?opID=BuscarCupon" method="POST">
                Buscar por numero: <input type="number" name="buscar"/> 
                <input type="submit" value="buscar" />
            </form> 
             <form action="Controller?opID=BuscarFechaCupon" method="POST">
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
                                Cupon _numero = (Cupon) _lista.get(i);
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
        </div>
    </body>
</html>
