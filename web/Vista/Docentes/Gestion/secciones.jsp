<%-- 
    Document   : secciones
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
        <title>Secciones del examen</title>
    </head>
    <body>
        <f:subview id="examenes">
        <center>
            <div>
                <br/>
                <%--<h:outputLabel id="mensajeError" style="color:#FF0000;" value="#{roles.mensajeError}" />--%>
                <h1 >Secciones</h1>
                <a4j:form id="secciones">
                    <center>
                        <display:table name="${examen.lstSecciones}" id="row" 
                                               styleClass="TABLA" cellpadding="10" cellspacing="0"
                                               requestURI="../Administrador/Claves/claves.jsp"
                                               pagesize="5" 
                                               excludedParams="*">
                            <display:column property="numero" title="Seccion"/>
                            <display:column>
                                <f:facet name="header">
                                    <h:outputText value="Contenido" />
                                </f:facet>
                                <h:selectOneMenu id="tipo_preguntas" value="#{examen.tipo_pregunta}">
                                    <f:selectItem itemValue="0" itemLabel="Seleccionar..."/>
                                    <f:selectItems value="#{examen.lstTipoPreguntas}" var="pregunta"
                                                   itemLabel="#{pregunta.nombre}" itemValue="#{pregunta.id}"  />
                                </h:selectOneMenu>
                                <h:selectManyListbox id="temas" value="#{examen.temas_seccion}">
                                    <f:selectItems value="#{examen.lstTemas}" var="tema"
                                                   itemLabel="#{tema.nombre}" itemValue="#{tema.id}"  />
                                </h:selectManyListbox>
                                <a4j:commandButton value="Generar Preguntas" action="#{examen.preguntas()}"/>
                            </display:column>
                        </display:table>
                        <a4j:commandButton value="Agregar Seccion" action="#{examen.agregarSeccion()}" reRender="secciones"/>
                    </center>
                </a4j:form>
            </div>
        </center>
    </f:subview>
</body>
</html>