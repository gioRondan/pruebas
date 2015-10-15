<%-- 
    Document   : carro
    Created on : Oct 14, 2015, 9:50:34 PM
    Author     : Mati
--%>

<%@page import="logica.Fabrica"%>
<%@page import="logica.IControladorProveedor"%>
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
        <link rel="stylesheet" type="text/css" href="./media/styles/stylo.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carrito</title>
         <%@ include file="\WEB-INF\Template\Template.jsp" %>
    </head>
    <body>
		
			<h2 style="margin:auto; width:200px"><img src="./media/imagenes/carro.gif" alt="foto"/>  Carrito </h2>			
			<br/>
                        
        
                        
			
			
                                  
                                    
                                  <div style="margin:auto; width:1200px">
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
                        List<DataServicio> servicios1 = (List<DataServicio>) request.getAttribute("dataServicos");
                        Fabrica fab = Fabrica.getInstance();
                        IControladorProveedor ICP = fab.getIControladorProveedor();
                        List<DataServicio> servicios = ICP.listarServiciosXCategoria("Playa");
                        float p = 0;
                        float auxp;
                        float auxc;
                        if (servicios != null)
                            for(DataServicio servicio : servicios){
                        %>                        
                                        <tr>
						<td> <%= servicio.getNombre() %> </td>
						<td > <img src="<%=servicio.getImagen()%>" alt="foto"/> </td>
                                                <td>  <%=servicio.getPrecio() %>$ </td> 
                                                <td> <%=servicio.getDescripcion() %> </td>
						<td> Servicio </td>
                                                <td id="cant1"> 2 </td>         <% p += servicio.getPrecio() * 2; // hay q agregar el cant%> 
					</tr>
			<% }; %> 
					<tr>
						<td>Total</td>
						<td id="total"><%= Float.toString(p)%></td>
					</tr>
				</table>
			</div>
			
			
		
        <button style="margin:calc; width:200px" type="button" class="btn btn-success pull-left">Comprar</button>
        
        
        
        
        
        
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    </body>
</html>
