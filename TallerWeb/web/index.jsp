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
        <link rel="stylesheet" type="text/css" href="Style.css">
        
        <title>h4travel</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <div class="horizontal">
            <ul>
                <li><a href="#home">Home</a></li>
                <li><a href="#news">Servicios</a></li>
                <li><a href="#contact">Promociones</a></li>
                <li><a href="#about">Proveedores</a></li>
                <li><a href="#about">Reservas</a></li>
                <li><img class="img-circle" src="http://www.xn--sueo-iqa.net/wp-content/uploads/2014/06/so%C3%B1ar-con-cachorros-tigres.jpg" alt="Mountain View" label="Usuario" float="right" style="width:35px;height:35px;"></li>
            </ul>
        </div><br>
        <div class="centerbox" style="text-align:center">
            <form action="controller1" method="POST">
                <img class="img-circle" src="http://www.xn--sueo-iqa.net/wp-content/uploads/2014/06/so%C3%B1ar-con-cachorros-tigres.jpg" alt="Mountain View" style="width:150px;height:150px;">
                <h3>Iniciar sesión:</h3><br>
                <input class="center" name="nick" type="text" /><br><br>
                <input class="center" name="pass" type="password" /><br><br>                  
                <%//request.getSession().setAttribute("clave", "inicioSesion");%>
                <input class="center"  type="submit" name="entrar" value="Entrar"/>              
            </form>
        </div>    
        <br>
        <form action="controller1"  method="POST">
            <%//request.getSession().setAttribute("clave", "registrarCliente");%>
            <input  type="submit" name="registrar" value="Registrarse"/>
        </form>    
        <form action="controller2"  method="POST">
            <%//request.getSession().setAttribute("clave", "verInfoProveedor");%>
            <input  type="submit" name="infoproveedor" value="infoProveedor"/>                 
        </form>
    </body>
</html>