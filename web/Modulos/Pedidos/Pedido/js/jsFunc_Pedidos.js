/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function load_csscheck() {
    $('.i-checks').iCheck({
        checkboxClass: 'icheckbox_square-green',
        radioClass: 'iradio_square-green',
    });
}
function func_vModalAddPlatos() {
    $.ajax({
        type: "GET",
        url: "Modulos/Pedidos/Pedido/PageAddPlato.jsp",
        contentType: "application/json; charset=utf-8",
        async: false,
        success: function (data) {
            $("#idModalAddPlato").html(data);
            $('#idModalAddPlato').modal('show');
        },
        error: function (result) {
            alert("Error: " + result);
        }
    });
}
;
function func_vModalNewPedido(idmesa) {
    var idAnterior = $("#idIdAnterior").val();
    $("#idSelect" + idAnterior).html("");
    $.ajax({
        type: "GET",
        url: "GestionarPedido?mesaid=" + idmesa,
        contentType: "application/json; charset=utf-8",
        async: false,
        success: function (data) {
            $("#idContDetalleBoleta").html("");
            $("#idModalNewPedido").html(data);
            $('#idModalNewPedido').modal('show');
            $("#idSelect" + idmesa).html('<i class="fa fa-check text-navy"></i>');
            $("#idIdAnterior").val(idmesa);
        },
        error: function (result) {
            alert("Error: " + result);
        }
    });
}
;
function func_MostrarItemsPlato() {
    $("#idContItemPedido").html("");
    $.ajax({
        type: "GET",
        url: "Modulos/Pedidos/Pedido/PageItemsPedido.jsp",
        contentType: "application/json; charset=utf-8",
        async: false,
        success: function (data) {
            $("#idContItemPedido").html(data);
        },
        error: function (result) {
            alert("Error: " + result);
        }
    });

}
;
function func_BuscarClientes() {
    var descCliente = $('#idTxtDescCliente').val();
    progressbar('idProgresBarCliente');
    $("#idContResultClientes").html("");
    $("#idProgresBarCliente").show();
    $.ajax({
        type: "GET",
        url: "ConsultarClientes?descCliente="+descCliente,
        contentType: "application/json; charset=utf-8",
        async: false,
        success: function (data) {
            $('#idProgresBarCliente').hide();
            $("#idContResultClientes").html(data);
        },
        error: function (result) {
            alert("Error: " + result);
        }
    });

}
;

function func_buscarPlatos() {
    var valorBusqueda;
    valorBusqueda = $("#idTxtDescPlato").val();
    progressbar('idProgresBarPlatos');
    $("#idContResultados").html("");
    $("#idProgresBarPlatos").show();
    $.ajax({
        type: "GET",
        url: "BuscarPlatos?nombreplato=" + valorBusqueda,
        contentType: "application/json; charset=utf-8",
        async: false,
        success: function (data) {
            $('#idProgresBarPlatos').hide();
            $("#idContResultados").html(data);

            func_calsubtotal();
        },
        error: function (result) {
            alert("Error: " + result);
        }
    });
}
;

function met_buscarMesas() {
    var valorBusqueda;
    progressbar('idProMesas');
    $("#idContenedorMesas").html("");
    $("#idProMesas").show();
    valorBusqueda = $("#idTxtNombre").val();
    $.ajax({
        type: "GET",
        url: "ConsultarMesasDePedido?tipo=15",
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

function met_buscarDetalle(idmesa) {
    progressbar('idProgressDetalle');
    var idAnterior = $("#idIdAnterior").val();
    $("#idSelect" + idAnterior).html("");
    $("#idContDetalleBoleta").html("");
    $("#idProgressDetalle").show();
    $.ajax({
        type: "GET",
        url: "ConsultarPedido?mesaid=" + idmesa,
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
function func_calsubtotal() {
    $("#items").keyup(function (event) {
        $("#items .ibox-content").each(function () {
            var precio = $(this).find(".hprecio").val();
            var cantidad = parseInt($(this).find(".form-control").val());
            var subtotal = precio * cantidad;
            $(this).find(".subtotal").html(subtotal);
        });
    });
}
;

function addPlatoPedido(idPlato) {
    var cantidad = parseInt($("#idcant" + idPlato).val());
    if (cantidad > 0) {
        $.ajax({
            type: "GET",
            url: "AgregarPlato?platoid=" + idPlato + "&cantidad=" + cantidad,
            contentType: "application/json; charset=utf-8",
            async: false,
            success: function (data) {
                alert("Se agrego un nuevo plato al pedido");
                $("#idcant" + idPlato).val("");
                $(".subtotal").html("");
            },
            error: function (result) {
                alert("Error: " + result);
            }
        });
    } else {
        alert("Ingrese la cantidad adecuada");
    }
}
;
function func_actualizarPlatoPedido() {
    $("#itemsplatos").keyup(function (event) {
        $("#itemsplatos .ibox-content").each(function () {
            var idPlato = $(this).find(".idPlatoitem").val();
            var cantidad = parseInt($(this).find("#idcantitem").val());
            if (cantidad > 0) {
                $.ajax({
                    type: "GET",
                    url: "AgregarPlato?platoid=" + idPlato + "&cantidad=" + cantidad,
                    contentType: "application/json; charset=utf-8",
                    async: false,
                    success: function (data) {

                    },
                    error: function (result) {
                        alert("Error: " + result);
                    }
                });
                func_MostrarItemsPlato();
            }
        });
    });

}
;

function func_quitarPlatoPedido(idplatoitem) {
    var deseaEliminar;
    deseaEliminar = confirm("¿Esta seguro de quitar el plato?");
    if (deseaEliminar) {
        $.ajax({
            type: "GET",
            url: "EliminarPlatoDePedido?platoid=" + idplatoitem,
            contentType: "application/json; charset=utf-8",
            async: false,
            success: function (data) {
                alert("Se ha quitado el plato del pedido.");
            },
            error: function (result) {
                alert("Error: " + result);
            }
        });
        func_MostrarItemsPlato();
    }
}
;
function func_DetallePlatos() {
    progressbar('idProgressPlDetail');
    $("#idBDetallePlatos").html("");
    $("#idProgressPlDetail").show();
    $.ajax({
        type: "GET",
        url: "Modulos/Pedidos/Pedido/PageDetallePlatos.jsp",
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

function func_Modguardarpedido() {
    var idCliente = $('#idIdAntCli').val();
    $.ajax({
        type: "GET",
        url: "GuardarPedido?idCliente="+idCliente,
        contentType: "application/json; charset=utf-8",
        async: false,
        success: function (data) {
            $('#idModalAddPlato').modal('toggle');
            swal("NazcaSoft", "Se ha modificado el pedido.", "success");
            func_DetallePlatos();
        },
        error: function (result) {
            alert("Error: " + result);
        }
    });

}
;
function func_guardarpedido() {
    var idCliente = $('#idIdAntCli').val();
    $.ajax({
        type: "GET",
        url: "GuardarPedido?idCliente="+idCliente,
        contentType: "application/json; charset=utf-8",
        async: false,
        success: function (data) {
            $('#idModalNewPedido').modal('toggle');
            swal("NazcaSoft", "Se ha guardado el pedido.", "success");
            met_buscarMesas();
        },
        error: function (result) {
            alert("Error: " + result);
        }
    });

}
;

function func_MostrarItemsCliente() {
    progressbar('progressimtes');
    $("#contIbox").html("");
    $("#progressimtes").show();
    $.ajax({
        type: "GET",
        url: "Modulos/Pedidos/Pedido/PageItemsPedidoCliente.jsp",
        contentType: "application/json; charset=utf-8",
        async: false,
        success: function (data) {
            $('#progressimtes').hide();
            $("#contIbox").html(data);
        },
        error: function (result) {
            swal('Ups!', 'Ha ocurrido un error de comunicación de datos', 'danger');
        }
    });
}
;
function func_mostrarMesas() {
    $.ajax({
        type: "GET",
        url: "ConsultarMesasDePedido?tipo=5",
        contentType: "application/json; charset=utf-8",
        async: false,
        success: function (data) {
            $("#idModalAgregarMesa").html(data);
            $('#idModalAgregarMesa').modal('show');
        },
        error: function (result) {
            alert(result);
        }
    });

}

function func_confirmarpedido() {
    var arrayIds = new Array();
    var cantIds,
            idMesa;
    arrayIds = $('input[name="orderBox[]"]').serializeArray();
    cantIds = arrayIds.length;
    if (cantIds > 0) {
        if (cantIds === 1) {
            for (var i = 0; i < arrayIds.length; i++) {
                idMesa = arrayIds[i].value;
                $.ajax({
                    type: "GET",
                    url: "ConfirmarPedido?idmesa=" + idMesa,
                    contentType: "application/json; charset=utf-8",
                    async: false,
                    success: function (data) {
                        $('#idModalAgregarMesa').modal('toggle');
                        func_MostrarItemsCliente();
                        swal("NazcaSoft", "Se ha generado su pedido", "success");
                    },
                    error: function (result) {
                        alert(result);
                    }
                });
            }
        } else {
            alert("Debe seleccionar solo un registro.");
        }
    } else {
        alert("Debe seleccionar un registro");
    }
}
;

function func_agregarid(idCliente){
    $('#idIdAntCli').val('');
  $('#idIdAntCli').val(idCliente);  
};



