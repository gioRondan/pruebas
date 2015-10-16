

<%@page import="java.util.Comparator"%>
<%@page import="java.util.Collections"%>
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
                            <form action="home">
                                
                                <input id="filtro" type="submit" value="Filtar por :" name="categoria" /><br>
                            </form> 
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
                                    <input type="submit" value="Mas Info" name="Vermasinfo" style="color: black"  /><br>
                                    <input type="text" label="nomServico" id="nombresri" name="nomServicio" value="<%=servcio.getNombre()%>" hidden="true"> 
                                    <input type="text" label="nomProveedor" id="nombrerprv" name="nomProveedor" value="<%=servcio.getProveedor()%>" hidden="true">
                                </form>     
                                    <%="Nombre: "+servcio.getNombre() %>
                                    <%  if ((request.getSession().getAttribute("Login") == "Logeado")){ %> 
                                            
                                            <img src="./media/imagenes/carro.gif" alt="foto3" style="float: right; text-align: center"/> <br>
                                            <form action="verinfoservicio">
                                                <input type="submit" value="Mas Info" name="Vermasinfo" style="color: black"  /><br>
                                                <input type="text" label="nomServico" id="nombresri" name="nomServicio" value="<%=servcio.getNombre()%>" hidden="true"> 
                                                Cantidad: <input class="form-control" type="number" label="Cantidad" id="Cantidad" name="cantItemReserva" placeholder="Introduzca Cantidad"> 
                                                Fecha inicio: <input class="form-control" type="date" label="Cantidad" id="Cantidad2" name="fechainiItemReserva" placeholder="Introduzca Cantidad"> 
                                                Fecha Fin: <input class="form-control" type="date" label="Cantidad" id="Cantidad3" name="fechafinItemReserva" placeholder="Introduzca Cantidad"> 
                                            </form> 
                                           
                                    <% };%>
                                    <%="Precio: " +servcio.getPrecio() %><br>
                                    
                                    <%="Proveedor: "+servcio.getProveedor()%><br>
                                    <%="Descripcion: "+servcio.getDescripcion()%><br>
                                    <%="---------------------------------------------------------"%><br>
                                  		
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
    <script src="./dist/libs/jquery.js"></script>
    <script src="./dist/jstree.min.js"></script>
    <script>
        $(function () { $('#jtree')                            // listen for event
            .on('changed.jstree', function (e, data) {
                var i, j, r = [];
                for(i = 0, j = data.selected.length; i < j; i++) {
        
                  r.push(data.instance.get_node(data.selected[i]).text);
                }
              
                $('#filtro').attr("value",r.join(', ')+', ');
              
              })
            .jstree( <%= request.getAttribute("dataCategorias")  %>
            });
            
        
    </script>
    </body>
</html>
