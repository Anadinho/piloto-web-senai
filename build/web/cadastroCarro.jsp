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
        <title>Cadastro Piloto</title>
        <script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>

    </head>
    <body>   
    <script>
        $(function() {
            $('input[name=data]').datepicker();
        });
    </script>
    
        <div class="table-container">  
            <div class="fundoEscuro">               
            <div class="escudoCadastroCarros">
         <form method="POST" action='CarroController' name="frmAddCarro">
        
            
           <label class="textRenavam">Renavam : </label> 
         <input  type="text" name="renavam"  value="<c:out value="${carro.renavam}" />"  class="botaoRenavam"/> <br />
         
         <label class="textMarca">Marca : </label>
         <input  type="text" name="marca" value="<c:out value="${carro.marca}" />" class="botaoMarca" /> <br /> 
         
         <label class="textModelo">Modelo: : </label>
         <input  type="text" name="modelo" value="<c:out value="${carro.modelo}" />" class="botaoModelo" /> <br /> 
         
         <label class="textCor">Cor : </label> 
         <input  type="text" name="cor" value="<c:out value="${carro.cor}" />"  class="botaoCor" /> <br /> 
         
         <label class="textPlaca">Placa : </label> 
         <input  type="text" name="placa" value="<c:out value="${carro.placa}" />"  class="botaoPlaca" /> <br /> 
         
         <label class="textData">Data : </label> 
         <input   type="text" name="data" value="<fmt:formatDate pattern="MM/dd/yyyy" value="${carro.data}" />" class="botaoData" /> <br /> 
         
        <label class="textCategoria">Categoria: : </label>  
         <input  type="text" name="categoria" value="<c:out value="${carro.categoria}" />" class="botaoCategoria" /> <br /> 
         
         <label class="textCombustivel">Combustivel : </label> 
         <input  type="text" name="combustivel" value="<c:out value="${carro.combustivel}" />"  class="botaoCombustivel"/> <br />
         
         <label class="textKM">Km : </label>
         <input  type="text" name="km" value="<c:out value="${carro.km}" />"  class="botaoKm"/> <br /> 

        <button type="submit" value="Submit" class="botaoCadastrarCarros"> Salvar </button>
  
          
           
            </form>
         <button onclick="window.location.href='CarroController?action=listarCarro'" class="botaoVoltarCarros"></button>
             </div>
         
         
        </div>
       
          </div>
      
    </body>
</html>
