package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class webmostrarempleadossession_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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

      out.write('\n');
      controllers.ControllerEmpleados controlleremp = null;
      synchronized (request) {
        controlleremp = (controllers.ControllerEmpleados) _jspx_page_context.getAttribute("controlleremp", PageContext.REQUEST_SCOPE);
        if (controlleremp == null){
          controlleremp = new controllers.ControllerEmpleados();
          _jspx_page_context.setAttribute("controlleremp", controlleremp, PageContext.REQUEST_SCOPE);
        }
      }
      out.write('\n');

  controlleremp.setSession(session);

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link href=\"css/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

        String eliminar = request.getParameter("eliminar");
        if (eliminar != null){
            controlleremp.eliminarEmpleadoSession(eliminar);
        }
        
      out.write("\n");
      out.write("        <h1>MOSTRAR SESSION</h1>\n");
      out.write("        <ul>\n");
      out.write("            <li><a href=\"index.html\">Home</a></li>\n");
      out.write("            <li><a href=\"webalmacenarempleados.jsp\">Almacenar empleados</a></li>\n");
      out.write("            <li><a href=\"webmostrarempleadossession.jsp\">Mostrar empleados</a></li>\n");
      out.write("            <li><a href=\"proteccion/usuarioempleado.jsp\">Zona empleado</a></li>\n");
      out.write("        </ul>\n");
      out.write("        <table class=\"table table-sm\">\n");
      out.write("            <thead>\n");
      out.write("                <tr>                    \n");
      out.write("                    <th>Apellido</th>\n");
      out.write("                    <th>Oficio</th>\n");
      out.write("                    <th>Salario</th>\n");
      out.write("                    <th>Dpto</th>\n");
      out.write("                    <th></th>\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody>\n");
      out.write("                    ");
      out.print(controlleremp.getEmpleadosSession());
      out.write("\n");
      out.write("            </tbody>\n");
      out.write("        </table>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
}
