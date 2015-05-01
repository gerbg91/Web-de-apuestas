<%@page import="Entidades.Cupon"%>
<% Cupon _datosNumero = (Cupon) request.getAttribute("_datosNumero");%>
<jsp:include page="menu.jsp" />
<div class="anadir"> 
    <form action="Controller?opID=NumeroActualizarCupon" method="POST">
        <div class="izquierda">Numero:</div>
        <div class="derecha"><input type="number" name="numeroDado" value="<%=_datosNumero.getNumero()%>"/></div>
        <div class="izquierda">Nombre</div>
        <div class="derecha">
        <select name="TipoLoteria">
            <option value="<%=_datosNumero.getNombre()%>" selected><%=_datosNumero.getNombre()%></option>
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
        </div>
            <input type="hidden" name="id_Cupon" value="<%=_datosNumero.getId_Cupon()%>"/>
            <div class="izquierda">Fecha del sorteo:</div>
            <div class="derecha"><input type="text" name="ingreso" id="ingreso" value="<%=_datosNumero.getFecha()%>" required = "required"/>
                <img src="css/images/calendario.png" width="16" height="16" border="0" title="Fecha Inicial" id="lanzador"></div>
                <div class="izquierda">Premio por euro:</div>
                <div class="derecha"><input type="text" name="premios" value="<%=_datosNumero.getPremios()%>"/></div>
                <div class="centro_boton"> <input type="submit" value="Actualizar"/></div>
    </form>
        <script type="text/javascript">
    Calendar.setup({
        inputField: "ingreso",
        ifFormat: "%Y-%m-%d",
        button: "lanzador"
    });
</script> 
</div>