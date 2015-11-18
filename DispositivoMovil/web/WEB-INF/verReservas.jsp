<%-- 
    Document   : verReservas
    Created on : Nov 18, 2015, 7:57:17 PM
    Author     : diego.roman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="pageheader center">
            <%--<jsp:include page="Template.jsp" /> hacen lo mismo --%> 
            <%@ include file="\WEB-INF\Template\Template.jsp" %>
        </div>
        <div class="centerbox">
            <h1>Reservas</h1>
            <div class="container">
                <div class="panel-group">
                    <div class="panel panel-success">
                        <div class="panel-heading">
                            <h4 style="float: left;" class="panel-title">
                                <a aria-expanded="false" class="collapsed" data-toggle="collapse" href="#collapse1">Collapsible panel</a>
                            </h4><h4 style="text-align: right;" class="panel-title">
                                <a aria-expanded="false" class="collapsed" data-toggle="collapse" href="#collapse1">Facturar</a>
                            </h4>
                        </div>
                        <div style="height: 0px;" aria-expanded="false" id="collapse1" class="panel-collapse collapse">
                            <div class="panel-body">Panel Body</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
