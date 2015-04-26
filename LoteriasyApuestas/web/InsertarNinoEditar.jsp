
<%@page import="Entidades.Nino"%>
<% Nino _datosNumero = (Nino) request.getAttribute("_datosNumero");%>

<div class="form">  
    <form action="Controller?opID=NumeroActualizarNino" method="POST">
        Numero:<input type="number" name="numeroDado" value="<%=_datosNumero.getNumero()%>"/>
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
            <input type="hidden" name="id_Nino" value="<%=_datosNumero.getId_Nino()%>"/>
            <input type="text" name="ingreso" id="ingreso" value="<%=_datosNumero.getFecha()%>" required = "required"/>
        <img src="css/images/calendario.png" width="16" height="16" border="0" title="Fecha Inicial" id="lanzador">
        <input type="text" name="premios" value="<%=_datosNumero.getPremios()%>"/>
        <input type="submit" value="Actualizar"/>
    </form>
        <script type="text/javascript">
    Calendar.setup({
        inputField: "ingreso",
        ifFormat: "%Y-%m-%d",
        button: "lanzador"
    });
</script> 
</div>