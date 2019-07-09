package controlador;

import modelo.adm.UsuarioAdm;
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
import modelo.doctor;
import modelo.paciente;

/**
 *
 * @author NB
 */
public class ServletListar extends HttpServlet {

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
        //Obtiene el valor del input (name="accion" value="goListar") de intranet.jsp 
        String accion = request.getParameter("accion");

        if (accion == null) {
            accion = "";
        }

        System.out.println("accion----" + accion);

        HttpSession session = request.getSession();
        //Obtiene la sesion ya iniciada en ServletControler por el atributo "bUsuario" 
        //y lo castea a tipo "(Usuario)" dentro de la variable "busuario"
        Usuario busuario = (Usuario) session.getAttribute("bUsuario");

        if (busuario == null) {
            request.getRequestDispatcher("jsp/404.jsp").forward(request, response);
        } else {
            switch (busuario.getID_PERFIL()) { // obtiene el ID_PERFIL del usuario logeado
                case 1: // ID_PERFIL = 1 = administrador 
                    if (accion.equalsIgnoreCase("goListar")) { //llamado desde intranet, boton LISTAR
                        request.setAttribute("accion", accion);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/intranet-eleccion.jsp");
                        dispatcher.forward(request, response);
                    } else if (accion.equalsIgnoreCase("goListarAdm")) {
                        UsuarioAdm usuAdm = new UsuarioAdm();
                        ArrayList alUsuarios = usuAdm.getListaUsuarios();
                        request.setAttribute("alUsuarios", alUsuarios);
                        request.setAttribute("accion", accion);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/intranet-listar.jsp");
                        dispatcher.forward(request, response);
                    } else if (accion.equalsIgnoreCase("goListarMedicos")) {
                        UsuarioAdm usuAdm = new UsuarioAdm();
                        ArrayList alMedicos = usuAdm.getListaMedicos();
                        request.setAttribute("listamedico", alMedicos);
                        request.setAttribute("accion", accion);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/intranet-listar.jsp");
                        dispatcher.forward(request, response);
                    } else if (accion.equalsIgnoreCase("goListarPacientes")) {
                        UsuarioAdm usuAdm = new UsuarioAdm();
                        ArrayList alPacientes = usuAdm.getListaPacientes();
                        request.setAttribute("listapaciente", alPacientes);
                        request.setAttribute("accion", accion);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/intranet-listar.jsp");
                        dispatcher.forward(request, response);
                    } else if (accion.equalsIgnoreCase("goRegistrar")) { //llamado desde intranet, boton Insertar
                        request.setAttribute("accion", accion);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/intranet-eleccion.jsp");
                        dispatcher.forward(request, response);
                    } else if (accion.equalsIgnoreCase("goRegistrarAdm")) {
                        UsuarioAdm usuAdm = new UsuarioAdm();
                        ArrayList alUsuarios = usuAdm.getListaUsuarios();
                        request.setAttribute("alUsuarios", alUsuarios);
                        request.setAttribute("accion", accion);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/intranet-insertar.jsp");
                        dispatcher.forward(request, response);
                    } else if (accion.equalsIgnoreCase("goRegistrarMedicos")) {
                        UsuarioAdm usuAdm = new UsuarioAdm();
                        ArrayList alMedicos = usuAdm.getListaMedicos();
                        request.setAttribute("listamedico", alMedicos);
                        request.setAttribute("accion", accion);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/intranet-insertar.jsp");
                        dispatcher.forward(request, response);
                    } else if (accion.equalsIgnoreCase("goRegistrarPacientes")) {
                        UsuarioAdm usuAdm = new UsuarioAdm();
                        ArrayList alPacientes = usuAdm.getListaPacientes();
                        request.setAttribute("listapaciente", alPacientes);
                        request.setAttribute("accion", accion);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/intranet-insertar.jsp");
                        dispatcher.forward(request, response);
                    } 
                    break;
                case 2: // CASO PERSONAL DE ESSALUD
                    if (accion.equalsIgnoreCase("goListar")) { //llamado desde intranet, boton LISTAR
                        request.setAttribute("accion", accion);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/intranet-eleccion.jsp");
                        dispatcher.forward(request, response);
                    } else if (accion.equalsIgnoreCase("goListarMedicos")) {
                        UsuarioAdm usuAdm = new UsuarioAdm();
                        ArrayList alMedicos = usuAdm.getListaMedicos();
                        request.setAttribute("listamedico", alMedicos);
                        request.setAttribute("accion", accion);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/intranet-listar.jsp");
                        dispatcher.forward(request, response);
                    } else if (accion.equalsIgnoreCase("goListarPacientes")) {
                        UsuarioAdm usuAdm = new UsuarioAdm();
                        ArrayList alPacientes = usuAdm.getListaPacientes();
                        request.setAttribute("listapaciente", alPacientes);
                        request.setAttribute("accion", accion);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/intranet-listar.jsp");
                        dispatcher.forward(request, response);
                    } else if (accion.equalsIgnoreCase("goRegistrar")) { //llamado desde intranet, boton Insertar
                        request.setAttribute("accion", accion);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/intranet-eleccion.jsp");
                        dispatcher.forward(request, response);
                    } else if (accion.equalsIgnoreCase("goRegistrarMedicos")) {
                        UsuarioAdm usuAdm = new UsuarioAdm();
                        ArrayList alMedicos = usuAdm.getListaMedicos();
                        request.setAttribute("listamedico", alMedicos);
                        request.setAttribute("accion", accion);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/intranet-insertar.jsp");
                        dispatcher.forward(request, response);
                    } else if (accion.equalsIgnoreCase("goRegistrarPacientes")) {
                        UsuarioAdm usuAdm = new UsuarioAdm();
                        ArrayList alPacientes = usuAdm.getListaPacientes();
                        request.setAttribute("listapaciente", alPacientes);
                        request.setAttribute("accion", accion);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/intranet-insertar.jsp");
                        dispatcher.forward(request, response);
                    }
                    break;
                case 3:
                    break;
                default: //en caso se intente acceder sin haberse logeado
                    response.sendRedirect("jsp/404.jsp");
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
