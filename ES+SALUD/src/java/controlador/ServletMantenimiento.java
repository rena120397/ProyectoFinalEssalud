package controlador;

import modelo.adm.UsuarioAdm;
import modelo.vo.Usuario;
import java.io.IOException;
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
public class ServletMantenimiento extends HttpServlet {

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
        //Obtiene la sesion ya iniciada en ServletControler por el atributo "bUsuario" 
        //y lo castea a tipo "(Usuario)" dentro de la variable "busuario"
        HttpSession session = request.getSession();

        Usuario busuario = (Usuario) session.getAttribute("bUsuario");
        if (busuario != null) {
            //obtiene el valor de accion del intranet.jsp
            String accion = request.getParameter("accion");

            if (accion == null) {
                accion = "";
            }
            System.out.println("accion   " + accion);

            switch (busuario.getID_PERFIL()) {// obtiene el ID_PERFIL del usuario logeado
                case 1:// ID_PERFIL = 1 = administrador 
                    if (accion.equalsIgnoreCase("goMantenimiento")) {//llamado desde intranet.jsp, boton MANTENIMIENTO
                        request.setAttribute("accion", accion);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/intranet-eleccion.jsp");
                        dispatcher.forward(request, response);
                    } else if (accion.equalsIgnoreCase("goMantenimientoAdm")) {
                        //instancia nuevo usuario
                        UsuarioAdm usuAdm = new UsuarioAdm();
                        //lista usuarios
                        ArrayList alUsuarios = usuAdm.getListaUsuarios();
                        //establece atributo "alUsuarios" para el obejeto instanciado,
                        //para ser llamado en intranet-mantenimiento.jsp
                        request.setAttribute("alUsuarios", alUsuarios);
                        request.setAttribute("accion", accion);
                        //Envia a intranet-mantenimiento.jsp
                        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/intranet-mantenimiento.jsp");
                        dispatcher.forward(request, response);
                    } else if (accion.equalsIgnoreCase("goMantenimientoMed")) {
                        UsuarioAdm usuAdm = new UsuarioAdm();
                        ArrayList alMedicos = usuAdm.getListaMedicos();
                        request.setAttribute("listamedico", alMedicos);
                        request.setAttribute("accion", accion);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/intranet-mantenimiento.jsp");
                        dispatcher.forward(request, response);
                    } else if (accion.equalsIgnoreCase("goMantenimientoPac")) {
                        UsuarioAdm usuAdm = new UsuarioAdm();
                        ArrayList alPacientes = usuAdm.getListaPacientes();
                        request.setAttribute("listapaciente", alPacientes);
                        request.setAttribute("accion", accion);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/intranet-mantenimiento.jsp");
                        dispatcher.forward(request, response);
                    } else if (accion.equalsIgnoreCase("EliminarAdm")) {//llamado desde intranet-mantenimiento.jsp, boton ELIMINAR
                        UsuarioAdm usuAdm = new UsuarioAdm();
                        Usuario usu = new Usuario();
                        usu.setID_USU(request.getParameter("TXT_ID_USU"));
                        usuAdm.eliminarUsuario(usu);
                        ArrayList alUsuarios = usuAdm.getListaUsuarios();
                        request.setAttribute("alUsuarios", alUsuarios);
                        request.setAttribute("accion", accion);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/intranet-mantenimiento.jsp");
                        dispatcher.forward(request, response);
                    } else if (accion.equalsIgnoreCase("EliminarMedico")) {//toma el nuevo valor de accion, dado despues de eliminar un usuario
                        UsuarioAdm usuAdm = new UsuarioAdm();
                        doctor doc = new doctor();
                        doc.setIdoctor(request.getParameter("idmedico"));
                        usuAdm.eliminarMedico(doc);
                        ArrayList alMedicos = usuAdm.getListaMedicos();
                        request.setAttribute("listamedico", alMedicos);
                        request.setAttribute("accion", accion);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/intranet-mantenimiento.jsp");
                        dispatcher.forward(request, response);
                    } else if (accion.equalsIgnoreCase("EliminarPaciente")) {

                        UsuarioAdm usuAdm = new UsuarioAdm();
                        paciente p = new paciente();
                        p.setHI_NREG(request.getParameter("HI_NREG"));
                        usuAdm.eliminarPaciente(p);
                        ArrayList alPacientes = usuAdm.getListaPacientes();
                        request.setAttribute("listapaciente", alPacientes);
                        request.setAttribute("accion", accion);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/intranet-mantenimiento.jsp");
                        dispatcher.forward(request, response);
                    }
                    break;
                case 2:
                    if (accion.equalsIgnoreCase("goMantenimiento")) {//llamado desde intranet.jsp, boton MANTENIMIENTO
                        request.setAttribute("accion", accion);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/intranet-eleccion.jsp");
                        dispatcher.forward(request, response);
                    } else if (accion.equalsIgnoreCase("goMantenimientoMed")) {
                        UsuarioAdm usuAdm = new UsuarioAdm();
                        ArrayList alMedicos = usuAdm.getListaMedicos();
                        request.setAttribute("listamedico", alMedicos);
                        request.setAttribute("accion", accion);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/intranet-mantenimiento.jsp");
                        dispatcher.forward(request, response);
                    } else if (accion.equalsIgnoreCase("goMantenimientoPac")) {
                        UsuarioAdm usuAdm = new UsuarioAdm();
                        ArrayList alPacientes = usuAdm.getListaPacientes();
                        request.setAttribute("listapaciente", alPacientes);
                        request.setAttribute("accion", accion);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/intranet-mantenimiento.jsp");
                        dispatcher.forward(request, response);
                    } else if (accion.equalsIgnoreCase("EliminarMedico")) {//toma el nuevo valor de accion, dado despues de eliminar un usuario
                        UsuarioAdm usuAdm = new UsuarioAdm();
                        doctor doc = new doctor();
                        doc.setIdoctor(request.getParameter("idmedico"));
                        usuAdm.eliminarMedico(doc);
                        ArrayList alMedicos = usuAdm.getListaMedicos();
                        request.setAttribute("listamedico", alMedicos);
                        request.setAttribute("accion", accion);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/intranet-mantenimiento.jsp");
                        dispatcher.forward(request, response);
                    } else if (accion.equalsIgnoreCase("EliminarPaciente")) {
                        UsuarioAdm usuAdm = new UsuarioAdm();
                        paciente pac = new paciente();
                        pac.setHI_NREG(request.getParameter("HI_NREG"));
                        System.out.println("EL PACIENTE ES "+pac.getHI_NREG());
                        usuAdm.eliminarPaciente(pac);
                        ArrayList alPacientes = usuAdm.getListaPacientes();
                        request.setAttribute("listapaciente", alPacientes);
                        request.setAttribute("accion", accion);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/intranet-mantenimiento.jsp");
                        dispatcher.forward(request, response);
                    }
                    break;
                case 3:
                    break;
                default://en caso se intente acceder sin haberse logeado
                    RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/mensaje.jsp");
            }
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/mensaje.jsp");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
