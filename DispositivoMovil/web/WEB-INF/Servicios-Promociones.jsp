<%-- 
    Document   : Servicios-Promociones
    Created on : Nov 16, 2015, 7:47:38 PM
    Author     : rodrigo.linares
--%>

<%@page import="servidor.DataPromocion"%>
<%@page import="servidor.DataPromocionArray"%>
<%@page import="servidor.DataServicioArray"%>
<%@page import="servidor.DataServicio"%>
<%@page import="java.util.List"%>
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
            <div class="container" style="width: 100%;">
                <h2 style="text-align: center;">Servicios y Promociones</h2>
                <ul class="nav nav-tabs">
                    <li class="active"><a data-toggle="tab" href="#servicios">Servicios</a></li>
                    <li><a data-toggle="tab" href="#promociones">Promociones</a></li>
                    <li><a data-toggle="tab" href="#servicios-promociones">Servicios y Promociones</a></li>
                </ul>

                <div class="tab-content">
                    <div id="servicios" class="tab-pane in active">
                    <%
                        DataServicioArray servicios = (DataServicioArray) request.getSession().getAttribute("listaServicios");
                        List<DataServicio> serv = servicios.getItem();
                            for(DataServicio servicio : serv){
                    %>    
                        <h3><%=servicio.getNombre() %></h3>
                        <img src="http://www.xn--sueo-iqa.net/wp-content/uploads/2014/06/so%C3%B1ar-con-cachorros-tigres.jpg" />
                        <p><%=servicio.getDescripcion()%></p>
                    
                        <% }                     
                    %>
                    </div>
                    <div id="promociones" class="tab-pane">
                    <%
                        DataPromocionArray promociones = (DataPromocionArray) request.getSession().getAttribute("listaPromociones");
                        List<DataPromocion> prom = promociones.getItem();
                            for(DataPromocion promocion : prom){
                    %>    
                        <h3><%=promocion.getNombre() %></h3>
                        <img src="http://www.xn--sueo-iqa.net/wp-content/uploads/2014/06/so%C3%B1ar-con-cachorros-tigres.jpg" />                    
                        <% }                     
                    %>
                    </div>                    
                </div>
            </div>
        </div>    
    </body>

    <script>
        jQuery('.nav-tabs a').click(function(){
            var id = jQuery(this).attr('href');
            if(id=="#servicios-promociones"){
                jQuery('.tab-pane').css('display', 'block');
            }
            else{
                jQuery('.tab-pane').css('display', 'none');
                jQuery('div'+id).css('display', 'block');
            }
        });        
    </script>
</html>
