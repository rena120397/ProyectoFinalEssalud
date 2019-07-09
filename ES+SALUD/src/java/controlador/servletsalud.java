package controlador;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.*;
import Procedimientos.icitas;
import Procedimientos.usuariocitas;

public class servletsalud extends HttpServlet {
    icitas ic=new usuariocitas();
    ArrayList listacita = null;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            HttpSession session = request.getSession(true);
            perfil per=(perfil)session.getAttribute("perse");
            
            if(per==null)
            {
                session.invalidate();
                response.sendRedirect("index.jsp");
            }
            else
            {
                String tipo=request.getParameter("eleccion");
                if (tipo == null)
                {tipo="";}
                
                    if(tipo.equalsIgnoreCase("u1"))
                    {
                        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/usuario-perfil.jsp");
                        dispatcher.forward(request, response);
                    }
                    else if(tipo.equalsIgnoreCase("u2"))
                    {
                        int count=ic.valida_replica(per);
                        if(count==0)
                        {
                            listacita = ic.listarcitas();
                            request.setAttribute("listacita", listacita);
                            request.setAttribute("count",count);
                            RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/usuario-citas.jsp");
                            dispatcher.forward(request, response);
                        }
                        else
                        {
                            request.setAttribute("count",count);
                            RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/usuario-citas.jsp");
                            dispatcher.forward(request, response);
                        }
                    }        
                    else if(tipo.equalsIgnoreCase("u3"))
                    {
                        ArrayList listadoctor = ic.listarDoctores();
                        request.setAttribute("listadoctor", listadoctor);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/usuario-doctores.jsp");  
                        dispatcher.forward(request, response);
                    }
                    else if(tipo.equalsIgnoreCase("u4"))
                    {
                        ArrayList listahistorial = ic.listarhistorial(per);
                        request.setAttribute("listahistorial",listahistorial); 
                        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/usuario-historialcitas.jsp");  
                        dispatcher.forward(request, response);
                    }
                    else if(tipo.equalsIgnoreCase("u5"))
                    {
                        session.invalidate();
                        response.sendRedirect("index.jsp");
                    }
                    else
                    {
                        
                        if(per.getVermodal()==true)
                        {
                            ArrayList lista= ic.listamodal(per.getPad().getIdpadecencia().trim());
                            request.setAttribute("lista",lista);
                        }
                        //dona
                        ArrayList listadona = new ArrayList<Double>();
                        listadona.add(ic.enfermedadesprobabilidad("A"));
                        listadona.add(ic.enfermedadesprobabilidad("B"));
                        listadona.add(ic.enfermedadesprobabilidad("C"));
                        listadona.add(ic.enfermedadesprobabilidad("D"));
                        //barra
                        ArrayList listabarra= new ArrayList<Double>();
                        listabarra.add(ic.enfermedadesespecificasprobabilidad("A", 12, 20));
                        listabarra.add(ic.enfermedadesespecificasprobabilidad("B", 12, 20));
                        listabarra.add(ic.enfermedadesespecificasprobabilidad("C", 12, 20));
                        listabarra.add(ic.enfermedadesespecificasprobabilidad("D", 12, 20));
                        
                        listabarra.add(ic.enfermedadesespecificasprobabilidad("A", 21, 30));
                        listabarra.add(ic.enfermedadesespecificasprobabilidad("B", 21, 30));
                        listabarra.add(ic.enfermedadesespecificasprobabilidad("C", 21, 30));
                        listabarra.add(ic.enfermedadesespecificasprobabilidad("D", 21, 30));
                        
                        listabarra.add(ic.enfermedadesespecificasprobabilidad("A", 31, 40));
                        listabarra.add(ic.enfermedadesespecificasprobabilidad("B", 31, 40));
                        listabarra.add(ic.enfermedadesespecificasprobabilidad("C", 31, 40));
                        listabarra.add(ic.enfermedadesespecificasprobabilidad("D", 31, 40));
                        
                        listabarra.add(ic.enfermedadesespecificasprobabilidad("A", 41, 50));
                        listabarra.add(ic.enfermedadesespecificasprobabilidad("B", 41, 50));
                        listabarra.add(ic.enfermedadesespecificasprobabilidad("C", 41, 50));
                        listabarra.add(ic.enfermedadesespecificasprobabilidad("D", 41, 50));
                        
                        listabarra.add(ic.enfermedadesespecificasprobabilidad("A", 51, 60));
                        listabarra.add(ic.enfermedadesespecificasprobabilidad("B", 51, 60));
                        listabarra.add(ic.enfermedadesespecificasprobabilidad("C", 51, 60));
                        listabarra.add(ic.enfermedadesespecificasprobabilidad("D", 51, 60));
                        
                        listabarra.add(ic.enfermedadesespecificasprobabilidad("A", 61, 70));
                        listabarra.add(ic.enfermedadesespecificasprobabilidad("B", 61, 70));
                        listabarra.add(ic.enfermedadesespecificasprobabilidad("C", 61, 70));
                        listabarra.add(ic.enfermedadesespecificasprobabilidad("D", 61, 70));
                        
                        listabarra.add(ic.enfermedadesespecificasprobabilidad("A", 71, 80));
                        listabarra.add(ic.enfermedadesespecificasprobabilidad("B", 71, 80));
                        listabarra.add(ic.enfermedadesespecificasprobabilidad("C", 71, 80));
                        listabarra.add(ic.enfermedadesespecificasprobabilidad("D", 71, 80));
                        
                        listabarra.add(ic.enfermedadesespecificasprobabilidad("A", 81, 90));
                        listabarra.add(ic.enfermedadesespecificasprobabilidad("B", 81, 90));
                        listabarra.add(ic.enfermedadesespecificasprobabilidad("C", 81, 90));
                        listabarra.add(ic.enfermedadesespecificasprobabilidad("D", 81, 90));
                        
                        listabarra.add(ic.enfermedadesespecificasprobabilidad("A", 91, 100));
                        listabarra.add(ic.enfermedadesespecificasprobabilidad("B", 91, 100));
                        listabarra.add(ic.enfermedadesespecificasprobabilidad("C", 91, 100));
                        listabarra.add(ic.enfermedadesespecificasprobabilidad("D", 91, 100));
                        
                        // torta
                        
                        ArrayList<String> listatorta = new ArrayList();
                        ArrayList<String> listatortanombres = new ArrayList();
                        
                        String cod=per.getPad().getIdpadecencia().trim();
                        char[] codarray = cod.toCharArray();
                        
                        if(codarray[0]=='A')
                        {
                            listatorta.add(ic.estadisticaprobabilidadderivada("A01")+" , "+ic.estadisticaprobabilidadderivada("A02"));
                            listatortanombres.add("'Hipertensión esencial (primaria)' , 'Hipertensión secundaria'" );
                        }
                        else if(codarray[0]=='B')
                        {
                            listatorta.add(ic.estadisticaprobabilidadderivada("B01")+" , "+ic.estadisticaprobabilidadderivada("B02")+" , "+ic.estadisticaprobabilidadderivada("B03"));
                            listatortanombres.add("'Asma predominantemente -Alergia' ,'Asma ', 'Asma Mixta'");
                        }
                        else if(codarray[0]=='C')
                        {
                            listatorta.add(ic.estadisticaprobabilidadderivada("C01")+" , "+ic.estadisticaprobabilidadderivada("C02")+" , "+ic.estadisticaprobabilidadderivada("C03"));
                            listatortanombres.add("'Diabetes tipo 2', 'Diabetes tipo 1' , 'PreDiabetes'");
                        }
                        else if(codarray[0]=='D')
                        {
                            listatorta.add(ic.estadisticaprobabilidadderivada("D01")+" , "+ic.estadisticaprobabilidadderivada("D02")+" , "+ic.estadisticaprobabilidadderivada("D03")+" , "+ic.estadisticaprobabilidadderivada("D04"));
                            listatortanombres.add("'Tuberculosis respiratoria', 'Tuberculosis del pulmón' , 'Tuberculosis de ganglios' , 'Tuberculosis de laringe, tráquea y bronquios'");
                        }
                        
                        
                        request.setAttribute("listadona",listadona); 
                        request.setAttribute("listabarra",listabarra);
                        request.setAttribute("listatorta",listatorta);
                        request.setAttribute("listatortanombres",listatortanombres);
                        System.out.println(listatortanombres.get(0));
                        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/usuario.jsp");
                        dispatcher.forward(request, response);
                    }
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
        
        HttpSession session = request.getSession(true);
        perfil per=(perfil)session.getAttribute("perse");
            
        String pc=request.getParameter("procesarcita");
        String rc=request.getParameter("rc");
                
        if (pc == null)
        {pc="";}
        
        if(pc.equalsIgnoreCase("procesarcita"))
        {
            cita ci=new cita();
            ci.setIdprogmedic(rc);
            ci.setNdocum(per.getNdocum());
            ic.procita(ci);
            ic.disminuircupo(rc);
            RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/usuario.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}