<%-- 
    Document   : pagePedidoCliente
    Created on : 27-sep-2016, 11:42:30
    Author     : <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src="Modulos/Pedidos/Pedido/js/jsFunc_Pedidos.js" type="text/javascript"></script>
<link href="css/plugins/iCheck/custom.css" rel="stylesheet">
<!-- iCheck -->
<script src="js/plugins/iCheck/icheck.min.js"></script>
<div class="row">
    <div id="progressimtes"></div>
    <div class="ibox" id="contIbox">

    </div>



</div>

<div class="modal inmodal fade" id="idModalAgregarMesa" tabindex="-1" role="dialog" aria-hidden="true">

</div>

<script type="text/javascript">
    $(function () {
        func_MostrarItemsCliente();
    });
</script>