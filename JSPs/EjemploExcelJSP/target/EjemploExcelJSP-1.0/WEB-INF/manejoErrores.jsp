
<%@page isErrorPage="true" %>
<%@page import="java.io.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manejo de Errores</title>
    </head>
    <body>
        <h1>Manejo de errores</h1>
        <br>
        Ocurri� la siguiente excepci�n: <%= exception.getMessage()%>
        <br>
        <textarea rows="5" cols="30">
                <% exception.printStackTrace(new PrintWriter(out));%>
        </textarea>

    </body>
</html>
