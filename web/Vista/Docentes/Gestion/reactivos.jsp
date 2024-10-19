<%-- 
    Document   : reactivos
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
<!DOCTYPE html>
<html>
    <head>
        <title>Reactivos del Examen</title>
    </head>
    <body>
        <f:subview id="examenes">
        <center>
            <div>
                <br/>
                <rich:dragIndicator id="indicator" />
                <%--<h:outputLabel id="mensajeError" style="color:#FF0000;" value="#{roles.mensajeError}" />--%>
                <h1 >Reactivos</h1>
                <a4j:form id="reactivos">
                    <center>
                        <h:selectManyListbox id="reativos">
                            <f:selectItems value="#{examen.lstPreguntas}" var="reactivo"
                                           itemLabel="#{reactivo.pregunta}" itemValue="#{reactivo.id}"  />
                        </h:selectManyListbox>
                        <a4j:commandButton value="Guardar" action="#{examen.agregarSeccion()}" reRender="secciones"/>
                        <rich:dragSupport id="examen">
                            <f:selectItems value="#{examen.lstPreguntas}" var="reactivo"
                                           itemLabel="#{reactivo.pregunta}" itemValue="#{reactivo.id}"  />
                        </rich:dragSupport>
                    </center>
                </a4j:form>
            </div>
        </center>
    </f:subview>
</body>
</html>
