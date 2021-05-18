<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EL y variables implícitas</title>
    </head>
    <body>
        <h1>EL y variables implícitas</h1>
        <ul>
            <li>Nombre de la aplicación: ${pageContext.request.contextPath}</li>
            <li>Nombre del navegador: ${header["User-Agent"]}</li>
            <li>Id Sesión: ${cookie.JSESSIONID.value}</li>
            <li>Web server: ${pageContext.servletContext.serverInfo}</li>
            <li>Valor parámetro: ${param.usuario}</li>
        </ul>
        <br>
        <br>
        <a href="index.jsp">Regresar al inicio</a>
    </body>
</html>
