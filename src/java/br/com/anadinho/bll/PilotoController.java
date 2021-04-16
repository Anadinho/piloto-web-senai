/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.anadinho.bll;

import br.com.anadinho.dal.PilotoDal;
import br.com.anadinho.model.Piloto;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "PilotoController", urlPatterns = {"/PilotoController"})
public class PilotoController extends HttpServlet {
       private static String INSERT_OR_EDIT = "/cadastroPiloto.jsp";
       private static String LIST_USER = "/listarPiloto.jsp";
       private PilotoDal dal;
            
    public PilotoController() {
        super();
        dal = new PilotoDal();
    }


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
     
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PilotoController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Pagina processRequest TESTE "+ request.getParameter("name")+"</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         String forward="";
        String action = request.getParameter("action");
        if(action.equalsIgnoreCase("listarPiloto")){
             forward = LIST_USER;
             request.setAttribute("pilotos", dal.getAllPiloto());
        }
        
        else  if(action.equalsIgnoreCase("cadastrarPiloto")){
             forward = INSERT_OR_EDIT;
        } 
        
        else if (action.equalsIgnoreCase("delete")){
            int matricula = Integer.parseInt(request.getParameter("matricula"));
            dal.deletePiloto(matricula);
            forward = LIST_USER;
            request.setAttribute("pilotos", dal.getAllPiloto()); 
        }
       else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int matricula = Integer.parseInt(request.getParameter("matricula"));
            Piloto piloto = dal.getPilotoById(matricula);
            request.setAttribute("piloto", piloto);
       }
        

         RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
        //        processRequest(request, response);
    }

    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Piloto piloto = new Piloto();
        
        piloto.setNome(request.getParameter("nome"));
        piloto.setPais(request.getParameter("pais"));
      
        try {
            Date dataNascimento = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("dataNascimento"));
            piloto.setDataNascimento(dataNascimento);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
         piloto.setEquipe(request.getParameter("equipe"));
         piloto.setFabricanteMotor(request.getParameter("fabricanteMotor"));   
         piloto.setPontosTemporadas(Integer.parseInt(request.getParameter("pontosTemporada"))); 
         
        String matricula = request.getParameter("matricula");
        if(matricula == null || matricula.isEmpty())
        {
            dal.addPiloto(piloto);
        }
        else
        {
            piloto.setMatricula(Integer.parseInt(matricula));
            dal.updatePiloto(piloto);
        }
        
        RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
        request.setAttribute("pilotos", dal.getAllPiloto());
        view.forward(request, response);
        
        
        processRequest(request, response);
    }

    
    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
