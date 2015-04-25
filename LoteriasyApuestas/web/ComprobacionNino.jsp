<div class="publi_comprobacion">Publicidad</div>
<div class="comprobacion">
    <form action="Controller?opID=ResultadoNino" method="POST" class="form_compro">
        Numero:<input type="number" name="numeroDado" required = "required"/>
        Cantidad en euros:<input type="number" name="cantidadDinero"  step="any" required = "required"/>?
        Fecha del Sorteo:
        <input type="text" name="ingreso" id="ingreso" placeholder="yyyy-mm-dd" required = "required"/>
        <img src="css/images/calendario.png" width="16" height="16" border="0" title="Fecha Inicial" id="lanzador"> 
        <input class="botonComprobar1" type="submit" value="COMPRUEBA"/>
    </form>
</div>
<div class="publicidad_web">
    <div class="text_publicidad">
        <p class="p1">Siguenos ahora en Facebook o Twitter</p>
        <p class="p2">Y recuerda que la <b class="b1">SUERTE</b><a class="trebol"></a></p> 
        <p class="p3">esta siempre de nuestra parte.</p>
    </div>             
</div>
<script type="text/javascript">
    Calendar.setup({
        inputField: "ingreso",
        ifFormat: "%Y-%m-%d",
        button: "lanzador"
    });
</script> 


