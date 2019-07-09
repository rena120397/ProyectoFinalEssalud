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
public class ServletInsertar extends HttpServlet {

  
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
        //obtiene el valor de accion del frm de "intranet-insertar.jsp
        String accion = request.getParameter("accion");

        if (accion == null) {
            accion = "";
        }
        System.out.println("accion   " + accion);
        //obtiene la sesion ya iniciada
        HttpSession session = request.getSession();
        //Obtiene la sesion ya iniciada en ServletControler por el atributo "bUsuario" 
        //y lo castea a tipo "(Usuario)" dentro de la variable "busuario"
        Usuario busuario = (Usuario) session.getAttribute("bUsuario");

        if (busuario == null) {
            request.getRequestDispatcher("jsp/404.jsp").forward(request, response);
        } else {
            switch (busuario.getID_PERFIL()) {// obtiene el ID_PERFIL del usuario logeado
                case 1:// ID_PERFIL = 1 = administrador 
                    if (accion.equalsIgnoreCase("Insertar")) {//llamado desde intranet-insertar.jsp, boton INSERTAR
                        //instancia nuevo usuario
                        UsuarioAdm usuAdm = new UsuarioAdm();
                        Usuario usu = new Usuario();
                        //Definiendo los valores de objeto usuario con los valores de las cajas de texto del formulario.
                        usu.setID_USU(request.getParameter("TXT_ID_USU"));
                        usu.setNOMBRE(request.getParameter("TXT_NOMBRE"));
                        usu.setCONTRA(request.getParameter("TXT_CONTRA"));
                        usu.setID_PERFIL(Integer.parseInt(request.getParameter("TXT_ID_PERFIL")));
                        //registra usuario en la bd
                        usuAdm.registrarUsuario(usu);
                        //lista usuarios
                        ArrayList alUsuarios = usuAdm.getListaUsuarios();
                        //establece atributo "alUsuarios" para el obejeto instanciado,
                        //para ser llamado en intranet-insertar.jsp
                        request.setAttribute("alUsuarios", alUsuarios);
                        request.setAttribute("accion", accion);
                        //enviar nuevamente a intranet-insertar.jsp
                        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/intranet-insertar.jsp");
                        dispatcher.forward(request, response);
                    } else if (accion.equalsIgnoreCase("InsertarMedico")) {
                        UsuarioAdm usuAdm = new UsuarioAdm();
                        doctor doc = new doctor();
                        doc.setIdoctor(request.getParameter("idmedico"));
                        doc.setNombred(request.getParameter("nombre"));
                        doc.setEspecialidad(request.getParameter("especialidad"));
                        usuAdm.registrarMedico(doc);
                        ArrayList alMedicos = usuAdm.getListaMedicos();
                        request.setAttribute("listamedico", alMedicos);
                        request.setAttribute("accion", accion);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/intranet-insertar.jsp");
                        dispatcher.forward(request, response);
                    } else if (accion.equalsIgnoreCase("InsertarPaciente")) {
                        UsuarioAdm usuAdm = new UsuarioAdm();
                        paciente pac = new paciente();
                        pac.setHI_NREG(request.getParameter("HI_NREG"));                        
                        pac.setHI_NOMBRE(request.getParameter("HI_NOMBRE"));
                        pac.setHI_FECNAC(request.getParameter("HI_FECNAC"));
                        pac.setHI_DIRECC(request.getParameter("HI_DIRECC"));
                        pac.setHI_SEXO(request.getParameter("HI_SEXO"));
                        pac.setHI_FULTAT(request.getParameter("HI_FULTAT"));
                        pac.setHI_NDOCUM(Integer.parseInt(request.getParameter("HI_NDOCUM")));
                        pac.setHI_ESTCIV(request.getParameter("HI_ESTCIV"));
                        pac.setHI_CONTRA(request.getParameter("HI_CONTRA"));
                        pac.setHI_PAD(request.getParameter("HI_PAD"));
 
                        usuAdm.registrarPaciente(pac);
                        ArrayList alPacientes = usuAdm.getListaPacientes();
                        request.setAttribute("listapaciente", alPacientes);
                        request.setAttribute("accion", accion);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/intranet-insertar.jsp");
                        dispatcher.forward(request, response);
                    }
                    break;
                case 2:
                    if (accion.equalsIgnoreCase("InsertarMedico")) {
                        UsuarioAdm usuAdm = new UsuarioAdm();
                        doctor doc = new doctor();
                        doc.setIdoctor(request.getParameter("idmedico"));
                        doc.setNombred(request.getParameter("nombre"));
                        doc.setEspecialidad(request.getParameter("especialidad"));
                        usuAdm.registrarMedico(doc);
                        ArrayList alMedicos = usuAdm.getListaMedicos();
                        request.setAttribute("listamedico", alMedicos);
                        request.setAttribute("accion", accion);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/intranet-insertar.jsp");
                        dispatcher.forward(request, response);
                    } else if (accion.equalsIgnoreCase("InsertarPaciente")) {
                        UsuarioAdm usuAdm = new UsuarioAdm();
                        paciente pac = new paciente();
                        pac.setHI_NREG(request.getParameter("HI_NREG"));                        
                        pac.setHI_NOMBRE(request.getParameter("HI_NOMBRE"));
                        pac.setHI_FECNAC(request.getParameter("HI_FECNAC"));
                        pac.setHI_DIRECC(request.getParameter("HI_DIRECC"));
                        pac.setHI_SEXO(request.getParameter("HI_SEXO"));
                        pac.setHI_FULTAT(request.getParameter("HI_FULTAT"));
                        pac.setHI_NDOCUM(Integer.parseInt(request.getParameter("HI_NDOCUM")));
                        pac.setHI_ESTCIV(request.getParameter("HI_ESTCIV"));
                        pac.setHI_CONTRA(request.getParameter("HI_CONTRA"));
                        pac.setHI_PAD(request.getParameter("HI_PAD"));
 
                        usuAdm.registrarPaciente(pac);
                        ArrayList alPacientes = usuAdm.getListaPacientes();
                        request.setAttribute("listapaciente", alPacientes);
                        request.setAttribute("accion", accion);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/intranet-insertar.jsp");
                        dispatcher.forward(request, response);
                    }
                    break;
                case 3:
                    break;
                default://en caso se intente acceder sin haberse logeado
                    response.sendRedirect("jsp/404.jsp");
            }
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
