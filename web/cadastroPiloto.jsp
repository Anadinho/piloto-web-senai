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
    <main>
    <div class="table-container">  
        <div class="card">
        <form method="POST" action='PilotoController' name="frmAddPiloto">
            
         Matricula :  <input  type="text" name="matricula"  readonly="readonly" value="<c:out value="${piloto.matricula}" />"  class="box"/> <br />
         Name : <input  type="text" name="nome" value="<c:out value="${piloto.nome}" />" class="box" /> <br /> 
         Pais : <input  type="text" name="pais" value="<c:out value="${piloto.pais}" />" class="box" /> <br /> 
         Data Nascimento : <input   type="text" name="dataNascimento" value="<fmt:formatDate pattern="MM/dd/yyyy" value="${piloto.dataNascimento}" />" class="box" /> <br /> 
         Equipe : <input  type="text" name="equipe" value="<c:out value="${piloto.equipe}" />"  class="box" /> <br /> 
         Fabricante do Motor : <input  type="text" name="fabricanteMotor" value="<c:out value="${piloto.fabricanteMotor}" />" class="box" /> <br /> 
         Pontos da temporada : <input  type="text" name="pontosTemporada" value="<c:out value="${piloto.pontosTemporadas}" />"  class="box"/> <br />     

                <button type="submit" value="Submit"> Salvar </button>
        </div>
    </div>   
    </form>
         <button onclick="window.location.href='PilotoController?action=listarPiloto'" class="button">Voltar para lista</button>
           </div>
    </div>  
         </main>
    </body>
</html>
