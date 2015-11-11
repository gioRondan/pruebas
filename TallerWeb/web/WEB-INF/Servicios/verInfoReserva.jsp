
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
                       List<DataItemReserva> items = reserva.getItems();
                       for(DataItemReserva item : items){
                           if (item.getServicio() != null){
                       %> 
                                <tr> 
                                    <td>
                                        <a href="verinfoservicio?nomProveedorServicio=<%=item.getServicio().getProveedor()%>&nomServicio=<%=item.getServicio().getNombre()%>" ><%=item.getServicio().getNombre()%></a>
                                    </td>
                               Solos     <td><%= item.getCantidad() %></td> 
                                    <td><%//= formatoFecha.format(item.getFechaInicio()) %></td>
                                    <td><%//= formatoFecha.format(item.getFechaFin()) %></td>
                                    <td> Servicio </td> 
                                </tr>
                            <%}else{%> 
                                <tr> 
                                    <td>
                                        <a href="<%="verinfopromocion?nomProveedorPromocion="+item.getPromocion().getNickProveedor()+"&nomPromocion="+item.getPromocion().getNombre()%>" > <%=item.getPromocion().getNombre()%></a>
                                    </td>
                                    <td><%= item.getCantidad() %></td> 
                                    <td><%//= formatoFecha.format(item.getFechaInicio()) %></td>
                                    <td><%//= formatoFecha.format(item.getFechaFin()) %></td>
                                    <td> Promocion </td> 
                                </tr>
                           <%}//CIERRO IF ES SERCICIO%>
                        <%}//CIERRO FOR DE LOS ITEM RESERVA%>
                </table>
            </div>
        </div>   
    </body>
</html>
