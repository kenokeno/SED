<%-- 
    Document   : ConsultaUsuario
    Created on : 05-dic-2012, 12:56:05
    Author     : alfredo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <f:view>
        <a href="">REGRESA</a>
        <br>
        <h:inputText value="#{roles.clave}"/>
        <h:form id="buscar_avance">
        <display:table id="lista_avance"
                       name="${roles.claves}" pagesize="15"
                       requestURI=""
                       class="Grid" cellpadding="0" cellspacing="0" border="0"
                       defaultsort="1" excludedParams="*">
            <display:column property="id" sortable="true"
                            title="Id" align="center" style="width: 130px"/>
            <display:column property="clave" sortable="true"
                            title="Clave" align="center"/>
            <display:column property="rol" sortable="true"
                            title="Rol" align="center" />
        </display:table>
        </h:form>
    </f:view>
</body>
</html>
