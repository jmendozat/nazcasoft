<%-- 
    Document   : PageDetallePlatos
    Created on : 16-sep-2016, 13:39:28
    Author     : <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
--%>

<%@page import="modelo.LineaDePedido"%>
<%@page import="modelo.Pedido"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Pedido pedido = (Pedido) request.getSession().getAttribute("pedido");
%>
<strong>Detalle Boleta</strong>
<div class="table-responsive m-t">
    <table class="table invoice-table">
        <thead>
            <tr>
                <th>PLATO</th>
                <th>CANT.</th>
                <th>Precio</th>
                <th>Total</th>
            </tr>
        </thead>
        <tbody>
            <%
                for (LineaDePedido lineadepedido : pedido.getLineasDePedido()) {
            %>
            <tr>
                <td><%=lineadepedido.getPlato().getNombre()%>
                <td><%=lineadepedido.getCantidad()%></td>
                <td>S/<%=lineadepedido.getPrecio()%></td>
                <td>S/<%=lineadepedido.calcularSubTotal()%></td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
</div><!-- /table-responsive -->

<table class="table invoice-total">
    <tbody>
        <tr>
            <td><strong>Sub Total :</strong></td>
            <td>S/<%=pedido.calcularSubTotal() %></td>
        </tr>
        <tr>
            <td><strong>Descuento :</strong></td>
            <td>S/<%=pedido.calcularDescuento()%></td>
        </tr>
        <tr>
            <td><strong>TOTAL :</strong></td>
            <td>S/<%=pedido.calcularTotal() %></td>
        </tr>
    </tbody>
</table>
<strong>Notes</strong>
<p>
    Sugiera al cliente revisar bien su calculo de la boleta, para evitar percances.
</p>
</div>
