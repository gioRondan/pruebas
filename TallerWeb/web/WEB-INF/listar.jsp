

<%@page import="logica.DataPromocion"%>
<%@page import="logica.DataServicio"%>
<%@page import="logica.DataServicio"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>


<%@page import="java.util.Collection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="/WEB-INF/errorPages/500.jsp" %>
<!doctype html>
!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/estilopestanias.css"/>
        <script type="text/javascript" src="js/cambiarPestanna.js"></script>
        <script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
        <div id="pageheader">
            <%--<jsp:include page="Template.jsp" /> hacen lo mismo --%> 
           <%@ include file="/Template.jsp" %>
        </div>
        <title></title>
    </head>
    <body>
        <div class="contenedor">
            <div class="titulo">Servicos y promociones por Categorias</div>
            <div id="pestanas">
                <ul id=lista>
                    <li id="pestana1"><a href='javascript:cambiarPestanna(pestanas,pestana1);'>Servicos</a></li>
                    <li id="pestana2"><a href='javascript:cambiarPestanna(pestanas,pestana2);'>Promociones</a></li>
                </ul>
            </div>
            
            <body onload="javascript:cambiarPestanna(pestanas,pestana1);">
       
            <div id="contenidopestanas">
                <div id="cpestana1">
                    
                    <% 
                        List<DataServicio> servicios = (List<DataServicio>)
                                            request.getAttribute("dataServicos");

                        for(DataServicio servcio : servicios){
                    %>
                        
                            
                                    <%="         Tipo: SERVICO"%><br>
                                    <%="         Nombre: "+servcio.getNombre() %><br>
                                    <%="         Precio: " +servcio.getPrecio() %><br>
                                    <%="         Proveedor: "+servcio.getProveedor()%><br>
                                    <%="         Descripcion: "+servcio.getDescripcion()%><br>
                                    <%="---------------------------------------------------------"%><br>
                        		
                    <% } %>
                </div>
                <div id="cpestana2">
                    <% 
                        List<DataPromocion> promociones = (List<DataPromocion>)
                                        request.getAttribute("dataPromociones");
                        for(DataPromocion promocion : promociones){
                    %>
                        
                                    <%="         Tipo: PROMOCION"%><br>
                                    <%="         Nombre: "+promocion.getNombre() %><br>
                                    <%="         Precio: " +promocion.getPrecioTotal()  %><br>
                                    <%="         Descuento: "+promocion.getDescuento()%><br>
                                    <%="-------------------------------------------------------------"%><br>
                        
                    <% } %>
                </div>

            </div>
        </div>
    </body>
</html>
