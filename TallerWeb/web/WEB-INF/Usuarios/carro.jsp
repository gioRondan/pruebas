
<%@page import="servidor.DataItemReserva"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="servidor.DataCategoria"%>
<%@page import="servidor.DataPromocion"%>
<%@page import="servidor.DataServicio"%>
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
                        
                        <td>Precio</td>
                        <td>Descripcion</td>
                        <td>Tipo</td>
                        <td>Cantidad</td>
                        <td>Boton</td>
                    </tr>
                  
                    <% 
                        List<DataItemReserva> items = (List<DataItemReserva>) request.getSession().getAttribute("ItemsReservaActual");
                        
                        float p = 0;
                       
                        if (items != null){
                            for(DataItemReserva item : items){
                                if (item.isEsServico()){
                    %>        
                                    <tr>
                                        <td><%=item.getServicio().getNombre()%></td>
                                       
                                        <td id="precio1"> <%=item.getServicio().getPrecio() %> </td>
                                        <td> <%=item.getServicio().getDescripcion() %></td>
                                        <td> Servicio </td>
                                        <td id="cant1"> <%=item.getCantidad() %> </td>
                                        <td id="borrar">  
                                            <form action="agregaraacarrito">
                                                <input type="text" name="nomServicio" value="<%=item.getServicio().getNombre()%>" hidden="true"/>
                                                <input type="text" name="nomProveedorServicio" value="<%=item.getServicio().getProveedor() %>" hidden="true"/>
                                                <button type="submit"  name="borrar" style="margin:calc; width:200px" type="button" class="btn btn-danger pull-left">Borrar</button>
                                            </form>    
                                        </td>
                                    </tr>
                                    <% p +=item.getCantidad() * item.getServicio().getPrecio(); %>
                                <%}else{%>
                                    <tr>
                                        <td><%=item.getPromocion().getNombre()%></td>
                                        
                                        <td id="precio1"> <%=item.getPromocion().getPrecioTotal()%> </td>
                                        <td> Sin Descripocion </td>
                                        <td> Promocion </td>
                                        <td id="cant1"> <%=item.getCantidad() %> </td>
                                        <td id="borrar">  
                                            <form action="agregaraacarrito">
                                                <input type="text" name="nomPromocion" value="<%=item.getPromocion().getNombre()%>" hidden="true"/>
                                                <input type="text" name="nomProveedorPromocion" value="<%=item.getPromocion().getNickProveedor() %>" hidden="true"/>
                                                <button type="submit"  name="borrar" style="margin:calc; width:200px" type="button" class="btn btn-danger pull-left">Borrar</button>
                                            </form>    
                                        </td>
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
                 
                
              <form action="generarreserva">
              <button type="submit"  name="comprar" style="margin:calc; width:200px" type="button" class="btn btn-success pull-left">Comprar</button>
              </form>   
                
                
               
            
            
            
            
            
            </div>
           
        </div> 
      
    </body>
</html>
