<%-- 
    Document   : Template
    Created on : 08-oct-2015, 21:30:01
    Author     : Rodrigo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="./media/styles/Style.css">
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Template</title>
        <style>
            body{
                background-color: #393939;
            }
        </style>
    </head>
    <body>
        
        <nav class="navbar navbar-inverse">
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
                        <form class="navbar-form navbar-left" role="search">
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Promociones y/o servicios">
                            </div>
                            <button type="submit" class="btn btn-default">Buscar</button>
                        </form>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a onClick="window.location = 'vercarrito';">  Carrito</a></li>
                        <li><a onClick="window.location = 'vercarrito';"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                       
                        <li style="height: 50px;"><a onClick="window.location = './WEB-INF/inicioSesion.jsp'" style="padding-top:9px; height: 50px"><img class="img-circle" src="http://www.xn--sueo-iqa.net/wp-content/uploads/2014/06/so%C3%B1ar-con-cachorros-tigres.jpg" alt="Mountain View" label="Usuario" float="right" style="width:35px;height:35px;"> Login</a></li>
                    </ul>
                </div>
            </div>
        </nav>
    </body>
</html>
