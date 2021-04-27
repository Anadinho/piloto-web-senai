<%-- 
    Document   : index
    Created on : 16/04/2021, 09:30:38
    Author     : suporte
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%--<jsp:forward page="PilotoController?action=listarPiloto" />--%>
         <jsp:forward page="CarroController?action=listarCarro" />
        <%--<jsp:forward page="PilotoController" />--%>
    </body>
</html>
     