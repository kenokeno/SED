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
        <link href="../../Recursos/CSS/estilos.css" rel="stylesheet" type="text/css" />
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
        <f:subview id="claves">
            <div class="contenido" >
                <center>
                    <br/>
                    <h:outputLabel id="mensajeError" style="color:#FF0000;" value="#{roles.mensajeError}" />
                    <h1 >Claves</h1>
                    <h:form id = "formulario">
                        <h:outputLabel value="Consulta por Clave "/>
                        <h:inputText id="txtFiltro" value="#{roles.filtros.filtro1}">
                            <a4j:support id="ajax" event="onkeyup" action="#{roles.consultar()}" reRender="stock"/>
                        </h:inputText>
                    </h:form>
                    <br/>
                    <h:form id="stock">
                        <center>
                            <div id="displayTagDiv">                      
                                <script language="javascript" type="text/javascript">
                                    $( function(){
                                        $("#displayTagDiv").displayTagAjax();
                                    })
                                </script>                         
                                <table cellspacing="0" cellpadding="0" border="0" >
                                    <tbody>
                                        <tr>
                                            <td>
                                                <strong><h:outputText
                                                        value="Lista de Claves"></h:outputText>
                                                    <h:inputHidden id="seleccionados" value="#{roles.claves_Seleccionadas}" />
                                                </strong>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                                <br/>                        
                                <display:table name="${roles.claves}" id="row" 
                                               styleClass="TABLA" cellpadding="10" cellspacing="0"
                                               requestURI="../Administrador/Claves/claves.jsp"
                                               pagesize="5" 
                                               excludedParams="*">
                                    <display:column property="id" sortable="true" title="ID"/>
                                    <display:column property="clave" sortable="true" title="Clave"/>
                                    <display:column property="rol" sortable="true" title="Rol"/>
                                    <display:column property="checkBox" sortable="false" title="Seleccionar"/>
                                </display:table>
                            </div>
                            <br/>
                            <a4j:commandLink id="nuevo" action="#{roles.nuevo()}" title="Nuevo" reRender=":vista"> 
                                <img src="../Recursos/imagenes/nuevo-usuario.png"></a4j:commandLink>
                            <a4j:commandLink id="editar" title="Editar" action="#{roles.editar()}" 
                                             onclick="checks_seleccionados('vista:claves:stock','seleccionados');" reRender="mensajeError"> 
                                <img src="../Recursos/imagenes/editar-usuario.png"></a4j:commandLink> 
                                <!--checks_seleccionados(debes ver los forms dentro de los que esta encerrado el que quieres. Los forms que estan en inicio.jsp y en este jsp)-->
                            <a4j:commandLink id="eliminar" title="Eliminar" action="#{roles.eliminar()}" 
                                             onclick="checks_seleccionados('vista:claves:stock','seleccionados');" reRender="mensajeError, stock"> 
                                <img src="../Recursos/imagenes/editar-usuario.png"></a4j:commandLink> 
                            </center>
                    </h:form>
                </center>
            </div>
        </f:subview>
    </body>
</html>