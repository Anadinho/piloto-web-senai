<%-- 
    Document   : listarPiloto
    Created on : 16/04/2021, 09:41:56
    Author     : suporte
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
           <link type="text/css" href="css/style.css" rel="stylesheet" />
        <title>Lista </title>
    </head>
    <body>
        
        
          <table border=1 class="card">
        <thead>
            <tr>
                <th>Renavam</th>
                <th>Marca</th>
                <th>Modelo</th>
                <th>Data</th>
                <th>Cor</th>
                <th>Placa do carro</th>
                <th>Categoria</th>
                <th>Combustivel</th>
                <th>Km</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${carros}" var="user">
                <tr>
                    <td><c:out value="${user.renavam}" /></td>
                    <td><c:out value="${user.marca}" /></td>
                    <td><c:out value="${user.modelo}" /></td>
                    <td><fmt:formatDate pattern="yyyy-MMM-dd" value="${user.data}" /></td>
                    <td><c:out value="${user.cor}" /></td>
                    <td><c:out value="${user.placa}" /></td>
                    <td><c:out value="${user.categoria}" /></td>
                    <td><c:out value="${user.combustivel}" /></td>
                     <td><c:out value="${user.km}" /></td>
                    <td><a href="CarroController?action=edit&placa=<c:out value="${user.placa}"/>">Update</a></td>
                    <td><a href="CarroController?action=delete&placa=<c:out value="${user.placa}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
        
        <button onclick="window.location.href='PilotoController?action=cadastrarPiloto'">Cadastrar Piloto</button>
         <button onclick="window.location.href='CarroController?action=cadastrarCarro'">Cadastrar Carro</button>
          <button onclick="window.location.href='PilotoController?action=listarPiloto'">Exibir Piloto</button>
          <button onclick="window.location.href='CarroController?action=listarCarro'">Exibir Carro</button>
    </body>
</html>
