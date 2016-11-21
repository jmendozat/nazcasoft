<%-- 
    Document   : PageBuscarMesas
    Created on : 14-sep-2016, 21:17:19
    Author     : <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
--%>

<%@page import="c3_dominio.pedidos.entidad.Mesa"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<Mesa> listaMesas = (List<Mesa>) request.getAttribute("listaMesas");
%>
<input hidden="true" id="idIdAnterior" />
<table class="table table-striped table-hover">
    <tbody>
        <%
            for (Mesa mesa : listaMesas) {
                if (mesa.isDisponible()) {
        %>
            <tr>
                <td><a href="javascript:void(0)" class="client-link" >Mesa <%=mesa.getNumero()%></a></td>
                <td><%=mesa.getTipoMesa().getNombre()%></td>
                <td><%=mesa.getTipoMesa().getDescripcion()%></td>
                <td class="client-status"><span class="<%=mesa.getColor()%>">Disponible</span></td>
                <td id="idSelect<%=mesa.getMesaid()%>"></td>
            </tr>
            <%
            } else {
            %>
            <tr>
                <td><a href="javascript:void(0)" class="client-link" onclick="met_buscarDetalle(<%=mesa.getMesaid()%>)">Mesa <%=mesa.getNumero()%></a></td>
                <td><%=mesa.getTipoMesa().getNombre()%></td>
                <td><%=mesa.getTipoMesa().getDescripcion()%></td>
                <td class="client-status"><span class="<%=mesa.getColor()%>">Ocupada</span></td>
                <td id="idSelect<%=mesa.getMesaid()%>"></td>
            </tr>
            <%
                    }
                }
            %>

    </tbody>
</table>
