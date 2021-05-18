<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSTL core</title>
    </head>
    <body>
        <h1>JSTL Core</h1>
        <!-- Manipulación de variables -->
        <!-- Se define la variable -->
        <c:set var="nombre" value="Ernesto"/>
        <!-- Desplegamos el valor de la variable con EL -->
        variable nombre: <c:out value="${nombre}"/>
        <br>
        <br>
        <!-- con escapeXml se respetan las etiquetas html -->
        Variable con código HTML:
        <c:out value="<h4>Hola</h4>" escapeXml="false"/>
        <br>
        <br>
        <!-- Uso de if, condiciones -->
        <c:set var="bandera" value="true" />
        <c:if test="${bandera}">
            La bandera es verdadera
        </c:if>   
        <br>
        <!-- Código condicionado, uso de switch -->
        <c:if test="${param.opcion != null}">
            <c:choose>
                <c:when test="${param.opcion ==1}">
                    <br>
                    Opcion 1 seleccionada
                </c:when>
                <c:when test="${param.opcion ==2}">
                    <br>
                    Opcion 2 seleccionada
                </c:when>
                <c:otherwise>
                    <br>
                    Opcion proporcionada desconocida: ${param.opcion}
                </c:otherwise> 
            </c:choose>
        </c:if>
        <!-- Iteración de un arreglo -->      
        <%
            String nombres[]={"Jesús", "Silvia", "Eva", "Valentín"};
            //compartimos la varoable en el alcance de request
            request.setAttribute("nombres", nombres);
        %>
        <br>
        Lista de nombres:
        <br>
        <ul>
            <!-- Va a crer una variable de persona, en donde
            va a bucar en cada contexto al areglo de nombres y lo va a iterar--> 
            <c:forEach var="persona" items="${nombres}">
                <li>Nombre: ${persona}</li>
            </c:forEach>
        </ul>
        <br>
        <br>
        <a href="index.jsp">Volver al inicio</a>

    </body>
</html>
