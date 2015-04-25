<%@page import="Entidades.Navidad"%>
<%@page import="java.util.ArrayList"%>
<div class="lista">
    <table>
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
            <td><a href=" " id="<%=_numero.getId_Navidad()%>" name="eliminar">Eliminar</a></td>
            <td><a href=" " id="<%=_numero.getId_Navidad()%>" name="editar">Editar</a></td>
        </tr>
        <%
            }
        %>
    </table>   
</div>