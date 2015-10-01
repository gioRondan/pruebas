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
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        

    </head>
    <body>
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">WebSiteName</a>
                </div>
                <div>
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="#">Home</a></li>
                        <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="#">Page 1-1</a></li>
                                <li><a href="#">Page 1-2</a></li>
                                <li><a href="#">Page 1-3</a></li>
                            </ul>
                        </li>
                        <li><a href="#">Page 2</a></li>
                        <li><a href="#">Page 3</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <!--        <div class="horizontal">
                    <ul>
                        <li><a href="#home">Home <span class="badge">5</span></a></li>
                        <li><a href="#news">Servicios</a></li>
                        <li><a href="#contact">Promociones</a></li>
                        <li><a href="#about">Proveedores</a></li>
                        <li><a href="#about">Reservas</a></li>
                        <li id="image"><img class="img-circle" src="http://www.xn--sueo-iqa.net/wp-content/uploads/2014/06/so%C3%B1ar-con-cachorros-tigres.jpg" alt="Mountain View" label="Usuario" float="right" style="width:35px;height:35px;"></li>
                    </ul>
                </div><br>-->
        <div class="centerbox" style="text-align:center">
            <form action="controller1" method="POST">
                <img class="img-circle" src="http://www.xn--sueo-iqa.net/wp-content/uploads/2014/06/so%C3%B1ar-con-cachorros-tigres.jpg" alt="Mountain View" style="width:150px;height:150px;">
                <h3 class="bg-success">Iniciar sesión:</h3><br>
                <input class="center" name="nick" type="text" /><br><br>
                <input class="center" name="pass" type="password" /><br><br>                  
                <%//request.getSession().setAttribute("clave", "inicioSesion");%>
                <button type="button" class="btn btn-success"><span class="glyphicon glyphicon-log-in"></span> Entrar</button>
                <!--<input class="center"  type="submit" name="entrar" value="Entrar"/>-->              
            </form>
        </div><br>    
        <div class="container">
            <div class="alert alert-success">
                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                <strong>Success!</strong> This alert box could indicate a successful or positive action.
            </div>
        </div><br>
        <div class="container">
            <div class="jumbotron">
                <form action="controller1"  method="POST">
                    <%//request.getSession().setAttribute("clave", "registrarCliente");%>
                    <input  type="submit" name="registrar" value="Registrarse"/>
                </form>    
                <form action="controller2"  method="POST">
                    <%//request.getSession().setAttribute("clave", "verInfoProveedor");%>
                    <input  type="submit" name="infoproveedor" value="infoProveedor"/>                 
                </form>
            </div>    
        </div>

    </body>
</html>