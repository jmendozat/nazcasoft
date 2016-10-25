<%-- 
    Document   : viewPlatos
    Created on : 01-oct-2016, 11:54:06
    Author     : <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
--%>

<%@page import="modelo.Plato"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
   List<Plato> listaPlatos = (List<Plato>)request.getAttribute("listViewPlatos");
%>
   <%
                    for (Plato plato : listaPlatos) {
                %>
                <div class="col-md-3">
                    <div class="ibox">
                        <div class="ibox-content product-box">

                             <% 
                         if(plato.getUrlfoto()!= null){
                             %>
                             <div class="product-imitation" style="background-image: url('<%=plato.getUrlfoto()%>'); -webkit-background-size: cover;-moz-background-size: cover;-o-background-size: cover;background-size: cover;"></div>
                             <%
                         }else{
                            %>
                            <div class="product-imitation" style="background-color: #f8f8f9;"></div>
                             <%
                            }
                        %>
                            
                            <div class="product-desc">
                                <span class="product-price">
                                    S/<%=plato.getPrecio()%>0
                                </span>
                                <small class="text-muted">Menu</small>
                                <a href="#" class="product-name"><%=plato.getNombre()%></a>
                                <div class="small m-t-xs">
                                    <%=plato.getDescripcion()%>                              
                                </div>
                                <div class="m-t text-righ">
                                    <a href="javascript:void(0)" onclick="mostrarFormAgregar(<%=plato.getPlatoid()%>, '<%=plato.getNombre()%>');" class="btn btn-xs btn-outline btn-primary"><i class="fa fa-shopping-cart"></i> </a>                               
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <%
                    }
                %>