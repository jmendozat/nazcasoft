<%-- 
    Document   : PageDetallePedido
    Created on : 14-sep-2016, 21:20:31
    Author     : <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
--%>

<%@page import="c3_dominio.administrativo.entidad.Persona"%>
<%@page import="c3_dominio.pedidos.entidad.Pedido"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Pedido pedido = (Pedido) request.getSession().getAttribute("pedido");
%>
<div class="ibox-content">
    <div class="tab-content">       
        <div id="contact-1" class="tab-pane active">
            <div class="row m-b-lg">
                <div class="col-lg-4 text-center">
                    <% 
                     if(pedido.getCliente().getTipopersona().equals(Persona.NATURAL)){
                         %>
                           <h2><%=pedido.getCliente().getNombre()%></h2>
                    
                    <%
                     }else{
                     %>
                    
                      <h2><%=pedido.getCliente().getRazonsocial()%></h2>
                     <%
                        }
                        %>
                    <div class="m-b-sm">
                        <img alt="image" class="img-circle" src="<%=pedido.getCliente().getUrlfotoperfil()%>"
                             style="width: 62px">
                    </div>
                </div>
                <div class="col-lg-8">
                    <strong>
                        cliente que usa la mesa Nº <%=pedido.getMesa().getNumero()%>
                    </strong>

                    <p>
                        El pedido realizado se muestra a continuación detallado, mostrando
                        el nombre del plato el precio el total y el descuento.
                    </p>
                    <button type="button" class="btn btn-primary btn-sm btn-group" onclick="func_vModalPago();" ><i
                            class="fa fa-money"></i> Pagar
                    </button>
                </div>
            </div>
            <div class="client-detail">
                <div id="idProgressPlDetail"></div>
                <div class="full-height-scroll" id="idBDetallePlatos">



                </div>
            </div>
        </div>
    </div>
   

    <script type="text/javascript">
        $(function () {
            func_DetallePlatos();
        });
    </script>
