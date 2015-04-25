<%@page import="Entidades.Cupon"%>
<%@page import="java.util.ArrayList"%>
<div class="lista">
    <table>
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