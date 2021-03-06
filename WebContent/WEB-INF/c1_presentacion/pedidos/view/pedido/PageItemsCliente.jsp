<%-- 
    Document   : PageItemsCliente
    Created on : 30-sep-2016, 22:52:36
    Author     : <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
--%>

<%@page import="java.util.List"%>
<%@page import="c3_dominio.administrativo.entidad.Persona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<Persona> listaPersona = (List<Persona>) request.getAttribute("listClientes");
%>
<input hidden="true" id="idIdAntCli" />
<div class="full-height-scroll">
    <div class="table-responsive">
        <table class="table table-striped table-hover">
            <tbody>
                <%
                    for (Persona cliente : listaPersona) {     
                %>
                <tr id="idClient<%=cliente.getCodigo()%>" onclick="func_agregarid(<%=cliente.getCodigo()%>);">
                    <td class="client-avatar"><img alt="image" src="<%=cliente.getUrlfotoperfil()%>"><input  hidden="true" id="idCliente" value="<%=cliente.getCodigo()%>"/> </td>
                    <td><a data-toggle="tab" href="#contact-1"  class="client-link"><%=cliente.getNombre()%></a></td>                
                    <td class="client-status"><span class="label label-primary" id="idSelected<%=cliente.getCodigo()%>"></span></td>
                </tr>
                  <%
                    }
                %>

            </tbody>
        </table>
    </div>
</div>

<script type="text/javascript">
    $(function () {
        load_csscheck();

        $('#idLinkCliente').on("click", function () {
            $('#ids').text("Selecionado");

        });

    });
</script>