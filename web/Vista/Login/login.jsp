<%-- 
    Document   : login
    Created on : 20/09/2012, 01:26:19 PM
    Author     : MOY
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!-- RichFaces tag library declaration -->
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%--
    This file is an entry point for JavaServer Faces application.
--%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="../Recursos/CSS/estilos.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <f:view>
        <center>
        <header>
            <div >
                <img src="../Recursos/imagenes/logo_itspa.png"/>
            </div>
            <div id="titulo">
                <h1><h:outputText value="Sistema de Examenes Departamentales"/></h1>
            </div>
        </header>
        
        <div id="inicio">
            <h:form id="log" onsubmit="return validaLogin()">
                <table class="tab-login" width="210" border="0">
                    <tr><td></td><td><h:messages/></td></tr>
                    <tr >
                        <td rowspan="4" width="230"><img width="60px" height="80px" src="../Recursos/imagenes/candado.png" /></td>
                        <td width="115">Clave: </td>
                        <td width="69"><h:inputText id="usuario" size="10" title="Su nombre de usuario" 
                                     required="true" value="#{login.nombreUsuario}"/></td>
                    </tr>
                    <tr>

                        <td>Password:</td>
                        <td><h:inputSecret id="pass" size="20" maxlength="20"  required="true" 
                                       title="Su contraseña" value="#{login.password}"/></td>
                    </tr>
                    <tr>

                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr>
                        <td align="center" colspan="2">
                            <h:commandButton id="entrar"  value="Entrar"
                                             styleClass="Button" title="Iniciar sesión"
                                             action="#{login.validar()}" />
                            <h:commandButton type="reset" value="Limpiar" /></td>
                    </tr>
                </table>
            </h:form>
        </div>
        <div id="pie">
            <p> REGISTRO. Si no tienes cuenta consulta al administrador del sitio. </p>
        </div>
    </center>
    </f:view>
</body>
</html>