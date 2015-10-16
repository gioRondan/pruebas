<%-- 
    Document   : listar
    Author     : Igui
--%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Set"%>
<%@page import="logica.DataItemReserva"%>
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
        <div id="pageheader">
            <%--<jsp:include page="Template.jsp" /> hacen lo mismo --%> 
           <%@ include file="\WEB-INF\Template\Template.jsp" %>
        </div>
        <title>H4Travel</title>
    </head>
    <body>        
        <div class="centerbox" style="text-align:left; margin:auto; width:85% " > 
            <div class="container" >
                <h1>Informacion General de la Reserva </h1>
                <%
                    DataInfoReserva reserva = (DataInfoReserva) request.getAttribute("dataInfoReserva");

                %>
                <br>
                id= <%= reserva.getId()%>
                <br>
                precio= <%= reserva.getPrecio()%>
                <br>
                estado= <%= reserva.getEstado()%>
                <br>
                <h1>Items</h1>
                <table>
                    <tr>
                        <td><strong> nombre </strong></td>
                        <td><strong> cantidad </strong></td>
                        <td><strong> fechaInicio </strong></td>
                        <td><strong> fechaFin </strong></td>
                        <td><strong> Tipo </strong></td>
                    </tr>
                    <% 
                    DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
                       String servlet ="";
                       String tipo = "";
                       Set<DataItemReserva> items = reserva.getItems();
                       for(DataItemReserva item : items){
                           if (item.getesServico()){
                               tipo ="Servicio";
                               servlet="verinfoservico";
                           }else{
                               tipo="Promocion";
                               servlet="verinfopromocion";
                           }
                    %> 
                    <tr> 
                        <td>
                            <form action="<%=servlet%>" method="POST">
                                <!--Se nesesita el proveedor--> 
                                <input type="text" name="nickCliente" value="<%=item.getNombre()%>"  hidden="true" />
                                <input type="submit" name="<%=servlet%>" value="<%=item.getNombre()%>"/>
                            </form>
                        </td>
                        <td><%= item.getCantidad() %></td> 
                        <td><%= formatoFecha.format(item.getFechaInicio()) %></td>
                        <td><%=formatoFecha.format(item.getFechaFin()) %></td>
                        <td><%= tipo %></td> 

                    </tr>
                    <%}%>
                </table>
            </div>
        </div>
    </body>
</html>