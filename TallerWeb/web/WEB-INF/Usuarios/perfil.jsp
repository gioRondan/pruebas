
<%@page import="servidor.DataFecha"%>
<%@page import="servidor.DataReserva"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="servidor.DataInfoCliente"%>
<%@page import="javax.websocket.Session"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
        <link rel="stylesheet" type="text/css" href="./media/styles/estilopestanias.css"/>
        <script type="text/javascript" src="./js/cambiarPestanna.js"></script>
        <script type="text/javascript" src="./js/jquery-1.7.2.min.js"></script>
<%@page errorPage="/WEB-INF/errorPages/500.jsp" %>
<!doctype html>
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

             

                    <div id="contenidopestanas" style="width: 500px" >
                    <div id="cpestana1" >
                        <table>
                            <tr>
                                <td>
                                    <h1 >Perfil</h1>
                                    <%
                                        DataInfoCliente cliente = (DataInfoCliente) request.getSession().getAttribute("dataCliente");
                                        DataFecha fecha = (DataFecha)request.getSession().getAttribute("fechaNacimiento");
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
                                        Fecha de nacimiento: <%= cliente.getFechaNac().getDia()+'/'+cliente.getFechaNac().getMes()+'/'+cliente.getFechaNac().getAnio() %>
                                    <%}%>
                                    <br>
                                    <%= fecha.getDia() %><br><%= fecha.getMes() %><br><%= fecha.getAnio() %>     
                                    <%= cliente.getFechaNac().getDia() %><br><%= cliente.getFechaNac().getMes() %><br><%= cliente.getFechaNac().getAnio() %>     
                                </td>
                                <td>
                                   <% if (cliente.getImagen() !=null){%>
                                    <br>
                                   <%}%>
                                </td>
                            </tr>
                        </table>
                    </div>
                    <div id="cpestana2">
                       aaa
                    </div>
                </div>
            </div>
        </div>
         <form action="cierresesion" method="POST">
            <input type="submit" name="cerrarSesion" value="Cerrar Sesion"/>
        </form>
        </div>
        
    </body>
</html>