        <div class="result_right"><img src="images/banner3.png" alt="Advertisement" border="0" /></div>
        <div class="results">
            <% float _premio = (float) request.getAttribute("Premio");         
            if (_premio == 0) { %>
                <h1>Lo sentimos...</h1> 
                 <p>No te ha tocado nada, pero recuerda que todos los días tienes la oportunidad de tener suerte, ¡Sigue intentandolo!</p>
                 <div class="pobre"></div>
            <%} else if(_premio >= 123456789){%>
                <h1>¡Has ganado!</h1> 
                <p>¡Te ha tocado un sueldo de  <%=_premio-123456789%> al MES durante 25 años!</p>
                <div class="rico"></div>
            <%} else {%>
                <% if (_premio >= 200 ) { %>
                <h1>¡Has ganado!</h1> 
                <p>Tu premio ha sido de : <%=_premio%> ¡Enhorabuena!</p>
                <div class="rico"></div>
                <%}else {%>
                <h1>¡Has ganado!</h1> 
                <p>Tu premio ha sido de : <%=_premio%> ¡Enhorabuena!</p>
                <div class="feliz"></div>
               <%}%>     
            <%}%>
        </div>
        <div class="result_left"><img src="images/banner3.png" alt="Advertisement" border="0" /></div>
