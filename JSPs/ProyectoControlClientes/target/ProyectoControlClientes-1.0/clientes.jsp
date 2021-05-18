<!DOCTYPE html>
<html>
    <head>
        
        <jsp:include page="WEB-INF/paginas/comunes/bootstrapFontAwesome.jsp"/>
        
        <title>Control de clientes</title>
    </head>
    <body>
        <!-- Se incluye el cabecero que esta construido en otra pagina JSP para que se integre con esta -->
        <jsp:include page="/WEB-INF/paginas/comunes/cabecero.jsp"/>

        <!-- Se incluye la secci�n de botones de navegaci�n (aqui tambien est� la parte de agregar cliente -->
        <jsp:include page="/WEB-INF/paginas/comunes/botonesNavegacion.jsp"/>
        
        <!-- Se incluye la secci�n del listado de clientes -->
        <jsp:include page="/WEB-INF/paginas/cliente/listadoClientes.jsp"/>

        <!-- Se incluye la secci�n del pie de p�gina -->
        <jsp:include page="/WEB-INF/paginas/comunes/piePagina.jsp"/>

        <jsp:include page="/WEB-INF/paginas/comunes/jsScripts.jsp"/>
    </body>
</html>
