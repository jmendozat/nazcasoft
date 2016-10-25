/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function met_buscarMesas() {
    var valorBusqueda;
    progressbar('idProMesas');
    $("#idContenedorMesas").html("");
    $("#idProMesas").show();
    valorBusqueda = $("#idTxtNombre").val();
    $.ajax({
        type: "GET",
        url: "ConsultarMesasConPedido?tipo=15",
        contentType: "application/json; charset=utf-8",
        async: false,
        success: function (data) {
            $('#idProMesas').hide();
            $("#idContenedorMesas").html(data);
        },
        error: function (result) {
            alert("Error: " + result);
        }
    });
}
;
function met_buscarDetalle(idmesa) {
    progressbar('idProgressDetalle');
    var idAnterior = $("#idIdAnterior").val();
    $("#idSelect" + idAnterior).html("");
    $("#idContDetalleBoleta").html("");
    $("#idProgressDetalle").show();
    $.ajax({
        type: "GET",
        url: "BuscarPedidoDetalle?mesaid=" + idmesa,
        contentType: "application/json; charset=utf-8",
        async: false,
        success: function (data) {
            $('#idProgressDetalle').hide();
            $("#idContDetalleBoleta").html(data);
            $("#idSelect" + idmesa).html('<i class="fa fa-check text-navy"></i>');
            $("#idIdAnterior").val(idmesa);
        },
        error: function (result) {
            alert("Error: " + result);
        }
    });
}
;
function func_DetallePlatos() {
    progressbar('idProgressPlDetail');
    $("#idBDetallePlatos").html("");
    $("#idProgressPlDetail").show();
    $.ajax({
        type: "GET",
        url: "Modulos/Ventas/Pagos/PageDetallePlatos.jsp",
        contentType: "application/json; charset=utf-8",
        async: false,
        success: function (data) {
            $('#idProgressPlDetail').hide();
            $("#idBDetallePlatos").html(data);
        },
        error: function (result) {
            alert("Error: " + result);
        }
    });
}
;
function func_vModalPago() {
    $.ajax({
        type: "GET",
        url: "Modulos/Ventas/Pagos/PageModalPagos.jsp",
        contentType: "application/json; charset=utf-8",
        async: false,
        success: function (data) {
            $("#idModalPagos").html(data);
            $('#idModalPagos').modal('show');
        },
        error: function (result) {
            alert("Error: " + result);
        }
    });
}
;

function func_obtenerMonto() {
    var monto=0.0;

    $('#idPMonto').keyup(function (event) {
        monto = $("#idPMonto").val();
        calcVuelto(monto);
    });
}
;

function calcVuelto(monto) {
    var vuelto,
            totalpedido;
    $('#MsgError').text("");
    $('#idvuelto').text("");
    totalpedido = $('#idTotalPedido').val();
    if (monto >= totalpedido) {
        vuelto = monto - totalpedido;
        $('#idvuelto').text(vuelto);
        $('#idbtnPagar').attr('disabled', false);
    } else {
        $('#idbtnPagar').attr('disabled', true);
        $('#MsgError').text("El monto ingresado no supera al total.");
    }
};
function func_guardarVenta() {
    var monto = $("#idPMonto").val();
    $.ajax({
        type: "GET",
        url: "GuardarVenta?monto="+monto,
        contentType: "application/json; charset=utf-8",
        async: false,
        success: function (data) {
            $('#idModalPagos').modal('toggle');
            $('#idContDetalleBoleta').html("");
            swal("NazcaSoft", "Se ha generado esta venta.", "success");
            met_buscarMesas(); 
        },
        error: function (result) {
            alert("Error: " + result);
        }
    });

}
;