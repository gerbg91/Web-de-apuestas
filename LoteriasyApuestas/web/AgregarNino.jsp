<jsp:include page="menu.jsp" />
<div class="anadir">
    
    <b>Advertencia</b> Ingresar por orden de lista.
    <form action="Controller?opID=InsertarNino" method="POST">
        <div class="izquierda">Numero:</div>
        <div class="derecha"><input type="number" name="numeroDado" required = "required"/></div>
        <div class="izquierda">Nombre</div>
        <div class="derecha">
        <select name="TipoLoteria"> 
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
        <div class="izquierda">Fecha del sorteo</div>
        <div class="derecha"><input type="text" name="ingreso" id="ingreso" required = "required"/>
            <img src="css/images/calendario.png" width="16" height="16" border="0" title="Fecha Inicial" id="lanzador"></div>
        <div class="izquierda">Premio por euro</div>
        <div class="derecha"><input type="text" name="premios" required = "required"/></div>
        <div class="centro_boton"><input type="submit" value="Añadir"/></div>
    </form>
</div>
<script src="js/calen.js" type="text/javascript"></script> 