<%-- 
    Document   : registrarCliente
    Created on : 25/09/2015, 11:19:12 AM
    Author     : giovani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>        
        <div id="regCliente" >
            <%="registrarCliente"%>
            <%
                

            %>
            <form action="controller1" method="POST">
                <input type="submit" value="Cerrar Sesion"/>
                <% request.getSession().setAttribute("clave", "cerrarSesion");%>

            </form>
        </div>
    </body>
</html>
