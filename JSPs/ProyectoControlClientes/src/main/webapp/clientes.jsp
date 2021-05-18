<!DOCTYPE html>
<html>
    <head>
        
        <jsp:include page="WEB-INF/paginas/comunes/bootstrapFontAwesome.jsp"/>
        
        <title>Control de clientes</title>
    </head>
    <body>
        <!-- Se incluye el cabecero que esta construido en otra pagina JSP para que se integre con esta -->
        <jsp:include page="/WEB-INF/paginas/comunes/cabecero.jsp"/>

        <!-- Se incluye la sección de botones de navegación (aqui tambien está la parte de agregar cliente -->
        <jsp:include page="/WEB-INF/paginas/comunes/botonesNavegacion.jsp"/>
        
        <!-- Se incluye la sección del listado de clientes -->
        <jsp:include page="/WEB-INF/paginas/cliente/listadoClientes.jsp"/>

        <!-- Se incluye la sección del pie de página -->
        <jsp:include page="/WEB-INF/paginas/comunes/piePagina.jsp"/>

        <jsp:include page="/WEB-INF/paginas/comunes/jsScripts.jsp"/>
    </body>
</html>
