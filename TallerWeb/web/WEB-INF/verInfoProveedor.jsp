<%-- 
    Document   : verInfoProveedor
    Created on : 27/09/2015, 02:25:38 PM
    Author     : giovani
--%>

<%@page import="logica.DataInfoProveedor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        verInfoProveedor
        <br>
        <%//DataInfoProveedor proveedor = (DataInfoProveedor) request.getSession().getAttribute("proveedor");%>
        nick: <% //proveedor.getNickname()%>
        nombre: <% //proveedor.getNombre()%>
        apellido: <% //proveedor.getApellido()%>
        email: <%//proveedor.getEmail()%>
        fecha nacimiento: <%//proveedor.getFechaNac()%>
        imagen: <%//proveedor.getImagen()%>
        empresa: <%//proveedor.getEmpresa()%>
        listarservicios
        <form action="controller2" method="POST">
                <input type="submit" name="verInfoServicio" value="ver Info Servicio(sin terminar)"/>
                
            </form>
    </body>
</html>
