<%
    String colorFondo = request.getParameter("colorFondo");
%> 



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body bgcolor="<%= colorFondo%>">
        <h1>Ejemplo de inclusi�n din�mica cambiando el color de fondo</h1>
        color de fondo: <%= colorFondo%>
    </body>
</html>
