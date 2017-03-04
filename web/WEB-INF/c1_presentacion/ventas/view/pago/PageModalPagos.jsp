<%-- 
    Document   : PageModalPagos
    Created on : 19-sep-2016, 23:48:29
    Author     : <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
--%>

<%@page import="c3_dominio.pedidos.entidad.Pedido"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Pedido pedido = (Pedido) request.getSession().getAttribute("pedido");
%>
<div class="modal-dialog modal-sm">
    <div class="modal-content">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
            <h4 class="modal-title">Realizar Pago</h4>
        </div>
        <div class="modal-body">
            <div class="row">
                <div class="col-lg-4">
                    <span>
                        Nº Platos
                    </span>
                    <h4 class="font-bold" align="center">
                        <%=pedido.calcularNumeroDePlatos()%>
                    </h4>
                </div>
                <div class="col-lg-4">
                    <span>
                        Sub Total
                    </span>
                    <h4 class="font-bold">
                        S/<%=pedido.calcularTotal()%>
                    </h4>
                </div>
                <div class="col-lg-4">
                    <span>
                        Descuento
                    </span>
                    <h4 class="font-bold">
                        S/<%=pedido.calcularDescuento()%>
                    </h4>
                </div>
            </div>
            <hr />
            <div class="row">
                <div class="col-lg-8">
                    <span>
                        Total
                    </span>
                    <input hidden="true" value="<%=pedido.calcularTotal() %>" id="idTotalPedido" />
                    <h2 class="font-bold">
                        S/<%=pedido.calcularTotal() %>
                    </h2>
                </div>
            </div>
            <hr/>
            <div class="row">
                <div class="col-xs-5 col-md-5 pull-left">
                    <div class="form-group">
                        <input type="text" id="idPMonto" class="form-control" placeholder="Monto"  size="10"/>
                    </div>
                </div>
               
            </div>

            <span class="text-muted small">
                *Ingrese el monto, registre la venta y obtenga el vuelto.
            </span><br />
            <label class="error small" id="MsgError">

            </label>
        </div>
        <div class="modal-footer">
            <button type="button" class="btn btn-white" data-dismiss="modal">Cancelar</button>
            <button type="button" class="btn btn-primary" id="idbtnPagar" onclick="func_guardarVenta();"><i class="fa fa-money"></i> Pagar</button>
        </div>
    </div>
</div>
