

<%@page import="servidor.DataProveedor"%>
<%@page import="java.util.Comparator"%>
<%@page import="java.util.Collections"%>
<%@page import="servidor.DataCategoria"%>
<%@page import="servidor.DataPromocion"%>
<%@page import="servidor.DataServicio"%>
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
                            
                        </div>
                        <div id="seleccionado" style="color: red ">
                            <form action="home">
                                <input id="filtro" type="text" value=" " name="categoria" hidden="true"/>
                                <input id="botnfiltro" type="submit" value="Filtrar" name="botonfiltro" /><br>
                            </form>
                            <form action="home">
                                <select name="orden">
                                    <option value="1">Precio asendente</option>
                                    <option value="2">Precio decendente</option>
                                    <option value="3">Nombre</option>
                                    <option value="4">Nombre proveedor</option>
                                    <input id="ord" type="submit" value="Ordenar" name="ordenar" /><br>
                                </select>
                                <input id="filtro2" type="text" value="<%= request.getSession().getAttribute("textodebusqueda")%>" name="textodebusqueda" hidden="true"/>
                                <input id="filtro" type="text" value="<%= request.getSession().getAttribute("categoria")%>" name="categoria" hidden="true"/>
                            </form>
                        </div>
                    </td>   
                    <td>
                        <div id="pestanas"  > 
                            <ul id=lista>
                                <li id="pestana1"><a href='javascript:cambiarPestanna(pestanas,pestana1);'>Servicos</a></li>
                                <li id="pestana2"><a href='javascript:cambiarPestanna(pestanas,pestana2);'>Promociones</a></li>
                                <li id="pestana3"><a href='javascript:cambiarPestanna(pestanas,pestana3);'>Proveedores</a></li>
                            </ul>
                        </div>

                <body onload="javascript:cambiarPestanna(pestanas,pestana1);"></body>
                       
                            <div id="contenidopestanas" >
                                <div id="cpestana1"  >
                                <% 
                                    List<DataServicio> servicios = (List<DataServicio>)
                                                        request.getAttribute("dataServicos");
                                    if (servicios!=null){
                                    for(DataServicio servcio : servicios){
                                %>
                                <table border="1" cellspacing="10"  style="width: 95%">
                                        <thead>
                                            <tr>
                                                <th></th>
                                                <th></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td >
                                                    <%="Nombre: "+servcio.getNombre() %><br>
                                                    <%="Precio: US$ " +servcio.getPrecio() %><br>
                                                    <%="Proveedor: "+servcio.getProveedor()%><br>
                                                    <%="Descripcion: "+servcio.getDescripcion()%><br>
                                                    <form action="verinfoservicio" style="float: left">
                                                        <input type="submit" value="Mas Info" name="Vermasinfo" style="color: black"  /><br>
                                                        <input type="text" label="nomServico" id="nombresri" name="nomServicio" value="<%=servcio.getNombre()%>" hidden="true"> 
                                                        <input type="text" label="nomProveedorServicio" id="nombrerprv" name="nomProveedorServicio" value="<%=servcio.getProveedor()%>" hidden="true">
                                                    </form> 
                                                </td>
                                                <%  if ((request.getSession().getAttribute("Login") == "Logeado")){ %>
                                                <td style="width: 45%">
                                                   <form action="agregaraacarrito">
                                                        <input type="text" label="nomServico" id="nombresri" name="nomServicio" value="<%=servcio.getNombre()%>" hidden="true">
                                                        <input type="text" label="nomProveedor" id="nombrerprv" name="nomProveedorServicio" value="<%=servcio.getProveedor()%>" hidden="true">
                                                        <input type="text" label="Tipo" id="Cantidad4" value="true" name="esservicio" hidden="true">
                                                        <table border="0" cellspacing="1" >
                                                            <thead>
                                                                <tr>
                                                                    <th></th>
                                                                    <th></th>
                                                                </tr>
                                                            </thead>
                                                            <tbody>
                                                                <tr>
                                                                    <th>Cantidad: </th>
                                                                    <td><input style="width: 75px; " min="0" class="form-control" type="number" label="Cantidad" id="Cantidad" name="cantItemReserva" placeholder="Introduzca Cantidad"></td>
                                                                </tr>
                                                                <tr>
                                                                    <th>Fecha inicio: </th>
                                                                    <td><input style="width: 170px; " class="form-control" type="date" label="Fecha inicio:" id="Cantidad2" name="fechainiItemReserva" ></td>
                                                                </tr>
                                                                <tr>
                                                                    <th>Fecha Fin: </th>
                                                                    <td><input style="width: 170px; " class="form-control" type="date" label="Fecha Fin:" id="Cantidad3" name="fechafinItemReserva"></td>
                                                                </tr>
                                                                <tr>
                                                                    <th></th>
                                                                    <td><input type="submit" value="Agregar al carrito" name="agregaracarrito"/></td>
                                                                </tr>
                                                            </tbody>
                                                        </table>
                                                    </form> 
                                                </td>
                                            <% };%>  
                                            </tr><br/>
                                        </tbody>
                                    </table>                               		
                                <% }};//CIERRA FOR SERVICOS %>
                            </div>
                            <div id="cpestana2">
                                
                                  <% 
                                     List<DataPromocion> promociones = (List<DataPromocion>)
                                                    request.getAttribute("dataPromociones");
                                     if (promociones !=null){
                                    for(DataPromocion promocion : promociones){
                                %>
                                <table border="1" cellspacing="10"  style="width: 95%">
                                        <thead>
                                            <tr>
                                                <th></th>
                                                <th></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td >
                                                    <%="Nombre: "+promocion.getNombre() %><br>
                                                    <%="Precio: US$ "+promocion.getPrecioTotal() %><br>
                                                    <%="Proveedor: "+promocion.getNickProveedor() %><br>
                                                   
                                                    <form action="verinfopromocion" style="float: left">
                                                        <input type="submit" value="Mas Info" name="Vermasinfo" style="color: black"  /><br>
                                                        <input type="text" label="nomPromocion" id="nombresri" name="nomPromocion" value="<%=promocion.getNombre()%>" hidden="true"> 
                                                        <input type="text" label="nomProveedorPromocion" id="nombrerprv" name="nomProveedorPromocion" value="<%=promocion.getNickProveedor()%>" hidden="true">
                                                    </form> 
                                                </td>
                                                <%  if ((request.getSession().getAttribute("Login") == "Logeado")){ %>
                                                <td style="width: 45%">
                                                   <form action="agregaraacarrito">
                                                        <input type="text" label="nomPromocion" id="nombresri" name="nomPromocion" value="<%=promocion.getNombre()%>" hidden="true">
                                                        <input type="text" label="nomProveedorPromocion" id="nombrerprv" name="nomProveedorPromocion" value="<%=promocion.getNickProveedor()%>" hidden="true">
                                                        <input type="text" label="Tipo" id="Cantidad4" value="false" name="esservicio" hidden="true">
                                                        <table border="0" cellspacing="1" >
                                                            <thead>
                                                                <tr>
                                                                    <th></th>
                                                                    <th></th>
                                                                </tr>
                                                            </thead>
                                                            <tbody>
                                                                <tr>
                                                                    <th>Cantidad: </th>
                                                                    <td><input style="width: 75px; " min="0" class="form-control" type="number" label="Cantidad" id="Cantidad4" name="cantItemReservaPromo" placeholder="Introduzca Cantidad"></td>
                                                                </tr>
                                                                <tr>
                                                                    <th>Fecha inicio: </th>
                                                                    <td><input style="width: 170px; " class="form-control" type="date" label="Fecha inicio:" id="Cantidad5" name="fechainiItemReserva" ></td>
                                                                </tr>
                                                                <tr>
                                                                    <th>Fecha Fin: </th>
                                                                    <td><input style="width: 170px; " class="form-control" type="date" label="Fecha Fin:" id="Cantidad6" name="fechafinItemReserva"></td>
                                                                </tr>
                                                                <tr>
                                                                    <th></th>
                                                                    <td><input type="submit" value="Agregar al carrito" name="agregarAcarritoPromo"/></td>
                                                                </tr>
                                                            </tbody>
                                                        </table>
                                                    </form> 
                                               
                                                </td>
                                                 <% };%>  
                                            </tr><br/>
                                        </tbody>
                                    </table>                               		
                                <% }};//CIERRA FOR PROMOCIONES %>
                            </div>
                             
                             <div id="cpestana3"  >
                                <% 
                                    List<DataProveedor> proveeedor = (List<DataProveedor>)
                                                        request.getAttribute("dataProveedor");
                                    for(DataProveedor proveedor : proveeedor){
                                %>
                                <table border="1" cellspacing="10"  style="width: 95%">
                                        <thead>
                                            <tr>
                                                <th></th>
                                                <th></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>
                                                    <%="Nickname: "+proveedor.getNickname() %><br>
                                                    <%="Nombre: " +proveedor.getNombre() %><br>
                                                    <%="Apellido: "+proveedor.getApellido() %><br>
                                                    <%="Email: "+proveedor.getEmail() %><br>
                                                    
                                                    <form action="verinfoproveedor" style="float: left">
                                                        <input type="submit" value="Mas Info" name="Vermasinfo" style="color: black"  /><br>
                                                        <input type="text" label="nomProveedor" id="nombrerprv" name="nomProveedor" value="<%=proveedor.getNickname()%>" hidden="true">
                                                    </form> 
                                                </td>
                                            </tr><br/>
                                        </tbody>
                                    </table>                               		
                                <% };//CIERRA FOR PROVEEDOR %>
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
            //.jstree( <%= request.getAttribute("dataCategorias")  %>);
            .jstree( <%= request.getAttribute("dataCategorias")  %>);
        });
            
        
    </script>
    </body>
</html>
