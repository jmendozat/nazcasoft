<%-- 
    Document   : PaginaGestionarPlatos
    Created on : 
    Author     : Lain
--%>

<%@page import="c3_dominio.pedidos.entidad.Plato"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    List<Plato> listaPlatos = (List<Plato>) request.getAttribute("listaPlatos");

%> 
<table class="table table-striped">
    <thead>
        <tr>
            <th style="width: 5px"><i class="fa fa-check text-navy"></i></th>
            <th>Nombre</th>
            <th>Descripción</th>
            <th>Estado</th>
            <th style="text-align: center">Precio</th>
            <th></th>
        </tr>
    </thead>
    <tbody>
        <% if (listaPlatos != null) {
                for (Plato plato : listaPlatos) {%>     
        <tr>
            <td><input type="checkbox" value="<%= plato.getPlatoid()%>" name="orderBox[]" class="i-checks"></td>
            <td><%= plato.getNombre()%></td>
            <td><%= plato.getDescripcion()%></td>
            <td><%= plato.getEstado()%></td>
            <td style="text-align: center"><%=plato.getPrecio()%></td>
            <td><a href="javascript:void(0)" title="Ver imagen del plato <%=plato.getNombre()%>" onclick="func_verImgPlato('<%=plato.getUrlfoto()%>')"><i class="fa fa-eye"></i></a></td>
        </tr>
        <% }
            }%>
    </tbody>
</table>
<%
    String mensaje = (String) request.getAttribute("mensaje");
    if (mensaje != null) {%>
<font style="color: red"><%=mensaje%></font>
<% }%>

<div class="modal inmodal" id="modIdVerPlato" tabindex="-1" role="dialog" aria-hidden="true">

</div>








