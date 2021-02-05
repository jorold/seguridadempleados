<%@page import="models.Empleado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <%
        Empleado emp = (Empleado)session.getAttribute("EMPLEADO");
        %>
        <h1>Bienvenido usuario</h1>
        <h2 style="color: blueviolet">
            Perfil: <%=emp.getApellido()%>, <%=emp.getOficio()%>
        </h2>
        <ul class="list-group list-group-horizontal">
            <li class="list-group-item"><a class="btn btn-outline-primary" href="../index.html">Home</a></li>            
            <li class="list-group-item"><a class="btn btn-outline-primary" href="usuarioempleado.jsp">Zona empleado</a></li>
            <li class="list-group-item"><a class="btn btn-outline-primary" href="../webalmacenarempleados.jsp">Almacenar empleados</a></li>
            <li class="list-group-item"><a class="btn btn-outline-primary" href="../webmostrarempleadossession.jsp">Mostrar empleados</a></li>
        </ul>
    </body>
</html>
