<%-- 
    Documen/* global request */

t   : inicioSesion
    Created on : Sep 23, 2015, 6:57:16 PM
    Author     : giovani.rondan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>h4travel</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		
	</head>
	<body>
              <form action="controller1" method="POST">
                  iniciar sesion:(fuera de servicio momentaneamente)
                  <input name="nick" type="text" />
                  <input name="pass" type="password"  />
                  
                  <%request.getSession().setAttribute("clave", "inicioSesion");%>
                  <input  type="submit" value="Entrar"/>
                 
                  
              </form>
                  <br>
              <form action="controller1"  method="POST">
                  <%request.getSession().setAttribute("clave", "registrarCliente");%>
                  <input  type="submit" value="Registrarse"/>
                   
                  
                          
                  
              </form>    
              <!--<form action="controller2"  method="POST">-->
                  <%//request.getSession().setAttribute("clave", "verInfoProveedor");%>
<!--                  <input  type="submit" value="infoProveedor"/>
                   
                  
                          
                  
              </form>-->
	</body>
</html>