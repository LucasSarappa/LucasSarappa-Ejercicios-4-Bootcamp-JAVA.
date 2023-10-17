<!DOCTYPE html>
<html>
<head>
    <title>DNI Repetido</title>
    <style>

        .btn-volver {
            background-color: skyblue;
            color: black;
            border: black;
            padding: 5px 10px;
            cursor: pointer;
        }
    </style>
</head>
<body>
<div class="error-message">
    <p>El DNI ingresado ya existe en la base de datos de usuarios.</p>
    <a href="mostrarUsuarios.jsp" title="Volver" class="btn-volver">
        <i class="fas fa-trash-alt"></i> Volver
    </a>
</div>
</body>
</html>
