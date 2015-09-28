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
      
         <script src="//code.jquery.com/jquery-1.10.2.js"></script>
     <script type="text/javascript">
            jQuery(function() {
                jQuery("#username").change(function() {
// ajax                 
console.log(jQuery("#username").val());
                    jQuery.ajax({
                        type: "POST",
                        url: "./ajax.jsp",
                        data: {username: jQuery("#username").val()},
                        success:function(data) {
                            //console.log(data); 
                            alert(data.toString());  
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
                <input type="submit" value="Registrar"/>
                <% //request.getSession().setAttribute("clave", "altaCliente");%>
            </form>
        </div>
    </body>
   
</html>
