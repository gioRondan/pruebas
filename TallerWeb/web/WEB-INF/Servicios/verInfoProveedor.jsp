<%-- 
    Document   : verInfoProveedor
    Created on : 27/09/2015, 02:25:38 PM
    Author     : giovani
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="servidor.DataServicio"%>
<%@page import="java.util.List"%>
<%@page import="servidor.DataInfoProveedor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!doctype html>
<html>
    <head>
        <div id="pageheader">
            <%--<jsp:include page="Template.jsp" /> hacen lo mismo --%> 
           <%@ include file="\WEB-INF\Template\Template.jsp" %>
        </div>
        <title>H4Travel</title>
    </head>
    <body>        
        <div class="centerbox" style="text-align:left; margin:auto; width:85% " > 
            <div class="container" >
                <h1>Informacion General de la Proveedor</h1>
                <%
                    DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
                    DataInfoProveedor proveedor = (DataInfoProveedor) request.getSession().getAttribute("dataInfoProveedor");
                   
                %>
                <br>
                 Nickname: <%= proveedor.getNickname() %>
                <br>
                 Nombre: <%= proveedor.getNombre()  %>
                <br>
                 Apellido: <%= proveedor.getApellido()  %>
                <br>
                Email:<a href="mailto:<%=proveedor.getEmail()%>"> <%= proveedor.getEmail() %></a>
                <br> 
                 Fecha de nacimiento: <%=formatoFecha.format(proveedor.getFechaNac().toGregorianCalendar().getTime())%>
                <br>
                
                <h1>Empresa</h1>
                  Nombre:  <%= proveedor.getEmpresa().getNombre() %> <br>
                  Pagina: <a href="<%= proveedor.getEmpresa().getUrl()%>" target="_blank"><%= proveedor.getEmpresa().getUrl()%></a> <br>
                <h1>Servicios </h1>
                    <% 
                       List<DataServicio> servicios = proveedor.getServicios();
                       for(DataServicio item : servicios){
                    %> 
                    <a href="verinfoservicio?nomProveedorServicio=<%=servicios.iterator().next().getProveedor()%>&nomServicio=<%=item.getNombre()%>" ><%=item.getNombre()%></a>
                        
                        <br/>
                    <%}%>
                
            </div>
        </div>
    </body>
</html>
