<%-- 
    Document   : PaginaGestionarPedidos
    Created on : 17-feb-2015, 15:30:32
    Author     : Lain
--%>

<%@page import="java.util.List"%>
<%@page import="modelo.Mesa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>NazcaSoft</title>
    </head>
    <body>        
        <% 
            List<Mesa> listaMesas = (List<Mesa>)request.getAttribute("listaMesas");
        %> 
        <div align ="center">
            <table>
                <tr>
                    <td style="text-align: center"><img src="figuras/pedido.png" title="Gestionar pedidos"></td>
                    <td>
                        <h1><font style="font-style: italic">Restaurante Nazca</font></h1>
                        <a href="index.html">Menú principal</a><br>
                    </td>
                </tr>
            </table>
        </div>
        <hr>
        <div align="center">    
            <table border="1" style="background: aliceblue">
                <!-- caption: asigna un titulo fuera de la tabla -->
                <caption><h3>GESTIÓN DE PEDIDOS</h3></caption>
                <thead>                    
                    <tr style="background-color: gold">
                        <th style="width: 300px">Mesa</th>
                    </tr>
                </thead>
                <tbody>
                    <% if(listaMesas != null){
                        for(Mesa mesa : listaMesas){ %>
                            <tr>
                                <td style="text-align: center; background-color: <%= mesa.getColor()%>">
                                    <a href="GestionarPedido?mesaid=<%= mesa.getMesaid()%>">Mesa # <%= mesa.getNumero()%></a>
                                </td>
                            </tr>
                        <% } 
                     } %>
                </tbody>
            </table>
            <% 
                String mensaje = (String)request.getAttribute("mensaje"); 
                if(mensaje != null) { %>                    
                    <font style="color: red"><%=mensaje%></font>
           <%   } %> 
        </div>
    </body>
</html>
