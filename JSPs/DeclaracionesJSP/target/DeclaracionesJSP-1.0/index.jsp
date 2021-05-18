<%-- Agregamos una declaracioón de JSP --%>

<%!
    //Declaramos una variable con su método GET
    private String usuario = "Jesús";

    public String getusuario() {
        return this.usuario;
    }

    // Declaramos un contador de visitas
    private int contadorVisitas = 1;
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Uso de declaraciones con JSPs</title>
    </head>
    <body>
        <h1>Uso de declaraciones con JSPs</h1>
        Valor del usuario por medio del atributo: <%= this.usuario %>
        <br> 
        Valor usuario por medio del método: <%= this.getusuario() %>
        <br>
        Contador de Visitas: <%= this.contadorVisitas++ %>
    </body>
</html>
