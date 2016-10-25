<%-- 
    Document   : PaginaNuevoPlato
    Created on : 15-feb-2015, 16:27:06
    Author     : Lain
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>NazcaSoft</title>
    </head>
    <body>
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
            <form name="FormNuevoPlato" id="FormNuevoPlato" action="InsertarPlato"> 
                <table border="1" style="background: aliceblue">
                    <caption><h3>NUEVO PLATO</h3></caption>                    
                    <tfoot>
                        <tr>
                            <th colspan="2">
                                <input type="submit" value="Guardar"/>
                                <input type="button" value="Cancelar" onclick="window.location='ConsultarPlatos'"/>
                            </th>
                        </tr>
                    </tfoot>
                    <tbody>
                        <tr>
                            <td><label for="nombre">Nombre:</label></td>
                            <td><input type="text" id="nombre" name="nombre" value="" maxlength="40" size="60" required="required" autofocus="autofocus"/></td>
                        </tr>
                        <tr>
                            <td><label for="precio">Precio:</label></td>
                            <td><input type="text" id="precio" name="precio" value="" style="text-align: right" maxlength="6" size="10" required="required"/></td>
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
