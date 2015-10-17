
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
                  
                    <% 
                        List<DataItemReserva> items = (List<DataItemReserva>) request.getSession().getAttribute("ItemsReservaActual");
                        
                        float p = 0;
                       
                        if (items != null){
                            for(DataItemReserva item : items){
                                if (item.getesServico()){
                    %>        
                                    <tr>
                                        <td><%=item.getServicio().getNombre()%></td>
                                        <td > <img src="./media/imagenes/moody - Euro-Car-1 1.png" alt="foto"/> </td>
                                        <td id="precio1"> <%=item.getServicio().getPrecio() %> </td>
                                        <td> <%=item.getServicio().getDescripcion() %></td>
                                        <td> Servicio </td>
                                        <td id="cant1"> <%=item.getCantidad() %> </td>
                                    </tr>
                                    <% p +=item.getCantidad() * item.getServicio().getPrecio(); %>
                                <%}else{%>
                                    <tr>
                                        <td><%=item.getPromocion().getNombre()%></td>
                                        <td > Sin imagen </td>
                                        <td id="precio1"> <%=item.getPromocion().getPrecioTotal()%> </td>
                                        <td> Sin Descripocion </td>
                                        <td> Promocion </td>
                                        <td id="cant1"> <%=item.getCantidad() %> </td>
                                    </tr>
                                    <% p +=item.getCantidad() * item.getPromocion().getPrecioTotal();%>
                                
                    <%          }//CIERRA IF ES SERVICIO
                            }//CIERRA FOR 
                        }//CIERRA IF NULL 
                    %> 
                    <tr>
                        <td>Total</td>
                        <td id="total"><%= p%></td>
                    </tr>
                </table>
                 
                
              <form action="/generarreserva">
              <input type="submit"  name="agregaracarrito" <button style="margin:calc; width:200px" type="button" class="btn btn-success pull-left">Comprar</button> />
              </form>   
                
                
               
            
            
            
            
            
            </div>
           
        </div> 
      
    </body>
</html>
