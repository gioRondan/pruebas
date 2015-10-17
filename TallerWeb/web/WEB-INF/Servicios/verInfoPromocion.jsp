<%@page import="java.util.Set"%>
<%@page import="logica.DataServicio"%>
<%@page import="logica.DataInfoPromocion"%>
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
                    DataInfoPromocion promo = (DataInfoPromocion) request.getAttribute("dataInfoPromocion");
                    Set<DataServicio> servicios = promo.getServicios();
                %>
                <br>
                Nombre: <%= promo.getNombre()  %>
                <br>
                Precio Total: <%= promo.getPrecioTotal()%>
                <br>
                El descuento aplicado fue: <%= promo.getDescuento()  %>
                <br>
                Proveedor: <%= servicios.iterator().next().getProveedor() %>
                <br> 
                <%  if ((request.getSession().getAttribute("Login") == "Logeado")){ %>
                    <td style="width: 45%">
                       <form action="agregaraacarrito">
<!--                            <input type="text" id="esser" name="esservicio" value="false" hidden="true">-->
                            <input type="text" label="nomPromocion" id="nombresri" name="nomPromocion" value="<%=promo.getNombre()%>" hidden="true">
                            <input type="text" label="nomProveedorPromocion" id="nombrerprv" name="nomProveedorPromocion" value="<%= servicios.iterator().next().getProveedor()%>" hidden="true">
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
                <h1>Servicios incluidos</h1>
                    <% 
                       
                       for(DataServicio item : servicios){
                    %> 
                        <%= item.getNombre() %> 
                        <br/>
                    <%}%>
                
            </div>
        </div>
    </body>
</html>
