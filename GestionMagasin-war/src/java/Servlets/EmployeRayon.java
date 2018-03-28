/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Entites.Autre.BonDeCommande;
import Entites.Autre.Livraison;
import Entites.Autre.Rayon;
import Entites.Autre.Stock;
import Entites.Personne.Employe;
import Sessions.EmployeDeRayonSessionLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


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
        
        if(request.getSession(false).getAttribute("name") == null)
        {
            jspClient="/login.jsp";
        }
        
        else if((action==null) || (action.equals("null")))
        {
            jspClient="/employeRayon/index.jsp";
        }
         
        
          else if(action.equals("RetraitArticlePerime"))
        {
            jspClient="/EmployeRayon/index.jsp";
            // Méthode de retrait des articles périmés
        }
         
         
          else if(action.equals("versConsulterCommande"))
        {
            versConsulterCommande(request, response);
            jspClient="/employeRayon/consulterCommande.jsp"; 
        }
         
        else if(action.equals("versConsulterLivraison"))
        {
            jspClient="/employeRayon/consulterLivraison.jsp";
            versConsulterLivraison(request, response);
        }
         
          else if(action.equals("versRetraitArticlePerime"))
        {
            jspClient="/employeRayon/retraitArticlePerime.jsp";
            versArticlePerime(request, response);   
        }
         
        else if(action.equals("supprimerProduitPerime"))
              
        {
            supprimerProduitPerime(request, response);
            jspClient="/employeRayon/retraitArticlePerime.jsp";
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
            out.println("<title>Servlet EmployeRayon</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EmployeRayon at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
            
        }
        
        
        
        
        
        
    }
 


    
    protected void versConsulterCommande(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
            
    {
        HttpSession session= request.getSession();
        Employe e=(Employe) session.getAttribute("user");
        
        Collection<BonDeCommande> c = employeDeRayonSession.rechercherParMagasin(e.getIdMagasin());
        
        
  
        String message = "Voici la liste des commandes recensées";
        request.setAttribute("commande", c);
        request.setAttribute("message", message);        
    }   
    
    
    protected void versConsulterLivraison(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
            
    {
        HttpSession session= request.getSession();
        Employe e=(Employe) session.getAttribute("user");
        
        
        Collection<Livraison> l = employeDeRayonSession.rechercheLivraisonEnCours(e.getIdMagasin());
       
        String message = "Voici la liste des livraisons recensées";
        request.setAttribute("livraison", l);
        request.setAttribute("message", message);        
    }
   
     protected void versArticlePerime(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
            
    {
        HttpSession session= request.getSession();
        Employe e=(Employe) session.getAttribute("user");
        
        Rayon r= e.getLeRayon();
        Date d= new Date();
        
        Collection <Stock> s=employeDeRayonSession.rechercherStockAvecProduitPerime(d, r);
        
        String message = "Voici la liste des livraisons recensées";
        request.setAttribute("message", message);  
        request.setAttribute("stock", s);
   
    }
    
     
     protected void supprimerProduitPerime(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
     {
        HttpSession session= request.getSession();
        Employe e=(Employe) session.getAttribute("user");
        
        Rayon r= e.getLeRayon();
        Date d= new Date();
        
        employeDeRayonSession.retirerStockPerime(d, r);
        
        String message="Bravo, vous avez enlevé le stock périmé";
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
