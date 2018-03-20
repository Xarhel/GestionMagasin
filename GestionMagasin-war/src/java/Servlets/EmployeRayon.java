/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Entites.Autre.BonDeCommande;
import Entites.Autre.CommandeLot;
import Entites.Personne.Employe;
import Entites.Personne.Personne;
import Sessions.EmployeDeRayonSessionLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.jboss.weld.servlet.SessionHolder;


/**
 *
 * @author 3137574
 */
public class EmployeRayon extends HttpServlet {

    @EJB
    private EmployeDeRayonSessionLocal employeDeRayonSession;

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
        
        String jspClient = null;
        String action = request.getParameter("action");
        
        // Jsp par défaut lorsque l'utilisateur exécute la solution
        
         if((action==null) || (action.equals("null")))
        {
            jspClient="/EmployeRayon/index.jsp";
        }
         
        else if(action.equals("consulterCommande"))
        {
            consulterCommande(request, response);
            jspClient="consulterCommande.jsp";
        }
         
           else if(action.equals("consulterLivraison"))
        {
            jspClient="consulterLivraison.jsp";
        }
        
          else if(action.equals("retraitArticlePerimer"))
        {
            jspClient="retraitArticlePerimer.jsp";
        }
         
          ////////////////////////DIRECTION//////////////////////
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EmployeRayon</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EmployeRayon at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
            
        }
        
        
        
        
        
        
    }
 


    
    protected void consulterCommande(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
            
    {
        HttpSession session= request.getSession();
        Employe e=(Employe) session.getAttribute("user");
        
        Collection<BonDeCommande> c = employeDeRayonSession.rechercherParMagasin(e.getIdMagasin());
        
        String message = "Voici la liste des commandes recensées";
        request.setAttribute("commande", c);
        request.setAttribute("message", message);        
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
        processRequest(request, response);
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
