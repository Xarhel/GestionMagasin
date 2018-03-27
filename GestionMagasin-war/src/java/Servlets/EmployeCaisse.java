/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Entites.Autre.RayonArticle;
import Entites.Personne.Employe;
import Entites.Vente.ArticleVente;
import Sessions.EmployeDeCaisseSessionLocal;
import java.io.IOException;
import java.io.PrintWriter;
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
 * @author 3137574
 */
public class EmployeCaisse extends HttpServlet {

    @EJB
    private EmployeDeCaisseSessionLocal employeDeCaisseSession;

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
            jspClient ="/login.jsp";
        }
        
        else if(action == null || action.equals("null"))
        {
            jspClient ="/EmployeDeCaisse/index.jsp";
        }
        
        else if(action.equals("versEnregistrerVente"))
        {
            versEnregistrerVente(request, response);
            jspClient="/EmployeDeCaisse/enregistrerVente.jsp";
        }
        
        else if(action.equals("ajouterArticle"))
        {
            ajouterArticle(request, response);
            jspClient="/EmployeDeCaisse/enregistrerVente.jsp";
        }
        
        
        // Logout
        
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
            out.println("<title>Servlet EmployeCaisse</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EmployeCaisse at " + request.getContextPath() + "</h1>");
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

    
    protected void versEnregistrerVente(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
    {
        
        // Création du panier
        
        HttpSession session = request.getSession();
        Employe e = (Employe) session.getAttribute("user");
        long idPanier = employeDeCaisseSession.creerPanierCaisse(Integer.parseInt(e.getId().toString()));
        
        // Recherche des articles présents dans ce magasin
        
        Collection<RayonArticle> rayonArticles = employeDeCaisseSession.rechercherRayonArticleParIdMagasin(Integer.parseInt(e.getLeMagasin().getId().toString()));
        
        // Création d'une liste d'articles vide pour ne pas avoir d'erreur en important le bean sur la page d'ajout des articles au panier
        
        ArrayList<ArticleVente> articlesVenteArrayList = new ArrayList<>();
        Collection<ArticleVente> articlesVente = articlesVenteArrayList;
        
        // Définition des paramètres utilisés dans la jsp
        
        request.setAttribute("idPanier", idPanier);
        request.setAttribute("rayonArticles", rayonArticles);
        request.setAttribute("articlesVente", articlesVente);
        
    }
    
    protected void ajouterArticle(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
    {
        
        // Récupération des paramètres de la jsp
        
        HttpSession session = request.getSession();
        Employe e = (Employe) session.getAttribute("user");
        String stringIdPanier = request.getParameter("idPanierActuel");
        String stringIdRayonArticle = request.getParameter("article");
        String stringQuantite = request.getParameter("quantite");
        
        // Casting des attributs
        
        long idPanier = Long.valueOf(stringIdPanier);
        int idRayonArticle = Integer.parseInt(stringIdRayonArticle);
        long idArticle = employeDeCaisseSession.rechercherRayonArticleParId(idRayonArticle).getLesArticles().getId();
        int idArticleFinal = Integer.parseInt(Long.toString(idArticle));
        Integer quantite = Integer.valueOf(stringQuantite);
        
        // Ajout de l'article au panier
                
        employeDeCaisseSession.ajouterArticleVente(idPanier, idArticleFinal, quantite, employeDeCaisseSession.rechercherRayonArticleParId(idRayonArticle).getPrixVente() ,e.getIdMagasin());    
        
        // Recherche des articles présents dans ce magasin et des articles du panier
        
        
        Collection<RayonArticle> rayonArticles = employeDeCaisseSession.rechercherRayonArticleParIdMagasin(Integer.parseInt(e.getLeMagasin().getId().toString()));             
        Collection<ArticleVente> articlesVente = employeDeCaisseSession.rechercherArticleVenteParPanier(idPanier);
        
        // Passage des paramètres à la jsp
        
        request.setAttribute("idPanier", idPanier);
        request.setAttribute("rayonArticles", rayonArticles);
        request.setAttribute("articlesVente", articlesVente);
        
    }
    
    
}
