package servlets;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import logica.Usuario;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

public class SvGenerarPDF extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float margin = 20;
        float rowHeight = 10;
        float columnSpacing = 2; // Espacio entre columnas

        List<Usuario> listaUsuarios = (List<Usuario>) request.getSession().getAttribute("listaUsuarios");
        int cols = 7; // DNI, Nombre, Apellido, fecha, profesion y contacto (+1 para que me quede mas lindo)

        float yPosition = PDRectangle.A4.getHeight() - margin;
        float tableWidth = (PDRectangle.A4.getWidth() - 2 * margin);
        float columnWidth = (tableWidth - columnSpacing * (cols - 1)) / cols; // Calcula el ancho de la columna

        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);

            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD), 10);

                float tableXPosition = margin;
                float textXPosition = tableXPosition; // Posición del texto

                // Dibujo la cabecera de la tabla
                contentStream.beginText();
                contentStream.newLineAtOffset(textXPosition, yPosition);
                contentStream.showText("DNI");
                contentStream.newLineAtOffset(columnWidth + columnSpacing, 0);
                contentStream.showText("Nombre");
                contentStream.newLineAtOffset(columnWidth + columnSpacing, 0);
                contentStream.showText("Apellido");
                contentStream.newLineAtOffset(columnWidth + columnSpacing, 0);
                contentStream.showText("Nacimiento");
                contentStream.newLineAtOffset(columnWidth + columnSpacing, 0);
                contentStream.showText("Profesion");
                contentStream.newLineAtOffset(columnWidth + columnSpacing, 0);
                contentStream.showText("Contacto");
                contentStream.endText();
                yPosition -= rowHeight;

                // Dibujo la tabla
                for (Usuario usuario : listaUsuarios) {
                    contentStream.beginText();
                    contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.COURIER), 10);
                    contentStream.newLineAtOffset(textXPosition, yPosition);
                    contentStream.showText(usuario.getDni());
                    contentStream.newLineAtOffset(columnWidth + columnSpacing, 0);
                    contentStream.showText(usuario.getNombre());
                    contentStream.newLineAtOffset(columnWidth + columnSpacing, 0);
                    contentStream.showText(usuario.getApellido());
                    contentStream.newLineAtOffset(columnWidth + columnSpacing, 0);
                    contentStream.showText(usuario.getFecha_nacimiento());
                    contentStream.newLineAtOffset(columnWidth + columnSpacing, 0);
                    contentStream.showText(usuario.getProfesion());
                    contentStream.newLineAtOffset(columnWidth + columnSpacing, 0);
                    contentStream.showText(usuario.getContacto());
                    contentStream.endText();
                    yPosition -= rowHeight;
                }

                contentStream.close();
            }

            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=usuarios.pdf");
            document.save(response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
