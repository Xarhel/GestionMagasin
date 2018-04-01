/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Entites.Autre.BonDeCommande;
import Entites.Autre.Livraison;
import Entites.Personne.Fournisseur;
import Sessions.FournisseurSessionLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
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
public class FournisseurServlet extends HttpServlet {

    @EJB
    private FournisseurSessionLocal fournisseurSession;

  

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
        
        if(request.getSession(false).getAttribute("name") == null)
        {
            jspClient="/login.jsp";
        }
        
        else if((action==null) || (action.equals("null")))
        {
            jspClient="/fournisseur/index.jsp";              
        }
          
          else if(action.equals("versListeLivraison"))
        {
            jspClient="/fournisseur/listeLivraison.jsp";
            afficherListeLivraison(request, response);
          
        }
          
        else if(action.equals("versSaisirLivraison"))
        {

            jspClient="/fournisseur/saisirLivraison.jsp";
            saisirLivraison(request, response);
        } 

        else if(action.equals("creerLivraison"))
        {
            jspClient="/fournisseur/listeLivraison.jsp";
            creerLivraison(request, response);
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
            out.println("<title>Servlet Fournisseur</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Fournisseur at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    
    
    protected void afficherListeLivraison(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
    {
    
        HttpSession session= request.getSession();
        Entites.Personne.Fournisseur four=(Fournisseur) session.getAttribute("user");    
       
      
        
        
      Collection <Livraison> result =fournisseurSession.afficherLivraisonsEnCours(four.getId());
       
       
        
        request.setAttribute("livraison", result);
        
    }
    
    protected void saisirLivraison(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
    {
    
     HttpSession session= request.getSession();
        Entites.Personne.Fournisseur four=(Fournisseur) session.getAttribute("user");
        
        long idFour= four.getId();
        
        Collection<BonDeCommande> result=fournisseurSession.consulterBonDeCommande(idFour);
        
        request.setAttribute("bdc", result);
    
    
    
    }
    
    
     protected void creerLivraison(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
    {
       String stringIdCommande = request.getParameter("bonCommande");
       String dateLiv= request.getParameter("dateLivraison");
        
        int idCommande=Integer.parseInt(stringIdCommande);
        Date d= Date.valueOf(dateLiv);
        
        
        Livraison l=fournisseurSession.creerLivraison(idCommande, d);
        ArrayList<Livraison> listeLivraisons = new ArrayList();
        listeLivraisons.add(l);
        
        
        request.setAttribute("livraison", listeLivraisons);
        
        
        
        
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
