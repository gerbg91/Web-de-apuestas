<%-- 
    Document   : Resultado
    Created on : 18-feb-2015, 11:49:36
    Author     : Ger
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <div class="result_right">Publicidad</div>
        <div class="results">
            <% float _premio = (float) request.getAttribute("Premio");         
            if (_premio == 0) { %>
                <h1>¡Has perdido!</h1> 
                 No te ha tocado nada, jodete! muahahaha
            <%} else if(_premio >= 123456789){%>
                <h1>¡Has ganado!</h1> 
                ¡Te ha tocado un sueldo de  <%=_premio-123456789%> al MES durante 25 años!
            <%} else {%>
                <h1>¡Has ganado!</h1> 
                Te ha tocado: <%=_premio%>
            <%}%>
        </div>
        <div class="result_left">Publicidad</div>
    </body>
</html>
