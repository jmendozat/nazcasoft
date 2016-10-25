<%-- 
    Document   : PaginaBuscarPlatos
    Created on : 22-feb-2015, 18:49:07
    Author     : Lain
--%>

<%@page import="modelo.Pedido"%>
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
        <% 
            List<Plato> listaPlatos = (List<Plato>)request.getAttribute("listaPlatos");
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
            <table border="1" style="background: lemonchiffon">
                <caption><h3>SOLICITUD DE PLATOS</h3></caption>
                <thead style="background-color: khaki">
                    <tr>
                        <th style="width: 100px"># Mesa</th>
                        <th style="width: 100px">Platos</th>
                        <th style="width: 100px">Total S/.</th>
                    </tr>
                </thead>
                <tfoot>
                    <tr>
                        <th colspan="3">
                            <input type="button" value="Ver mesas" name="botonVerMesas" onclick="window.location='ConsultarMesasDePedido'"/>                            
                            <input type="button" value="Ver pedido" name="botonVerPedido" onclick="window.location='ConsultarPedido'"/>                            
                        </th>
                    </tr>
                </tfoot>
                <tbody >
                    <tr style="font-size: large">
                        <td style="text-align: center"><%= pedido.getMesa().getNumero() %></td>
                        <td style="text-align: center"><%= pedido.calcularNumeroDePlatos()%></td>
                        <td style="text-align: center"><%= pedido.calcularTotal() %></td>
                    </tr>
                </tbody>
            </table>
            <br>
        </div>
        <div align="center">            
            <form name="FormConsultarPlatos" id="FormConsultarPlatos" action="BuscarPlatos">        
                <table border="1" style="background: aliceblue">                    
                    <thead>
                        <tr style="background-color: cornflowerblue">
                            <!-- td: asigna una celda y define una columna, colspan=2 espande la celda a dos columnas -->
                            <td colspan="2" align="right">                            
                                <label for="nombre" style="color: white">Buscar por nombre:</label>
                                <input type="text" id="nombre" name="nombreplato" value="" maxlength="40" size="40" autofocus="autofocus"/>
                                <input type="submit" value="Buscar"/>
                            </td>
                        </tr>
                        <tr style="background-color: gold">
                            <th style="width: 400px">Nombre</th>
                            <th style="width: 100px">Precio S/.</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% if(listaPlatos != null){
                            for(Plato plato : listaPlatos){ %>     
                                <tr>
                                    <td><a href="BuscarPlato?platoid=<%= plato.getPlatoid()%>"><%= plato.getNombre() %></a></td>
                                    <td style="text-align: right"><%=plato.getPrecio()%></td>
                                </tr>
                            <% } 
                         } %>
                    </tbody>
                </table>                
            </form>                    
            <% 
                String mensaje = (String)request.getAttribute("mensaje"); 
                if(mensaje != null) { %>                    
                    <font style="color: red"><%=mensaje%></font>
           <%   } %> 
        </div>
    </body>
</html>
