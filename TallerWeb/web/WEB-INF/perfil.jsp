<%-- 
    Document   : listar
    Author     : Igui
--%>
<%@page import="logica.DataInfoCliente"%>
<%@page import="javax.websocket.Session"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="/WEB-INF/errorPages/500.jsp" %>
<!doctype html>
<html>
    <head>
        <title>Ses :: H4Travel</title>
    </head>
    <body>        
        <div id="infoPerfil" >
            <%="perfil"%>
            <%
                DataInfoCliente cliente = (DataInfoCliente) request.getSession().getAttribute("dataCliente");

            %>
            <%= cliente.getNickname()%>
            <%= cliente.getPassword()%>
            <form action="controller1" method="POST">
                <input type="submit" value="Cerrar Sesion"/>
                <% request.getSession().setAttribute("clave", "cerrarSesion");%>

            </form>
        </div>
    </body>
</html>