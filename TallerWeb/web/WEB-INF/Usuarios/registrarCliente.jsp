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
        <div id="pageheader">
            <%--<jsp:include page="Template.jsp" /> hacen lo mismo --%> 
            <%@ include file="\WEB-INF\Template\Template.jsp" %>
        </div>
        
        <div class="centerbox" style="text-align:center">
            <div class="container">
                <form class="form-horizontal" role="form"  action="registrarcliente"  method="POST">
                    
                    
                    
                    
                    <div class="form-group">
                        <div class="col-sm-5">
                            <h3 class="bg-success">Registrarse</h3><br>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-1" for="nick">Nickname:</label>
                        <div class="col-sm-4">
                            <input class="form-control" type="text" label="nick" id="username" name="nickRegistrar" placeholder="Introduzca su nick">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-1" for="email">Email:</label>
                        <div class="col-sm-4">

                            <input class="form-control" label= "email" type="text" name="emailCliente" placeholder="Introduzca su nick">
                        </div>
                    </div>
                     <div class="form-group">
                        <label class="control-label col-sm-1" for="nombre"> Nombre:</label>
                        <div class="col-sm-4">
                            <input class="form-control" label= "nombre" type="text"  name="nombreCliente" placeholder="Introduzca su nick">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-1" for="apellido"> Apellido: </label>
                        <div class="col-sm-4">
                            <input class="form-control" label= "apellido" type="text"  name="apellidoCliente" placeholder="Introduzca su nick">
                        </div>
                    </div>
                <div class="form-group">
                        <label class="control-label col-sm-1" for="Fecha"> Fecha Nacimiento: </label>
                        <div class="col-sm-4">
                            <input class="form-control" type="text" id="datepicker"  name="fechaCliente" placeholder="Introduzca su nick">
                        </div>
                    </div>
                <div class="form-group">
                        <label class="control-label col-sm-1" for="nick"> Password: </label>
                        <div class="col-sm-4">
                            <input class="form-control" label= "password" type="password"  name="passRegistrar" placeholder="Introduzca su nick">
                        </div>
                    </div>
                <div class="form-group">
                        <label class="control-label col-sm-1" for="nick"> Verificar Password: </label>
                        <div class="col-sm-4">
                            <input class="form-control" label= "verificar password" type="password"  name="passVerificar" placeholder="Introduzca su nick">
                        </div>
                    </div>
                    <div class="form-group container">        
                        <div class="col-sm-5 jumbotron" >
                            <button type="submit" name="altaCliente" value="altaCliente" class="btn btn-success"><span class="glyphicon glyphicon-log-in"></span> Registrar</button>
                        </div>
                    </div>
                </form>
            </div>
            
        </div><br>    

      
        
        
        
        
    </body>

</html>