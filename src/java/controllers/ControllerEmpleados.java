package controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import models.Empleado;
import repositories.RepositoryEmpleados;

public class ControllerEmpleados {

    RepositoryEmpleados repo;
    HttpSession session;

    public void setSession(HttpSession session) {
        this.session = session;
    }

    public String almacenarEmpleadosSession(String idempleado) {
        ArrayList<String> sessionempleados;
        //para almacenar primero tenemos que saber si existe la sesion o no
        if (session.getAttribute("EMPLEADOS") == null) {
            //creamos la lista por primera vez
            sessionempleados = new ArrayList<>();
        } else {
            //ya tenemos una lista en la sesión y la recuperamos
            sessionempleados = (ArrayList) session.getAttribute("EMPLEADOS");
        }
        //ya tenemos una lista nueva o recuperada, hay que añadir el empleado
        //para evitar repetidos comprobamos si ya existe
        if (sessionempleados.contains(idempleado) == false) {
            //no existe, lo añadimos
            sessionempleados.add(idempleado);
            //actualizar la sesion
            session.setAttribute("EMPLEADOS", sessionempleados);
            return "Almacenados: " + sessionempleados.size();
        } else {
            return "Empleado ya incluido en session: " + idempleado;
        }
    }

    public String getDatosSession() {
        //necesitamos recuperar la lista de la sesion
        ArrayList<String> sessionempleados = (ArrayList) session.getAttribute("EMPLEADOS");
        //es posible que no exista la sesion
        if (sessionempleados == null) {
            return "<h1 style='color:red'>Session está vacio</h1>";
        } else {
            String html = "<ul>";
            for (String dato : sessionempleados) {
                html += "<li>" + dato + "</li>";
            }
            html += "</ul>";
            return html;
        }
    }

    public void eliminarEmpleadoSession(String idempleado) {
        ArrayList<String> sessionempleados = (ArrayList) session.getAttribute("EMPLEADOS");
        sessionempleados.remove(idempleado);
        //SI NO EXISTEN MAS EMPLEADOS, DEBEMOS ELIMINAR EMPLEADOS
        //DE SESSION
        if (sessionempleados.size() == 0) {
            //ELIMINAMOS SESSION
            session.setAttribute("EMPLEADOS", null);
        } else {
            //ACTUALIZAMOS SESSION
            session.setAttribute("EMPLEADOS", sessionempleados);
        }
    }

    public ControllerEmpleados() {
        this.repo = new RepositoryEmpleados();
    }

    /*
    public String getTablaEmpleados() throws SQLException {
        ArrayList<Empleado> empleados = this.repo.getEmpleados();
        String html = "";
        for (Empleado emp : empleados) {
            html += "<tr>";
            html += "<td>" + emp.getApellido() + "</td>";
            html += "<td>" + emp.getOficio() + "</td>";
            html += "<td>" + emp.getSalario() + "</td>";
            html += "<td>" + emp.getDepartamento() + "</td>";
            html += "<td>";
            html += "<a class=' btn btn-outline-primary' href='webalmacenarempleados.jsp?idempleado=";
            html += emp.getIdEmpleado() + "'>Guardar en Session</a>";
            html += "</td";
            html += "</tr>";
        }
        return html;
    }
     */
    public String getTablaEmpleados() throws SQLException {
        ArrayList<Empleado> empleados = this.repo.getEmpleados();
        ArrayList<String> sessionempleados = (ArrayList) session.getAttribute("EMPLEADOS");
        String html = "";
        for (Empleado emp : empleados) {
            html += "<tr>";
            html += "<td>" + emp.getApellido() + "</td>";
            html += "<td>" + emp.getOficio() + "</td>";
            html += "<td>" + emp.getSalario() + "</td>";
            html += "<td>" + emp.getDepartamento() + "</td>";
            html += "<td>";
            if (sessionempleados == null) {
                html += "<td>";
                html += "<a class=' btn btn-outline-primary' href='webalmacenarempleados.jsp?idempleado=";
                html += emp.getIdEmpleado() + "'>Guardar en Session</a>";
                html += "</td";
            } else if (sessionempleados.contains(String.valueOf(emp.getIdEmpleado())) == false) {
                html += "<td>";
                html += "<a class=' btn btn-outline-primary' href='webalmacenarempleados.jsp?idempleado=";
                html += emp.getIdEmpleado() + "'>Guardar en Session</a>";
                html += "</td";
            } else {
                html += "<img src='images/ok.png' style='width:25px;height:25px;'/>";
            }
            html += "</tr>";
        }
        return html;
    }

    /*public String getEmpleadosSession() throws SQLException {
        ArrayList<String> sessionempleados = (ArrayList) session.getAttribute("EMPLEADOS");
        if (sessionempleados == null) {
            //NO HAY NADA EN LA SESION
            return "<h1 style='color:red'>No hay empleados en Session</h1>";
        } else {
            ArrayList<Empleado> empleados
                    = this.repo.getEmpleadosSession(sessionempleados);
            String html = "<ul>";
            for (Empleado emp : empleados) {
                html += "<li>" + emp.getApellido() + " | ";
                html += "<a href='webmostrarempleadossession.jsp?eliminar=";
                html += emp.getIdEmpleado() + "'>Quitar sesión</a>";
                html += "</li>";
            }
            html += "</ul>";
            return html;
        }
    }*/
    public String getEmpleadosSession() throws SQLException {
        ArrayList<String> sessionempleados = (ArrayList) session.getAttribute("EMPLEADOS");
        if (sessionempleados == null) {
            //NO HAY NADA EN LA SESION
            return "<h1 style='color:red'>No hay empleados en Session</h1>";
        } else {
            ArrayList<Empleado> empleados
                    = this.repo.getEmpleadosSession(sessionempleados);
            String html = "";
            for (Empleado emp : empleados) {
                html += "<tr>";
                html += "<td>" + emp.getApellido() + "</td>";
                html += "<td>" + emp.getOficio() + "</td>";
                html += "<td>" + emp.getSalario() + "</td>";
                html += "<td>" + emp.getDepartamento() + "</td>";
                html += "<td>";
                html += "<a class=' btn btn-outline-danger' href='webmostrarempleadossession.jsp?eliminar=";
                html += emp.getIdEmpleado() + "'>Quitar sesión</a>";
                html += "</td>";
                html += "</tr>";
            }
            return html;
        }
    }
}
