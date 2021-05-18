<%-- 
    Document   : index
    Created on : Apr 23, 2021, 2:11:14 PM
    Author     : jperezgarcia
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>HolaMundo JSPs</title>
    </head>
    <body>
        <h1>Hola Mundo JSPs</h1>
        <ul>
            <li> <% out.print("HolaMundo con Scriplets");%> </li>
            <li>${"HolaMundo con expresion languaje (el)"}</li>
            <li><%= "HolaMundo con expresiones"%></li>
            <li><c:out value="Hola con JSTL" /></li>
            </ul>

        </body>
    </html>