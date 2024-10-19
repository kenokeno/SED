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
        <title>Docente</title>
        <link href="../Recursos/CSS/estilos.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript"  src="../Recursos/JS/jquery-1.8.2.min.js"></script>
        <script type="text/javascript" src="../Recursos/JS/muestra-informacion.js"></script> 
        <script type="text/javascript" src="../Recursos/JS/JQuery-MOY.js"></script>
        <script language="javascript" type="text/javascript">
            $( function(){
                $("#displayTagDiv").displayTagAjax();
            })
            function abrir(){
                
            }
        </script>

    </head>
    <body>
        <f:view>
        <center>
            <header>
                <div id="titulo">
                    <h1> Sistema de Examenes Departamentales</h1>
                </div>
                <div id="usuario">
                    <h:form>
                        <h1>Docente</h1>
                        <h2><% out.print(session.getAttribute("login"));%></h2>                        
                        <h2><h:commandLink action="#{sesion.logout()}">Salir</h:commandLink></h2>
                        <%@include  file="../Login/redireccionar.jsp" %>
                    </h:form>
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
                            <li><h:form id="a1"><a4j:commandLink actionListener="#{docente.manage('gestion')}">Gestion</a4j:commandLink></h:form></li>
                            <li><a id="a1" href="#">Revision</a></li>
                            <li><a  href="#">Estatus</a>
                                <ul>
                                    <li><a id="a1" href="#">Aprobados</a></li>
                                    <li><a id="a1" href="#">Pendientes</a></li>
                                    <li><a id="a1" href="#">Rechazados</a></li>
                                </ul>
                            </li>
                        </ul>
                    </li>
                    <li><h:form id="e1"><a4j:commandLink actionListener="#{docente.manage('perfil')}">Perfil</a4j:commandLink></h:form></li>
                </ul>
            </div>
            <div id="cuerpo">
                <div id="contenido"><br />
                    <a4j:outputPanel ajaxRendered="true">
                        <a4j:page>
                            <a4j:include id="vista" viewId="#{docente.bean}"/>
                        </a4j:page>
                    </a4j:outputPanel>
                </div>
            </div>
        </center>
    </f:view>        
</body>
</html>
