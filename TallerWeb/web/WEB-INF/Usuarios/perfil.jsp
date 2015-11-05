<%-- 
    Document   : listar
    Author     : Igui
--%>
<%@page import="wsc.DataReserva"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="wsc.DataInfoCliente"%>
<%@page import="javax.websocket.Session"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
        <link rel="stylesheet" type="text/css" href="./media/styles/estilopestanias.css"/>
        <script type="text/javascript" src="./js/cambiarPestanna.js"></script>
        <script type="text/javascript" src="./js/jquery-1.7.2.min.js"></script>
<%@page errorPage="/WEB-INF/errorPages/500.jsp" %>
<!doctype html>
<html>
    <head>
        <title>H4Travel</title>
    </head>
    <body>       
         <div id="pageheader">
            <%--<jsp:include page="Template.jsp" /> hacen lo mismo --%> 
            <%@ include file="\WEB-INF\Template\Template.jsp" %>
        </div>
        <div class="centerbox" >
        <div class="container">
        <div id="infoPerfil" class="">
               <div id="pestanas"  > 
                    <ul id=lista>
                        <li id="pestana1"><a href='javascript:cambiarPestanna(pestanas,pestana1);'>Info</a></li>
                        <li id="pestana2"><a href='javascript:cambiarPestanna(pestanas,pestana2);'>Reservas</a></li>
                    </ul>
                </div>

                <body onload="javascript:cambiarPestanna(pestanas,pestana1);"\>

                    <div id="contenidopestanas" style="width: 500px" >
                    <div id="cpestana1" >
                        <table>
                            <tr>
                                <td>
                                    <h1 >Perfil</h1>
                                    <%
                                        DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
                                        DataInfoCliente cliente = (DataInfoCliente) request.getSession().getAttribute("dataCliente");
                                    %>
                                    <br>
                                    Nickname: <%= cliente.getNickname()%>
                                    <br>
                                    Email: <%= cliente.getEmail()%>
                                    <br>
                                    <% if (cliente.getNombre() !=null){%>
                                        Nombre: <%= cliente.getNombre()%>
                                    <%}%>
                                    <br>
                                    <% if (cliente.getApellido() !=null){%>
                                        Apellido: <%= cliente.getApellido()%>
                                    <%}%>
                                    <br>
                                    <% if (cliente.getFechaNac() !=null){%>
                                        Fecha de nacimiento: <%= formatoFecha.format(cliente.getFechaNac()) %>
                                    <%}%>
                                    <br>
                                </td>
                                <td>
                                   <% if (cliente.getImagen() !=null){%>
                                        <img src="<%="C:/"+cliente.getImagen()%>" alt=""/>
                                    <br>
                                   <%}%>
                                </td>
                            </tr>
                        </table>
                    </div>
                    <div id="cpestana2">
                        <h1>Reservas</h1>
                        <table border="1">
                            <thead>
                                <tr>
                                    <th> Id </th>
                                    <th> Fechadecreacion </th>
                                    <th> Precio </th>
                                    <th> Estado </th>
                                </tr>
                            </thead>
                            <tbody>
                                <% 
                                  
                                List<DataReserva> a = (List<DataReserva>) request.getSession().getAttribute("dataClienteres");
                                if (a!=null){
                                    for(DataReserva c : a){ 
                                %> 
                                    <tr> 
                                        <td>
                                            <a href="<%="verinforeserva?nickCliente="+cliente.getNickname()+"&verInfoReserva="+c.getIdentificador()%> "><%=c.getIdentificador()%></a>
                                        </td>
                                        <td><%= formatoFecha.format(c.getFechaCreacion()) %></td>
                                        <td><%=c.getPrecio() %></td>
                                        <td><%= c.getEstado().name() %></td> 

                                    </tr>
                                <%}}%>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
         <form action="cierresesion" method="POST">
            <input type="submit" name="cerrarSesion"value="Cerrar Sesion"/>
        </form>
        </div>
        
    </body>
</html>