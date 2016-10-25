<%-- 
    Document   : PaginaAgregarPlato
    Created on : 22-feb-2015, 20:15:52
    Author     : Lain
--%>

<%@page import="modelo.Plato"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>NazcaSoft</title>
    </head>
    <body>
        <%
            Plato plato = (Plato)request.getAttribute("plato");
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
            <form name="FormAgregarPlato" id="FormAgregarPlato" action="AgregarPlato"> 
                <!-- el <input type="hidden"> es un campo oculto -->
                <input type="hidden" name="platoid" value="<%= plato.getPlatoid() %>" />
                <table border="1" style="background: aliceblue">
                    <caption><h3>AGREGAR PLATO AL PEDIDO</h3></caption>                    
                    <tfoot>
                        <tr>
                            <th colspan="2">
                                <input type="submit" value="Agregar"/>
                                <input type="button" value="Cancelar" onclick="window.location='BuscarPlatos'"/>
                            </th>
                        </tr>
                    </tfoot>
                    <tbody>
                        <tr>
                            <td>Nombre:</td>
                            <td style="width: 200px"><%= plato.getNombre() %></td>
                        </tr>
                        <tr>
                            <td>Precio:</td>
                            <td><%= plato.getPrecio() %></td>
                        </tr>
                        <tr>
                            <td><label for="cantidad">Cantidad:</label></td>
                            <td><input type="text" id="cantidad" name="cantidad" value="" style="text-align: right" maxlength="2" size="10" required="required" autofocus="autofocus"/></td>
                        </tr>
                    </tbody>
                </table>                                           
            </form> 
            <% 
               String mensaje = (String)request.getAttribute("mensaje"); 
               if(mensaje != null) { %>
                    <font style="color: red"><%=mensaje%></font>
           <% } %>
        </div>
    </body>
</html>
