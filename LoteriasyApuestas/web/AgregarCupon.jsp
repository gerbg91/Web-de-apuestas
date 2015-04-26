<div class="form">  
    <form action="Controller?opID=InsertarCupon" method="POST">
        Numero:<input type="number" name="numeroDado"/>
        <select name="TipoLoteria">
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
            <input type="hidden" name="id_Navidad"/>
            <input type="text" name="ingreso" id="ingreso" required = "required"/>
        <img src="css/images/calendario.png" width="16" height="16" border="0" title="Fecha Inicial" id="lanzador">
        <input type="text" name="premios"/>
        <input type="submit" value="Agregar"/>
    </form>
        <script type="text/javascript">
    Calendar.setup({
        inputField: "ingreso",
        ifFormat: "%Y-%m-%d",
        button: "lanzador"
    });
</script> 
</div>