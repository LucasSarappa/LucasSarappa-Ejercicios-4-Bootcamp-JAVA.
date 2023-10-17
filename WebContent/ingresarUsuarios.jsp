<%@page import="logica.Usuario" %>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Mostrar Usuarios</title>
    <i class="fa-solid fa-trash"></i>
    <style>

        .btn-volver {
        background-color: skyblue;
        color: black;
        border: black;
        padding: 5px 10px;
        cursor: pointer;
        }

        .btn-agregar {
            background-color: green;
            color: black;
            border: black;
            padding: 5px 10px;
            cursor: pointer;
        }

    </style>
</head>
<body>
<h1> Datos del usuario </h1>
<form action="SvUsuarios" method="POST">
    <p><label> Dni: </label> <input type = "text" name="dni"></p>
    <p><label> Nombre: </label> <input type = "text" name="nombre"></p>
    <p><label> Apellido: </label> <input type = "text" name="apellido"></p>
    <p><label> Fecha de nacimiento: </label> <input type = "date" name="Fecha_nacimiento"></p>
    <p><label> Profesion: </label> <input type = "text" name="profesion"></p>
    <p><label> Contacto: </label> <input type = "text" name="contacto"></p>

    <button type = "submit" class="btn-agregar"  >Enviar</button>

    <a href="mostrarUsuarios.jsp" title="Volver" class="btn-volver">
        <i class="fas fa-trash-alt"></i> Volver
    </a>
</form>



</body>
</html>