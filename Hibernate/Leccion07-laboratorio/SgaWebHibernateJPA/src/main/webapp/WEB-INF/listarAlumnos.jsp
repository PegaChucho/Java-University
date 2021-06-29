<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Listado de Alumnos</title>
    </head>
    <body>
        <p style="text-align: center">Listado de Alumno</p>
        <br/>
        <a href="${pageContext.request.contextPath}/ServletRedireccionar" style="text-align:center; display:block">Agregar alumno</a>
        <br/>
        <table border="1" style="margin-left: auto; margin-right: auto">
            <caption>

            </caption>
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Domicilio</th>
                <th>Email</th>
                <th>Teléfono</th>
            </tr>
            <c:forEach var="alumno" items="${alumnos}">
                <tr>
                    <td> 
                        <a href="${pageContext.request.contextPath}/ServletModificar?idAlumno=${alumno.idAlumno}">${alumno.idAlumno}</a>
                    </td>
                    <td>${alumno.nombre} ${alumno.apellido}</td>
                    <td>Calle ${alumno.domicilio.calle} no. ${alumno.domicilio.noCalle}, CP ${alumno.domicilio.cp}, ${alumno.domicilio.pais}</td>
                    <td>${alumno.contacto.email}</td>
                    <td>${alumno.contacto.telefono}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
