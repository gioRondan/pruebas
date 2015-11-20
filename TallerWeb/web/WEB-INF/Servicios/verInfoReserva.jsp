
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Set"%>
<%@page import="servidor.DataItemReserva"%>
<%@page import="servidor.DataInfoReserva"%>
<%@page import="servidor.DataInfoCliente"%>
<%@page import="javax.websocket.Session"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="/WEB-INF/errorPages/500.jsp" %>
<!doctype html>
<html>
    <head>
        <div id="pageheader">
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
                <strong> Identificador: </strong> <%= reserva.getId()%>
                <br>
                <strong> Precio: </strong> <%= reserva.getPrecio()%>
                <br>
                <strong> Estado: </strong><%= reserva.getEstado()%>
                <br>
                <h1>Items</h1>
                <table border="1">
                    <thead> 
                        <tr>
                            <th><strong> Nombre </strong></th>
                            <th><strong> Cantidad </strong></th>
                            <th><strong> FechaInicio </strong></th>
                            <th><strong> FechaFin </strong></th>
                            <th><strong> Tipo </strong></th>
                        </tr>
                    </thead>
                    <tbody> 
                    <% 
                    DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
                     
                       List<DataItemReserva> items = reserva.getItems();
                       for(DataItemReserva item : items){
                           if (item.getServicio() != null){
                       %> 
                                <tr> 
                                    <td>
                                        <a href="verinfoservicio?nomProveedorServicio=<%=item.getServicio().getProveedor()%>&nomServicio=<%=item.getServicio().getNombre()%>" ><%=item.getServicio().getNombre()%></a>
                                    </td>
                                    <td><%= item.getCantidad() %></td> 
                                    <td><%//= formatoFecha.format(item.getFechaInicio().toGregorianCalendar().getTime()) %></td>
                                    <td><%//= formatoFecha.format(item.getFechaFin().toGregorianCalendar().getTime()) %></td>
                                    <td> Servicio </td> 
                                </tr>
                            <%}else{%> 
                                <tr> 
                                    <td>
                                        <a href="<%="verinfopromocion?nomProveedorPromocion="+item.getPromocion().getNickProveedor()+"&nomPromocion="+item.getPromocion().getNombre()%>" > <%=item.getPromocion().getNombre()%></a>
                                    </td>
                                    <td><%= item.getCantidad() %></td> 
                                    <td><%//= formatoFecha.format(item.getFechaInicio().toGregorianCalendar().getTime()) %></td>
                                    <td><%//= formatoFecha.format(item.getFechaFin().toGregorianCalendar().getTime()) %></td>
                                    <td> Promocion </td> 
                                </tr>
                           <%}//CIERRO IF ES SERCICIO%>
                        <%}//CIERRO FOR DE LOS ITEM RESERVA%>
                    </tbody>
                </table>
            </div>
        </div>   
    </body>
</html>
