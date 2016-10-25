<%-- 
    Document   : IndexPlatos
    Created on : 14-sep-2016, 10:10:12
    Author     : <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/plugins/iCheck/custom.css" rel="stylesheet">
        <!-- iCheck -->
        <script src="js/plugins/iCheck/icheck.min.js"></script>

        <script src="Modulos/Pedidos/Platos/js/jsFunc_Platos.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="row">

            <div class="col-lg-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>Gestión de Platos </h5>
                    </div>
                    <div class="ibox-content">
                        <div class="row">
                            <div class="col-sm-9 m-b-xs">
                                <div data-toggle="buttons" class="btn-group">
                                    <button type="button" class="btn btn-white" data-toggle="modal" data-target="#modNewPlato"><i class="fa fa-plus"></i> Nuevo</button>
                                    <button type="button" class="btn btn-white" onclick="mod_modificar();"><i class="fa fa-edit"></i></button>
                                    <button type="button" class="btn btn-white" onclick="mod_eliminar();" ><i class="fa fa-trash-o"></i></button>                     
                                </div>
                            </div>
                            <div class="col-sm-3">
                                <div class="input-group"><input type="text" placeholder="Buscar" class="input-sm form-control" id="textDescSearch"> <span class="input-group-btn">
                                        <button type="button" class="btn btn-sm btn-primary" onclick="buscarPlatos();"> Go!</button> </span></div>
                            </div>
                        </div>
                        <div class="table-responsive">
                            <div id="idLoadPlatos"></div>
                            <div id="idContPlatos"></div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
        <div class="modal inmodal" id="modNewPlato" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content animated bounceInRight">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Cerrar</span></button>                    
                        <h4 class="modal-title">  <i class="fa fa-cutlery"></i> Nuevo Plato</h4>
                        <small class="font-bold">Registro general de platos del restaurante NazcaSoft</small>
                    </div>
                    <div class="modal-body">
                        <p><strong>Aviso!</strong> debe registrar especialmente los platos denominados a la carta o menu, recuerde registrar de manera adecuada.</p>

                        <div class="form-group">
                            <label>Nombre</label> 
                            <input type="text" placeholder="Ingrese el nombre" id="idNombrePlato" class="form-control" required="required" autofocus="autofocus">
                            <label>Descripción</label> 
                            <input type="text" placeholder="Ingrese una descripción" id="idDescripcionPlato" class="form-control" required="required" >
                            <label>URL Foto</label> 
                            <input type="text" placeholder="Url de la Foto" id="idurlFoto" class="form-control" required="required" >
                            <label>Precio</label> 
                            <input type="text" placeholder="Ingrese el precio" id="idPrecioPlato" class="form-control" required="required">
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-white" data-dismiss="modal">Cancelar</button>
                        <input type="button" class="btn btn-primary" onclick="met_guardarplato();" value="Guardar"/>
                    </div>
                </div>
            </div>
        </div>
        <div class="modal inmodal" id="modModPlato" tabindex="-1" role="dialog" aria-hidden="true">

        </div>
        <script type="text/javascript">
            $(function () {
                buscarPlatos();
                load_csscheck();

            });
        </script>

    </body>
</html>
