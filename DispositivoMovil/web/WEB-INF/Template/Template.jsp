<%-- 
    Document   : Template
    Created on : 08-oct-2015, 21:30:01
    Author     : Rodrigo
--%>
<%@page import="servidor.DataInfoProveedor"%>
<%@page import="org.apache.catalina.connector.Request"%>
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
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="inicioSesion.jsp">Help4Travelling.com</a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <%
                        if (request.getSession().getAttribute("dataProveedor") != null) {
                    %>
                    <ul class="nav navbar-nav">
                        <li class="active"><a onClick="window.location = 'verServiciosPromociones';" href="#">Servicios/Promociones <span class="sr-only">(current)</span></a></li>
                        <li><a onClick="window.location = 'verReservas';" href="#">Reservas</a></li>
                    </ul>
                    
                    <ul class="nav navbar-nav navbar-right">
                        <li><a onClick="window.location = 'logout';" href="#"><span class="glyphicon glyphicon-log-out"></span> Salir</a></li>
                    </ul>  
                    <%}%>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>
    </body>
</html>
