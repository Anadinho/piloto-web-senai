<%-- 
    Document   : cadastroPiloto
    Created on : 16/04/2021, 09:29:20
    Author     : suporte
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
        <link type="text/css" href="css/style.css" rel="stylesheet" />
        <title>Cadastro COrrida</title>
        <script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>

    </head>
    <body>   
    <script>
        $(function() {
            $('input[name=dataCorrida]').datepicker();
        });
    </script>
    
        <div class="table-container">  
            <div class="fundoEscuro">               
            <div class="escudoCadastroCarros">
         <form method="POST" action='CorridaController' name="frmAddCorrida">
        
            
         <label class="textNomeCorrida"></label>
         <input  type="text" name="id" value="<c:out value="${corrida.id}" />" class="botaoCorrida" /> <br /> 
             
         <label class="textNomeCorrida">Nome </label>
         <input  type="text" name="nomeCorrida" value="<c:out value="${corrida.nomeCorrida}" />" class="botaoCorrida" /> <br /> 
         
         <label class="textDataCorrida">Data : </label> 
         <input   type="text" name="dataCorrida" value="<fmt:formatDate pattern="MM/dd/yyyy" value="${corrida.dataCorrida}" />" class="botaoDataCorrida" /> <br /> 
         
         <label class="textCircuito">Circuito : </label>
         <input  type="text" name="circuito" value="<c:out value="${corrida.circuito}" />" class="botaoCircuito" /> <br /> 
         
         <label class="textPiloto">Piloto : </label> 
         <input  type="text" name="piloto" value="<c:out value="${corrida.piloto.matricula}" />"  class="botaoPiloto" /> <br /> 
         
         <label class="textCarro">Carro : </label> 
         <input  type="text" name="carro" value="<c:out value="${corrida.carro.placa}" />"  class="botaoCarro" /> <br />  

        <button type="submit" value="Submit" class="botaoCadastrarCarros"> </button>
  
          
           
            </form>
         <button onclick="window.location.href='CorridaController?action=listarCorrida'" class="botaoVoltarCarros"></button>
             </div>
         
         
        </div>
       
          </div>
      
    </body>
</html>
