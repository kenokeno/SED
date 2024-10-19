<%-- 
    Document   : inicio
    Created on : 21/09/2012, 03:06:49 PM
    Author     : MOY
--%>
<%@page  session="true" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!-- RichFaces tag library declaration -->
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Jefe Carrera</title>
        <link href="../Recursos/CSS/estilos.css" rel="stylesheet" type="text/css" />
<script type="text/javascript"  src="../Recursos/JS/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="../Recursos/JS/muestra-informacion.js"></script> 
<script type="text/javascript" src="../Recursos/JS/JQuery-MOY.js"></script>
    </head>
    <body>
     <f:view>
         <center>
            <header>
            <div id="titulo">
                <h1> Sistema de Examenes Departamentales</h1>
            </div>
            <div id="usuario">
                <h1>Jefe de Carrera</h1>
                <h2><% out.print(session.getAttribute("login")); %></h2>
            </div>
            <div id="logo">
              <img src="../Recursos/imagenes/logo_itspa.png"/>
            </div>
            </header><br />
            <div class="slider" >
                <ul>
                    <li><a id="a2" href="#" >Casa</a></li>
                    <li><a href="#">Examenes</a>
                        <ul>
                            <li><a id="a1" href="#">Revision</a></li>                               
                        </ul>
                    </li>
                    <li><a id="a1" href="javascript:pedirDatos('../Administrador/perfil.jsp','targetDiv')">Perfil</a></li>
                </ul>
            </div>
            <div id="cuerpo">
                <div id="contenido"><br />
                    <div id="targetDiv">
                        <p> aqui va el contenido ok.OK.</p>
                   </div>
                </div>
            </div>

            </center>
     </f:view> 

    </body>
</html>
