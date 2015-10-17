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
                <% if (servicio.getDestino()!=null){%>
                    Destino: <%= servicio.getDestino().getPais()+", "+servicio.getDestino().getNombre()%> 
                <br>
                <%};%>
                Origen: <%= servicio.getOrigen().getPais()+", "+servicio.getOrigen().getNombre()%> 
                <br>
                Precio: <%= servicio.getPrecio() %>
                <br>
                Proveedor: <%= servicio.getProveedor().getNickname() %>
                <br> 
                <%  if ((request.getSession().getAttribute("Login") == "Logeado")){ %>
                    <td style="width: 45%">
                       <form action="agregaraacarrito">
                            <input type="text" label="nomServicio" id="nombresri" name="nomServicio" value="<%=servicio.getNombre()%>" hidden="true">
                            <input type="text" label="nomProveedor" id="nombrerprv" name="nomProveedor" value="<%=servicio.getProveedor().getNickname() %>" hidden="true">
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
                                        <td><input style="width: 170px; " class="form-control" type="date" label="Fecha inicio:" id="Cantidad5" name="fechainiItemReservaPromo" ></td>
                                    </tr>
                                    <tr>
                                        <th>Fecha Fin: </th>
                                        <td><input style="width: 170px; " class="form-control" type="date" label="Fecha Fin:" id="Cantidad6" name="fechafinItemReservaPromo"></td>
                                    </tr>
                                    <tr>
                                        <th></th>
                                        <td><input type="submit" value="Agregar al carrito" name="agergaracarritopromo"/></td>
                                    </tr>
                                </tbody>
                            </table>
                        </form> 

                    </td>
                <% };%>  
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
