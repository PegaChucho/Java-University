<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP con Scriplets</title>
    </head>
    <body>
        <h1>JSP con Scriplets</h1>
        <br>
        <%-- Scriplet para mandar información al navegador --%>
        <%
            out.print("Saludos desde un Scriplet");
        %>
        <%-- Scriplet para manipular los objetos implícitos --%>
        <%
            String nombreAplicacion = request.getContextPath();
            out.print("Nombre de la aplicación: " + nombreAplicacion);
        %>
        <br>
        <%-- Scriplet con codigo condicionado --%>
        <%
            if (session != null && session.isNew()) {
        %>
        La sesión es nueva
        <%
            }else if (session != null) {
        %>
        La sesión no es nueva
        <%
            }
        %>  
        <br>
        <a href="index.html">Regresar a la página de inicio</a>
        
    </body>
</html>
