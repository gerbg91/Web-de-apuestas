<%@page import="Entidades.Cupon"%>
<%@page import="java.util.ArrayList"%>
<div class="publi_comprobacion"><img src="images/banner1.png" alt="Advertisement" border="0" /></div>
<div class="listado_usuario">
    <table class="t2">
        <tr class="colortr">
            <td>Número</td>
            <td>Fecha</td>
        </tr>
        <%
            ArrayList _listaNumeros = (ArrayList) request.getAttribute("_listaNumeros");
            for (int i = 0; i < _listaNumeros.size(); i++) {
                Cupon _numero = (Cupon) _listaNumeros.get(i);
        %>        
        <tr>
            <td><%=_numero.getNumero()%></td>
            <td><%=_numero.getFecha()%></td>
        </tr>
   
        <%
            }
        %>
    </table>   
</div>