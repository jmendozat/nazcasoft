<%-- 
    Document   : PageAddPlato
    Created on : 15-sep-2016, 9:31:44
    Author     : <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
--%>

<%@page import="modelo.Pedido"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Pedido pedido = (Pedido) request.getSession().getAttribute("pedido");
%>
<div class="modal-dialog modal-lg">
    <div class="modal-content animated bounceInRight">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
            <h4 class="modal-title">Modificar el Pedido</h4>
            <small class="font-bold">Agregue mas platos al pedido realizado por el cliente <b>Alfredo carlos</b></small>
        </div>
        <div class="modal-body">
            <div class="tabs-container">
                <div class="tabs-left">
                    <ul class="nav nav-tabs">
                        <li class="active"><a data-toggle="tab" href="#tab-addPlatos"><i class="fa fa-cutlery"></i>Buscar Platos</a></li>
                        <li class=""><a data-toggle="tab" href="#tab-verpedido" class="tabItemPedido"><i class="fa fa-shopping-cart"></i>Ver el Pedido</a></li>                       
                        <li class=""><a data-toggle="tab" href="#tab-verClientes" class="tabItemCliente"><i class="fa fa-user"></i>Agregar Cliente</a></li>
                    </ul>
                    <div class="tab-content ">
                        <div id="tab-addPlatos" class="tab-pane active">
                            <div class="panel-body">
                                <div class="input-group">
                                    <input type="text" placeholder="Buscar platos " class="input form-control" id="idTxtDescPlato">
                                    <span class="input-group-btn">
                                        <button type="button" class="btn btn btn-primary" onclick="func_buscarPlatos();"> <i class="fa fa-search"></i> Buscar</button>
                                    </span>
                                </div>
                                <br>
                                <div id="idProgresBarPlatos"></div>
                                <div id="idContResultados" style="overflow-y: scroll; height: 250px;">

                                </div>
                            </div>
                        </div>
                        <div id="tab-verpedido" class="tab-pane">
                            <div class="panel-body">
                                <div id="idContItemPedido" style="overflow-y: scroll; height: 250px;">

                                </div>
                            </div>
                        </div>
                        <div id="tab-verClientes" class="tab-pane">
                            <div class="panel-body">
                                <div class="input-group">
                                    <input type="text" placeholder="Buscar clientes " class="input form-control" id="idTxtDescCliente">
                                    <span class="input-group-btn">
                                        <button type="button" class="btn btn btn-primary" onclick="func_BuscarClientes();"> <i class="fa fa-search"></i> Buscar</button>
                                    </span>
                                </div>
                                <br>
                                <div id="idProgresBarCliente"></div>
                                <div id="idContResultClientes" style="overflow-y: scroll; height: 250px;">

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
        <div class="modal-footer">
            <button type="button" class="btn btn-white" data-dismiss="modal">Close</button>
            <button type="button" class="btn btn-primary" onclick="func_Modguardarpedido();">Guardar</button>
        </div>
    </div>
</div>


<script type="text/javascript">
    $(function () {
        func_buscarPlatos();
        func_calsubtotal();

        $('#idTxtDescPlato').bind("enterKey", function (e) {
            func_buscarPlatos();
        });
        $('#idTxtDescPlato').keyup(function (e) {
            if (e.keyCode == 13)
            {
                $(this).trigger("enterKey");
            }
        });

        $('#idTxtDescCliente').bind("enterKey", function (e) {
            func_buscarPlatos();
        });
        $('#idTxtDescCliente').keyup(function (e) {
            if (e.keyCode == 13)
            {
                $(this).trigger("enterKey");
            }
        });


        $(".tabItemPedido").on("click", function () {
            func_MostrarItemsPlato();
        });
        
        $(".tabItemCliente").on("click", function(){
            func_BuscarClientes();
        });
        
    });

</script>