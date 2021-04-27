/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.anadinho.bll;

import br.com.anadinho.dal.CarroDal;
import br.com.anadinho.model.Carro;
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

/**
 *
 * @author suporte
 */
@WebServlet(name = "CarroController", urlPatterns = {"/CarroController"})
public class CarroController extends HttpServlet {
     private static String INSERT_OR_EDIT = "/cadastroCarro.jsp";
     private static String EDIT = "/editarCarro.jsp";
       private static String LIST_USER = "/listarCarro.jsp";
       private CarroDal dal;
            
    public CarroController() {
        super();
        dal = new CarroDal();
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
            out.println("<title>Servlet CarroController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CarroController at " + request.getContextPath() + "</h1>");
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
        if(action.equalsIgnoreCase("listarCarro")){
             forward = LIST_USER;
             request.setAttribute("carros", dal.getAllCarro());
        }
        
        else  if(action.equalsIgnoreCase("cadastrarCarro")){
             forward = INSERT_OR_EDIT;
        } 
        
        else if (action.equalsIgnoreCase("delete")){
            String placa = (request.getParameter("placa"));
            dal.deleteCarro(placa);
            forward = LIST_USER;
            request.setAttribute("carros", dal.getAllCarro()); 
        }
       else if (action.equalsIgnoreCase("edit")){
            forward = EDIT;
           String placa = (request.getParameter("placa"));
            Carro carro = dal.getCarroById(placa);
            request.setAttribute("carro", carro);
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
        
        Carro carro = new Carro();
        
        carro.setRenavam(Integer.parseInt(request.getParameter("renavam"))); 
        carro.setMarca(request.getParameter("marca"));
      
        try {
            Date date = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("data"));
            carro.setData(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
         carro.setModelo(request.getParameter("modelo"));
         carro.setCor(request.getParameter("cor"));
         carro.setPlaca(request.getParameter("placa"));
         carro.setCategoria(request.getParameter("categoria"));   
         carro.setCombustivel(Integer.parseInt(request.getParameter("combustivel"))); 
         carro.setKm(Integer.parseInt(request.getParameter("km"))); 
          dal.addCarro(carro);
         
         
        String placa = request.getParameter("placa");
        if(placa == null || placa.isEmpty())
        {
            dal.addCarro(carro);
        }
        else
        {
            carro.setPlaca(placa);
            dal.updateCarro(carro);
        }
        
        RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
        request.setAttribute("carros", dal.getAllCarro());
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
