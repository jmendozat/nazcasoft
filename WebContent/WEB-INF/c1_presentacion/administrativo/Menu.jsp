<%-- 
    Document   : Menu
    Created on : 14-sep-2016, 8:23:50
    Author     : <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
--%>
<%@page import="c3_dominio.administrativo.entidad.Persona"%>
<%@page import="c3_dominio.administrativo.entidad.Interface"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<Interface> listaInterface = (List<Interface>) request.getAttribute("listInterface");
    Persona persona = (Persona) request.getSession().getAttribute("sesUsuario");
%> 
<div class="sidebar-collapse">
    <ul class="nav metismenu" id="side-menu">
        <li class="nav-header">
            <div class="dropdown profile-element"> <span>
                    <img alt="image" class="img-circle" src="<%=persona.getUrlfotoperfil()%>" />
                </span>
                <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                    <span class="clear"> <span class="block m-t-xs"> <strong class="font-bold"><%=persona.getNombre()%></strong>
                        </span> <span class="text-muted text-xs block"><%=persona.getTipousuario()%> <b class="caret"></b></span> </span> </a>
                <ul class="dropdown-menu animated fadeInRight m-t-xs">
                    <li><a href="Index">Inicio</a></li>
                    <li><a href="#">Perfil</a></li>
                    <li><a href="#">Contactos</a></li>
                    <li><a href="#">Correo</a></li>
                    <li class="divider"></li>
                    <li><a href="Logout?hr=exit">Salir</a></li>
                </ul>
            </div>
            <div class="logo-element">
                NS
            </div>
        </li>
        <%
            for (Interface interfaces : listaInterface) {
                if (interfaces.getListaInterface().size() > 0) {
        %>
        <li class="lihijas">
            <a href="javascript:void(0)" ><i class="<%= interfaces.getIcondesc()%>"></i> <span class="nav-label"><%=interfaces.getNombreMinus()%></span><span class="fa arrow"></span></a>
            <ul class="nav nav-second-level">
                <%
                    for (Interface interfaceHija : interfaces.getListaInterface()) {
                        if (interfaceHija.getListaInterface().size() > 0) {
                %>
                <li><a href="javascript:void(0)"><%=interfaceHija.getNombreMinus()%><span class="fa arrow"></span></a>
                    <ul class="nav nav-third-level">
                        <%
                            for (Interface interfaceNieta : interfaceHija.getListaInterface()) {
                        %>
                        <li id="idInt<%=interfaceNieta.getCodigoInterface()%>"><a href="javascript:void(0)" onclick="adm_mostrarInterfaz('<%= interfaceNieta.getRuta()%>', '<%=interfaceNieta.getCodigoInterface()%>');"><%=interfaceNieta.getNombreMinus()%></a></li>
                            <%
                                }
                            %>
                    </ul>
                </li>
                <%
                } else {
                %>
                <li id="idInt<%=interfaceHija.getCodigoInterface()%>"><a href="javascript:void(0)" onclick="adm_mostrarInterfaz('<%= interfaceHija.getRuta()%>', '<%=interfaceHija.getCodigoInterface()%>');"><%=interfaceHija.getNombreMinus()%></a></li>
                    <%
                            }
                        }
                    %>

            </ul>
        </li>
        <%
        } else {
        %>
        <li>
            <a href="javascript:void(0)" onclick="adm_mostrarInterfaz('<%= interfaces.getRuta()%>', '<%=interfaces.getCodigoInterface()%>');"><i class="<%= interfaces.getIcondesc()%>"></i> <span class="nav-label"><%=interfaces.getNombreMinus()%></span> </a>
        </li>
        <%
                }
            }
        %>
    </ul>
</div>
<script type="text/javascript">


    function adm_mostrarInterfaz(servlet, idInterfaz) {      
        $('.lihijas li').removeClass();
        $('#idInt' + idInterfaz).addClass("active");
        $("#idContenedor").html("");
        if (servlet !== "#") {
            progressbar('idprogressbar');
            $("#idprogressbar").show();

            $.ajax({
                type: "GET",
                url: servlet,
                contentType: "application/json; charset=utf-8",
                async: false,
                success: function (data) {
                    $('#idprogressbar').hide();
                    $("#idContenedor").html(data);
                },
                error: function (result) {
                    $('#idprogressbar').hide();
                    swal("NazcaSoft", "Ha ocurrido un error de comunicación.", "danger");
                }
            });
        }else{
             swal("NazcaSoft", "Ups! La opción solicitada aún no está implementada. Intente más tarde o comuníquese con el administrador del sistema.", "warning");
        }

    }


</script>

