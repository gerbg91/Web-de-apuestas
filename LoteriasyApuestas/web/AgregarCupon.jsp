<jsp:include page="menu.jsp" />
<div class="anadir">
    <b>Advertencia</b> Ingresar por orden de lista.
    <form action="Controller?opID=InsertarCupon" method="POST">
        <div class="izquierda">Número:</div>
        <div class="derecha"><input type="number" name="numeroDado" required = "required"/></div>
        <div class="izquierda">Nombre</div>
        <div class="derecha">
            <select name="TipoLoteria">
                <option value="CincoCifras">Cinco Cifras</option>
                <option value="CincoCifrasAnterior"> Cinco cifras anterior</option>
                <option value="CincoPosterior">Cinco cifras posterior</option>
                <option value="CuatroCifras">Cuatro ultimas cifras</option>
                <option value="TresCifras">Tres ultimas cifras</option>
                <option value="DosCifras">Dos ultimas cifras</option>
                <option value="UltimaCifra">Ultima cifra</option>
                <option value="PrimeraCifra">Primera cifra</option>
                <option value="Serie">Serie</option>
            </select> 
        </div>
        <div class="izquierda">Fecha del sorteo</div>
        <div class="derecha"> <input type="text" name="ingreso" id="ingreso" required = "required" required = "required"/><img src="css/images/calendario.png" width="16" height="16" border="0" title="Fecha Inicial" id="lanzador"></div>
        <div class="izquierda"> Premio:</div>
        <div class="derecha"><input type="text" name="premios" required = "required"/></div>
        <div class="centro_boton"><input type="submit" value="Añadir"/></div>
    </form>
</div>
<script src="js/calen.js" type="text/javascript"></script> 