package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Empleado;

public class FiltroEmpleados implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //necesitamos las peticiones
        HttpServletRequest peticion = (HttpServletRequest) request;
        //necesitamos la uri (string de la peticion)
        String uri = peticion.getRequestURI();
        //necesitamos recuperar el usuario de la sesion, en nuestro caso es un empleado
        Empleado empleado = (Empleado) peticion.getSession().getAttribute("EMPLEADO");
        if (uri.contains("proteccion")) {
            //necesitamos validad es zona protegida
            //si el empleado existe puede navegar
            if (empleado != null) {
                chain.doFilter(request, response);
            } else {
                //no se ha validado todavía
                HttpServletResponse respuesta = (HttpServletResponse) response;
                respuesta.sendRedirect("../login.jsp");
            }
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }

}
