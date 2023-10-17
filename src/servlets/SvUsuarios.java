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


@WebServlet(name = "SvUsuarios", urlPatterns = {"/SvUsuarios"})
public class SvUsuarios extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Usuario> listaUsuarios = new ArrayList<>();
        listaUsuarios.add(new Usuario("1234567", "Juan", "Perez", "1990-10-10", "Ingeniero", "juanperez@hotmail.com"));
        listaUsuarios.add(new Usuario("7654321", "Alberto", "Gonzalez", "1850-09-05", "Taxista", "albertog@gmail.com"));
        listaUsuarios.add(new Usuario("2525252", "Lucas", "Sarappa", "2000-10-18", "Programador","sarappalucas2000@gmail.com"));
        listaUsuarios.add(new Usuario("1010101", "Lionel", "Messi", "1870-09-15", "Jugador", "leomessi10@gmail.com"));

        HttpSession misesion = request.getSession();
        misesion.setAttribute("listaUsuarios", listaUsuarios);

        response.sendRedirect("mostrarUsuarios.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String dni = request.getParameter("dni");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String fecha_nacimiento = request.getParameter("Fecha_nacimiento");
        String profesion = request.getParameter("profesion");
        String contacto = request.getParameter("contacto");

        // Crea un nuevo usuario con los datos del formulario.
        Usuario nuevoUsuario = new Usuario(dni, nombre, apellido,  fecha_nacimiento, profesion, contacto);

        // Obtengo la lista de usuarios de la sesión.
        HttpSession misesion = request.getSession();
        List<Usuario> listaUsuarios = (List<Usuario>) misesion.getAttribute("listaUsuarios");

        // Verifico si el DNI ya está en uso.
        boolean dniRepetido = false;
        for (Usuario usuarioExistente : listaUsuarios) {
            if (usuarioExistente.equals(nuevoUsuario)) {
                dniRepetido = true;
                break; // DNI repetido, no es necesario seguir buscando.
            }
        }

        if (dniRepetido) {
            response.sendRedirect("dniRepetido.jsp");
        } else {
            // Agrego el nuevo usuario a la lista.
            listaUsuarios.add(nuevoUsuario);
            misesion.setAttribute("listaUsuarios", listaUsuarios); // Actualizo la lista en la sesión.
            response.sendRedirect("mostrarUsuarios.jsp");
        }

    }



}
