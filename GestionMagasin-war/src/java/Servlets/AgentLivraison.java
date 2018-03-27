/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Entites.Autre.CommandeLot;
import Entites.Autre.Livraison;
import Entites.Autre.Magasin;
import Entites.Personne.Employe;
import Sessions.AgentDeLivraisonSessionLocal;
import facades.MagasinFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.sql.Date;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 6137220
 */
public class AgentLivraison extends HttpServlet {

    @EJB
    private MagasinFacadeLocal magasinFacade;

    @EJB
    private AgentDeLivraisonSessionLocal agentDeLivraisonSession;

    
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
            jspClient="/agentLivraison/index.jsp";
        }
        
          else if ((action.equals("versListeLivraison")))
              
          {
              afficherListeLivraison(request, response);
              jspClient="/agentLivraison/listeLivraison.jsp";

          }
           
          else if ((action.equals("versCreerLivraison")))
          {
              
              jspClient="/agentLivraison/creerLivraison.jsp";
              
          }
          else if (((action.equals("versEnregistrerLivraison"))))
          {
              versEnregistrerLivraison(request, response);
              jspClient="/agentLivraison/enregistrerCommandeLot.jsp";
              
          }
          
          else if (((action.equals("enregistrerCommandeLot"))))
          {enregistrerCommandeLot(request, response);
            jspClient="/agentLivraison/index.jsp";
          }
              
              
          
          else if(action.equals("logout"))
        {
            request.getSession(false).invalidate();
            jspClient="/login.jsp";
        }
          
              
          RequestDispatcher rd;
        rd = getServletContext().getRequestDispatcher(jspClient);
        rd.forward(request, response); 
          
        
        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AgentLivraison</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AgentLivraison at " + request.getContextPath() + "</h1>");
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

    protected void afficherListeLivraison(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
    {
    
        HttpSession session= request.getSession();
        Employe e=(Employe) session.getAttribute("user");    
        
        Magasin m= e.getLeMagasin();
        long mid= m.getId();
        
        Collection <Livraison> result =agentDeLivraisonSession.listerLivraisonEnCours(mid);
        
        request.setAttribute("livraison", result);
        
    }
    
    
       protected void versEnregistrerLivraison(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
       {
           String id = request.getParameter("id");
           int idLivraison = Integer.valueOf(id);
           agentDeLivraisonSession.enregistrerLivraison(idLivraison);
           Collection <CommandeLot> cl = agentDeLivraisonSession.AfficherCommandeLots(idLivraison);
           
           request.setAttribute("cl", cl);
           request.setAttribute("id", id);
           
           
       }

    private void enregistrerCommandeLot(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idLivraison = request.getParameter("id");
        int idLiv = Integer.valueOf(idLivraison);
        Collection <CommandeLot> cl = agentDeLivraisonSession.AfficherCommandeLots(idLiv);
        request.setAttribute("cl", cl);
        int longeur = cl.size();
        
        for (int i=1; i<longeur+2; i++ ){
            String st = String.valueOf(i);
           String idLot = request.getParameter("idCommandeLot"+st);
           int idCommandeLot = Integer.valueOf(idLot);
           String qlivree =request.getParameter("qlivree"+st);
           String qrecue =request.getParameter("qrecue"+st);
           String qacceptee =request.getParameter("qacceptee"+st);
           String taille =request.getParameter("taille");
           String dateperemption =request.getParameter("dateperemption"+st);
           String garantie =request.getParameter("garantie"+st);
           
           if(!(qlivree.isEmpty()) && !(qrecue.trim().isEmpty()) && !(qacceptee.trim().isEmpty())&& !(taille.trim().isEmpty())&& !(dateperemption.trim().isEmpty())&& !(garantie.trim().isEmpty()))
           {
               int iqlivree = Integer.valueOf(qlivree);
               int iqrecue = Integer.valueOf(qrecue);
               int iqacceptee = Integer.valueOf(qacceptee);
               Date idateperemption= Date.valueOf(dateperemption);
               int igarantie = Integer.valueOf(garantie);
               
           
           agentDeLivraisonSession.enregistrerLivraisonLots( idLiv,idCommandeLot, iqacceptee, iqlivree, iqrecue,  idateperemption, taille, igarantie);
           }}
           
        
    }
    
    
}
