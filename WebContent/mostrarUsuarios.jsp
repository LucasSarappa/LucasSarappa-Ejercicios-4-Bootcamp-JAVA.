<%@page import="logica.Usuario" %>
<%@page import="java.util.List" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.0/css/all.min.css">

<!DOCTYPE html>
<html>
<head>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }
        th, td {
            border: 1px solid black;
            text-align: center;
            padding: 8px;
        }
        th {
            background-color: sandybrown			;
        }
        .btn-eliminar {
            background-color: red;
            color: black;
            border: none;
            padding: 5px 10px;
            cursor: pointer;
        }
        .btn-editar {
            background-color: orange;
            color: black;
            border: none;
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

        .btn-desc {
            background-color: orangered;
            color: black;
            border: black;
            padding: 5px 10px;
            cursor: pointer;
        }

        .button-container {
            display: flex;
            justify-content: space-between;
        }



    </style>
</head>
<body>

<h1><center>Lista de Usuarios registrados</center></h1>

<table>
    <tr>
        <th>DNI <i class="fa-solid fa-id-card fa-beat-fade fa-xl"></i></th>
        <th>NOMBRE <i class="fa-solid fa-signature fa-beat-fade fa-xl"></i> </th>
        <th>APELLIDO <i class="fa-solid fa-signature fa-beat-fade fa-xl"></i> </th>
        <th>FECHA NACIMIENTO <i class="fa-solid fa-calendar-days fa-beat-fade fa-xl"></i></th>
        <th>PROFESION <i class="fa-solid fa-user-tie fa-beat-fade fa-xl"></i></th>
        <th>CONTACTO <i class="fa-solid fa-envelope fa-beat-fade fa-xl"></i></th>
        <th>ACCIONES <i class="fa-solid fa-bolt fa-beat-fade fa-xl"></i> </th>
    </tr>
    <% List<Usuario> listaUsuarios = (List) request.getSession().getAttribute("listaUsuarios");
        for (Usuario usu : listaUsuarios) { %>
    <tr>
        <td><%=usu.getDni()%></td>
        <td><%=usu.getNombre()%></td>
        <td><%=usu.getApellido()%></td>
        <td><%=usu.getFecha_nacimiento()%></td>
        <td><%=usu.getProfesion()%></td>
        <td><%=usu.getContacto()%></td>
        <td>
            <a href="SvEditar?dni=<%=usu.getDni()%>" title="Editar" class="btn-editar">
                <i class="fas fa-pencil-alt"></i> Editar
            </a>

            <a href="SvEliminar?dni=<%=usu.getDni()%>" title="Eliminar" class="btn-eliminar" onclick="return confirmarEliminacion()">
                <i class="fas fa-trash-alt"></i> Eliminar
            </a>
        </td>

    </tr>
    <% } %>

</table>
<br>
<br>
<div class="button-container">
    <a href="ingresarUsuarios.jsp" title="Agregar nuevo Usuario" class="btn-agregar">
        <i class="fa-solid fa-user-plus fa-beat-fade fa-xl"></i> Agregar Usuario
    </a>

    <a href="SvGenerarPDF" title="Descargar listado de Usuario" class="btn-desc">
        <i class="fa-solid fa-file-pdf fa-beat-fade fa-xl"></i> Generar listado
    </a>
</div>

<br>
<br>
</body>
</html>
