<%-- 
    Document   : listar
    Author     : Igui
--%>
<%@page import="logica.DataInfoReserva"%>
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
        <div id="infoReserva" >
            <%="infoReserva"%>
            <%
               // DataInfoReserva reserva = (DataInfoReserva) request.getSession().getAttribute("dataInfoReserva");

            %>
            <br>
            id= <%//= reserva.getId()%>
            <br>
            precio= <%//= reserva.getPrecio()%>
            <br>
            estado= <%//= reserva.getEstado()%>
            <br>
            falta servicios y promociones
            
        </div>
    </body>
</html>