<%-- 
    Document   : PageItemsPedido
    Created on : 15-sep-2016, 18:23:32
    Author     : <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
--%>

<%@page import="modelo.Plato"%>
<%@page import="modelo.LineaDePedido"%>
<%@page import="modelo.Pedido"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Pedido pedido = (Pedido) request.getSession().getAttribute("pedido");
%>
<div id="itemsplatos"> 
    <%        for (LineaDePedido lineaDePedido : pedido.getLineasDePedido()) {
        
    %>

    <div class="ibox-content">
        <div class="table-responsive ">
            <table class="table shoping-cart-table">
                <tbody>
                    <tr>
                        <td width="90">
                               <% 
                         if(lineaDePedido.getPlato().getUrlfoto()!= null){
                             %>
                             <div class="cart-product-imitation" style="background-image: url('<%=lineaDePedido.getPlato().getUrlfoto()%>'); -webkit-background-size: cover;-moz-background-size: cover;-o-background-size: cover;background-size: cover;"></div>
                             <%
                         }else{
                            %>
                            <div class="cart-product-imitation" style="background-color: #f8f8f9;"></div>
                             <%
                            }
                        %>
                        </td>
                        <td class="desc">
                            <input hidden="true" value="<%=lineaDePedido.getPlato().getPlatoid()%>" class="idPlatoitem"/>
                            <h3>
                                <a href="#" class="text-navy">
                                    <%= lineaDePedido.getPlato().getNombre()%>
                                </a>
                            </h3>
                            <dl class="small m-b-none">
                                <dt>Descripción</dt>
                                 <dd><%= lineaDePedido.getPlato().getDescripcion()%></dd>
                            </dl>

                            <div class="m-t-sm">
                                <a href="#" class="text-muted" onclick="func_quitarPlatoPedido(<%=lineaDePedido.getPlato().getPlatoid()%>)"><i class="fa fa-trash"></i> Quitar plato</a>
                            </div>
                        </td>

                        <td>
                            S/<%= lineaDePedido.getPrecio()%>
                            <%-- <s class="small text-muted">$230,00</s>--%>
                        </td>
                        <td width="65">
                            <input type="text" class="form-control" id="idcantitem" placeholder="<%= lineaDePedido.getCantidad()%>">
                        </td>
                        <td style="text-align: left;">
                           
                                <h4>S/<%= lineaDePedido.calcularSubTotal()%></h4>
                            
                        </td>
                    </tr>
                </tbody>
            </table>                    
        </div>
    </div>
    <%
        }
    %>
</div>
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
            <td>S/<%=pedido.calcularTotal()%></td>
        </tr>
    </tbody>
</table>

<script type="text/javascript">
    $(function () {
        func_actualizarPlatoPedido();
    });

</script>