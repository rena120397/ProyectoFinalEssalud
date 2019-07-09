package controlador;

import modelo.vo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.adm.UsuarioAdm;

/**
 *
 * @author NB
 */
public class ServletIntranet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        System.out.println("ENTRO A INTRANET");

        HttpSession session = request.getSession();
        //Obtiene la sesion ya iniciada en ServletControler por el atributo "bUsuario" 
        //y lo castea a tipo "(Usuario)" dentro de la variable "busuario"
        Usuario busuario = (Usuario) session.getAttribute("bUsuario");

        if (busuario == null) { //si no existe sesion o es nula
            request.getRequestDispatcher("jsp/404.jsp").forward(request, response);
        } else if (busuario.getID_PERFIL() == 3) { //si es un medico
            UsuarioAdm usuAdm = new UsuarioAdm();
            ArrayList alCitasDes = usuAdm.getListaCitasDes();
            request.setAttribute("alCitasDes", alCitasDes);
            RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/intranet.jsp");
            dispatcher.forward(request, response);
        } else {//si existe sesion o está establecida
            request.getRequestDispatcher("jsp/intranet.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
