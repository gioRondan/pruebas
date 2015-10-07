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
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.10.2.js"></script>
        <script type="text/javascript">
            jQuery(function () {
                jQuery("#username").change(function () {
   // ajax                 
                    console.log(jQuery("#username").val());
                    jQuery.ajax({
                        type: "POST",
                        url: "./ajax/verificarUsuario.jsp",
                        data: {username: jQuery("#username").val()},
                        success: function (data) {
                            if (data == "si")
                                alert("Existe");
                            else
                                alert(data);
                                alert("No existe");
                        }
                    })
                    /*.done(function(String msg) {
                     console.log(msg);
                  
                     if(msg == "SI"){
                     alert("El nombre (" + jQuery("#username").val() + ") ya existe.");
                     }
                     else{
                     alert("gio");
                     }
                     });*/
                });
            });
        </script>
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
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                        <li><a href="#"><img class="img-circle" src="http://www.xn--sueo-iqa.net/wp-content/uploads/2014/06/so%C3%B1ar-con-cachorros-tigres.jpg" alt="Mountain View" label="Usuario" float="right" style="width:35px;height:35px;"> Login</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <div id="regCliente" >
            <%="registrarCliente"%>
            <form action="controller1" method="POST">
                <!--chequear con ajax disponibilidad de nick y email, verificar password, agregarimagen y arreglar fecha-->
                Nickname: 
                <input name="nickRegistrar" label="nick" type="text" name="username" id="username" />
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
                <input type="text" id="datepicker" />
                <br>
                Password: 
                <input name="passRegistrar" label= "password" type="password"  />
                <br>
                Verificar Password: 
                <input name="passVerificar" label= "verificar password" type="password"  />
                <br>
                <input type="submit" name="altaCliente" value="Registrar"/>
                <% //request.getSession().setAttribute("clave", "altaCliente");%>
            </form>
        </div>
    </body>

</html>