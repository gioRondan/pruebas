<%-- 
    Document   : listar
    Author     : Igui
--%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="logica.DataReserva"%>
<%@page import="logica.DataInfoCliente"%>
<%@page import="javax.websocket.Session"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="/WEB-INF/errorPages/500.jsp" %>
<!doctype html>
<html>
    <head>
        <title>H4Travel</title>
    </head>
    <body>       
         <div id="pageheader">
            <%--<jsp:include page="Template.jsp" /> hacen lo mismo --%> 
            <%@ include file="\WEB-INF\Template\Template.jsp" %>
        </div>
        <div class="centerbox" >
        <div class="container">
        <div id="infoPerfil" class="">
            <table>
                <tr>
                    <td>
                        <h1 >Perfil</h1>
                        <%
                            DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
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
                        <% if (cliente.getFechaNac() !=null){%>
                        fecha de nacimiento = <%= formatoFecha.format(cliente.getFechaNac()) %>
                        <%}%>
                        <br>
                    </td>
                    <td>
                        imagen <img src="<%="C:"+cliente.getImagen()%>" alt=""/>
                        <br>
                    </td>
                </tr>
            </table>
            <h1>Reservas</h1>
            <table>
                <tr>
                    <td><strong> Id </strong></td>
                    <td><strong> Fechadecreacion </strong></td>
                    <td><strong> Precio </strong></td>
                    <td><strong> Estado </strong></td>
                </tr>
                <% 
                    List<DataReserva> a = cliente.getReservas();
                    if (a!=null){
                    for(DataReserva c : a){ 
                %> 
                <tr> 
                    <td>
                        <form action="verinforeserva" method="POST">
                            <input type="text" name="nickCliente" value="<%=cliente.getNickname()%>"  hidden="true" />
                            <input type="submit" name="verInfoReserva" value="<%=c.getId()%>"/>
                        </form>
                    </td>
                    <td><%= formatoFecha.format(c.getFechaCreacion()) %></td>
                    <td><%=c.getPrecio() %></td>
                    <td><%= c.getEstado().name() %></td> 
                    
                </tr>
                <%}}%>
            </table>
        </div>
        </div>
         <form action="cierresesion" method="POST">
            <input type="submit" name="cerrarSesion"value="Cerrar Sesion"/>
        </form>
        </div>
        
    </body>
</html>