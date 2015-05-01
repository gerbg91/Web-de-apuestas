<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Loterias Y Apuestas</title>
        <link href="css/templatemo_style.css" rel="stylesheet" type="text/css"/>     
        <link href="css/calendario.css" type="text/css" rel="stylesheet">
        <script src="js/calendar.js" type="text/javascript"></script>
        <script src="js/calendar-es.js" type="text/javascript"></script>
        <script src="js/calendar-setup.js" type="text/javascript"></script> 
        
    </head>
    <body>
        <div id="templatemo_container">
            <div id="templatemo_banner">
                <div id="trebol_banner"><p>Loterías y Apuestas</p></div> 
               <div class="titulo_banner"><p></p></div> 
            </div>
            
            
            <div><a href="Controller?opID=Login" class="icon-cog" id="setting" ></a></div>
            <div id="templatemo_content_top">            
                <% String paginaprincipal = (String) request.getAttribute("paginaprincipal");
                if (paginaprincipal != null){%>
                <jsp:include page='<%=(String) request.getAttribute("paginaprincipal")%>' />
                <%} else {%>
                <jsp:include page='PrincipalEleccion.jsp' />
                <%}%>     
            </div> 
            
            <% if(paginaprincipal !="/InsertarNavidad.jsp" && paginaprincipal !="/InsertarCupon.jsp" && paginaprincipal !="/InsertarNino.jsp") {%>
           <!--  <div id="icons">
                <ul>
                    <li><a id="red" href="#"></a></li>
                    <li><a id="fac" href="#"></a></li>
                    <li><a id="twi" href="#"></a></li>
                </ul>
            </div> -->
          <div class="margin_bottom_1"></div>
            <div id="templatemo_footer">
                <ul class="footer_list">
                    <li><a href="#">Home</a></li>
                    <li><a href="#">Archives</a></li>
                    <li><a href="#">Resources</a></li>
                    <li><a href="#">Services</a></li>
                </ul> 
                <div class="margin_bottom_10"></div>
                Copyright © 2024 <a href="#">R.Ger Company</a> | Designed by <a href="http://www.templatemo.com" target="_parent">Free CSS Templates</a>
            </div>
         
        </div>   
             <%}%> 
    </body>
</html>