<%-- 
    Document   : index
    Created on : Oct 10, 2015, 12:40:13 PM
    Author     : Juan
--%>

<%@page import="logica.DataPromocion"%>
<%@page import="logica.DataPromocion"%>
<%@page import="java.util.ArrayList"%>
<%@page import="logica.DataServicio"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <div id="pageheader">
            <%--<jsp:include page="Template.jsp" /> hacen lo mismo --%> 
            <%@ include file="\WEB-INF\Template\Template.jsp" %>
             
        </div>
        <div class="centerbox" style="text-align:center">
            <div class="container">
                <form class="form-horizontal" role="form">
                    <div class="form-group">
                        <div class="col-sm-5">
                            <h3 class="bg-success">Servicos y promociones:</h3><br>
                        </div>
                    </div>
                   
                    <a href="verinfopromocion">Iniciar</a>
                    
                </form>
            </div>
         </div> 
    </body>
</html>
