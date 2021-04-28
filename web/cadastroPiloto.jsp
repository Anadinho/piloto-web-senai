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
            $('input[name=dataNascimento]').datepicker();
        });
    </script>
    <div class="table-container">  
          <div class="fundoEscuro">
            <div class="escudoLogin">
        <form method="POST" action='PilotoController' name="frmAddPiloto">
            
            <label class="matricula">Matricula :</label>
         <input  type="text" name="matricula"  readonly="readonly" value="<c:out value="${piloto.matricula}" />"  class="botaoMatricula"/> <br />
         
         <label class="nome">Nome :</label>
         <input  type="text" name="nome" value="<c:out value="${piloto.nome}" />" class="botaoNome" /> <br /> 
         
         <label class="pais">Pais :</label>
         <input  type="text" name="pais" value="<c:out value="${piloto.pais}" />" class="botaoPais" /> <br /> 
         
        <label class="dataNascimento">Data </label>
         <input   type="text" name="dataNascimento" value="<fmt:formatDate pattern="MM/dd/yyyy" value="${piloto.dataNascimento}" />" class="botaoDataPiloto" /> <br /> 
         
          <label class="equipe">Equipe :</label>
         <input  type="text" name="equipe" value="<c:out value="${piloto.equipe}" />"  class="botaoEquipe" /> <br /> 
         
          <label class="fabricante">Fab. do Motor :</label>
         <input  type="text" name="fabricanteMotor" value="<c:out value="${piloto.fabricanteMotor}" />" class="botaoFabricante" /> <br /> 
         
          <label class="pontos">Pontos </label>
         <input  type="text" name="pontosTemporada" value="<c:out value="${piloto.pontosTemporadas}" />"  class="botaoPontos"/> <br />     

                <button type="submit"  class="botaoCadastrar" value="Submit"> </button>
        
     
    </form>
         <button onclick="window.location.href='PilotoController?action=listarPiloto'" class="botaoVoltar"></button>         
  </div>
         </div>
           </div>
     
    </body>
</html>
