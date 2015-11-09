<%@page import="java.util.List"%>
<%@page import="servidor.DataServicio"%>
<%@page import="servidor.DataInfoPromocion"%>
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
                <h1>Informacion General de la Promocion</h1>
                <%
                    DataInfoPromocion promo = (DataInfoPromocion) request.getAttribute("dataInfoPromocion");
                    List<DataServicio> servicios = promo.getServicios();
                %>
                <br>
                Nombre: <%= promo.getNombre()  %>
                <br>
                Precio Total: <%= "US$ "+promo.getPrecioTotal()%>
                <br>
                El descuento aplicado fue: <%= promo.getDescuento()+"%"  %>
                <br>
                Proveedor: <a onclick="window.location = 'verinfoproveedor?nomProveedor=<%=servicios.iterator().next().getProveedor()%>'" ><%= servicios.iterator().next().getProveedor() %></a>
                <br> 
                <%  if ((request.getSession().getAttribute("Login") == "Logeado")){ %>
                    <td style="width: 45%">
                       <form action="agregaraacarrito">
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
                                        <td><input type="submit" value="Agregar al carrito" name="agregaraacarrito"/></td>
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
                    <a href="verinfoservicio?nomProveedorServicio=<%=servicios.iterator().next().getProveedor()%>&nomServicio=<%=item.getNombre()%>" ><%=item.getNombre()%></a> 
                        <br/>
                    <%}%>
            </div>
        </div>
    </body>
</html>
