<%-- 
    Document   : IndexPedido
    Created on : 14-sep-2016, 16:26:50
    Author     : <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- Toastr style -->
        
        <link href="css/plugins/toastr/toastr.min.css" rel="stylesheet">
        <script src="js/pedidos/jsFunc_Pedidos.js" type="text/javascript"></script>
          <!-- iCheck -->
        <script src="js/plugins/iCheck/icheck.min.js"></script>
        
    </head>
    <body>
        <div class="row">
            <div class="col-sm-8">
                <div class="ibox">
                    <div class="ibox-content">
                        <h2>Gestión de Pedidos</h2>
                        <p>
                            Buscar todas las mesas registradas del restaurante Nazca.
                        </p>
                        <div class="input-group">
                            <input type="text" placeholder="Buscar mesas " class="input form-control" id="idTxtNombre">
                            <span class="input-group-btn">
                                <button type="button" class="btn btn btn-primary"> <i class="fa fa-search"></i> Buscar</button>
                            </span>
                        </div>
                        <br />
                        <div class="mesa_list">
                            <ul class="nav nav-tabs">
                                <li class="active"><a data-toggle="tab" href="#tab-1"><i class="fa fa-tencent-weibo"></i> Mesas</a></li>
                            </ul>
                            <div class="tab-content">
                                <div id="tab-1" class="tab-pane active">
                                    <div class="full-height-scroll">
                                        <div class="table-responsive">
                                            <div id="idProMesas"></div>
                                            <div id="idContenedorMesas"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>

            <div class="col-sm-4">
                <div class="ibox ">
                    <div id="idProgressDetalle"></div>
                    <div id="idContDetalleBoleta"></div>

                </div>
            </div>
        </div>
        <div class="modal inmodal fade" id="idModalNewPedido" tabindex="-1" role="dialog" aria-hidden="true">

        </div>
    </body>
    
    
    <script type="text/javascript">
        $(function () {
            met_buscarMesas(); 
        });
        
  <%-- (function met_buscarMesasAsinc() {
    var valorBusqueda;
    $("#idContenedorMesas").html("");
    valorBusqueda = $("#idTxtNombre").val();
    $.ajax({
        type: "GET",
        url: "ConsultarMesasDePedido",
        contentType: "application/json; charset=utf-8",
        async: false,
        success: function (data) {
            $("#idContenedorMesas").html(data);
        },
        error: function (result) {
            alert("Error: " + result);
        }
    }).then(function() {          
       setTimeout(met_buscarMesasAsinc, 30000);  
    });
})();--%>
    </script>
</html>
