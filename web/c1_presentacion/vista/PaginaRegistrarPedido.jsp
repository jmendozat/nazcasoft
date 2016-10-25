<%-- 
    Document   : PaginaRegistrarPedido
    Created on : 26-feb-2015, 16:06:16
    Author     : Lain
--%>

<%@page import="modelo.Pedido"%>
<%@page import="modelo.LineaDePedido"%>
<%@page import="modelo.Plato"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>NazcaSoft</title>
    </head>
    <body>
        <script>
            function confirmarEliminacion(platoid) {
                var deseaEliminar = confirm("¿Esta seguro de eliminar?");
                if (deseaEliminar)
                    window.location="EliminarPlatoDePedido?platoid=" + platoid;
            }
        </script>
        <% 
            Pedido pedido = (Pedido)request.getSession().getAttribute("pedido");
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
                <caption><h3>PEDIDO Mesa # <%= pedido.getMesa().getNumero() %></h3></caption>
                <thead>                    
                    <tr style="background-color: lemonchiffon">                        
                        <th colspan="5">
                            <input type="button" value="Ver mesas" name="botonVerMesas" onclick="window.location='ConsultarMesasDePedido'"/>
                            <input type="button" value="Buscar platos" name="botonBuscarPlatos" onclick="window.location='BuscarPlatos'"/>
                            <input type="button" value="Guardar pedido" name="botonGuardarPedido" onclick="window.location='GuardarPedido'"/>
                        </th>
                    </tr>
                    <tr style="background-color: gold">
                        <th style="width: 5px"><img src="figuras/eliminar.gif" title="Eliminar plato"></th>
                        <th style="width: 400px">Plato</th>
                        <th style="width: 100px">Precio S/.</th>
                        <th style="width: 100px">Cantidad</th>
                        <th style="width: 100px">Total S/.</th>
                    </tr>
                </thead>
                <tfoot>
                    <tr>
                        <th colspan="4" style="text-align: right">Total a pagar: </th>
                        <th style="text-align: right; background-color: cyan"><%= pedido.calcularTotal() %></th>
                    </tr>
                     <tr>
                         <th colspan="4" style="text-align: right">Descuento:</th>
                        <th style="text-align: right; background-color: cyan"><%= pedido.calcularDescuento() %></th>
                    </tr>
                     <tr>
                        <th colspan="4" style="text-align: right">Totalito: </th>
                        <th style="text-align: right; background-color: cyan"><%= pedido.calcularTotalito() %></th>
                    </tr>
                </tfoot>
                <tbody>
                    <% for(LineaDePedido lineaDePedido : pedido.getLineasDePedido()){ %>     
                        <tr>
                            <td style="text-align: center">
                                <button type="button" onclick="confirmarEliminacion(<%= lineaDePedido.getPlato().getPlatoid() %>)">
                                    <img src="figuras/eliminar.gif" title="Eliminar plato">
                                </button>                                        
                            </td>
                            <td><%= lineaDePedido.getPlato().getNombre() %></td>
                            <td style="text-align: right"><%= lineaDePedido.getPrecio() %></td>
                            <td style="text-align: right"><%= lineaDePedido.getCantidad() %></td>
                            <td style="text-align: right"><%= lineaDePedido.calcularSubTotal() %></td>
                        </tr>
                    <% } %>
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
