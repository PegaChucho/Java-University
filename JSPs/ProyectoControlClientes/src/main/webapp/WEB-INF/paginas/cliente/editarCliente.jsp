<!DOCTYPE html>
<html>
    <head>

        <jsp:include page="/WEB-INF/paginas/comunes/bootstrapFontAwesome.jsp"/>

        <title>Editar Cliente</title>
    </head>
    <body>
        <!-- Se incluye el cabecero que esta construido en otra pagina JSP para que se integre con esta -->
        <jsp:include page="/WEB-INF/paginas/comunes/cabecero.jsp"/>

        <form action="${pageContext.request.contextPath}/ServletControlador?accion=modificar&idCliente=${cliente.idCliente}"
              method="POST" class="was-validated">

            <!-- Botones de navegación para esta pagina -->
            <jsp:include page="/WEB-INF/paginas/comunes/botonesNavegacionEdicion.jsp"/>

            <section id="details">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="card">
                                <div class="card-header">
                                    <h4>Editar Cliente</h4> 
                                </div>
                                <div class="card-body">
                                    <div class="form-group">
                                        <label for="nombre">Nombre:</label>
                                        <input type="text" name="nombre" id="nombre" class="form-control" required value="${cliente.nombre}">
                                    </div>
                                    <div class="form-group">
                                        <label for="apellido">Apellido:</label>
                                        <input type="text" name="apellido" id="apellido" class="form-control" required value="${cliente.apellido}">
                                    </div>
                                    <div class="form-group">
                                        <label for="email">E-mail:</label>
                                        <input type="email" name="email" id="email" class="form-control" required value="${cliente.email}">
                                    </div>
                                    <div class="form-group">
                                        <label for="telefono">Teléfono</label>
                                        <input type="tel" name="telefono" id="telefono" class="form-control" required value="${cliente.telefono}">
                                    </div>
                                    <div class="form-group">
                                        <label for="saldo">Saldo:</label>
                                        <input type="number" step="any" name="saldo" id="saldo" class="form-control" required value="${cliente.saldo}">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>

        </form>

        <!-- Se incluye la sección del pie de página -->
        <jsp:include page="/WEB-INF/paginas/comunes/piePagina.jsp"/>

        <jsp:include page="/WEB-INF/paginas/comunes/jsScripts.jsp"/>
    </body>
</html>
