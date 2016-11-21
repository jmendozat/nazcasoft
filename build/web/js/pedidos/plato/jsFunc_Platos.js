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

function met_guardarplato() {
    var nombrePlato,
            precioPlato,
            descripcion,
            urlfoto;
    nombrePlato = $("#idNombrePlato").val();
    precioPlato = $("#idPrecioPlato").val();
    descripcion = $("#idDescripcionPlato").val();
    urlfoto = $("#idurlFoto").val();

    $.ajax({
        type: "GET",
        url: "InsertarPlato?nombre=" + nombrePlato + "&precio=" + precioPlato + "&descripcion=" + descripcion + "&urlfoto=" + urlfoto,
        contentType: "application/json; charset=utf-8",
        async: false,
        success: function (data) {
            $('#modNewPlato').modal('toggle');
            $("#idNombrePlato").val("");
            $("#idPrecioPlato").val("");
            $("#idDescripcionPlato").val("");
            $("#idurlFoto").val("");
            buscarPlatos();
            swal("NazcaSoft", "Se ha registrado el plato exitosamente.", "success");
            load_csscheck();
        },
        error: function (result) {
            alert("Error de comunicación de datos");
        }
    });
}
function mod_eliminar() {
    var arrayIds = new Array();
    var cantIds;
    arrayIds = $('input[name="orderBox[]"]').serializeArray();
    cantIds = arrayIds.length;
    if (cantIds > 0) {
        swal({
            title: "¿Desea eliminar ["+cantIds+"] registros?",
            text: "Si el plato existe en un pedido no se podra eliminar!",
            type: "warning",
            showCancelButton: true,
            confirmButtonClass: "btn-danger",
            confirmButtonText: "Si, Eliminar!",
            cancelButtonText: "No, Cancelar!",
            closeOnConfirm: false,
            closeOnCancel: false
        },
                function (isConfirm) {
                    if (isConfirm) {
                        for (var i = 0; i < arrayIds.length; i++) {
                            $.ajax({
                                type: "GET",
                                url: "EliminarPlato?platoid=" + arrayIds[i].value,
                                contentType: "application/json; charset=utf-8",
                                async: false,
                                success: function (data) {

                                },
                                error: function (result) {
                                    swal("Ups!", "Lo sentimos ha ocurrido un error de comunicación.", "danger");
                                }
                            });
                        }
                        buscarPlatos();
                        swal("Eliminado(s)!", "Lo registros seleccionados han sido eliminados.", "success");
                        load_csscheck();
                    }else{
                        swal("Cancelado", "Tu proceso de eliminación ha sido cancelado.", "error");
                    }
                });
    } else {
        swal("NazcaSoft", "Debe seleccionar un registro.", "warning");
    }
}
;

function mod_modificar() {
    var arrayIds = new Array();
    var cantIds,
            idPlato;
    arrayIds = $('input[name="orderBox[]"]').serializeArray();
    cantIds = arrayIds.length;

    if (cantIds > 0) {
        if (cantIds === 1) {
            for (var i = 0; i < arrayIds.length; i++) {
                idPlato = arrayIds[i].value;
                $.ajax({
                    type: "GET",
                    url: "ConsultarPlato?platoid=" + idPlato,
                    contentType: "application/json; charset=utf-8",
                    async: false,
                    success: function (data) {
                        $("#modModPlato").html(data);
                        $('#modModPlato').modal('show');
                    },
                    error: function (result) {
                         swal("Ups!", "Lo sentimos ha ocurrido un error de comunicación.", "danger");
                    }
                });
            }
        } else {
            swal("NazcaSoft", "Debe seleccionar solo un registro.", "warning");
        }
    } else {
       swal("NazcaSoft", "Debe seleccionar un registro.", "warning");
    }
}
;

function buscarPlatos() {
    var valorBusqueda;
    progressbar('idLoadPlatos');
    $("#idContPlatos").html("");
    $("#idLoadPlatos").show();
    valorBusqueda = $("#textDescSearch").val();
    $.ajax({
        type: "GET",
        url: "ConsultarPlatos?nombreplato=" + valorBusqueda,
        contentType: "application/json; charset=utf-8",
        async: false,
        success: function (data) {
            $('#idLoadPlatos').hide();
            $("#idContPlatos").html(data);
            load_csscheck();
        },
        error: function (result) {
           swal("Ups!", "Lo sentimos ha ocurrido un error de comunicación.", "danger");
        }
    });
}

function func_verImgPlato(rutaImg) {
    $.ajax({
        type: "GET",
        url: "ViewImgPlato",
        contentType: "application/json; charset=utf-8",
        async: false,
        success: function (data) {
            $("#modIdVerPlato").html(data);
            $('.imgPlato').html('  <img src="' + rutaImg + '" width="540px" height="400px" style="-webkit-background-size: cover;-moz-background-size: cover;-o-background-size: cover;background-size: cover;"/>');
            $('#modIdVerPlato').modal('show');
        },
        error: function (result) {
           swal("Ups!", "Lo sentimos ha ocurrido un error de comunicación.", "danger");
        }
    });
}
;

function cargarEstadosMod() {
    var jsonEstado = {"d": [
            {
                "name": "EN CARTA",
                "value": "EN CARTA"
            },
            {
                "name": "POR AGOTARCE",
                "value": "POR AGOTARCE"
            }, {
                "name": "AGOTADO",
                "value": "AGOTADO"
            }
        ]
    };
    var estadoplato = $("#idEstado").find('option:selected').val();
    ;

    for (let estado of jsonEstado.d){
        if (estado.name !== estadoplato) {
            $('#idEstado').append('<option value"' + estado.value + '">' + estado.name + '</option>');
        }
    }
}
;

function met_guardarEditPlato() {
    var nombrePlato,
            precioPlato,
            idPlato,
            descripcion,
            urlfoto,
            estado;
    nombrePlato = $("#idENombrePlato").val();
    precioPlato = $("#idEPrecioPlato").val();
    idPlato = $("#idPlato").val();
    descripcion = $("#idENDescripcionPlato").val();
    urlfoto = $("#idENurlFoto").val();
    estado = $("#idEstado").find('option:selected').val();

    $.ajax({
        type: "GET",
        url: "ModificarPlato?platoid=" + idPlato + "&nombre=" + nombrePlato + "&precio=" + precioPlato + "&descripcion=" + descripcion + "&urlfoto=" + urlfoto + "&estado=" + estado,
        contentType: "application/json; charset=utf-8",
        async: false,
        success: function (data) {
            $('#modModPlato').modal('toggle');
            buscarPlatos();
            swal("NazcaSoft", "Se ha modificado el plato exitosamente.", "success");
            load_csscheck();
        },
        error: function (result) {
            swal("Ups!", "Lo sentimos ha ocurrido un error de comunicación.", "danger");
        }
    });

}




