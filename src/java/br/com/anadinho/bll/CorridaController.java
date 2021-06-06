/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.anadinho.bll;


import br.com.anadinho.dal.CarroDal;
import br.com.anadinho.dal.CorridaDal;
import br.com.anadinho.dal.PilotoDal;
import br.com.anadinho.model.Carro;
import br.com.anadinho.model.Corrida;
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

/**
 *
 * @author suporte
 */
@WebServlet(name = "CorridaController", urlPatterns = {"/CorridaController"})
public class CorridaController extends HttpServlet {
    private static String INSERT_OR_EDIT = "/cadastroCorrida.jsp";
    private static String EDIT = "/editarCorrida.jsp";
    private static String LIST_USER = "/listarCorrida.jsp";
    private CorridaDal dal;
       
     public CorridaController() {
        super();
        dal = new CorridaDal();
    }


    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CorridaController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CorridaController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      String forward="";
        String action = request.getParameter("action");
        
        if(action.equalsIgnoreCase("listarCorrida")){
             forward = LIST_USER;
             request.setAttribute("corridas", dal.getAllCorrida());
        }
        
        else  if(action.equalsIgnoreCase("cadastrarCorrida")){
             forward = INSERT_OR_EDIT;
        } 
        
        else if (action.equalsIgnoreCase("delete")){
            String placa = (request.getParameter("id"));
            dal.deleteCarro(placa);
            forward = LIST_USER;
            request.setAttribute("corridas", dal.getAllCorrida()); 
        }
       else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            String id = (request.getParameter("id"));
            Corrida corrida = dal.getCorridaById(id);
            request.setAttribute("corrida", corrida);
       }
        

         RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
        //        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
Corrida corrida = new Corrida();
        
         PilotoDal pD =new PilotoDal();
          CarroDal cD = new CarroDal();
           
        corrida.setNomeCorrida(request.getParameter("nomeCorrida"));
      
        try {
            Date date = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("dataCorrida"));
            corrida.setDataCorrida(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        
         corrida.setCircuito(request.getParameter("circuito"));
         corrida.setPiloto(pD.getPilotoById(Integer.parseInt(request.getParameter("piloto")))); 
         corrida.setCarro(cD.getCarroById(request.getParameter("carro")));
         
         String id = request.getParameter("id");
        if(id == null || id.isEmpty())
        {
            dal.addCorrida(corrida);
        }
        else
        {
            corrida.setId(Integer.parseInt(id));
            dal.updateCorrida(corrida);
        }

         
         
        
        RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
        request.setAttribute("corridas", dal.getAllCorrida());
        view.forward(request, response);
        
        
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
