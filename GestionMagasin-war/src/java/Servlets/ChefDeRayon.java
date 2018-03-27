/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Entites.Autre.Article;
import Entites.Autre.BonDeCommande;
import Entites.Autre.CommandeLot;
import Entites.Autre.Rayon;
import Entites.Autre.RayonArticle;
import Entites.Enum.CategorieArticle;
import Entites.Personne.Employe;
import Entites.Personne.Fournisseur;
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
import javax.servlet.http.HttpSession;

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
            ajouterArticle(request,response);
            jspClient="/chefDeRayon/listeArticle.jsp";

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
                else if (action.equals("ajouterFournisseur"))
        {                
                ajouterFournisseur(request,response);
                jspClient="/chefDeRayon/listeFournisseur.jsp";
                
                        }
                
                
                else if (action.equals("versAjouterFournisseur"))
        {                
                versAjouterFournisseur(request,response);
                jspClient="/chefDeRayon/ajouterFournisseur.jsp";
                
                        }
                        
                
                
                else if (action.equals("listerFournisseur"))
        {
            jspClient="/chefDeRayon/listeFournisseur.jsp";
                listerFournisseur (request,response); }
                        
                
                
                
                else if (action.equals("versAjouterAuRayon"))
        {
            
            jspClient="/chefDeRayon/ajouterArticleAuRayon.jsp";
              versAjouterAuRayon(request,response);
        }
                
                
                
                else if (action.equals("ajouterAuRayon"))
        {
            jspClient="/chefDeRayon/listeRayonArticle.jsp";
            ajouterAuRayon(request,response);
        }
                
                
                
                else if (action.equals("versModifierRayonArticle"))
        {
        versModifierRayonArticle(request,response);
        jspClient="/chefDeRayon/modifierPrix.jsp";}
        
           
                
                
                else if (action.equals("listerLesRayonArticle"))
        {jspClient="/chefDeRayon/listeRayonArticle.jsp";
        afficherTousLesRayonArticles(request,response);}
        
        
                
                else if (action.equals("modifierPrix"))
        {
            modifierPrix(request,response);
            jspClient="/chefDeRayon/listeRayonArticle.jsp";
            

        }  
        
        else if (action.equals("listerCommande"))
        {
            listerCommande(request,response);
            jspClient="/chefDeRayon/listeCommande.jsp";
            

        }
        
        else if (action.equals("creerCommande")){
        creerCommande(request, response);
        jspClient="/chefDeRayon/ajouterCommande.jsp";
        }
        
        
                else if (action.equals("versCreerCommande")){
                    
        versCreerCommande(request, response);
        jspClient="/chefDeRayon/ajouterCommande.jsp";
        }
                
                else if (action.equals("versCreerCommandeLot")){
        versCreerCommandeLot(request, response);
        jspClient="/chefDeRayon/creerCommandeLot.jsp";
        }
                else if (action.equals("creerCommandeLot")){
        creerCommandeLot(request, response);
        jspClient="/chefDeRayon/creerCommandeLot.jsp";
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
            CategorieArticle ca = null;
            if ("0".equals(categorie)){ca = CategorieArticle.Général;}
            if ("1".equals(categorie)){ca = CategorieArticle.Alimentaire;}
            if ("2".equals(categorie)){ca = CategorieArticle.Vêtements;}
            if ("3".equals(categorie)){ca = CategorieArticle.Electroménager;}

            int referenceArticle = Integer.valueOf(reference);
            
            chefDeRayon.ajouterArticle(referenceArticle, libelle, ca);
            message = "Article crée Avec succes";
        Collection <Article> article = chefDeRayon.afficherTousLesArticles();
        request.setAttribute("message", message);
        request.setAttribute("article", article);
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
        HttpSession session = request.getSession();
        Employe e = (Employe) session.getAttribute("user");
        long r = e.getLeRayon().getId();
        
        int idArticle = Integer.parseInt(request.getParameter("idArticle"));
        Article articleAjouter = chefDeRayon.rechercherArticleParId(idArticle);

        String prix = request.getParameter("prix");
        Rayon rayon = chefDeRayon.rechercherRayonParId(r);
        if(!(prix.isEmpty())) {
        float prixVente = Float.valueOf(prix);
        chefDeRayon.ajouterArticleAuRayon(articleAjouter, rayon, prixVente);
        Collection <RayonArticle> rayonArticle = chefDeRayon.listerRayonArticleParRayon(rayon);
        request.setAttribute("rayonArticle", rayonArticle);
        
}
        
        
        
        
        
        
    
    }
        private void versAjouterAuRayon(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    { 
        HttpSession session = request.getSession();
        Employe e = (Employe) session.getAttribute("user");
        long r = e.getLeRayon().getId();
        Rayon rayon = chefDeRayon.rechercherRayonParId(r);
        int idArticle = Integer.parseInt(request.getParameter("idArticle"));
        Article article = chefDeRayon.rechercherArticleParId(idArticle);
        request.setAttribute("article", article);
        request.setAttribute("rayon", rayon);
        
        
        
    
    }
        
        private void versModifierRayonArticle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    { 

        int idRayonArticle = Integer.parseInt(request.getParameter("idRayonArticle"));
        RayonArticle ra= chefDeRayon.chercherRayonArticleParId(idRayonArticle);
        Article a = ra.getLesArticles();
        request.setAttribute("rayonArticle", ra);
        request.setAttribute("article", a);
        request.setAttribute("idRayonArticle", idRayonArticle);

    }
                
        private void afficherTousLesRayonArticles(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String message = "Voici la liste des articles dans le rayon";
        HttpSession session = request.getSession();
        Employe e = (Employe) session.getAttribute("user");
        Rayon r = e.getLeRayon();
//        Rayon rayon = chefDeRayon.rechercherRayonParId(r);
        Collection <RayonArticle> rayonArticle = chefDeRayon.listerRayonArticleParRayon(r);
        request.setAttribute("message", message);
        request.setAttribute("rayonArticle", rayonArticle);
    }

    private void modifierPrix(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        int idRayonArticle = Integer.parseInt(request.getParameter("idRayonArticle"));
        RayonArticle rayonArticleAmodifier = chefDeRayon.chercherRayonArticleParId(idRayonArticle);
        Article a = rayonArticleAmodifier.getLesArticles();
        Rayon r= rayonArticleAmodifier.getLesRayons();
        String prix = request.getParameter("prix");
        if(!(prix.isEmpty())) {
        float prixVente = Float.valueOf(prix);
        chefDeRayon.modifierPrixArticle(rayonArticleAmodifier, prixVente);
        Collection <RayonArticle> rayonArticle = chefDeRayon.listerRayonArticleParRayon(r);
        request.setAttribute("rayonArticle", rayonArticle);}

        
    }

    private void listerFournisseur(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String message = "Voici la liste des fournisseurs";
        Collection <Fournisseur> fournisseur = chefDeRayon.listerFournisseur();
        request.setAttribute("message", message);
        request.setAttribute("fournisseur", fournisseur);
        
    }

    private void ajouterFournisseur(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        String raisonSociale = request.getParameter("raisonSociale");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String login = request.getParameter("login");
        String mdp = request.getParameter("mdp");
        
        if(!(raisonSociale.isEmpty()) && !(nom.trim().isEmpty()) && !(prenom.trim().isEmpty()) && !(login.trim().isEmpty()) && !(mdp.trim().isEmpty()))
        {
            chefDeRayon.ajouterFournisseur(raisonSociale, login, prenom, nom, prenom);
        
        
                String message = "Voici la liste des fournisseurs";
        Collection <Fournisseur> fournisseur = chefDeRayon.listerFournisseur();
        request.setAttribute("message", message);
        request.setAttribute("fournisseur", fournisseur);}
        
        
        
    }
    
    
    private void versAjouterFournisseur(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{}

    private void listerCommande(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        
        String message = "Voici la liste des commandes du rayon";
        HttpSession session = request.getSession();
        Employe e = (Employe) session.getAttribute("user");
        Rayon r = e.getLeRayon();
//        Rayon rayon = chefDeRayon.rechercherRayonParId(r);
        Collection <BonDeCommande> commande = chefDeRayon.listerCommandesParRayon(r);
        request.setAttribute("message",message);
        request.setAttribute("commande",commande);
        
    
    }

    private void creerCommande(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        Employe e = (Employe) session.getAttribute("user");
        long r = e.getId();
        
        String fournisseurA = request.getParameter("four");
        
        if(!(fournisseurA.isEmpty()) )
        {
        int idf =Integer.valueOf(fournisseurA) ;
        
        BonDeCommande bdc = chefDeRayon.creerBonDeCommande(idf, r);
        
        request.setAttribute("bonDeCommande", bdc);
        Collection <Fournisseur> fournisseur = chefDeRayon.listerFournisseur();
        request.setAttribute("ListeFournisseur", fournisseur);
        }
        
        
        
    
    }

    private void versCreerCommande(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Collection <Fournisseur> fournisseur = chefDeRayon.listerFournisseur();
    request.setAttribute("ListeFournisseur", fournisseur);
    BonDeCommande bdc = new BonDeCommande();
    request.setAttribute("bonDeCommande", bdc);
    }

    private void versCreerCommandeLot(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String bon= request.getParameter("bon");
        int bonid= Integer.valueOf(bon);
        BonDeCommande bdc= chefDeRayon.chercherBonDeCommandeParId(bonid);
        HttpSession session = request.getSession();
        Employe e = (Employe) session.getAttribute("user");
        Rayon r = e.getLeRayon();
        Collection <RayonArticle> article = chefDeRayon.listerRayonArticleParRayon(r);
        Collection<CommandeLot> cl = chefDeRayon.rechercherCommandeLotParIdBonDeCommande(bonid);
        request.setAttribute("article", article);
        request.setAttribute("bonDeCommande", bdc);
        request.setAttribute("lots", cl);
        request.setAttribute("bon", bon);
        
    }

    private void creerCommandeLot(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
        String bon= request.getParameter("bon");
        request.setAttribute("bon", bon);
        int bonid= Integer.valueOf(bon);
        BonDeCommande bdc= chefDeRayon.chercherBonDeCommandeParId(bonid);
        HttpSession session = request.getSession();
        Employe e = (Employe) session.getAttribute("user");
        Rayon r = e.getLeRayon();
        Collection <RayonArticle> article = chefDeRayon.listerRayonArticleParRayon(r);
        Collection<CommandeLot> cl = chefDeRayon.rechercherCommandeLotParIdBonDeCommande(bonid);
        request.setAttribute("article", article);
        request.setAttribute("bonDeCommande", bdc);
        request.setAttribute("lots", cl);
        String prix = request.getParameter("prix");
        String quantite= request.getParameter("quantite");
        int ar = Integer.valueOf(request.getParameter("libelle"));
        Article a = chefDeRayon.rechercherArticleParId(ar);
        
        if(!(quantite.isEmpty()) && !(prix.trim().isEmpty())){
        float prixi = Float.valueOf(prix);
        int quantitei = Integer.valueOf(quantite);
        chefDeRayon.creerCommandeLot(bdc, prixi, a, quantitei);
        
        }
        

    }

}
