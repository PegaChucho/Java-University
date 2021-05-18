<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Despliegue de variables</title>
    </head>
    <body>
        <h1>Despliegue de variables</h1>
        <!-- EL va a buscar la llave "mensaje" en algun alcance y devolverá su valor -->
        Variable en alcance request: ${mensaje}
        <br>
        <br>
        Varible en alcance de sesión: 
        <br>
        <table border="1">
            <thead>
                <tr>
                    <th>Rectángulo</th>
                    <th>Valor</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Base:</td>
                    <td>${rectangulo.base}</td>
                </tr>
                <tr>
                    <td>Altura</td>
                    <td>${rectangulo.altura}</td>
                </tr>
                <tr>
                    <td>Área</td>
                    <td>${rectangulo.area}</td>
                </tr>
            </tbody>
        </table>

        <br>
        <br>
        <a href="${pageContext.request.contextPath}/index.jsp">Regresar al inicio</a>
        
    </body>
</html>
