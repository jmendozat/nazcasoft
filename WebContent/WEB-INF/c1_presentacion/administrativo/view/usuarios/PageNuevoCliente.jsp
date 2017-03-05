<%-- 
    Document   : PageNuevoUsuario
    Created on : 27-sep-2016, 0:32:17
    Author     : <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>


    <!-- Mirrored from webapplayers.com/inspinia_admin-v2.5/register.html by HTTrack Website Copier/3.x [XR&CO'2014], Thu, 31 Mar 2016 13:44:44 GMT -->
    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>INSPINIA | Register</title>

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="font-awesome/css/font-awesome.css" rel="stylesheet">
        <link href="css/plugins/iCheck/custom.css" rel="stylesheet">
        <link href="css/animate.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">

    </head>

    <body class="gray-bg">
        <%
            String success = (String) request.getAttribute("success");
            String danger = (String) request.getAttribute("danger");
            if (success != null) {
        %>
        <div class="alert alert-success"><%=success%></div>
        <%
            }
            if (danger != null) {
        %>
        <div class="alert alert-danger"><%=danger%></div>
        <%
            }
        %>

        <div class="middle-box text-center loginscreen   animated fadeInDown">
            <div>
                <div>

                    <h1 class="logo-name">NS</h1>

                </div>
                <h3>Crear Cuenta</h3>
                <p>Administra tus pedidos con la tienda virtual.</p>
                <form class="m-t" role="form" action="RegistrarCliente" method="POST">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Nombres" name="nombres" required="" autofocus="">
                    </div>
                    <div class="form-group">
                        <input type="email" class="form-control" placeholder="Email" name="correo" required="">
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" placeholder="Contraseña" name="password" required="">
                    </div>
                    <div class="form-group">
                        <div class="checkbox i-checks"><label> <input type="checkbox" id="idCheckTerminos"><i></i> De acuerdo en los términos y política</label></div>
                    </div>
                    <button type="submit" class="btn btn-primary block full-width m-b" id="idbtnRegistrar">Registrar</button>

                    <p class="text-muted text-center"><small>Ya tienes una cuenta?</small></p>
                    <a class="btn btn-sm btn-white btn-block" href="Login">Ingresa</a>
                </form>
                <p class="m-t"> <small>Prototipo web NazcaSoft por <a href="#"> Lain Cardenas </a>&copy; 2015</small><br><small>Mantenimiento preventivo y correctivo de Software por  <a href="#"> Valentin Mendoza </a>&copy; 2016</small> </p>
            </div>
        </div>

        <!-- Mainly scripts -->
        <script src="js/jquery-2.1.1.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <!-- iCheck -->
        <script src="js/plugins/iCheck/icheck.min.js"></script>
        <script type="text/javascript">
            $(function () {
                $('.i-checks').iCheck({
                    checkboxClass: 'icheckbox_square-green',
                    radioClass: 'iradio_square-green',
                });

                $('#idbtnRegistrar').attr('disabled', true);
                
                $('input').on('ifChecked', function (event) {
                     $('#idbtnRegistrar').attr('disabled', false);
                });
                $('input').on('ifUnchecked', function (event) {
                   $('#idbtnRegistrar').attr('disabled', true);
                });


            });

        </script>
    </body>


    <!-- Mirrored from webapplayers.com/inspinia_admin-v2.5/register.html by HTTrack Website Copier/3.x [XR&CO'2014], Thu, 31 Mar 2016 13:44:44 GMT -->
</html>
