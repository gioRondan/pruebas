<%-- 
    Document   : registrarCliente
    Created on : 25/09/2015, 11:19:12 AM
    Author     : giovani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>        
        <div id="regCliente" >
            <%="registrarCliente"%>
            <form action="controller1" method="POST">
                <!--chequear con ajax disponibilidad de nick y email-->
                <input name="nickRegistrar" type="text" />
                <input name="emailCliente" type="text"  />
                <input name="nombreCliente" type="text"  />
                <input name="apellidoCliente" type="text"  />
                <input name="fechaNacCliente" type="text"  />
                <input name="passRegistrar" type="password"  />
                <input name="passVerificar" type="password"  />
                <input type="submit" value="Registrar"/>
                <% request.getSession().setAttribute("clave", "altaCliente");%>

            </form>
        </div>
    </body>
</html>
