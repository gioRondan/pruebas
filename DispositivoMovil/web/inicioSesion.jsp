<%-- 
    Documen/* global request */

t   : inicioSesion
    Created on : Sep 23, 2015, 6:57:16 PM
    Author     : giovani.rondan
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

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
    <style>
        body{
            background-color: #393939;
        }
    </style>

    <body class="login">
        <div id="pageheader">
            <%--<jsp:include page="Template.jsp" /> hacen lo mismo --%> 
            <%@ include file="\WEB-INF\Template\Template.jsp" %>
        </div>
        <div class="container" >
            <div id="prueba" style="display: none;">
                <div class="alert alert-danger">
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    <strong id="estado" ><%= request.getSession().getAttribute("Login")%></strong> 
                </div>
            </div>
        </div><br>
        <script>
            if (jQuery("#estado").text()=== "Datosincorrectos"){
                jQuery("#estado").text("Los datos ingresados no son correctos");
                jQuery("#prueba").css("display", "block");
            }else{
                jQuery("#prueba").css("display", "none");
            }
            </script>
        <div class="centerbox" >
            <div class="container">
                <form class="form-signin" action="login"  method="POST">
                    <img class="img-circle" src="http://www.xn--sueo-iqa.net/wp-content/uploads/2014/06/so%C3%B1ar-con-cachorros-tigres.jpg" alt="Mountain View" style="width:150px;height:150px;">
                    <h2 class="form-signin-heading">Inicio de sesión</h2>
                    <label for="inputEmail" class="sr-only">Correo</label>
                    <input class="form-control" id="nick" name="nick" placeholder="Introduzca su nick" required="" autofocus="">


                    <label for="inputPassword" class="sr-only">Contraseña</label>
                    <input type="password" class="form-control" id="pwd" name="pass" placeholder="Introduzca su password" required="">
                    <div class="checkbox">
                        <label>
                            <input type="checkbox" value="remember-me"> Recordarme
                        </label>
                    </div>
                    <button class="btn btn-lg btn-primary btn-block" type="submit" name="entrar"><span class="glyphicon glyphicon-log-in"></span> Ingresar</button>
                </form>
            </div>
        </div>


        <!--        <div class="centerbox" >
                    <div class="container" >
                        <form class="form-horizontal" role="form" >
                            <div class="form-group">
                                <div class="col-sm-5 col-xs-5">
                                    <div class="col-sm-3 col-xs-3"></div>
                                    <div class="col-sm-6 col-xs-6">
                                        <img class="img-circle" src="http://www.xn--sueo-iqa.net/wp-content/uploads/2014/06/so%C3%B1ar-con-cachorros-tigres.jpg" alt="Mountain View" style="width:150px;height:150px;">
                                        <h3 class="bg-success">Iniciar sesión:</h3><br>
                                    </div>
                                    <div class="col-sm-3 col-xs-3"></div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-1 col-xs-1" for="nick">Nick:</label>
                                <div class="col-sm-4 col-xs-4">
                                    <input class="form-control" id="nick" name="nick"placeholder="Introduzca su nick">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-1" for="pwd">Password:</label>
                                <div class="col-sm-4 col-xs-4">          
                                    <input type="password" class="form-control" id="pwd" name="pass"placeholder="Introduzca su password">
                                </div>
                            </div>
                            <div class="form-group">        
                                <div class="col-sm-5 col-xs-5">
                                    <input class="center"  type="submit" name="entrar" value="Entrar"/> 
                                    <div class="col-sm-3 col-xs-3"></div>
                                    <div class="col-sm-6 col-xs-6">
                                        <button type="submit" name="entrar" class="btn btn-success"><span class="glyphicon glyphicon-log-in"></span> Entrar</button>
                                    </div>    
                                    <div class="col-sm-3 col-xs-3"></div>
                                </div>
                            </div>
                        </form>
                        <form action="registrarcliente"  method="POST">
                            <div class="col-sm-5 col-xs-5">
                                <div class="col-sm-3 col-xs-3"></div>
                                <div class="col-sm-6 col-xs-6">
                                    <input  type="submit" class="btn btn-default" name="registrar" value="Registrarse"/>
                                </div>    
                                <div class="col-sm-3 col-xs-3"></div>
                            </div>
                        </form>  
                    </div>
                </div><br>    
        -->


    </body>
</html>
