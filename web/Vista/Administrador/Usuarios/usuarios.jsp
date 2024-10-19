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
        <f:subview id="claves">
            <div class="contenido">
                <center>
                    <h2>Usuarios</h2>
                    <a4j:commandLink onclick="javascript:pedirDatos('../Administrador/usuario-nuevo.jsp','targetDiv')" title="Nuevo"> <img src="../Recursos/imagenes/nuevo-usuario.png"></a4j:commandLink>
                    <a4j:commandLink onclick="javascript:pedirDatos('../Administrador/ConsultaUsuario.jsp','targetDiv')" title="Consulta"> <img src="../Recursos/imagenes/editar-usuario.png"></a4j:commandLink> 
                    </center> 
                </div>
        </f:subview>
    </body>
</html>