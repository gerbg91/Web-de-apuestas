<%@page import="Entidades.Nino"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="menu.jsp" />
    <form action="Controller?opID=FomularioInsertarNino" method="POST"><button type="submit" name="anadir"><a class="icon-plus"></a></button></form>
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
                Nino _numero = (Nino) _listaNumeros.get(i);
        %>        
        <tr>
            <td><%=_numero.getNumero()%></td>
            <td><%=_numero.getNombre()%></td>
            <td><%=_numero.getFecha()%></td>
            <td><%=_numero.getPremios()%></td>
            <td class="botn"><form action="Controller?opID=InsertarNinoEliminar" method="POST"><button type="submit" name="eliminar" value="<%=_numero.getId_Nino()%>"><a class="icon-cross"></a></button></form></td>
            <td class="botn"><form action="Controller?opID=InsertarNinoEditar" method="POST"><button type="submit" name="editar" value="<%=_numero.getId_Nino()%>"><a class="icon-pencil2"></a></button></form></td>
        </tr>
        <%
            }
        %>
    </table>  