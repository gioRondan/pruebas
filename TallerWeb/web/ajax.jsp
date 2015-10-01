<%-- 
    Document   : ajax
    Created on : Sep 28, 2015, 6:26:11 PM
    Author     : diego.roman
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%><%

    String verificarUsuario(String username)
    {
        if (username == "pepe")
            return "si";
        else
            return "no";
    }
    
  /*  String usuario = "";
    usuario = request.getParameter("username");
    
    if (usuario.equals("pepe")) {
        out.print("El usuario ya existe");
    } else {
        out.print("");
    }*/
%>