package servlets;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import logica.Usuario;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "SvEliminar", urlPatterns = {"/SvEliminar"})
public class SvEliminar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String dniAEliminar = request.getParameter("dni");

        // Obtengo la lista de usuarios de la sesión.
        HttpSession misesion = request.getSession();
        List<Usuario> listaUsuarios = (List<Usuario>) misesion.getAttribute("listaUsuarios");

        // Encuentro y elimino el usuario con el DNI especificado.
        for (Iterator<Usuario> iterator = listaUsuarios.iterator(); iterator.hasNext();) {
            Usuario usuario = iterator.next();
            if (usuario.getDni().equals(dniAEliminar)) {
                iterator.remove();
                break;
            }
        }

        misesion.setAttribute("listaUsuarios", listaUsuarios); // Actualiza la lista en la sesión.

        response.sendRedirect("mostrarUsuarios.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // No es necesario implementar el método POST en este caso.
    }
}
