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
              $(function() {
                $("#username").change(function() {
// ajax                 
                  
                    $.ajax({
                        type: "POST",
                        url: "existeusuario",
                        data: {username: $("#username").val()}
                    })
                        .done(function(msg) {
                          
                            if (msg.indexOf("nombre usuario invalido") != -1 )
                            {
                               document.getElementById("error").style.visibility = "visible";
                            }else{
                                document.getElementById("error").style.visibility = "hidden";
                            }
                        });
                });
                 $("#email").change(function() {
// ajax                  
                    
                    $.ajax({
                        type: "POST",
                        url: "existeusuario",
                        data: {email: $("#email").val()}
                    })
                        .done(function(msg) {
                            
                            if (msg.indexOf("email invalido") != -1 )
                            {
                               document.getElementById("error2").style.visibility = "visible";
                            }else{
                               document.getElementById("error2").style.visibility = "hidden";
                            }
                        });
                });
               
                    $("#pass2").change(function() {
    // ajax                  
                        $.ajax({
                            type: "POST",
                            url: "existeusuario",
                            data: { 
                                pass: $("#pass").val(),
                                pass2:$("#pass2").val(),                             
                            }
                        })
                            .done(function(msg) {
                                
                                if (msg.indexOf("contaseña invalida") != -1 )
                                {
                                   document.getElementById("error3").style.visibility = "visible";
                                   $("#pass").val(null);
                                   $("#pass2").val(null);
                                }else{
                                   document.getElementById("error3").style.visibility = "hidden";
                                }
                                
                            });
                    });
            
            });
        </script>
    </head>

    <body> 
        <div id="pageheader">
            <%--<jsp:include page="Template.jsp" /> hacen lo mismo --%> 
            <%@ include file="\WEB-INF\Template\Template.jsp" %>
        </div>
        
        <div class="centerbox" style="text-align:center">
            <div class="container">
                <form class="form-horizontal" role="form"  action="registrarcliente"  method="POST">
                    <div class="form-group">
                        <div class="col-sm-5">
                            <span id="error" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 12pt;color: #CC3300; visibility: hidden;">Ya existe usuario</span><br>
                            <span id="error2" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 12pt;color: #CC3300; visibility: hidden;">Ya existe Email</span><br>
                            <span id="error3" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 12pt;color: #CC3300; visibility: hidden;">Las contraseñas no coinciden</span><br>
                            
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <div class="col-sm-5">
                            <h3 class="bg-success">Registrarse</h3><br>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-1" for="username">Nickname:</label>
                        <div class="col-sm-4">
                            <input class="form-control" type="text" id="username" name="nickRegistrar" placeholder="Introduzca su nick" >
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-1" for="email">Email:</label>
                        <div class="col-sm-4">

                            <input class="form-control" id="email" label= "email" type="email" name="emailCliente" placeholder="Introduzca su Email ">
                        </div>
                    </div>
                     <div class="form-group">
                        <label class="control-label col-sm-1" for="nombre"> Nombre:</label>
                        <div class="col-sm-4">
                            <input class="form-control" label= "nombre" type="text"  name="nombreCliente" placeholder="Introduzca su nombre">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-1" for="apellido"> Apellido: </label>
                        <div class="col-sm-4">
                            <input class="form-control" label= "apellido" type="text"  name="apellidoCliente" placeholder="Introduzca su apellido">
                        </div>
                    </div>
                <div class="form-group">
                        <label class="control-label col-sm-1" for="datepicker"> Fecha Nacimiento: </label>
                        <div class="col-sm-4">
                            <input class="form-control" type="date" id="datepicker"  name="fechaCliente" placeholder="dd/mm/yyyy">
                        </div>
                    </div>
                <div class="form-group">
                        <label class="control-label col-sm-1" for="pass"> Password: </label>
                        <div class="col-sm-4">
                            <input class="form-control" id="pass" label= "password" type="password"  name="passRegistrar" placeholder="Introduzca su contraseña">
                        </div>
                    </div>
                <div class="form-group">
                        <label class="control-label col-sm-1" for="pass2"> Verificar Password: </label>
                        <div class="col-sm-4">
                            <input class="form-control" id="pass2" label="verificar password" type="password"  name="passVerificar" placeholder="Confirme la contraseña">
                        </div>
                    </div>
                    
                    <div class="form-group container">        
                        <div class="col-sm-5 jumbotron" >
                            <button type="submit" name="altaCliente" value="altaCliente" class="btn btn-success"><span class="glyphicon glyphicon-log-in"></span> Registrar</button>
                        </div>
                    </div>
                </form>
                
<!--  PARA SUBIR IMAGEN <div class="form-group" >
                        <label class="control-label col-sm-1" for="nick">Imagen: </label>
                        <div class="col-sm-4">
                            <form action="imagenes"  method="post" enctype="multipart/form-data">
                                <input  type="file" name="file" />
                                <br>
                                <input type="submit" name="Subir" value="Subir" />
                            </form>
                        </div>
                    </div>-->
                
            </div>
            
        </div><br>    

      
        
        
        
        
    </body>

</html>