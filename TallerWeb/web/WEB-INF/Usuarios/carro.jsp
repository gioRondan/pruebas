<%-- 
    Document   : carro
    Created on : Oct 14, 2015, 9:50:34 PM
    Author     : Mati
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="/media/styles/stylo.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carrito</title>
         <%@ include file="\WEB-INF\Template\Template.jsp" %>
    </head>
    <body>
		<div class="hero-unit">
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
						<td > <img src="./media/imagenes/carro.gif" alt="foto"/> </td>
						<td id="precio1"> 200$ </td>
                                                <td> Un vuelo con mucha diversion a madrid, con todos los gastos pagos</td>
						<td> Servicio </td>
                                                <td id="cant1"> 2 </td>
					</tr>
			
					<tr>
						<td>Total</td>
						<td id="total">$400</td>
					</tr>
				</table>
			</div>
			
			
			
		</div>
        
        
        
        
        
        
        
        
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    </body>
</html>
