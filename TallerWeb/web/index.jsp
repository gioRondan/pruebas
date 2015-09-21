<%@page import="logica.DataCliente"%>
<%@page import="java.util.List"%>
<%@page import="logica.IControladorCliente"%>
<%@page import="logica.Fabrica"%>
<%@page import="logica.CargaInicial"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AJAX JSP Servelts</title>
<script src="http://code.jquery.com/jquery-latest.js">
</script>
<script>
        $(document).ready(function() {
            alert("S");
		$('#cargainicial').click(function(event) {
                    alert("se van a acrgar los datos");
                    <%
                        CargaInicial x = new CargaInicial();
                        x.cargar();
                    %>
                            
               window.document.form1.cargainicial.value = 'Se cargaron los datos';
		 window.document.form1.cargainicial.disabled= true;	
		});
                $('#verclientes').click(function(event) {
                   
                <% 
                    Fabrica fabrica2 = Fabrica.getInstance();
                   IControladorCliente ICC2= fabrica2.getIControladorCliente();
                   List<DataCliente> a2 = ICC2.listarClientes();
                    String sal ="<table><tr><th> NOMBRE </th><th> APELLIDO </th><th> NICKNAME </th></tr>";
                  for(DataCliente v : a2 ){
                     sal=sal+"<tr><td>"+v.getNombre()+"</td><td>"+v.getApellido()+"</td><td>"+v.getNickname()+"</td></tr>";
                   }
                  sal=sal+"</table>";
               %>                      
                window.document.form1.verclientes.value = 'Se cargaron los datos';
		 $('#clientes').html("<%=sal%>");	
		});
                
	});
        </script>
    </head>
    <body>
        
        <h1>Hello World!</h1>
        <FORM id="form1" name="form1" >
        
            <input type="button" id="cargainicial" NAME='cargainicial' value="antes de cargar" >
          
        
            <input type="button" id="verclientes" NAME='verclientes' value="Ver clientes" >
            
        </FORM>  
        <div id="clientes"></div>
    </body>
</html>
