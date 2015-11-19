<%-- 
    Document   : verReservas
    Created on : Nov 18, 2015, 7:57:17 PM
    Author     : diego.roman
--%>

<%@page import="servidor.DataPromocion"%>
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
            <h1>Reservas del proveedor</h1>
            <div class="container">
                <div class="panel-group">
                    <%
                        DataInfoReservaArray reservas = (DataInfoReservaArray) request.getSession().getAttribute("reservas");
                        List<DataInfoReserva> res = reservas.getItem();
                        for (DataInfoReserva reserva : res) {
                    %> 
                    <div class="panel panel-success">
                        <div class="panel-heading">
                            <h4 style="float: left;" class="panel-title">
                                <a aria-expanded="false" class="collapsed" data-toggle="collapse" href="#collapse1">Reserva <%=reserva.getId()%></a>
                            </h4>
                            <h4 style="text-align: right;" class="panel-title">
                                <a aria-expanded="false" class="collapsed" data-toggle="collapse" href="#">Facturar</a>
                            </h4>
                        </div>
                        <%
                            List<DataItemReserva> items = reserva.getItems();
                            for (DataItemReserva it : items) {
                                if (it.isEsServico()){
                                    DataServicio serv = it.getServicio();
                        %>     
                        <div style="height: 0px;" aria-expanded="false" id="collapse1" class="panel-collapse collapse">
                            <div class="panel-body"><%=serv.getNombre()%></div>
                        </div>
                        <%
                                }
                                else{
                                    DataPromocion promo = it.getPromocion();
                        %>
                        <div style="height: 0px;" aria-expanded="false" id="collapse1" class="panel-collapse collapse">
                            <div class="panel-body"><%=promo.getNombre()%></div>
                        </div>
                        <%
                                }
                        %>        
                        <%        
                            }
                        %>   
                    </div>
                    <% }
                    %>
                </div>
            </div>
        </div>
    </body>
</html>
