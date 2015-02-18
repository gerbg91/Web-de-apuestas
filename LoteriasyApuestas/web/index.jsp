<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Loterias Y Apuestas</title>
        <link href="css/templatemo_style.css" rel="stylesheet" type="text/css"/>     
    </head>
    <body>
        <div id="templatemo_container">
            <div id="templatemo_banner">

            </div> 
            <div id="templatemo_content_top">            
                <% String paginaprincipal = (String) request.getAttribute("paginaprincipal");
                if (paginaprincipal != null){%>
                <jsp:include page='<%=(String) request.getAttribute("paginaprincipal")%>' />
                <%} else {%>
                <jsp:include page='Principal.jsp' />
                <%}%>     
            </div> 
            <div id="templatemo_footer">
                <ul class="footer_list">
                    <li><a href="#">Home</a></li>
                    <li><a href="#">Archives</a></li>
                    <li><a href="#">Resources</a></li>
                    <li><a href="#">Services</a></li>
                </ul> 
                <div class="margin_bottom_10"></div>
                Copyright © 2024 <a href="#">R.Ger Company</a> | Designed by <a href="http://www.templatemo.com" target="_parent">Free CSS Templates</a>
                <div class="margin_bottom_20"></div>
            </div>
            <div class="cleaner"></div> 
        </div>       
    </body>
</html>