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
    <main>
    <div class="table-container">  
        <div class="card">
        <form method="POST" action='CarroController' name="frmAddCarro">
            
         Renavam :  <input  type="text" name="renavam"  value="<c:out value="${carro.renavam}" />"  class="box"/> <br />
         Marca : <input  type="text" name="marca" value="<c:out value="${carro.marca}" />" class="box" /> <br /> 
         Modelo: <input  type="text" name="modelo" value="<c:out value="${carro.modelo}" />" class="box" /> <br /> 
         Cor : <input  type="text" name="cor" value="<c:out value="${carro.cor}" />"  class="box" /> <br /> 
         Placa : <input  type="text" name="placa"  readonly="readonly" value="<c:out value="${carro.placa}" />"  class="box" /> <br /> 
         Data : <input   type="text" name="data" value="<fmt:formatDate pattern="MM/dd/yyyy" value="${carro.data}" />" class="box" /> <br /> 
         Categoria: <input  type="text" name="categoria" value="<c:out value="${carro.categoria}" />" class="box" /> <br /> 
         Combustivel : <input  type="text" name="combustivel" value="<c:out value="${carro.combustivel}" />"  class="box"/> <br />
         Km : <input  type="text" name="km" value="<c:out value="${carro.km}" />"  class="box"/> <br /> 

        <button type="submit" value="Submit"> Salvar </button>
        </div>
        </div>   
         </form>
         <button onclick="window.location.href='CarroController?action=listarCarro'" class="button">Voltar para lista</button>
           </div>
    </div>      
         </main>
    </body>
</html>
