<%-- 
    Document   : PaginaEditarPlato
    Created on : 15-feb-2015, 20:55:45
    Author     : Lain
--%>

<%@page import="modelo.Plato" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>NazcaSoft</title>
    </head>
    <body>

        <%
            Plato plato = (Plato) request.getAttribute("plato");
        %>
        <div class="modal-dialog">
            <div class="modal-content animated bounceInRight">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Cerrar</span></button>                  
                    <h4 class="modal-title"><i class="fa fa-cutlery"></i> Modificar Plato</h4>
                    <small class="font-bold">Registro general de platos del restaurante NazcaSoft</small>
                </div>
                <div class="modal-body">
                    <p><strong>Aviso!</strong> debe modificar especialmente los platos denominados a la carta o menu, recuerde registrar de manera adecuada.</p>

                    <div class="form-group">
                        <input hidden="true" value="<%= plato.getPlatoid()%>" id="idPlato">
                        <label>Nombre</label> 
                        <input type="text" placeholder="Ingrese el nombre" id="idENombrePlato" value="<%= plato.getNombre()%>" class="form-control" required="required">
                        <label>Descripción</label> 
                        <input type="text" placeholder="Ingrese una descripción" id="idENDescripcionPlato" value="<%=plato.getDescripcion()%>" class="form-control" required="required" >
                        <label>URL Foto</label> 
                        <input type="text" placeholder="Url de la Foto" id="idENurlFoto" value="<%=plato.getUrlfoto()%>"class="form-control" required="required" >
                        <label>Estado Plato</label> 
                        <select id="idEstado"  class="form-control m-b">
                            <option value="<%=plato.getEstado()%>"><%=plato.getEstado()%></option>
                        </select>
                        <label>Precio</label> 
                        <input type="text" placeholder="Ingrese el precio" id="idEPrecioPlato" value="<%= plato.getPrecio()%>"class="form-control" required="required">

                    </div>
                    <%
                        String mensaje = (String) request.getAttribute("mensaje");
                        if (mensaje != null) {%>
                    <font style="color: red"><%=mensaje%></font>
                    <% }%>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-white" data-dismiss="modal">Cancelar</button>
                    <input type="button" class="btn btn-primary" onclick="met_guardarEditPlato();" value="Guardar"/>
                </div>
            </div>
        </div>
        <script type="text/javascript">
            $(function () {
                cargarEstadosMod();
            });
        </script>
    </body>
</html>
