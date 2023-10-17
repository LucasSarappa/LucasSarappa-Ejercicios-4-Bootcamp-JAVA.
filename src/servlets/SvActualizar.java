package servlets;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import logica.Usuario;

import java.util.List;

@WebServlet(name = "SvActualizar", urlPatterns = {"/SvActualizar"})
public class SvActualizar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // No es necesario implementar el método GET en este caso.
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String dni = request.getParameter("dni");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String fechaNacimiento = request.getParameter("fecha_nacimiento");
        String profesion = request.getParameter("profesion");

        //Obtengo la lista de usuarios de la sesión.
        HttpSession session = request.getSession();
        List<Usuario> listaUsuarios = (List<Usuario>) session.getAttribute("listaUsuarios");

        // Encuentro el usuario a actualizar.
        Usuario usuarioActualizar = null;

        for (Usuario usuario : listaUsuarios) {
            if (usuario.getDni().equals(dni)) {
                usuarioActualizar = usuario;
                break;
            }
        }

        // Actualizo los datos del usuario. (ver porque no se actualiza el dni)
        if (usuarioActualizar != null) {
            usuarioActualizar.setDni(dni);
            usuarioActualizar.setNombre(nombre);
            usuarioActualizar.setApellido(apellido);
            usuarioActualizar.setFecha_nacimiento(fechaNacimiento);
            usuarioActualizar.setProfesion(profesion);
        }

        // Actualizo la lista en la sesión.
        session.setAttribute("listaUsuarios", listaUsuarios);

        // Redirigo a la página de mostrarUsuarios.jsp.
        response.sendRedirect("mostrarUsuarios.jsp");
    }
}
