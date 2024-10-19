<%-- 
    Document   : inicio
    Created on : 21/09/2012, 03:06:49 PM
    Author     : MOY
--%>
<%@page  session="true" %>
<%@page import="javax.faces.context.FacesContext"%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!-- RichFaces tag library declaration -->
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Administrador</title>
        <link href="../Recursos/CSS/estilos.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript"  src="../Recursos/JS/jquery-1.8.2.min.js"></script>
        <script type="text/javascript" src="../Recursos/JS/muestra-informacion.js"></script> 
        <script type="text/javascript" src="../Recursos/JS/JQuery-MOY.js"></script>
        <script type="text/javascript" src="../Recursos/JS/jquery.displaytag-ajax-1.2.js"></script> 
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
                        <h1>Administrador</h1>
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
                    <li><a id="a2"  href="#" >Casa</a></li>
                    <li><a href="#" >Catalogo</a>
                        <ul>
                            <li><h:form id="a1"><a4j:commandLink  actionListener="#{administrador.manage('usuarios')}">Usuarios</a4j:commandLink></h:form></li>
                            <li><h:form id="b1"><a4j:commandLink  actionListener="#{administrador.manage('carreras')}">Carreras</a4j:commandLink></h:form></li>
                            <li><h:form id="c1"><a4j:commandLink  actionListener="#{administrador.manage('profesiones')}">Profesiones</a4j:commandLink></h:form></li>
                            <li><h:form id="d1"><a4j:commandLink  actionListener="#{administrador.manage('claves')}">Claves</a4j:commandLink></h:form></li>
                        </ul>
                    </li>
                    <li><h:form id="e1"><a4j:commandLink actionListener="#{administrador.manage('perfil')}">Perfil</a4j:commandLink></h:form></li>
                </ul>
            </div>
            <div id="cuerpo">
                <div id="contenido"><br />
                    <a4j:outputPanel ajaxRendered="true">
                        <a4j:page>
                            <a4j:include id="vista" viewId="#{administrador.bean}"/>
                        </a4j:page>
                    </a4j:outputPanel>
                </div>
            </div>
        </center>
    </f:view> 
</body>
</html>