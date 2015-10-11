<%-- 
    Documen/* global request */

t   : inicioSesion
    Created on : Sep 23, 2015, 6:57:16 PM
    Author     : giovani.rondan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
        <link rel="stylesheet" type="text/css" href="Style.css">
        <title>h4travel</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script>
            $(function () {

                $('.nav li a').on('click', function (e) {

                    e.preventDefault(); // prevent link click if necessary?

                    var $thisLi = $(this).parent('li');
                    var $ul = $thisLi.parent('ul');

                    if (!$thisLi.hasClass('active'))
                    {
                        $ul.find('li.active').removeClass('active');
                        $thisLi.addClass('active');
                    }

                })

            })
        </script>
        <style>
            body{
                background-color: #393939;
            }
        </style>
    
    <body>
        <div id="pageheader">
            <%--<jsp:include page="Template.jsp" /> hacen lo mismo --%> 
           <%@ include file="/Template.jsp" %>
        </div>
        <!--        <nav class="navbar navbar-inverse">
                    <div class="container-fluid">
                        <div class="navbar-header">
                            <a class="navbar-brand" href="#">Help4Travelling.com</a>
                        </div>
                        <div>
                            <ul class="nav navbar-nav">
                                <li class="active"><a href="#">Home</a></li>
                                <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Servicios / Promociones <span class="caret"></span></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="#">Servicios</a></li>
                                        <li><a href="#">Promociones</a></li>
                                    </ul>
                                </li>
                                <li><a href="#">Proveedores</a></li>  
                                <li><a href="#">Reservas</a></li>
                            </ul>
                            <ul class="nav navbar-nav navbar-right">
                                <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                                <li style="height: 50px;"><a href="#" style="padding-top:9px; height: 50px"><img class="img-circle" src="http://www.xn--sueo-iqa.net/wp-content/uploads/2014/06/so%C3%B1ar-con-cachorros-tigres.jpg" alt="Mountain View" label="Usuario" float="right" style="width:35px;height:35px;"> Login</a></li>
                            </ul>
                        </div>
                    </div>
                </nav>-->
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
        <div class="container">
            <div class="alert alert-success">
                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                <strong>Success!</strong> This alert box could indicate a successful or positive action.
            </div>
        </div><br>
        <div class="centerbox" style="text-align:center">
            <div class="container">
                <form class="form-horizontal" role="form">
                    <div class="form-group">
                        <div class="col-sm-5">
                            <img class="img-circle" src="http://www.xn--sueo-iqa.net/wp-content/uploads/2014/06/so%C3%B1ar-con-cachorros-tigres.jpg" alt="Mountain View" style="width:150px;height:150px;">
                            <h3 class="bg-success">Iniciar sesión:</h3><br>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-1" for="nick">Nick:</label>
                        <div class="col-sm-4">
                            <input class="form-control" id="nick" name="nick"placeholder="Introduzca su nick">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-1" for="pwd">Password:</label>
                        <div class="col-sm-4">          
                            <input type="password" class="form-control" id="pwd" name="pass"placeholder="Introduzca su password">
                        </div>
                    </div>
                    <div class="form-group">        
                        <div class="col-sm-5">
                            <!--<input class="center"  type="submit" name="entrar" value="Entrar"/>--> 
                            <button type="submit" name="entrar" class="btn btn-success"><span class="glyphicon glyphicon-log-in"></span> Entrar</button>
                        </div>
                    </div>
                </form>
            </div>
            <!--            <form action="controller1" method="POST">
                            <img class="img-circle" src="http://www.xn--sueo-iqa.net/wp-content/uploads/2014/06/so%C3%B1ar-con-cachorros-tigres.jpg" alt="Mountain View" style="width:150px;height:150px;">
                            <h3 class="bg-success">Iniciar sesión:</h3><br>
                            <input class="center" name="nick" type="text" /><br><br>
                            <input class="center" name="pass" type="password" /><br><br>                  
            <%//request.getSession().setAttribute("clave", "inicioSesion");%>
            <button type="button" class="btn btn-success"><span class="glyphicon glyphicon-log-in"></span> Entrar</button>
            <input class="center"  type="submit" name="entrar" value="Entrar"/>              
        </form>-->
        </div><br>    

        <div class="container">
            <div class="jumbotron" style="text-align:center">
                <form action="controller1"  method="POST">
                    <%//request.getSession().setAttribute("clave", "registrarCliente");%>
                    <input  type="submit" name="registrar" value="Registrarse"/>
                </form>    
                <form action="controller2"  method="POST">
                    <input  type="submit" name="infoProveedor" value="infoProveedor"/>                 
                </form>
            </div>    
        </div>

    </body>
</html>