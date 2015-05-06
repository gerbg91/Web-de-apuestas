<jsp:include page="menu.jsp" />
<div class="anadir">
    <b>Advertencia</b> Ingresar por orden de lista.
    <form action="Controller?opID=InsertarNavidad" method="POST">
        <div class="izquierda"> Número:</div>
        <div class="derecha"><input type="number" name="numeroDado" required = "required"/></div>
        <div class="izquierda">Nombre</div>
        <div class="derecha">
        <select name="TipoLoteria">
            <option value="PrimerPremio">Primer Premio</option>
                    <option value="SegundoPremio">Segundo Premio</option>
                    <option value="TercerPremio">Tercer Premio</option>
                    <option value="CuartoPremio">Cuarto Premio</option>
                    <option value="QuintoPremio">Quinto Premio</option>
                    <option value="Pedrea">Tercer Premio</option>
                    <option value="AproxPrimerPremioSuperior">Aproximacion primer premio superior</option>
                    <option value="AproxPrimerPremioInferior">Aproximacion primer premio inferior</option>
                    <option value="AproxSegundoPremioSuperior">Aproximacion segundo premio superior</option>
                    <option value="AproxSegundoPremioInferior">Aproximacion segundo premio inferior</option>
                    <option value="AproxTercerPremioSuperior">Aproximacion tercer premio superior</option>
                    <option value="AproxTercerPremioInferior">Aproximacion tercer premio inferior</option>
                    <option value="PrimerPremioCentenas">Primer premio centenas</option>
                    <option value="SegundoPremioCentenas">Segundo premio centenas</option>
                    <option value="TercerPremioCentenas">Tercer premio centenas</option>
                    <option value="CuartoPremioCentenas">Cuarto premio centenas</option>
                    <option value="PrimerPremioDecenas">Primer premio decenas</option>
                    <option value="SegundoPremioDecenas">Segundo premio decenas</option>
                    <option value="TercerPremioDecenas">Tercer premio decenas</option>
                    <option value="Pedrea">Pedrea</option>
                    <option value="Reintegro">Reintegro</option>
        </select> 
        </div>
        <div class="izquierda">Fecha del sorteo</div>    
        <div class="derecha"><input type="text" name="ingreso" id="ingreso" required = "required" /><img src="css/images/calendario.png" width="16" height="16" border="0" title="Fecha Inicial" id="lanzador"></div>
        <div class="izquierda">Premio por euro</div>
        <div class="derecha"><input type="text" name="premios" required = "required"/></div>
        <div class="centro_boton"><input type="submit" value="Añadir"/></div>
    </form>
</div>
<script src="js/calen.js" type="text/javascript"></script> 