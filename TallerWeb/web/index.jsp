<%-- 
    Document   : inicioSesion
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
            <%String clave = "clave";
            String inicioSesion = "inicioSesion";
            String registrarCliente = "registrarCliente";%>
              <form action="controller1" method="POST">
                  <input name="nick" type="text" />
                  <input name="pass" type="password"  />
                  <%request.getSession().setAttribute(clave, inicioSesion);%>
                  <input  type="submit" value="Entrar"/>
                  
              </form>
                  <br>
              <form action="controller1" method="POST">
                  <%request.getSession().setAttribute(clave, registrarCliente);%>
                  <input type="submit" value="Registrarse"/>
                   
                  
                          
                  
              </form>    
	</body>
</html>