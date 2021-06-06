<%-- 
    Document   : listarCorrida
    Created on : 11/05/2021, 18:41:56
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
        <title>Lista Corridas </title>
    </head>
    <body>
         <div class="table-container">  
            <div class="escudoLista">
                <label  class="txtpilotos">Corridas</label>
                <div class="tableLista">
        
        
          <table border=1 class="card" >
        <thead>
            <tr>
                <th>Id</th>
                <th>Nome Corrida</th>
                <th>Data</th>
                <th>Circuito</th>
                <th>Piloto</th>
                <th>Carro</th>
                <th colspan=2 >Action</th>
            </tr>
        </thead>
        <tbody>
            
              <c:forEach items="${corridas}" var="user">
                <tr>
                    <td><c:out value="${user.id}" /></td>
                    <td><c:out value="${user.nomeCorrida}" /></td>
                    <td><fmt:formatDate pattern="yyyy-MMM-dd" value="${user.dataCorrida}" /></td>
                    <td><c:out value="${user.circuito}" /></td>                    
                    <td><c:out value="${user.piloto.matricula}" /></td>
                    <td><c:out value="${user.carro.placa}" /></td>
                    
                     <td ><a  href="CorridaController?action=edit&id=<c:out value="${user.id}"/>" >Update</a></td>
                    <td><a href="CorridaController?action=delete&id=<c:out value="${user.id}"/>">Delete</a></td>
                </tr>
            </c:forEach>
            
        </tbody> 
    </table>
       </div>
         </div>
        <button onclick="window.location.href='PilotoController?action=cadastrarPiloto'" class="novoPiloto"></button>
         <button onclick="window.location.href='CarroController?action=cadastrarCarro'" class="novoCarro"></button>
         <button onclick="window.location.href='CorridaController?action=cadastrarCorrida'" class="novaCorrida"></button>
         <button onclick="window.location.href='PilotoController?action=listarPiloto'" class="exibirPiloto"></button>
         <button onclick="window.location.href='CarroController?action=listarCarro'" class="exibirCarro"></button>
          <button onclick="window.location.href='CorridaController?action=listarCorrida'" class="exibirCorrida"></button>
           </div>
    </body>
</html>
