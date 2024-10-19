<%-- 
    Document   : redireccionar
    Created on : 17-ene-2013, 15:08:57
    Author     : alfredo
--%>

<%@page  session="true" %>
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
        <title>JSP Page</title>
    </head>
    <body>
        <%
            if (session.getAttribute("login") == null) {
                response.sendRedirect("../Login/login.jsp");
            }
        %>
    </body>
</html>
