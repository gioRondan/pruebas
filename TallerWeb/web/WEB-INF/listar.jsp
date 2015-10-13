

<%@page import="logica.DataCategoria"%>
<%@page import="logica.DataPromocion"%>
<%@page import="logica.DataServicio"%>
<%@page import="logica.DataServicio"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!doctype html>

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
        
        <div class="contenedor" >
            <div class="titulo">Servicos y promociones por Categorias</div>
             <div id="jtree" style="float:left">
   
            </div>
            <div id="seleccionado" style="color: red ">
                    HOla
            </div>
            <div id="pestanas"style="float:right" > 
                <ul id=lista>
                    <li id="pestana1"><a href='javascript:cambiarPestanna(pestanas,pestana1);'>Servicos</a></li>
                    <li id="pestana2"><a href='javascript:cambiarPestanna(pestanas,pestana2);'>Promociones</a></li>
                    <li id="pestana3"><a href='javascript:cambiarPestanna(pestanas,pestana3);'>Categorias</a></li>
                </ul>
            </div>
            
            <body onload="javascript:cambiarPestanna(pestanas,pestana1);">
       
                <div id="contenidopestanas" style="float:right">
                <div id="cpestana1">
                    
                    <% 
                        List<DataServicio> servicios = (List<DataServicio>)
                                            request.getAttribute("dataServicos");
                        for(DataServicio servcio : servicios){
                    %>
                    
                    <form action="verinfoservicio">
                    <%="Tipo: SERVICO"%><input type="submit" value="verInfoServicio" name="Vermasinfo" style="color: black" onclick="<%request.setAttribute("nickProveedor",servcio.getProveedor()); request.setAttribute("nomServicio",servcio.getNombre()); request.setAttribute("verInfoServicio","hola");%>" /><br>
                    <%="Nombre: "+servcio.getNombre() %><img src="carro.gif" alt="foto3"/><br>
                                    <%="Precio: " +servcio.getPrecio() %><br>
                                    <%="Proveedor: "+servcio.getProveedor()%><br>
                                    <%="Descripcion: "+servcio.getDescripcion()%><br>
                                    <%="---------------------------------------------------------"%><br>
                    </form>  		
                    <% } %>
                </div>
                <div id="cpestana2">
                    <% 
                        List<DataPromocion> promociones = (List<DataPromocion>)
                                        request.getAttribute("dataPromociones");
                        for(DataPromocion promocion : promociones){
                    %>
                        
                                    <%="         Tipo: PROMOCION"%><img src="carro.gif" alt="foto3"/><br>
                                    <lk href=""><%="         Nombre: "+promocion.getNombre() %><br></lk>
                                    <%="         Precio: " +promocion.getPrecioTotal()  %><br>
                                    <%="         Descuento: "+promocion.getDescuento()%><br>
                                    <%="-------------------------------------------------------------"%><br>
                        
                    <% } %>
                </div>
               <div id="cpestana3">
                    <%= request.getAttribute("dataCategorias") %>
               
                </div>
            </div>
       </div>
                  
    <!-- in this example the tree is populated from inline HTML -->
    
  
            
                <link rel="stylesheet" href="dist/themes/default/style.min.css" />
                <div id="jstree_demo_div"></div>
                <script src="dist/libs/jquery.js"></script>
                <script src="dist/jstree.min.js"></script>
                <script>$(function () { $('#jtree')                            // listen for event
                                                .on('changed.jstree', function (e, data) {
                                                    var i, j, r = [];
                                                    for(i = 0, j = data.selected.length; i < j; i++) {
                                                      r.push(data.instance.get_node(data.selected[i]).text);
                                                    }
                                                    $('#seleccionado').html('Selected: ' + r.join(', '));
                                                  })
                                                .jstree( <%= request.getAttribute("dataCategorias") %> });</script>
            
       
    </body>
</html>
