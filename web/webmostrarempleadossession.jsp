<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controlleremp" class="controllers.ControllerEmpleados" scope="request"/>
<%
  controlleremp.setSession(session);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <%
        String eliminar = request.getParameter("eliminar");
        if (eliminar != null){
            controlleremp.eliminarEmpleadoSession(eliminar);
        }
        %>
        <h1>MOSTRAR SESSION</h1>
        <ul class="list-group list-group-horizontal">
            <li class="list-group-item"><a class="btn btn-outline-primary" href="index.html">Home</a></li>            
            <li class="list-group-item"><a class="btn btn-outline-primary" href="webmostrarempleadossession.jsp">Mostrar empleados</a></li>
            <li class="list-group-item"><a class="btn btn-outline-primary" href="proteccion/usuarioempleado.jsp">Zona empleado</a></li>
            <li class="list-group-item"><a class="btn btn-outline-primary" href="webalmacenarempleados.jsp">Almacenar empleados</a></li>
        </ul>
        <table class="table table-sm">
            <thead>
                <tr>                    
                    <th>Apellido</th>
                    <th>Oficio</th>
                    <th>Salario</th>
                    <th>Dpto</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                    <%=controlleremp.getEmpleadosSession()%>
            </tbody>
        </table>
    </body>
</html>
