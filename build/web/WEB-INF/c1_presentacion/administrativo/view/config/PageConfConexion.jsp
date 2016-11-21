<%-- 
    Document   : PageConfConexion
    Created on : 28-oct-2016, 14:11:07
    Author     : <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
--%>

<%@page import="c3_dominio.administrativo.entidad.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Conexion conexion = (Conexion) request.getAttribute("conexion");
%> 
 <div class="row">
            <div class="col-lg-7">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>Configuración <small>Conexion de Base de Datos</small></h5>
                    </div>
                    <div class="ibox-content">
                        <div class="row">
                            <div class="col-sm-6 b-r"><h3 class="m-t-none m-b">Conexión</h3>
                                <p>Gestione su gestor de Base de datos</p>
                                <form role="form" action="GuardarConexion" method="POST">
                                    <div class="form-group"><label>Usuario</label> <input type="text" name="tusuario" placeholder="Usuario" class="form-control" value="<%=conexion.getUsuario()%>"></div>
                                    <div class="form-group"><label>Password</label> <input type="password" name="" placeholder="Password" class="form-control" value="<%=conexion.getPassword()%>"></div>                    
                                    <div class="form-group"><label>Servidor</label> <input type="text" name="tservidor" placeholder="Servidor" class="form-control" value="<%=conexion.getServidor()%>"></div>
                                    <div class="form-group"><label>Puerto</label> <input type="text" name="tpuerto" placeholder="Puerto" class="form-control" value="<%=conexion.getPuerto()%>"></div>
                                    <div class="form-group"><label>Base de datos</label> <input type="text" name="tbased" placeholder="BD" class="form-control" value="<%=conexion.getBaseDatos()%>"></div>
                                    <div class="form-group"><label>Fabrica</label> <input type="text" placeholder="Fabrica" name="tfabrica" class="form-control" value="<%=conexion.getFabrica()%>"></div>
                                    <div>
                                        <button class="btn btn-sm btn-primary pull-right m-t-n-xs" type="submit"><strong>Guardar</strong></button>                                   
                                    </div>
                                </form>
                            </div>
                            <div class="col-sm-6"><h4>Aviso!</h4>
                                <p>Se procedera a reiniciar el sistema al guardar.</p>
                                <p class="text-center">
                                    <a href="#"><i class="fa fa-database big-icon"></i></a>
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
               
 
 </div>
            

