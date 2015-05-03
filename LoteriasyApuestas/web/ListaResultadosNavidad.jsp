<%@page import="Entidades.Navidad"%>
<%@page import="java.util.ArrayList"%>
<div class="publi_comprobacion"><img src="images/banner1.png" alt="Advertisement" border="0" /></div>
<div class="listado_usuario">
    <table class="t1">
        <tr class="colortr">
            <td>Número</td>
            <td>Premio</td>
            <td>Fecha</td>
            <td>Dinero por euro jugado</td>
        </tr>
        <%
            ArrayList _listaNumeros = (ArrayList) request.getAttribute("_listaNumeros");
            for (int i = 0; i < _listaNumeros.size(); i++) {
                Navidad _numero = (Navidad) _listaNumeros.get(i);
        %>        
        <tr>
            <td><%=_numero.getNumero()%></td>
            <td><%=_numero.getNombre()%></td>
            <td><%=_numero.getFecha()%></td>
            <td><%=_numero.getPremios()%></td>
        </tr>
     
        <%
            }
        %>
    </table>   
</div>