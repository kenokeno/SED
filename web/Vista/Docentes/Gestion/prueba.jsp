<%-- 
    Document   : prueba
    Created on : 23-ene-2013, 15:45:35
    Author     : alfredo
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
        .panelc {
            width:25%;
            vertical-align:top;         
        }
        
        .dropTargetPanel {
            width: 90%;
        }

        .footerClass {
            text-align: center;
            padding-top: 5px;
        }

    </style>
    </head>
    <body>
    <rich:dragIndicator id="indicator" />
    <h:form id="form">
        <h:panelGrid columnClasses="panelc" columns="4" width="100%">
            <rich:panel style="width:133px"> 
                <f:facet name="header">
                    <h:outputText value="Source List" />
                </f:facet>
                <h:dataTable id="src" value="#{examen.lstPreguntas}"
                    var="fm" footerClass="footerClass">
                    <h:column>
                        <a4j:outputPanel style="width:100px;border:1px solid gray;padding:2px"
                            layout="block">
                            <rich:dragSupport dragIndicator=":indicator"
                                dragType="#{fm.family}" dragValue="#{fm}">
                                <rich:dndParam name="label" value="#{fm.name}" />
                            </rich:dragSupport>
                            <h:outputText value="#{fm.name}"></h:outputText>
                        </a4j:outputPanel>
                    </h:column>
                    <f:facet name="footer">
                        <a4j:commandButton action="#{dndBean.reset}" value="Start Over" reRender="src,phptable,cftable,dnettable"/>
                    </f:facet>
                </h:dataTable>
            </rich:panel>
            <rich:panel styleClass="dropTargetPanel">
                <f:facet name="header">
                    <h:outputText value="PHP Frameworks" />
                </f:facet>
                <rich:dropSupport id="php" acceptedTypes="PHP" dropValue="PHP"
                    dropListener="#{eventBean.processDrop}" reRender="phptable, src">
                </rich:dropSupport>

                <h:dataTable id="phptable" value="#{dndBean.containerPHP}" var="fm">
                    <h:column>
                        <h:outputText value="#{fm.name}"></h:outputText>
                    </h:column>
                </h:dataTable>
            </rich:panel>
            <rich:panel styleClass="dropTargetPanel">
                <f:facet name="header">
                    <h:outputText value=".NET Frameworks" />
                </f:facet>
                <rich:dropSupport id="dnet" acceptedTypes="DNET" dropValue="DNET"
                    dropListener="#{eventBean.processDrop}" reRender="dnettable, src">
                </rich:dropSupport>

                <h:dataTable id="dnettable" value="#{dndBean.containerDNET}" var="fm">
                    <h:column>
                        <h:outputText value="#{fm.name}"></h:outputText>
                    </h:column>
                </h:dataTable>
            </rich:panel>
            <rich:panel styleClass="dropTargetPanel">
                <f:facet name="header">
                    <h:outputText value="ColdFusion Frameworks" />
                </f:facet>
                <rich:dropSupport id="cf" acceptedTypes="CF" dropValue="CF"
                    dropListener="#{eventBean.processDrop}" reRender="cftable, src">
                </rich:dropSupport>
                <h:dataTable id="cftable" value="#{dndBean.containerCF}" var="fm">
                    <h:column>
                        <h:outputText value="#{fm.name}"></h:outputText>
                    </h:column>
                </h:dataTable>
            </rich:panel>
        </h:panelGrid>
    </h:form>
     <a4j:outputPanel ajaxRendered="true">
        <h:messages></h:messages>
    </a4j:outputPanel>
    </body>
</html>
