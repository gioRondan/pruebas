<%@page import="logica.DataCategoria"%>
<%@page import="java.util.List"%>
<%@page import="logica.DataInfoServicio"%>
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
                <h1>Informacion General de la Servicio</h1>
                <%
                    DataInfoServicio servicio = (DataInfoServicio) request.getAttribute("dataInfoServicio");

                %>
                <br>
                Nombre: <%= servicio.getNombre()  %>
                <br>
                Descripcion: <%= servicio.getDescripcion() %>
                <br>
                Destino: <%= servicio.getDestino().getPais()+", "+servicio.getDestino().getNombre()%> 
                <br>
                Origen: <%= servicio.getOrigen().getPais()+", "+servicio.getOrigen().getNombre()%> 
                <h1>Categorias</h1>
                    <% 
                   
                  
                       List<DataCategoria> categorias = servicio.getCategorias();
                       for(DataCategoria item : categorias){
                           
                    %> 
                        <%= item.getNombre() %> 
                        <br/>
                    <%}%>
                
            </div>
        </div>
    </body>
</html>
