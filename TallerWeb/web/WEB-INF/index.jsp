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
              <form action="iniciarSesion" method="POST">
                  <input name="txtnick" type="text" />
                  <input name="txtpass" type="password"  />
                  <input type="submit" value="Entrar"/>
                  <% request.getSession().setAttribute("clave", "inicioSesion");%>
                  
              </form>
	</body>
</html>