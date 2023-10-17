<%@page import="logica.Usuario" %>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Desea eliminar este usuario?</title>
</head>
<body>
<h1> DNI del usuario a eliminar </h1>
<form action="SvUsuarios" method="GET">
    <p><label> Dni: </label> <input type = "text" name="dni"></p>
    <input type="hidden" name="accion" value="eliminar">
    <button type = "submit"  >Enviar</button>

    <a href="index.jsp"> Volver</a>

</form>
</body>
</html>