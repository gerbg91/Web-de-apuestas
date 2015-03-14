

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="search_section">
          <jsp:include page="menu.jsp" />
            <div class="intrucciones">
                <h3>Instrucciones</h3>
                Se DEBEN colocar TODOS los premios 
                <br>
                -Para el premio de cinco cifras los cinco números.
                <br>
                -Para el premio de cinco cifras anterior, los cinco números.
                <br>
                -Para el premio de cinco cifras posterior, los cinco números.
                <br>
                -Para el premio de cuatro cifras, los cuatro números del final.
                <br>
                -Para el premio de tres cifras, los tres números del final.
                <br>
                -Para el premio de dos cifras, los dos números del final.
                <br>
                -Para el premio de la ultima cifra del primer premio, la ultima cifra.
                <br>
                -Para el premio de la primera cifra del primer premio, la primera cifra.
                <br>
                -En relacion a los a los numeros introducidos se debe colocar su premio en euros.
            </div>
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
                </select> 
                Premio en euros:<input type="number" name="cantidadDinero"  step="any"/>€
                <input type="submit" value="Comprobar" />
                <select name="fecha">
                    <option value="2015-03-13">13-03-2015</option>
                    <option value="2014-12-21">21-12-2014</option>
                    <option value="2013-12-21">21-12-2013</option>
                </select> 
            </form>
            </div>
        </div>
    </body>
</html>
