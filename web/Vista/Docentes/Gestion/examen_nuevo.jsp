<%-- 
    Document   : gestion
    Created on : 17-dic-2012, 9:07:50
    Author     : moises
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
        <title>Gestion</title>
        <link href="../../Recursos/CSS/estilos.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript"  src="../../Recursos/JS/jquery-1.8.2.min.js"></script>
        <script type="text/javascript" src="../../Recursos/JS/jquery.displaytag-ajax-1.2.js"></script> 
        <script type="text/javascript" src="../Recursos/JS/validacion.js"></script>
    </head>
    <body>
        <f:subview id="examenes">
        <center>
            <div class="contenido" >
                <br/>
                <%--<h:outputLabel id="mensajeError" style="color:#FF0000;" value="#{roles.mensajeError}" />--%>
                <h1 >Gestion</h1>
                <a4j:form id="formulario">
                    <h:outputLabel value="EXAMEN"/>
                    <br/>
                    <h:outputLabel value="Tipo: "/>
                    <h:selectOneMenu id="tipo" value="#{examen.examen.tipo_examen.ID_tipo_examen}">
                        <f:selectItems value="#{examen.lstTipos}" var="tipo_examen"
                                       itemLabel="#{tipo_examen.nombre_tipo_examen}" itemValue="#{tipo_examen.tipo_examen}"  />
                    </h:selectOneMenu>
                    <br/>
                    <h:outputLabel value="Periodo: "/>
                    <h:inputText readonly="true" value="#{examen.examen.periodo.inicio}"/>
                    <h:inputText readonly="true" value="#{examen.examen.periodo.fin}"/>
                    <br/>
                    <h:outputLabel value="Carrera: "/>
                    <h:selectOneMenu id="carrera" value="#{examen.examen.carrera.id}"> 
                        <f:selectItem itemValue="0" itemLabel="Seleccionar..."/>
                        <f:selectItems value="#{examen.lstCarreras}"/>
                        <a4j:support event="onchange" action="#{examen.filtrarCombos()}" reRender="materia, grupo, unidad"/>
                    </h:selectOneMenu>
                    <br/>
                    <h:outputLabel value="Asignatura "/>
                    <h:selectOneMenu value="#{examen.examen.materia.id_materia}" id="materia" >
                        <f:selectItem itemValue="0" itemLabel="Seleccionar..."/>
                        <f:selectItems value="#{examen.lstMaterias}" var="m"
                                       itemLabel="#{m.nombre_materia}" itemValue="#{m.id_materia}"/>
                        <a4j:support event="onchange" action="#{examen.filtrarUnidades()}" reRender="unidad"/>
                    </h:selectOneMenu>
                    <br/>
                    <h:outputLabel value="Unidad "/>
                    <h:selectOneMenu value="#{examen.examen.unidad}" id="unidad" >
                        <f:selectItem itemValue="0" itemLabel="Seleccionar..."/>
                        <f:selectItems value="#{examen.lstUnidades}"/>
                    </h:selectOneMenu>
                    <br/>
                    <h:outputLabel value="Valor Porcentual: "/>
                    <h:inputText id="procentaje" value="#{examen.examen.porcentaje}" required="true"/><h:message for="procentaje"/>
                    <br/>
                    <h:outputLabel value="Grupo: "/>
                    <h:selectOneMenu value="#{examen.examen.grupo.id_grupo}" id="grupo" >
                        <f:selectItem itemValue="0" itemLabel="Seleccionar..."/>
                        <f:selectItems value="#{examen.lstGrupos}" var="m"
                                       itemLabel="#{m.nombre}" itemValue="#{m.id_grupo}"/>
                    </h:selectOneMenu>
                    <br/>
                    <h:outputLabel value="Turno: "/>
                    <h:selectOneRadio value="#{examen.examen.turno}" id="turno" required="true">
                        <f:selectItem itemValue="1" itemLabel="Maturino" />
                        <f:selectItem itemValue="0" itemLabel="Vespertino" />
                    </h:selectOneRadio><h:message for="turno"/>
                    <br/>
                    <h:outputLabel value="Fecha de Aplicación: "/>
                    <rich:calendar id="fecha_aplicacion" value="#{examen.examen.fecha}" 
                                   datePattern="dd/MM/yyyy" required="true"/>
                    <h:message for="fecha_aplicacion"/>
                    <br/>
                    <h:outputLabel value="Profesor: "/>
                    <h:inputText readonly="true" value="#{examen.examen.profesor.nombre}"/>
                    <br/>
                    <a4j:commandLink id="nuevo" action="#{examen.temas()}" title="Nuevo" reRender=":vista"> 
                        <img src="../Recursos/imagenes/nuevo-usuario.png"></a4j:commandLink>
                </a4j:form>
            </div>
        </center>
    </f:subview>
</body>
</html>