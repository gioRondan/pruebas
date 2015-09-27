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
                <!--chequear con ajax disponibilidad de nick y email, verificar password, agregarimagen y arreglar fecha-->
                Nickname: 
                <input name="nickRegistrar" label= "nick"type="text" />
                <br>
                Email: 
                <input name="emailCliente" label= "email" type="text"  />
                <br>
                Nombre: 
                <input name="nombreCliente" label= "nombre" type="text"  />
                <br>
                Apellido: 
                <input name="apellidoCliente" label= "apellido" type="text"  />
                <br>
                Fecha Nacimiento: 
                <input name="fechaNacCliente" label= "fecha nacimiento" type="text"  />
                <br>
                Password: 
                <input name="passRegistrar" label= "password" type="password"  />
                <br>
                Verificar Password: 
                <input name="passVerificar" label= "verificar password" type="password"  />
                <br>
                <input type="submit" value="Registrar"/>
                <% request.getSession().setAttribute("clave", "altaCliente");%>

            </form>
        </div>
    </body>
</html>
