<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!DOCTYPE html>
<html>
    <head>
        <title>Modificar Alumno</title>
    </head>
    <body>
        <h1>Modificar Alumno</h1>
        <form action="${pageContext.request.contextPath}/ServletModificar" method="POST">
            <input type="hidden" name="idAlumno" value="${alumno.idAlumno}">
            
            <label for="nombre">Nombre:</label>
            <input type="text" name="nombre" id="nombre" value="${alumno.nombre}">
            <br/> 
            <label for="apellido">Apellido:</label>
            <input type="text" name="apellido" id="apellido" value="${alumno.apellido}">
            <br/>
            <p>Domicilio:</p>
            <section>
                <label for="calle">Calle:</label>
                <input type="text" name="calle" id="calle" value="${alumno.domicilio.calle}"> 

                <label for="noCalle">No. de calle:</label>
                <input type="text" name="noCalle" id="noCalle" value="${alumno.domicilio.noCalle}">

                <label for="cp">Código Postal:</label>
                <input type="number" name="cp" id="cp" value="${alumno.domicilio.cp}">

                <label for="pais">Pais:</label>
                <input type="text" name="pais" id="pais" value="${alumno.domicilio.pais}">
            </section>
            <br/>
            <label for="email">Email:</label>
            <input type="email" name="email" id="email" value="${alumno.contacto.email}">
            <br/>
            <label for="telefono">Teléfono:</label>
            <input type="tel" name="telefono" id="telefono" value="${alumno.contacto.telefono}">
            <br/>
            <input type="submit" value="Modificar" name="modificar">
            <input type="submit" value="Eliminar" name="eliminar">
        </form>
    </body>
</html>
