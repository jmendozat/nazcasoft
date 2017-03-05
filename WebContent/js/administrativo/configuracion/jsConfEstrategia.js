function modificarEstrategia() {
    var idEstrategia="DescuentoAFavorDelnegocio";
    $.ajax({
        type: "GET",
        url: "ModificarEstrategia?idestrategia=" + idEstrategia,
        contentType: "application/json; charset=utf-8",
        async: false,
        success: function (data) {
            console.log("Se ha cambiado de estrategia");
        },
        error: function (result) {
            swal("Ups!", "Lo sentimos ha ocurrido un error de comunicación.", "danger");
        }
    });

}
;


