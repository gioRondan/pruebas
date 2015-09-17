<%-- 
    Document   : index
    Created on : Sep 16, 2015, 10:03:27 PM
    Author     : Juan
--%>

<%@page import="logica.DataCliente"%>
<%@page import="java.util.List"%>
<%@page import="logica.Fabrica"%>
<%@page import="logica.IControladorCliente"%>
<%@page import="logica.CargaInicial"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script language=JavaScript>
            var numberOfClicks = 0;

            function cargainicial_onclick() {
                <%
                    CargaInicial x = new CargaInicial();
                    x.cargar();
                %>
                window.document.form1.cargainicial.value = 'Se cargaron los datos';
            }
            function verclientes_onclick() {
                
                <% 
//                    Fabrica fabrica2 = Fabrica.getInstance();
//                   IControladorCliente ICC2= fabrica2.getIControladorCliente();
//                   List<DataCliente> a2 = ICC2.listarClientes();
//                  for(DataCliente v : a2 ){
//                      out.println(v.getNombre()+" "+v.getApellido()+" \n");
//                  }
                %>
                       
                window.document.form2.verclientes.value = 'Se cargaron los datos';
                 
                
            }
        </script>
    </head>
    <body>
        
        <h1>Hello World!</h1>
        <FORM NAME=form1>
        
        <input type="button" NAME='cargainicial' value="antes de cargar"
             onclick="cargainicial_onclick()">
        </FORM>  
        <FORM NAME=form2>
        <input type="button" NAME='verclientes' value="Ver clientes"
             onclick= <% 
                    Fabrica fabrica2 = Fabrica.getInstance();
                   IControladorCliente ICC2= fabrica2.getIControladorCliente();
                   List<DataCliente> a2 = ICC2.listarClientes();
                 
                %>
                >
        <%
                    for(DataCliente v : a2 ){
                      out.println(v.getNombre()+" "+v.getApellido()+" \n");
                  }
        %>
        </FORM>  
      
    </body>
</html>
