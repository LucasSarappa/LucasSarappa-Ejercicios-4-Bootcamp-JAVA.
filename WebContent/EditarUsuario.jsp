<%@page import="logica.Usuario" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Editar Usuario</title>
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
<h1>Editar Usuario</h1>
<form action="SvActualizar" method="POST">
    <p><label> DNI: </label> <label>
        <input type="text" name="dni" value="${usuarioEditar.dni}">
    </label></p>
    <p><label> Nombre: </label> <label>
        <input type="text" name="nombre" value="${usuarioEditar.nombre}">
    </label></p>
    <p><label> Apellido: </label> <label>
        <input type="text" name="apellido" value="${usuarioEditar.apellido}">
    </label></p>
    <p><label> Fecha de nacimiento: </label> <label>
        <input type="date" name="fecha_nacimiento" value="${usuarioEditar.fecha_nacimiento}">
    </label></p>
    <p><label> Profesion: </label> <label>
        <input type="text" name="profesion" value="${usuarioEditar.profesion}">
    </label></p>
    <p><label> Contacto: </label> <label>
        <input type="text" name="email" value="${usuarioEditar.contacto}">
    </label></p>

    <button type = "submit" class="btn-agregar"  >Enviar</button>

    <a href="mostrarUsuarios.jsp" title="Volver" class="btn-volver">
        <i class="fas fa-trash-alt"></i> Volver
    </a>

</form>
</body>
</html>