<%-- 
    Document   : claves
    Created on : 17-dic-2012, 9:07:50
    Author     : alfredo
--%>
<%@page  session="true" %>

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
        <title>Claves</title>
        <script type="text/javascript"  src="../../Recursos/JS/jquery-1.8.2.min.js"></script>
        <script type="text/javascript" src="../../Recursos/JS/jquery.displaytag-ajax-1.2.js"></script> 
        <script type="text/javascript" src="../Recursos/JS/validacion.js"></script> 
        <script language="javascript" type="text/javascript">
            $( function(){
                $("#displayTagDiv").displayTagAjax();
            })
        </script>   
    </head>
    <body>
        <f:subview id="perfil">           
            <div class="contenido" >
                <center>
                    <h1>Perfil</h1>
                    <a4j:form id="form">
                        <table  width="210" border="0">
                            <tr >
                                <td rowspan="9" width="230px"><img width="80px" height="100px" src="../Recursos/imagenes/candado.png" /></td>
                                <td width="115">Nombre:</td>
                                <td width="69"><h:inputText readonly="#{perfil.nombreDisabled}" id="nombre" size="30" title="Su nombre" value="#{perfil.usuario.nombre}" /></td>
                            </tr>
                            <tr>
                                <td width="115">Apellido Paterno:</td>
                                <td width="69"><h:inputText readonly="#{perfil.disabledPaterno}" id="aPaterno" size="30" title="Paterno" value="#{perfil.usuario.APaterno}"/></td>
                            </tr>
                            <tr>
                                <td width="115">Apellido Materno:</td>
                                <td width="69"><h:inputText readonly="#{perfil.disabledMaterno}"  id="aMaterno" size="30" title="Materno" value="#{perfil.usuario.AMaterno}"/></td>
                            </tr>
                            <tr>
                                <td width="115">Clave: </td>
                                <td width="69"><h:inputText readonly="#{perfil.disabledClave}" id="Clave" size="30" title="clave" value="#{perfil.usuario.clave}"/></td>
                            </tr>
                            <tr>
                                <td width="115">Nombre de Usuario: </td>
                                <td width="69"><h:inputText readonly="#{perfil.disabledNombreUsuario}" id="nombreUsuario" size="30" title="nombreUsuario" value="#{perfil.usuario.nombreUsuario}"></h:inputText></td>
                                </tr>
                                <tr>

                                    <td>Contraseña:</td>
                                    <td><h:inputText readonly="#{perfil.password1Disabled}"  id="pass" size="30" title="Su Contraseña" value="#{perfil.usuario.password}"/></td>
                            </tr>
                            <tr>
                                <td width="115">Mail:</td>
                                <td width="69"><h:inputText  readonly="#{perfil.mailDisabled}" id="Mail" size="30" title="Mail" value="#{perfil.usuario.mail}"/></td>
                            </tr>
                            <tr>
                                <td width="115">Foto:</td>
                                <td width="69"><h:inputText  readonly="#{perfil.fotoDisabled}" id="Foto" size="30" title="Foto" value="#{perfil.usuario.foto}"/></td>
                            </tr>
                            <tr>
                                <td width="115">Profecion:</td>
                                <td width="69"><h:inputText readonly="#{perfil.profecionDisabled}" id="Profecion" size="30" title="Profecion" value="#{perfil.usuario.profesion}"/></td>
                            </tr>
                            <tr>
                                <td>&nbsp;</td>
                                <td>&nbsp;</td>
                            </tr>
                            <tr>
                                <td align="center" colspan="3">
                                    <a4j:commandButton disabled="#{perfil.botonModificarDisabled}" id="modificar" value="Modificar"
                                                       actionListener="#{perfil.modificar()}" styleClass="Button" title="Modificar" reRender="form"
                                                       >
                                    </a4j:commandButton>
                                    <a4j:commandButton disabled="#{perfil.botonCancelarDisabled}" actionListener="#{perfil.cancelar()}" id="cancelar" value="Cancelar"
                                                       styleClass="Button" title="Cancelar" 
                                                       reRender="form">
                                    </a4j:commandButton>
                                    <a4j:commandButton disabled="#{perfil.botonGuardarDisabled}" id="guardar" value="Guardar"
                                                       styleClass="Button" title="Guardar"
                                                       action="#{perfil.modificando()}" reRender="form"/>
                                </td>
                            </tr>
                        </table>
                    </a4j:form>
                </center>
             </div>     
        </f:subview>
             
    </body>
</html>