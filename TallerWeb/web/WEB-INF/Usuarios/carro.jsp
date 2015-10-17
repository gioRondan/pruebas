
<%@page import="logica.DataItemReserva"%>
<%@page import="logica.IControladorProveedor"%>
<%@page import="logica.Fabrica"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="logica.DataCategoria"%>
<%@page import="logica.DataPromocion"%>
<%@page import="logica.DataServicio"%>
<%@page import="logica.DataServicio"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="./media/styles/Style.css">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carrito</title>
        <div id="pageheader">
           <%@ include file="\WEB-INF\Template\Template.jsp" %>
        </div>
    </head>
    <body>
        <div class="centerbox" style="text-align:center; margin:auto; width:1200px" >
            <div class="container">
                <h2><img src="./media/imagenes/carro.gif" alt="foto"/>  Carrito </h2><br>
                <table class="table table-striped table-hover carrito">
                    <tr>
                        <td>Nombre</td>
                        <td>Imagen</td>
                        <td>Precio</td>
                        <td>Descripcion</td>
                        <td>Tipo</td>
                        <td>Cantidad</td>
                    </tr>
                    <tr>
                        <td>Vuelo a madrid</td>
                        <td > <img src="./media/imagenes/moody - Euro-Car-1 1.png" alt="foto"/> </td>
                        <td id="precio1"> 200$ </td>
                        <td> Un vuelo con mucha diversion a madrid, con todos los gastos pagos</td>
                        <td> Servicio </td>
                        <td id="cant1"> 2 </td>
                    </tr>
                    <% 
                        List<DataItemReserva> servicios = (List<DataItemReserva>) request.getAttribute("ItemsReservaActual");
                        
                        float p = 0;
                        float auxp;
                        float auxc;
                        if (servicios != null)
                            for(DataItemReserva servicio : servicios){
                    %>                        
                                <tr>
                                    <td> <%= servicio.getNombre() %> </td>
                                    <td > <img src="<%//servicio.getImagen()%>" alt="foto"/> </td>
                                    <td>  <%//=servicio. %>$ </td> 
                                    <td> <%//=servicio.getDescripcion() %> </td>
                                    <td> Servicio </td>
                                    <td id="cant1"> 2 </td>         <% p += 2; // hay q agregar el cant%> 
                                </tr>
                    <% 
                            }; 
                    %> 
                    <tr>
                        <td>Total</td>
                        <td id="total"><%= Float.toString(p)%></td>
                    </tr>
                </table>
                 <button style="margin:calc; width:200px" type="button" class="btn btn-success pull-left">Comprar</button>
            </div>
           
        </div> 
      
    </body>
</html>
