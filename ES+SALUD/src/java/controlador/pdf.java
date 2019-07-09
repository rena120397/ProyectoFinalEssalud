
package controlador;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.concurrent.Phaser;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.adm.UsuarioAdm;
import modelo.paciente;
import modelo.vo.Usuario;

/**
 *
 * @author NB
 */
public class pdf extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/pdf");

        OutputStream out = response.getOutputStream();
        
        String id = request.getParameter("accion");
        
        try {
            try {
                UsuarioAdm usuAdm = new UsuarioAdm();
                
                Document documento = new Document();
                PdfWriter.getInstance(documento, out);
                
                documento.open();
                
                paciente pac = usuAdm.getPaciente(id);
                
                Paragraph p1 = new Paragraph();
                Font font = new Font(Font.FontFamily.TIMES_ROMAN,16,Font.BOLD,BaseColor.BLACK);
                p1.add(new Phrase("Hola, tu contraseña es:", font));
                p1.setAlignment(Element.ALIGN_CENTER);
                p1.add(new Phrase(Chunk.NEWLINE));
                p1.add(new Phrase(Chunk.NEWLINE));
                p1.add(new Phrase(pac.getHI_CONTRA(), font));
                p1.add(new Phrase(Chunk.NEWLINE));
                documento.add(p1);
                documento.close();
                
            } catch (Exception e) {
               System.out.println(e.getMessage());
            }
        } finally {
            
            out.close();
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
