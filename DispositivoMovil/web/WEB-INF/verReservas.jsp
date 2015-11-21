<%-- 
    Document   : verReservas
    Created on : Nov 18, 2015, 7:57:17 PM
    Author     : diego.roman
--%>

<%@page import="servidor.DataPromocion"%>
<%@page import="servidor.Estado"%>
<%@page import="servidor.DataServicio"%>
<%@page import="java.util.Set"%>
<%@page import="servidor.DataItemReserva"%>
<%@page import="servidor.DataInfoReservaArray"%>
<%@page import="java.util.List"%>
<%@page import="servidor.DataInfoReserva"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="pageheader center">
            <%--<jsp:include page="Template.jsp" /> hacen lo mismo --%> 
            <%@ include file="\WEB-INF\Template\Template.jsp" %>
        </div>
        <div class="centerbox">
            <h1 style="text-align: center;">Reservas del proveedor</h1>
            <div class="container" style="width: 100%;">
                <div class="panel-group">
                    <%
                        DataInfoReservaArray reservas = (DataInfoReservaArray) request.getSession().getAttribute("reservas");
                        List<DataInfoReserva> res = reservas.getItem();
                        int i = 1;
                        for (DataInfoReserva reserva : res) {
                            String est = reserva.getItems().get(0).getEstado().name();
                            String clase = "";
                            if (est.equals("PAGADA")) {
                                clase = "panel-success";
                            } else if (est.equals("REGISTRADA") || est.equals("CANCELADA")) {
                                clase = "panel-danger";
                            } else {
                                clase = "panel-info";
                            }
                    %> 

                    <div class="panel <%=clase%>">
                        <div class="panel-heading">
                            <h4 style="float: left;" class="panel-title">
                                <a aria-expanded="false" class="collapsed" data-toggle="collapse" href="#collapse<%=i%>">Reserva <%=reserva.getId()%></a>
                            </h4>
                            <h4 style="text-align: right;" class="panel-title">
                                <% if (est.equals("PAGADA")) {%>
                                <a onClick="window.location = 'actualizarEstadoReserva?reserva=<%=reserva.getId()%>';" aria-expanded="false" class="collapsed" data-toggle="collapse" href="#">Facturar</a>
                                <%
                                } else if (est.equals("FACTURADA")) {
                                %>
                                <a aria-expanded="false" class="collapsed" data-toggle="collapse" style="text-decoration: none; cursor: default;">Facturada</a>
                                <%
                                } else if (est.equals("CANCELADA")) {
                                %>
                                <a aria-expanded="false" class="collapsed" data-toggle="collapse" style="text-decoration: none; cursor: default;">Cancelada</a>
                                <%
                                    } else {
                                %>
                                <a aria-expanded="false" class="collapsed" data-toggle="collapse" style="text-decoration: none; cursor: default;">Registrada</a>
                                <% } %>
                            </h4>
                        </div>
                        <div style="height: 0px;" aria-expanded="false" id="collapse<%=i%>" class="panel-collapse collapse">
                            <%
                                List<DataItemReserva> items = reserva.getItems();
                                for (DataItemReserva it : items) {

                                    if (it.isEsServico()) {
                                        DataServicio serv = it.getServicio();
                            %>     
                            <div class="panel-body"><%=serv.getNombre()%></div>
                            <%
                            } else {
                                DataPromocion promo = it.getPromocion();
                            %>
                            <div class="panel-body"><%=promo.getNombre()%></div>
                            <%
                                }
                            %>        
                            <%
                                }
                            %>   
                        </div>
                    </div>
                    <% i++;
                        }
                    %>
                </div>
            </div>
        </div>
    </body>
</html>
