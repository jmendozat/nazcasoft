<%-- 
    Document   : Login
    Created on : 26-sep-2016, 22:58:57
    Author     : <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>NazcaSoft | Login</title>

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="font-awesome/css/font-awesome.css" rel="stylesheet">

        <link href="css/animate.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
    </head>

    <body class="gray-bg">

        <div class="middle-box text-center loginscreen animated fadeInDown">
            <div>
                <div>

                    <h1 class="logo-name">NS</h1>

                </div>
                <h3>Bienvenido a NazcaSoft</h3>
                <p>Un restaurante al alcance de todos.
                </p>
                <p>Acceso al sistema</p>
                <form class="m-t" role="form" action="Login" method="POST">
                    <div class="form-group">
                        <input type="email" class="form-control" placeholder="Email" name = "txtUsuario" required="" autofocus="">
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" placeholder="Contraseña" name="txtPassword" required="">
                    </div>
                    <button type="submit" class="btn btn-primary block full-width m-b">Entrar</button>

                    <a href="index.jsp"><small>¿Olvidaste tú constraseña?</small></a>
                   <p class="text-muted text-center"><small>¿Aun no tienes tú cuenta?</small></p>
                   <a class="btn btn-sm btn-white btn-block" href="NuevoCliente">Crea una cuenta</a>
                </form>
                <p class="m-t"> <small>Sistema de adminsitración by <a href="#"> Lain Cardenas </a>&copy; 2015</small> </p>
            </div>
        </div>

        <!-- Mainly scripts -->
        <script src="js/jquery-2.1.1.js"></script>
        <script src="js/bootstrap.min.js"></script>

    </body>
</html>
