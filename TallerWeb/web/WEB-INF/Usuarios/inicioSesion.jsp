<%-- 
    Documen/* global request */

t   : inicioSesion
    Created on : Sep 23, 2015, 6:57:16 PM
    Author     : giovani.rondan
--%>

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
    
    <body>
        <div id="pageheader">
            <%--<jsp:include page="Template.jsp" /> hacen lo mismo --%> 
           <%@ include file="\WEB-INF\Template\Template.jsp" %>
        </div>
      
        <div class="container" >
            <div class="alert alert-success">
                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                <strong id="estado" ><%= request.getSession().getAttribute("Login") %></strong> 
                
            </div>
        </div><br>
        <div class="centerbox" >
            <div class="container" >
                <form class="form-horizontal" role="form" >
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
                <form action="registrarcliente"  method="POST">
                    <input  type="submit" name="registrar" value="Registrarse"/>
                </form>  
            </div>
        </div><br>    

       

    </body>
</html>