<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejemplo inclusi�n din�mica</title>
    </head>
    <body>
        <h1>Ejemplo Inclusi�n Din�mica</h1>
        <br>
        <jsp:include page="paginas/recursoPublico.jsp"/>
        <br>
        <!-- Va a leer el parametro de colorFondo y lo va a agregar al JSP secundario -->
        <jsp:include page="WEB-INF/recursoPrivado.jsp">
            <jsp:param name="colorFondo" value="yellow"/>
        </jsp:include>
    </body>
</html>
