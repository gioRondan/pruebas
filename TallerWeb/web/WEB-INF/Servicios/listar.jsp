

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
        <link rel="stylesheet" type="text/css" href="./media/styles/estilopestanias.css"/>
        <script type="text/javascript" src="./js/cambiarPestanna.js"></script>
        <script type="text/javascript" src="./js/jquery-1.7.2.min.js"></script>
        <div id="pageheader">
            <%--<jsp:include page="Template.jsp" /> hacen lo mismo --%> 
           <%@ include file="\WEB-INF\Template\Template.jsp" %>
        </div>
        <title></title>
    </head>
    <body>
      
       <div class="centerbox" style="text-align:left; margin:auto; width:85% " > 
        <div class="container" >
            <table>
                <tr>
                    <td><h1>Categorias</h1></td>
                    <td><h1 style="text-align: center">Servicos y promociones</h1></td>
                </tr>
                <tr>
                    <td VALIGN="TOP">
                        <div id="jtree">
                            <div id="plugins"></div>
                        </div>
                        <div id="seleccionado" style="color: red ">
                    
                        </div>
                    </td>   
                    <td>
                        <div id="pestanas"  > 
                            <ul id=lista>
                                <li id="pestana1"><a href='javascript:cambiarPestanna(pestanas,pestana1);'>Servicos</a></li>
                                <li id="pestana2"><a href='javascript:cambiarPestanna(pestanas,pestana2);'>Promociones</a></li>
                            </ul>
                        </div>

                        <body onload="javascript:cambiarPestanna(pestanas,pestana1);"\>

                            <div id="contenidopestanas" >
                                <div id="cpestana1" >

                                <% 
                                    List<DataServicio> servicios = (List<DataServicio>)
                                                        request.getAttribute("dataServicos");
                                    for(DataServicio servcio : servicios){
                                %>

                                <form action="verinfoservicio">
                                <%="Tipo: SERVICO"%><input type="submit" value="verInfoServicio" name="Vermasinfo" style="color: black" onclick="<%request.setAttribute("nickProveedor",servcio.getProveedor()); request.setAttribute("nomServicio",servcio.getNombre()); request.setAttribute("verInfoServicio","hola");%>" /><br>
                                <%="Nombre: "+servcio.getNombre() %><%  if ((request.getSession().getAttribute("Login") == "Logeado")){ %> <img src="./media/imagenes/carro.gif" alt="foto3" style="float: right; text-align: center"/> <br><% };%>
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

                                <%="         Tipo: PROMOCION"%> <%  if ((request.getSession().getAttribute("Login") == "Logeado")){ %><img src="./media/imagenes/carro.gif" alt="foto3" style="float: right; text-align: center"/><br> <% };%><br>
                                      Nombre:  <a href="verinfopromocion"><%=promocion.getNombre() %><br></a>
                                                <%="         Precio: " +promocion.getPrecioTotal()  %><br>
                                                <%="         Descuento: "+promocion.getDescuento()%><br>
                                                <%="-------------------------------------------------------------"%><br>

                                <% } %>
                            </div>
                        </div>
                    </td>
                </tr>
            </table>
       </div>
     </div>              
    <link rel="stylesheet" href="./dist/themes/default/style.min.css" />
    <div id="jstree_demo_div"></div>
    <script src="./dist/libs/jquery.js"></script>
    <script src="./dist/jstree.min.js"></script>
    <script>
        $(function () { $('#jtree')                            // listen for event
            .on('changed.jstree', function (e, data) {
                var i, j, r = [];
                for(i = 0, j = data.selected.length; i < j; i++) {
                  r.push(data.instance.get_node(data.selected[i]).text);
                }
                $('#seleccionado').html('Selected: ' + r.join(', '));
              })
            .jstree( <%= request.getAttribute("dataCategorias")  %>
        
        
        
            });
             (function () {
         $("#plugins").jstree({
             "checkbox" : {
                "keep_selected_style" : false
             },
            "plugins" : [ "checkbox" ]
         });
});
        
    </script>
    </body>
</html>
