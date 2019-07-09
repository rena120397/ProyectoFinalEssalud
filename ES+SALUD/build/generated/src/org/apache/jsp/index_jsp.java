package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_if_test.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write(" \n");
      out.write(" \n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"es\">\n");
      out.write("<head>\n");
      out.write("  <meta charset=\"UTF-8\">\n");
      out.write("  <title>Es+Salud</title>\n");
      out.write("  <meta charset=\"utf-8\">\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("  <link rel=\"stylesheet\" type=\"text/css\" href=\"css/normalize.css\"> \n");
      out.write("  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css\">\n");
      out.write("  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n");
      out.write("  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js\"></script>\n");
      out.write("  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js\"></script>\n");
      out.write("  <link rel=\"icon\" type=\"image/png\" href=\"img/hospital.png\"/>\n");
      out.write("  <link rel=\"stylesheet\" type=\"text/css\" href=\"css/estilo.css\"> \n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<div class=\"jumbotron jumbotron-fluid img-responsive text-center text-white\">\n");
      out.write("                <h1 class=\"font-weight-bold\">ES+SALUD</h1> \n");
      out.write("                <h4>Confiabilidad, Seguridad y rapidez</h4> \n");
      out.write("        </div>\n");
      out.write("  <!-- Nav tabs -->\n");
      out.write("  <div class=\"contenedor d-flex flex-column\">\n");
      out.write("  <ul class=\"nav nav-tabs flex-row-reverse\" role=\"tablist\">\n");
      out.write("    <li class=\"nav-item\">\n");
      out.write("      <a class=\"nav-link font-weight-bold text-gray\" data-toggle=\"tab\" href=\"#nosotros\">Nosotros</a>\n");
      out.write("    </li>\n");
      out.write("    <li class=\"nav-item\">\n");
      out.write("      <a class=\"nav-link font-weight-bold text-gray\" data-toggle=\"tab\" href=\"#intranet\">Intranet</a>\n");
      out.write("    </li>\n");
      out.write("    <li class=\"nav-item\">\n");
      out.write("      <a class=\"nav-link active font-weight-bold text-gray\" data-toggle=\"tab\" href=\"#home\">Afiliados</a>\n");
      out.write("    </li>\n");
      out.write("  </ul>\n");
      out.write("\n");
      out.write("  <!-- Tab panes -->\n");
      out.write("    <div class=\"tab-content navi\">\n");
      out.write("        <div id=\"home\" class=\"container tab-pane active\"><br>\n");
      out.write("            <h2 class=\"text-center\">AFILIADOS</h2>\n");
      out.write("            <form action=\"ServletValidacion\" name=\"miformulario\" method=\"POST\">\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"dni\">Usuario:</label>\n");
      out.write("                    <input type=\"text\"  id=\"dni\" class=\"form-control\" name=\"dni\" maxlength=\"8\" required placeholder=\"Ingrese Documento de Identidad\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"pwd\">Contraseña:</label>\n");
      out.write("                    <input type=\"password\" class=\"form-control\" id=\"pwd\" name=\"password\" required placeholder=\"Ingrese Contraseña\">\n");
      out.write("                </div>\n");
      out.write("                <p class=\"help-block textored font-weight-bold\"> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mensaje}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p><br>\n");
      out.write("                <div class=\"form-group form-check\"d=\"target\">\n");
      out.write("                    <label class=\"form-check-label\">\n");
      out.write("                    <input class=\"form-check-input\" type=\"checkbox\"> Recuerdame\n");
      out.write("                </label>\n");
      out.write("                </div>\n");
      out.write("                <button type=\"submit\" class=\"btn btn-success text-center\" id=\"mostrar\">INGRESAR</button>\n");
      out.write("                <button type=\"reset\" class=\"btn btn-danger text-center\">BORRAR</button>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"intranet\" class=\"container tab-pane fade\"><br>\n");
      out.write("            <h2 class=\"text-center\">INTRANET</h2>\n");
      out.write("            <form method=\"POST\" action=\"Controler\">\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"usuario\">Usuario:</label>\n");
      out.write("                    <input type=\"text\" name=\"usuario\" class=\"form-control\" id=\"usuario\" required placeholder=\"Ingrese Usuario\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"pwd\">Contraseña:</label>\n");
      out.write("                    <input type=\"password\" name=\"contra\" class=\"form-control\" id=\"pwd\" required placeholder=\"Ingrese Contraseña\">\n");
      out.write("                </div>\n");
      out.write("                <p class=\"help-block textored font-weight-bold\"> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mensaje2}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p><br>\n");
      out.write("                <div class=\"form-group form-check\">\n");
      out.write("                    <label class=\"form-check-label\">\n");
      out.write("                    <input class=\"form-check-input\" type=\"checkbox\"> Recuerdame\n");
      out.write("                </label>\n");
      out.write("                </div>\n");
      out.write("                <button type=\"submit\" class=\"btn btn-success text-center\">INGRESAR</button>\n");
      out.write("                <button type=\"reset\" class=\"btn btn-danger text-center\">BORRAR</button>\n");
      out.write("                <br>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"nosotros\" class=\"container tab-pane fade\"><br>\n");
      out.write("            <h3>Objetivo</h3><hr>\n");
      out.write("                <p class='text-justify'>El Seguro Social de Salud, EsSalud, es un organismo público descentralizado, con personería jurídica de derecho público interno, adscrito al Ministerio de Trabajo y Promoción del Empleo.\n");
      out.write("                <p class=\"text-justify\">Tiene por finalidad dar cobertura a los asegurados y sus derechohabientes, a través del otorgamiento de prestaciones de prevención, promoción, recuperación, rehabilitación, prestaciones económicas, y prestaciones sociales que corresponden al régimen contributivo de la Seguridad Social en Salud, así como otros seguros de riesgos humanos.</p>\n");
      out.write("            <h3>Mision</h3><hr>\n");
      out.write("                <p class='text-justify'>“Somos una entidad pública de Seguridad Social de Salud que tiene como fin la protección de la población asegurada brindando prestaciones de salud, económicas y sociales con calidad, integralidad, eficiencia y buen gobierno corporativo, colaborando con el Estado Peruano en alcanzar el Aseguramiento Universal en Salud”.</p>\n");
      out.write("            <h3>Vision</h3><hr>\n");
      out.write("                <p class='text-justify'>“Ser líder en Seguridad Social de Salud en América Latina, superando las expectativas de los asegurados y de los empleadores en la protección de su salud y siendo reconocida por su buen trato, con una gestión moderna y a la vanguardia de la innovación”.</p>\n");
      out.write("            <h3>Ubicacion</h3><hr>\n");
      out.write("                <iframe src=\"https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3904.1167978281546!2d-77.04068688456528!3d-11.89695469156724!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x9105d0f219d02d4b%3A0x9ef1552cf3a7a67!2sEssalud+Cap+III+Paul+Nogier+-+Carabayllo!5e0!3m2!1sen!2spe!4v1526886843444\" width=\"100%\" height=\"400\" frameborder=\"0\" style=\"border:0\" allowfullscreen></iframe>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("  <hr>\n");
      out.write("  <hr>\n");
      out.write(" <!-- Footer -->\n");
      out.write("\t<section id=\"footer\">\n");
      out.write("\t\t<div class=\"container\">\n");
      out.write("\t\t\t<div class=\"row text-center text-xs-center\">\n");
      out.write("\t\t\t\t<div class=\"col-xs-12 col-sm-6 col-md-6\">\n");
      out.write("\t\t\t\t\t<h5>Enlaces Empresariales Internos</h5>\n");
      out.write("\t\t\t\t\t<ul class=\"list-unstyled quick-links\">\n");
      out.write("\t\t\t\t\t\t<li><a href=\"../index.html\"><i class=\"fa fa-angle-double-right\"></i>Inicio</a></li>\n");
      out.write("\t\t\t\t\t\t<li><a href=\"javascript:void();\"><i class=\"fa fa-angle-double-right\"></i>About</a></li>\n");
      out.write("\t\t\t\t\t\t<li><a href=\"javascript:void();\"><i class=\"fa fa-angle-double-right\"></i>FAQ</a></li>\n");
      out.write("\t\t\t\t\t\t<li><a href=\"javascript:void();\"><i class=\"fa fa-angle-double-right\"></i>Videos</a></li>\n");
      out.write("\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<div class=\"col-xs-12 col-sm-6 col-md-6\">\n");
      out.write("\t\t\t\t\t<h5>Enlaces Empresariales Externos</h5>\n");
      out.write("\t\t\t\t\t<ul class=\"list-unstyled quick-links\">\n");
      out.write("\t\t\t\t\t\t<li><a href=\"javascript:void();\"><i class=\"fa fa-angle-double-right\"></i>Inicio</a></li>\n");
      out.write("\t\t\t\t\t\t<li><a href=\"javascript:void();\"><i class=\"fa fa-angle-double-right\"></i>About</a></li>\n");
      out.write("\t\t\t\t\t\t<li><a href=\"javascript:void();\"><i class=\"fa fa-angle-double-right\"></i>FAQ</a></li>\n");
      out.write("\t\t\t\t\t\t<li><a href=\"javascript:void();\"><i class=\"fa fa-angle-double-right\"></i>Videos</a></li>\n");
      out.write("\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"row\">\n");
      out.write("\t\t\t\t<div class=\"col-xs-12 col-sm-12 col-md-12 mt-2 mt-sm-5\">\n");
      out.write("\t\t\t\t\t<ul class=\"list-unstyled list-inline social text-center\">\n");
      out.write("\t\t\t\t\t\t<li class=\"list-inline-item\"><a href=\"https://www.facebook.com/EsSaludPeruOficial/\" target=\"_blank\"><i class=\"fa fa-facebook\"></i></a></li>\n");
      out.write("\t\t\t\t\t\t<li class=\"list-inline-item\"><a href=\"https://twitter.com/essaludperu?lang=es\" target=\"_blank\"><i class=\"fa fa-twitter\"></i></a></li>\n");
      out.write("\t\t\t\t\t\t<li class=\"list-inline-item\"><a href=\"https://www.instagram.com/essaludperu/\" target=\"_blank\"><i class=\"fa fa-instagram\"></i></a></li>\n");
      out.write("\t\t\t\t\t\t<li class=\"list-inline-item\"><a href=\"http://www.essalud.gob.pe/\" target=\"_blank\"><i class=\"fa fa-google-plus\"></i></a></li>\n");
      out.write("\t\t\t\t\t\t<li class=\"list-inline-item\"><a href=\"http://www.essalud.gob.pe/\" target=\"_blank\"><i class=\"fa fa-envelope\"></i></a></li>\n");
      out.write("\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t</hr>\n");
      out.write("\t\t\t</div>\t\n");
      out.write("\t\t\t<div class=\"row\">\n");
      out.write("\t\t\t\t<div class=\"col-xs-12 col-sm-12 col-md-12 mt-2 mt-sm-2 text-center text-white\">\n");
      out.write("\t\t\t\t\t<p>Propiedad de ES+SALUD CARABAYLLO</p>\n");
      out.write("\t\t\t\t\t<p class=\"h6\">&copy All right Reversed. Grupo 5 Curso Integrador</p>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t</hr>\n");
      out.write("\t\t\t</div>\t\n");
      out.write("\t\t</div>\n");
      out.write("\t</section>\n");
      out.write("\t<!-- ./Footer -->\n");
      out.write("   </div> \n");
      out.write("    <div class=\"modal fade\" id=\"mostrarmodal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"basicModal\" aria-hidden=\"true\">\n");
      out.write("      <div class=\"modal-dialog\">\n");
      out.write("        <div class=\"modal-content\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("           <div class=\"modal-header\">\n");
      out.write("                <h3>Atención Afiliados: </h3>\n");
      out.write("                <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</button>     \n");
      out.write("           </div>\n");
      out.write("           <div class=\"modal-body\">\n");
      out.write("               <h5 class=\"\">La contraseña esta conformada por: </h5><hr>  \n");
      out.write("               <h6 class=\"pad\"> 4 primeros digitos de su dni DNI y </h6>\n");
      out.write("               <h6 class=\"pad\"> Su apellido paterno </h6><hr>  \n");
      out.write("               <h5>Ejemplo: <span class=\"font-weight-bold\"> 9837PUSE </span></h5>\n");
      out.write("               </div>\n");
      out.write("           </div>\n");
      out.write("           <div class=\"modal-footer\">\n");
      out.write("          <a href=\"#\" data-dismiss=\"modal\" class=\"btn btn-danger\">Cerrar</a>\n");
      out.write("           </div>\n");
      out.write("      </div>\n");
      out.write("   </div>\n");
      out.write("</div>\n");
      out.write("    <script>\n");
      out.write("\n");
      out.write("    ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("  \n");
      out.write("    </script>\n");
      out.write("    <script src=\"js/general.js\"></script>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${contador==null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write(" \n");
        out.write("    \n");
        out.write("        $(document).ready(function()\n");
        out.write("        {\n");
        out.write("           $(\"#mostrarmodal\").modal(\"show\");\n");
        out.write("        });\n");
        out.write("    ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }
}
