package controlador;

import modelo.adm.SeguridadAdm;
import modelo.vo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author NB
 */
public class ServletControler extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //captura los parametros del frm
        String username = request.getParameter("usuario");
        String userclave = request.getParameter("contra");

        SeguridadAdm seguridadAdm = new SeguridadAdm();
        //valida en la base de datos el "NOMBRE" y "CONTRA"
        //envia los campos capturados del frm a validar
        Usuario usuObj = seguridadAdm.validarUsuario(username, userclave);

        if (usuObj != null) { //si no está vacio, significa que si existen ambos campos en la bd
            //genera sesion, la que servira para ingresar a las opciones de "Intranet"
            HttpSession session = request.getSession();
            session.setAttribute("bUsuario", usuObj); //establece el atributo "bUsuario" para la sesion
            System.out.println("ENVIANDO A INTRANET");
            response.sendRedirect("Intranet");
        } else if (usuObj == null) {//si se equivoco al escribir o ingreso usuario no existente
            request.setAttribute("mensaje2","<i class=\"fa fa-times\"> </i> Usuario no registrado");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            response.sendRedirect("jsp/404.jsp");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
