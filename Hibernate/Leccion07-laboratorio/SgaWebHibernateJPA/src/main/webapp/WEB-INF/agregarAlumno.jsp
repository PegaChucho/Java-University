<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!DOCTYPE html>
<html>
    <head>
        <title>Agregar Alumno</title>
    </head>
    <body>
        <h1>Agregar Alumno</h1>
        <form action="${pageContext.request.contextPath}/ServletAgregar" method="POST">
            <label for="nombre">Nombre:</label>
            <input type="text" name="nombre" id="nombre">
            <br/> 
            <label for="apellido">Apellido:</label>
            <input type="text" name="apellido" id="apellido">
            <br/>
            <p>Domicilio:</p>
            <section>
                <label for="calle">Calle:</label>
                <input type="text" name="calle" id="calle">

                <label for="noCalle">No. de calle:</label>
                <input type="text" name="noCalle" id="noCalle">

                <label for="cp">Código Postal:</label>
                <input type="number" name="cp" id="cp">

                <label for="pais">Pais:</label>
                <input type="text" name="pais" id="pais">
            </section>
            <br/>
            <label for="email">Email:</label>
            <input type="email" name="email" id="email">
            <br/>
            <label for="telefono">Teléfono:</label>
            <input type="tel" name="telefono" id="telefono">
            <br/>
            <input type="submit" value="Agregar" name="agregar">
        </form>
    </body>
</html>
