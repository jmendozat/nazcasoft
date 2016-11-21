<%-- 
    Document   : PageItemsPedidoCliente
    Created on : 27-sep-2016, 11:55:46
    Author     : <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
--%>

<%@page import="c3_dominio.pedidos.entidad.LineaDePedido"%>
<%@page import="c3_dominio.pedidos.entidad.Pedido"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%
    Pedido pedido = (Pedido) request.getSession().getAttribute("pedido");
%>
 <div class="col-md-9">
                   
              
<div class="ibox-title">
    <% 
     if(pedido.getLineasDePedido().size()>0){
         %>
    <span class="pull-right">(<strong><%=pedido.calcularNumeroDePlatos()%></strong>) items</span>
    <h5>Lista de platos agregados a tu pedido</h5>
</div>
    <%        for (LineaDePedido lineaDePedido : pedido.getLineasDePedido()) {

%>

<div class="ibox-content">
    <div class="table-responsive ">
        <table class="table shoping-cart-table">
            <tbody>
                <tr>
                    <td width="90">
                        <%  if (lineaDePedido.getPlato().getUrlfoto() != null) {
                        %>
                        <div class="cart-product-imitation" style="background-image: url('<%=lineaDePedido.getPlato().getUrlfoto()%>'); -webkit-background-size: cover;-moz-background-size: cover;-o-background-size: cover;background-size: cover;"></div>
                        <%
                        } else {
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
 <div class="col-md-3">

                    <div class="ibox">
                        <div class="ibox-title">
                            <h5>Resumen del Pedido</h5>
                        </div>
                        <div class="ibox-content">
                            <span>
                                Total
                            </span>
                            <h2 class="font-bold">
                                S/<%=pedido.calcularTotal()%>
                            </h2>

                            <hr/>
                            <span class="text-muted small">
                                *El pedido esta vigente hasta la 1:00pm de la tarde a partir de ello se condiera anulado.
                            </span>
                            <div class="m-t-sm">
                                <div class="btn-group">
                                    <a href="javascript:void(0)" onclick="func_mostrarMesas();" class="btn btn-primary btn-sm"><i class="fa fa-shopping-cart"></i> Confirmar Pedido</a>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="ibox">
                        <div class="ibox-title">
                            <h5>Support</h5>
                        </div>
                        <div class="ibox-content text-center">



                            <h3><i class="fa fa-phone"></i> +43 100 783 001</h3>
                            <span class="small">
                                Please contact with us if you have any questions. We are avalible 24h.
                            </span>


                        </div>
                    </div>

                    <div class="ibox">
                        <div class="ibox-content">

                            <p class="font-bold">
                            Other products you may be interested
                            </p>

                            <hr/>
                            <div>
                                <a href="#" class="product-name"> Product 1</a>
                                <div class="small m-t-xs">
                                    Many desktop publishing packages and web page editors now.
                                </div>
                                <div class="m-t text-righ">

                                    <a href="#" class="btn btn-xs btn-outline btn-primary">Info <i class="fa fa-long-arrow-right"></i> </a>
                                </div>
                            </div>
                            <hr/>
                            <div>
                                <a href="#" class="product-name"> Product 2</a>
                                <div class="small m-t-xs">
                                    Many desktop publishing packages and web page editors now.
                                </div>
                                <div class="m-t text-righ">

                                    <a href="#" class="btn btn-xs btn-outline btn-primary">Info <i class="fa fa-long-arrow-right"></i> </a>
                                </div>
                            </div>

                        </div>
                    </div>

                </div>
    <%
     }else{
        %>
      <h5>Tu lista de pedido esta vacia.</h5>
      </div>
    <%
        }
    %>
  

    

