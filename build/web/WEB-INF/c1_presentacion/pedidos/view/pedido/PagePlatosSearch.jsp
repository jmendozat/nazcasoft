<%-- 
    Document   : PagePlatosSearch
    Created on : 15-sep-2016, 17:16:39
    Author     : <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
--%>

<%@page import="c3_dominio.pedidos.entidad.Plato"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    List<Plato> listaPlatos = (List<Plato>) request.getAttribute("listaPlatos");
%>
<div id="items">
<%
    for (Plato plato : listaPlatos) {
%>
<div class="ibox-content">
    <div class="table-responsive ">
        <table class="table shoping-cart-table">
            <tbody>
                <tr>
                    <td width="90">
                        <% 
                         if(plato.getUrlfoto()!= null){
                             %>
                             <div class="cart-product-imitation" style="background-image: url('<%=plato.getUrlfoto()%>'); -webkit-background-size: cover;-moz-background-size: cover;-o-background-size: cover;background-size: cover;"></div>
                             <%
                         }else{
                            %>
                            <div class="cart-product-imitation" style="background-color: #f8f8f9;"></div>
                             <%
                            }
                        %>
                       
                    </td>
                    <td class="desc">
                        <h3>
                            <a href="#" class="text-navy">
                                <%=plato.getNombre()%>
                            </a>
                        </h3>
                        <dl class="small m-b-none">
                            <dt>Descripción</dt>
                            <dd><%= plato.getDescripcion()%></dd>
                        </dl>

                        <div class="m-t-sm">
                            <a href="#" class="text-muted" onclick="addPlatoPedido(<%=plato.getPlatoid()%>);" ><i class="fa fa-file-text"></i> Agregar al pedido</a>

                        </div>
                    </td>

                    <td>
                        <input hidden="true" value="<%=plato.getPrecio()%>" name="hprecio" class="hprecio" />
                        S/<%=plato.getPrecio()%>
                        <%-- <s class="small text-muted">$230,00</s>--%>
                    </td>
                    <td width="65">
                        <input type="text" class="form-control" name="form-control" id="idcant<%=plato.getPlatoid()%>" >
                    </td>
                    <td style="text-align: left;">
                        <table>
                            <tr><td><h4>S/ </h4></td><td style="text-align: left;"><h4 class="subtotal"></h4></td></tr>
                        </table>
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
