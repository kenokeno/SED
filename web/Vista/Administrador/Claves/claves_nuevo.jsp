<%-- 
    Document   : claves_nuevo
    Created on : 04-ene-2013, 13:44:01
    Author     : alfredo
--%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!-- RichFaces tag library declaration -->
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Nuevas Claves</title>
        <link href="../Recursos/CSS/estilos.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <f:subview id="prueba">
            <f:loadBundle basename="general.MessageBundle" var="bundle"/>
            <div>
                <center>
                    <h1>Perfil</h1>
                    <a4j:form id="form">
                        <table  width="auto" border="0">
                            <tr>
                                <td rowspan="9" width="230px">
                                    <img width="80px" height="100px" 
                                         src="../../Recursos/imagenes/candado.png" /></td>
                                <td width="115"><h:outputLabel value="#{bundle.label_clave}"/></td>
                                <td width="69"><h:inputText id="clave" size="5" maxlength="3" 
                                             title="Clave" value="#{roles.clave_dto.clave}" 
                                             required="true" 
                                             requiredMessage="#{bundleBean.campo_requerido_clave}"/>
                                </td><td>&nbsp;</td>
                                <td ><center><h:message for="clave" styleClass="message" /></center></td>
                            </tr>
                            <tr>
                                <td width="115"><h:outputLabel value="#{bundle.label_rol}"/></td>
                                <td width="69"><h:inputText id="rol" size="25" maxlength="20" 
                                             title="Rol" value="#{roles.clave_dto.rol}"
                                             required="true" 
                                             requiredMessage="#{bundleBean.campo_requerido_rol}"/></td>
                                <td>&nbsp;</td><td><center><h:message for="rol" 
                                           styleClass="message" /></center></td>
                            </tr>
                            <tr>
                                <td>&nbsp;</td>
                                <td>&nbsp;</td>
                            </tr>
                            <tr>
                                <td align="center" colspan="3">
                                    <a4j:commandButton immediate="true" action="#{roles.cancelar()}" 
                                                       id="cancelar" value="#{bundle.boton_cancelar}"
                                                       styleClass="Button" title="Cancelar" >
                                    </a4j:commandButton>
                                    <a4j:commandButton id="guardar" value="#{bundle.boton_guardar}"
                                                       styleClass="Button" title="Guardar"
                                                       action="#{roles.guardar()}" reRender=":stock, :vista"/>
                                </td>
                            </tr>
                        </table>
                    </a4j:form>
                </center>
            </div>       
        </f:subview>
    </body>
</html>