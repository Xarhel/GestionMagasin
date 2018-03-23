/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Entites.Autre.Article;
import Entites.Enum.CategorieArticle;
import Sessions.ChefDeRayonSession;
import Sessions.ChefDeRayonSessionLocal;
import facades.ArticleFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Collection;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 3137574
 */
public class ChefDeRayon extends HttpServlet {

    @EJB
    private ChefDeRayonSessionLocal chefDeRayon;
    
    
   
    
    
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
        
        if(request.getSession(false).getAttribute("name") == null)
        {
            jspClient="/login.jsp";
        }
        
        else if((action==null) || (action.equals("null")))
        {
            jspClient="/chefDeRayon/index.jsp";
        }
        
        else if (action.equals("ajouterArticle"))
        {
            jspClient="/chefDeRayon/ajouterArticle.jsp";
            ajouterArticle(request,response);

        }
                else if (action.equals("versAjouterArticle"))
        {
            jspClient="/chefDeRayon/ajouterArticle.jsp";
        }
        
                else if (action.equals("afficherTousLesArticles"))
        {
            jspClient="/chefDeRayon/listeArticle.jsp";
            afficherTousLesArticles(request,response);

        }
                else if (action.equals("versAjouterAuRayon"))
        {
            jspClient="/chefDeRayon/ajouterArticleAuRayon.jsp";
        }
                else if (action.equals("ajouterAuRayon"))
        {
            jspClient="/chefDeRayon/ajouterArticleAuRayon.jsp";
            ajouterAuRayon(request,response);
        }
               
        
        
        RequestDispatcher rd;
        rd = getServletContext().getRequestDispatcher(jspClient);
        rd.forward(request, response);
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ChefDeRayon</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ChefDeRayon at " + request.getContextPath() + "</h1>");
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

    private void ajouterArticle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String libelle = request.getParameter("libelle");
        String reference = request.getParameter("reference");
        String categorie = request.getParameter("categorie");
        String message;
        String jspClient;
        if(!(libelle.isEmpty()) && !(reference.trim().isEmpty()) && !(categorie.trim().isEmpty()))
        {
            String libelleArticle = libelle;
            CategorieArticle ca = null;
            if ("0".equals(categorie)){ca = CategorieArticle.Général;}
            if ("1".equals(categorie)){ca = CategorieArticle.Alimentaire;}
            if ("2".equals(categorie)){ca = CategorieArticle.Vêtements;}
            if ("3".equals(categorie)){ca = CategorieArticle.Electroménager;}

            int referenceArticle = Integer.valueOf(reference);
            
            chefDeRayon.ajouterArticle(referenceArticle, libelle, ca);
            message = "Article crée Avec succes";
            // Nom du menu à changer
            jspClient ="/ajouterArticle";
        }
        else
        {
            message = "Merci de saisir les champs précédés d'un astérisque";
            request.setAttribute("message", message);
            // Nom du menu à changer
            jspClient ="/ajouterArticle";
        }
        
                
    }

    private void afficherTousLesArticles(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = "Voici la liste des articles";
        Collection <Article> article = chefDeRayon.afficherTousLesArticles();
        request.setAttribute("message", message);
        request.setAttribute("article", article);
    }
    
    private void ajouterAuRayon(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    { 
    
    }

}
