
<%@page import="Entidades.Nino"%>
<% Nino _datosNumero = (Nino) request.getAttribute("_datosNumero");%>
<jsp:include page="menu.jsp" />
<div class="anadir">
     <form action="Controller?opID=NumeroActualizarNino" method="POST">
         <div class="izquierda">Numero:</div>
         <div class="derecha"><input type="number" name="numeroDado" value="<%=_datosNumero.getNumero()%>"/></div>
         <div class="izquierda">Nombre:</div>
         <div class="derecha">
        <select name="TipoLoteria">
            <option value="<%=_datosNumero.getNombre()%>" selected><%=_datosNumero.getNombre()%></option>
                     <option value="PrimerPremio">Primer Premio</option>
                    <option value="SegundoPremio">Segundo Premio</option>
                    <option value="TercerPremio">Tercer Premio</option>
                    <option value="TerminacionCuatroCifras">Terminacion cuatro cifras</option>
                     <option value="TerminacionDosCifras">Terminacion tres cifras</option>
                    <option value="TerminacionDosCifras">Terminacion dos cifras</option>
                    <option value="TerminacionUltimaCifra">Terminacion ultima cifra del primer premio</option>
                    <option value="PrimeraCifraPrimero">Primera cifra del primer premio</option>
                    <option value="PrimeraCifraSegundo">Primera cifra del segundo premio</option>
        </select> 
         </div>
            <input type="hidden" name="id_Nino" value="<%=_datosNumero.getId_Nino()%>"/>
            <div class="izquierda">Fecha del sorteo:</div>
            <div class="derecha">
        <input type="text" name="ingreso" id="ingreso" value="<%=_datosNumero.getFecha()%>" required = "required"/>
        <img src="css/images/calendario.png" width="16" height="16" border="0" title="Fecha Inicial" id="lanzador"></div>
        <div class="izquierda">Premio por euro:</div>
        <div class="derecha"><input type="text" name="premios" value="<%=_datosNumero.getPremios()%>"/></div>
     <div class="centro_boton"><input type="submit" value="Actualizar"/></div>
    </form>
</div>
<script src="js/calen.js" type="text/javascript"></script> 