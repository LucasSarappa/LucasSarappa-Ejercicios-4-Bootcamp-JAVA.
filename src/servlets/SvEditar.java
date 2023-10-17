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

@WebServlet(name = "SvEditar", urlPatterns = {"/SvEditar"})
public class SvEditar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String dniEditar = request.getParameter("dni");

        // Obténgo la lista de usuarios de la sesión.
        HttpSession misesion = request.getSession();
        List<Usuario> listaUsuarios = (List<Usuario>) misesion.getAttribute("listaUsuarios");

        Usuario usuarioEditar = null;

        // Encuentro el usuario con el DNI especificado.
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getDni().equals(dniEditar)) {
                usuarioEditar = usuario;
                break;
            }
        }

        // Guardo el usuario a editar en la sesión para mostrarlo en EditarUsuario.jsp.
        misesion.setAttribute("usuarioEditar", usuarioEditar);

        response.sendRedirect("EditarUsuario.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
