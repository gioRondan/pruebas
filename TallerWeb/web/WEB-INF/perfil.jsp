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
         <div id="pageheader">
            <%--<jsp:include page="Template.jsp" /> hacen lo mismo --%> 
            <%@ include file="\WEB-INF\Template\Template.jsp" %>
        </div>
        <div id="infoPerfil" class="">
            <%="perfil"%>
            <%
                DataInfoCliente cliente = (DataInfoCliente) request.getSession().getAttribute("dataCliente");

            %>
            <br>
            nickName= <%= cliente.getNickname()%>
            <br>
            email= <%= cliente.getEmail()%>
            <br>
            nombre= <%= cliente.getNombre()%>
            <br>
            apellido= <%= cliente.getApellido()%>
            <br>
            fecha de nacimiento = (falta hacer)
            <br>
            imagen = (falta hacer)
            <br>
            reservas = (falta hacer, la que selecciona llama a verinforeserva)
            <form action="controller1" method="POST">
                <input type="submit" name="verInfoReserva" value="ver Info Reserva(sin terminar)"/>
                <% 
                   request.getSession().setAttribute("reserva", "datainfo de reservaElegida");
                %>

            </form>
            <br>
            <form action="controller1" method="POST">
                <input type="submit" name="cerrarSesion"value="Cerrar Sesion"/>
                
            </form>
        </div>
    </body>
</html>