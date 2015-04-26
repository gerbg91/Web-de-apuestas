<%@page import="Entidades.Navidad"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="menu.jsp" />
<div class="lista">
    <form action="Controller?opID=FomularioInsertarNavidad" method="POST"><button type="submit" name="anadir">Añadir</button></form>
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
            <td><form action="Controller?opID=InsertarNavidadEliminar" method="POST"><button type="submit" name="eliminar" value="<%=_numero.getId_Navidad()%>">Eliminar</button></form></td>
            <td><form action="Controller?opID=InsertarNavidadEditar" method="POST"><button type="submit" name="editar" value="<%=_numero.getId_Navidad()%>">Editar</button></form></td>
        </tr>
        <%
            }
        %>
    </table>  
</div>