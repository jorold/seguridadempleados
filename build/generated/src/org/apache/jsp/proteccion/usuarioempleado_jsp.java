package org.apache.jsp.proteccion;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import models.Empleado;

public final class usuarioempleado_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write('\n');
      controllers.ControllerLogin controllerlogin = null;
      synchronized (request) {
        controllerlogin = (controllers.ControllerLogin) _jspx_page_context.getAttribute("controllerlogin", PageContext.REQUEST_SCOPE);
        if (controllerlogin == null){
          controllerlogin = new controllers.ControllerLogin();
          _jspx_page_context.setAttribute("controllerlogin", controllerlogin, PageContext.REQUEST_SCOPE);
        }
      }
      out.write('\n');

    controllerlogin.setSession(session);

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link href=\"../css/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

        Empleado emp = (Empleado)session.getAttribute("EMPLEADO");
        
      out.write("\n");
      out.write("        <h1>Bienvenido usuario</h1>\n");
      out.write("        <h2 style=\"color: blueviolet\">\n");
      out.write("            Perfil: ");
      out.print(emp.getApellido());
      out.write(',');
      out.write(' ');
      out.print(emp.getOficio());
      out.write("\n");
      out.write("        </h2>        \n");
      out.write("        <ul class=\"list-group list-group-horizontal\">\n");
      out.write("            <li class=\"list-group-item\"><a class=\"btn btn-outline-primary\" href=\"../index.html\">Home</a></li>            \n");
      out.write("            <li class=\"list-group-item\"><a class=\"btn btn-outline-primary\" href=\"usuarioempleado.jsp\">Zona empleado</a></li>\n");
      out.write("            <li class=\"list-group-item\"><a class=\"btn btn-outline-primary\" href=\"../webalmacenarempleados.jsp\">Almacenar empleados</a></li>\n");
      out.write("            <li class=\"list-group-item\"><a class=\"btn btn-outline-primary\" href=\"../webmostrarempleadossession.jsp\">Mostrar empleados</a></li>\n");
      out.write("        </ul>\n");
      out.write("        <img src=\"../images/ok2.jpg\" alt=\"\"/>\n");
      out.write("        <a class=\"btn btn-outline-danger\" href=\"usuarioempleado.jsp?cerrar=1\">Cerrar sesión</a>\n");
      out.write("        ");

        String cerrar = request.getParameter("cerrar");
        if(cerrar != null){
            controllerlogin.cerrarSesion();
            response.sendRedirect("../index.html");
        }
        
      out.write("\n");
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
