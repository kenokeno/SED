<%-- 
    Document   : perfil
    Created on : 26/09/2012, 04:00:53 PM
    Author     : MOY
--%>

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
        <title>Usuarios</title>
        <link href="../Recursos/CSS/estilos.css" rel="stylesheet" type="text/css" />
    </head>
    <body >
        <f:view>
            <div class="contenido">
                <center>
                    <h1>Nuevo Usuario</h1>
                    <a4j:form id="nuevoUsuario">
                        <table  width="210" border="0">
                            <tr >
                                <td rowspan="9" width="230px"><img width="80px" height="100px" src="../Recursos/imagenes/candado.png" /></td>
                                <td width="115">Nombre:</td>
                                <td width="69"><h:inputText id="nombre" size="30" title="Su nombre" value="#{administrador.nuevoNombre}" /></td>
                            </tr>
                            <tr>
                                <td width="115">Apellido Paterno:</td>
                                <td width="69"><h:inputText  id="paterno" size="30" title="Paterno" value="#{administrador.nuevoAPaterno}"/></td>
                            </tr>
                            <tr>
                                <td width="115">Apellido Materno:</td>
                                <td width="69"><h:inputText  id="Materno" size="30" title="Materno" value="#{administrador.nuevoAMaterno}"/></td>
                            </tr>
                            <tr>
                                <td width="115">Clave: </td>
                                <td width="69"><h:inputText disabled="" id="clave" size="30" maxlength="5" title="Clave" value="#{administrador.nuevoClave}"/></td>
                            </tr>
                            <tr>
                                <td width="115">Nombre de Usuario: </td>
                                <td width="69"><h:inputText disabled="" id="nomreUsuario" size="30" maxlength="15" title="Nombre de Usuario" value="#{administrador.nuevoNombreUsuario}"/></td>
                            </tr>
                            <tr>

                                <td>Contraseña:</td>
                                <td><h:inputText  id="pass" size="30" title="Su Contraseña" value="#{administrador.nuevoPassword}"/></td>
                            </tr>
                            <tr>
                                <td width="115">Mail:</td>
                                <td width="69"><h:inputText  id="Mail" size="30" title="Mail" value="#{administrador.nuevoMail}"/></td>
                            </tr>
                            <tr>
                                <td width="115">Foto:</td>
                                <td width="69"><h:inputText  id="Foto" size="30" title="Foto" value="#{administrador.nuevoFoto}"/></td>
                            </tr>
                            <tr>
                                <td width="115">Profecion:</td>
                                <td width="69"><h:inputText   onclick="habilitar(this)" tabindex="uno" id="Profecion" size="30" title="Profecion" value="#{administrador.nuevoProfecion}"/></td>
                            </tr>
                            <tr>
                                <td>&nbsp;</td>
                                <td>&nbsp;</td>
                            </tr>
                            <tr>
                                <td align="center" colspan="3">
                                    <a4j:commandButton value="Guardar"
                                                       styleClass="Button" 
                                                       title="Guardar"
                                                       action= "#{administrador.nuevoUsuario()}" 
                                                       oncomplete="javascript:pedirDatos('../Administrador/usuarios.jsp','targetDiv')">
                                    </a4j:commandButton>
                                </td>
                            </tr>
                        </table>
                    </a4j:form>
                </center>
            </div>       
        </f:view>
    </body>
</html>
