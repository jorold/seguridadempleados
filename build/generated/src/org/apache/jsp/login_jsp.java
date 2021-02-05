package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <link href=\"css/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"css/formgroup.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1 style=\"margin-left: 540px\">Log In Empleados</h1>\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("        <form method=\"post\">\n");
      out.write("            <label for=\"pwd\">Apellido: </label>\n");
      out.write("            <input class=\"form-control\" type=\"text\" name=\"apellido\" required placeholder=\"Apellido\"/>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("            <label for=\"pwd\">Id empleado: </label>\n");
      out.write("            <input class=\"form-control\" type=\"number\" name=\"cajaid\" required placeholder=\"Id empleado\"/>\n");
      out.write("        </div>\n");
      out.write("        <button class=\"btn btn-outline-success\" type=\"submit\" style=\"margin-left: 660px\">Log In</button>\n");
      out.write("        <img style=\"margin-left: 570px\" src=\"images/vigilando.jpg\" alt=\"\"/>\n");
      out.write("        </form>\n");
      out.write("        ");

        String apellido = request.getParameter("apellido");
        String dato = request.getParameter("cajaid");
        if(apellido != null){
            int idempleado = Integer.parseInt(dato);
            boolean acceso = controllerlogin.existeEmpleado(apellido, idempleado);
            if(acceso == true){
                response.sendRedirect("proteccion/usuarioempleado.jsp");
            }else{
                
      out.write("\n");
      out.write("                <h1 style=\"color:red\">Usuario/Password incorrectos</h1>\n");
      out.write("                ");

            }
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
