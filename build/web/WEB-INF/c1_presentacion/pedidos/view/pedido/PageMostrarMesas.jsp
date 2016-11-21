<%-- 
    Document   : PageMostrarMesas
    Created on : 27-sep-2016, 22:36:17
    Author     : <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
--%>

<%@page import="c3_dominio.pedidos.entidad.Mesa"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<Mesa> listaMesas = (List<Mesa>) request.getAttribute("listaMesas");
%>
<div class="modal-dialog modal-lg">
    <div class="modal-content animated bounceInRight">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
            <h4 class="modal-title">Confirmar el Pedido</h4>
            <small class="font-bold">Selecione la mesa que desea reserva junto a su pedido.</small>
        </div>
        <div class="modal-body">
            <div class="row">
                <div class="col-lg-12">
                    <table class="table table-striped table-hover">
                        <tbody>
                            <%
                                for (Mesa mesa : listaMesas) {
                                    if (mesa.isDisponible()) {
                            %>
                            <tr>
                                <td><input type="checkbox" value="<%= mesa.getMesaid()%>" name="orderBox[]" class="i-checks"></td>
                                <td><a href="javascript:void(0)" class="client-link">Mesa <%=mesa.getNumero()%></a></td>
                                <td><%=mesa.getTipoMesa().getNombre()%></td>
                                <td><%=mesa.getTipoMesa().getDescripcion()%></td>
                                <td class="client-status"><span class="<%=mesa.getColor()%>">Disponible</span></td>
                                <td id="idSelect<%=mesa.getMesaid()%>"></td>
                            </tr> 
                            <%
                                 }   
                                }
                            %>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div class="modal-footer">
            <button type="button" class="btn btn-white" data-dismiss="modal">Close</button>
            <button type="button" class="btn btn-primary" onclick="func_confirmarpedido();">Guardar</button>
        </div>
    </div>
</div>

<script type="text/javascript">
 $(function (){
     load_csscheck();
     
 });
 
</script>


