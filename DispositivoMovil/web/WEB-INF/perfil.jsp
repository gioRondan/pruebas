<%-- 
    Document   : perfil
    Created on : 14/11/2015, 08:42:58 PM
    Author     : giovani
--%>

<%@page import="servidor.DataFecha"%>
<%@page import="servidor.DataInfoProveedor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Perfil Proveedor</title>
    </head>
    <body class="login">
        <%
            DataInfoProveedor cliente = (DataInfoProveedor) request.getSession().getAttribute("dataProveedor");
            DataFecha fecha = (DataFecha) request.getSession().getAttribute("fechaNacimiento");
        %>
        <div id="pageheader center">
            <%--<jsp:include page="Template.jsp" /> hacen lo mismo --%> 
            <%@ include file="\WEB-INF\Template\Template.jsp" %>
        </div>
        <div class="centerbox">    
            <div class="container">    
                <div class="alert alert-success col-xs-12 col-sm-6 col-lg-8 center perfil-center">
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    <strong>Bienvenido <%= cliente.getNombre()%> <%= cliente.getApellido()%> al sistema! </strong>
                </div>
                <div class="col-xs-12 col-sm-6 col-lg-8 center perfil-center">
                    <h1 style="color: #ffffff">Información personal</h1>
                </div>
                <div class="panel panel-success col-xs-12 col-sm-6 col-lg-8 center perfil-center">
                    <div class="panel-heading">Perfil del Usuario</div>
                    <div class="panel-body">
                        <ul class="list-group">
                            <li class="list-group-item">Nickname: <%= cliente.getNickname()%></li>
                            <li class="list-group-item">Email: <%= cliente.getEmail()%></li>
                                <% if (cliente.getNombre() != null) {%>
                            <li class="list-group-item">Nombre: <%= cliente.getNombre()%></li>
                                <%}%>
                                <% if (cliente.getApellido() != null) {%>
                            <li class="list-group-item">Apellido: <%= cliente.getApellido()%></li>
                                <%}%>
                                <% if (cliente.getFechaNac() != null) {%>
                            <li class="list-group-item">Fecha de nacimiento: </li>
                                <%}%>
                        </ul>
                    </div>
                </div>
            </div>
        </div>    
    </body>
</html>
