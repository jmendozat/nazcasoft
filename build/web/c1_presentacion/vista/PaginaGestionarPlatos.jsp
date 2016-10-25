<%-- 
    Document   : PaginaGestionarPlatos
    Created on : 
    Author     : Lain
--%>

<%@page import="java.util.List"%>
<%@page import="modelo.Plato"%>
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
                    window.location="EliminarPlato?platoid=" + platoid;
            }
        </script>
        <% 
            List<Plato> listaPlatos = (List<Plato>)request.getAttribute("listaPlatos");
        %> 
        <div align ="center">
            <table>
                <tr>
                    <td style="text-align: center"><img src="figuras/plato.png" title="Gestionar platos"></td>
                    <td>
                        <h1><font style="font-style: italic">Restaurante Nazca</font></h1>
                        <a href="index.html">Menú principal</a><br>
                    </td>
                </tr>
            </table>
        </div>
        <hr>
        <div align="center">            
            <form name="FormConsultarPlatos" id="FormConsultarPlatos" action="ConsultarPlatos">        
                <table border="1" style="background: aliceblue">
                    <!-- caption: asigna un titulo fuera de la tabla -->
                    <caption><h3>GESTIÓN DE PLATOS</h3></caption>
                    <thead>
                        <tr style="background-color: cornflowerblue">
                            <!-- td: asigna una celda y define una columna, colspan=2 espande la celda a dos columnas -->
                            <td colspan="3" align="right">                            
                                <label for="nombre" style="color: white">Buscar por nombre:</label>
                                <input type="text" id="nombre" name="nombreplato" value="" maxlength="40" size="40" autofocus="autofocus"/>
                                <input type="submit" value="Buscar"/>
                                <input type="button" value="Nuevo" onclick="window.location='NuevoPlato'"/>
                            </td>
                        </tr>
                        <tr style="background-color: gold">
                            <th style="width: 300px">Nombre</th>
                            <th style="width: 10px">Precio</th>
                            <th style="width: 5px"><img src="figuras/eliminar.gif" title="Eliminar plato"></th>
                        </tr>
                    </thead>
                    <tbody>
                        <% if(listaPlatos != null){
                            for(Plato plato : listaPlatos){ %>     
                                <tr>
                                    <td><a href="ConsultarPlato?platoid=<%= plato.getPlatoid()%>"><%= plato.getNombre() %></a></td>
                                    <td style="text-align: right"><%=plato.getPrecio()%></td>
                                    <td style="text-align: center">
                                        <button type="button" onclick="confirmarEliminacion(<%= plato.getPlatoid()%>)"><img src="figuras/eliminar.gif" title="Eliminar plato"></button>                                        
                                    </td>
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
