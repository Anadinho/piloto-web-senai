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
        <div class="table-container">  
            <div class="escudoLista">
                <label class="txtpilotos">Pilotos</label>
                <div class="tableLista">
          <table border=1 class="card">
        <thead>
            <tr>
                <th>Matricula</th>
                <th>Nome</th>
                <th>Pais</th>
                <th>Data de Nascimento</th>
                <th>Equipe</th>
                <th>Fabricante do Motor</th>
                <th>Pontos Temporada</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${pilotos}" var="user">
                <tr>
                    <td><c:out value="${user.matricula}" /></td>
                    <td><c:out value="${user.nome}" /></td>
                    <td><c:out value="${user.pais}" /></td>
                    <td><fmt:formatDate pattern="yyyy-MMM-dd" value="${user.dataNascimento}" /></td>
                    <td><c:out value="${user.equipe}" /></td>
                    <td><c:out value="${user.fabricanteMotor}" /></td>
                    <td><c:out value="${user.pontosTemporadas}" /></td>
                    <td ><a href="PilotoController?action=edit&matricula=<c:out value="${user.matricula}"/>" >Update</a></td>
                    <td><a href="PilotoController?action=delete&matricula=<c:out value="${user.matricula}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
        
       
       
          
          </div>
                
          </div>
         <button onclick="window.location.href='PilotoController?action=cadastrarPiloto'" class="novoPiloto"></button>
         <button onclick="window.location.href='CarroController?action=cadastrarCarro'" class="novoCarro"></button>
         <button onclick="window.location.href='CarroController?action=cadastrarCorrida'" class="novaCorrida"></button>
         <button onclick="window.location.href='PilotoController?action=listarPiloto'" class="exibirPiloto"></button>
         <button onclick="window.location.href='CarroController?action=listarCarro'" class="exibirCarro"></button>
          <button onclick="window.location.href='CorridaController?action=listarCorrida'" class="exibirCorrida"></button>
          </div>
    </body>
</html>
