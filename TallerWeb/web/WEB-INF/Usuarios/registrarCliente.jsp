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
            function autentica(){
                    usuario = document.getElementById("username").value;
                    url = "existeusuario?usuario=" + usuario;
                    leer_doc(url);
                }
                var req;
                if (window.XMLHttpRequest) { 
                    req = new XMLHttpRequest();
                } else if (window.ActiveXObject) {
                    req = new ActiveXObject("Microsoft.XMLHTTP"); 
                }
                if(req){
                    req.onreadystatechange = procesarRespuesta;
                    req.open('GET', url, true);
                    req.send(null);
                }
                function procesarRespuesta(){

                    respuesta = req.responseXML;

                    var existe = respuesta.getElementsByTagName('existe')
                      .item(0).firstChild.data;

                    if (existe=="true")
                      document.getElementById("error").style.visibility = "visible";
                    else
                      document.getElementById("error").style.visibility = "hidden";
                }
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
                    <span id="error" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 12pt;color: #CC3300; position: relative; text-align: center;  visibility: hidden;">Ya existe un usuario con ese nickname por favor elije otro</span>

                    
                    
                    <div class="form-group">
                        <div class="col-sm-5">
                            <h3 class="bg-success">Registrarse</h3><br>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-1" for="nick">Nickname:</label>
                        <div class="col-sm-4">
                            <input class="form-control" type="text" id="username" name="nickRegistrar" onkeypress="return autentica();">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-1" for="email">Email:</label>
                        <div class="col-sm-4">

                            <input class="form-control" label= "email" type="email" name="emailCliente" placeholder="Introduzca su nick">
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
                            <input class="form-control" type="date" id="datepicker"  name="fechaCliente" placeholder="Introduzca su nick">
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