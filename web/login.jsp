<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controllerlogin" class="controllers.ControllerLogin" scope="request"/>
<%
controllerlogin.setSession(session);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/formgroup.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Log In Empleados</h1>
        <div class="form-group">
        <form method="post">
            <label for="pwd">Apellido: </label>
            <input class="form-control" type="text" name="apellido" required placeholder="Apellido"/>
        </div>
        <div class="form-group">
            <label for="pwd">Id empleado: </label>
            <input class="form-control" type="number" name="cajaid" required placeholder="Id empleado"/>
        </div>
        <button class="btn btn-outline-success" type="submit" style="margin-left: 660px">Log In</button>
        <img style="margin-left: 570px" src="images/vigilando.jpg" alt=""/>
        </form>
        <%
        String apellido = request.getParameter("apellido");
        String dato = request.getParameter("cajaid");
        if(apellido != null){
            int idempleado = Integer.parseInt(dato);
            boolean acceso = controllerlogin.existeEmpleado(apellido, idempleado);
            if(acceso == true){
                response.sendRedirect("proteccion/usuarioempleado.jsp");
            }else{
                %>
                <h1 style="color:red">Usuario/Password incorrectos</h1>
                <%
            }
        }
        %>
    </body>
</html>
