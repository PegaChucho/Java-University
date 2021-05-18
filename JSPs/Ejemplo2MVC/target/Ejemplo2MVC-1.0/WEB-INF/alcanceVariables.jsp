<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alcance de variables</title>
    </head>
    <body>
        <h1>Alcance de variables</h1>
        <br>
        <br>
        <div>
            <table border="1">
                <caption>Variable request (ya no se mostrará al haberse hecho otra petición):</caption>
                <thead>
                    <tr>
                        <th>Rectangulo</th>
                        <th>Propiedad</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Base:</td>
                        <td>${rectanguloRequest.base}</td>
                    </tr>
                    <tr>
                        <td>Altura:</td>
                        <td>${rectanguloRequest.altura}</td>
                    </tr>
                    <tr>
                        <td>Área:</td>
                        <td>${rectanguloRequest.area}</td>
                    </tr>
                </tbody>
            </table>
            <br>        
            <table border="1">
                <caption>Variable session</caption>
                <thead>
                    <tr>
                        <th>Rectangulo</th>
                        <th>Propiedad</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Base:</td>
                        <td>${rectanguloSesion.base}</td>
                    </tr>
                    <tr>
                        <td>Altura:</td>
                        <td>${rectanguloSesion.altura}</td>
                    </tr>
                    <tr>
                        <td>Área:</td>
                        <td>${rectanguloSesion.area}</td>
                    </tr>
                </tbody>
            </table>
            <br>        
            <table border="1">
                <caption>Variable application:</caption>
                <thead>
                    <tr>
                        <th>Rectangulo</th>
                        <th>Propiedad</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Base:</td>
                        <td>${rectanguloAplicacion.base}</td>
                    </tr>
                    <tr>
                        <td>Altura:</td>
                        <td>${rectanguloAplicacion.altura}</td>
                    </tr>
                    <tr>
                        <td>Área:</td>
                        <td>${rectanguloAplicacion.area}</td>
                    </tr>
                </tbody>
            </table>
        </div>
        <br>        
        <br> 
        <a href="${pageContext.request.contextPath}/index.jsp">Regresar al inicio</a>
    </body>
</html>
