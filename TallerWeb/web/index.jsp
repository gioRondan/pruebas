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
        <style>
            .centerbox {
                margin: auto;
                width: 40%;
                border:3px solid #8AC007;
                padding: 10px;
                //background-color: #8AC007;
            }
            .center{
                text-align:center;
                position: center;
            }
            p{
                text-align: center;
                alignment-adjust: center;
            }
            div.horizontal {
                width: 100%;
                height: 30px;
                background-color: #98bf21;
            }
            ul {
                list-style-type: none;
                margin: 0;
                padding: 0;
                overflow: hidden;
            }

            li {
                float: left;
            }

            a {
                display: block;
                width: 60px;
                background-color: #dddddd;
            }
            div.horizontal a:link, div.horizontal a:visited {
                font-weight: bold;
                color: #FFFFFF;
                background-color: #98bf21;
                text-align: center;
                padding: 4px;
                text-decoration: none;
                text-transform: uppercase;
            }
            div.horizontal a {
                display: block;
                width: 120px;
            }
        </style>
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
            </ul>
        </div><br>
        <div class="centerbox" style="text-align:center">
            <form action="controller1" method="POST">
                <p>iniciar sesion:</p><br>
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