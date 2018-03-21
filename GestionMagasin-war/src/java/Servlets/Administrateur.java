/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Entites.Autre.Adresse;
import Entites.Autre.Article;
import Entites.Autre.Magasin;
import Entites.Autre.Rayon;
import Entites.Enum.TypeCompte;
import Entites.Personne.Employe;
import Entites.Personne.Personne;
import Sessions.AdministrateurLocal;
import Sessions.DirectionLocal;
import facades.AgentDeLivraisonFacade;
import facades.EmployeFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
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
public class Administrateur extends HttpServlet {
    
    @EJB
    private DirectionLocal direction;

    @EJB
    private AdministrateurLocal administrateur;   
    
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
            jspClient="/Administrateur/index.jsp";
        }
        
        else if(action.equals("creerEmploye"))
        {
            creerUtilisateur(request, response);
            //jspClient="/Administrateur/listeEmploye.jsp";
        }
        
        else if(action.equals("afficherTousEmployes"))
        {
            afficherTousEmployes(request, response);
            jspClient="/Administrateur/listeEmploye.jsp";
        }
            
        else if(action.equals("supprimerEmploye"))
        {
            supprimerEmploye(request, response);
            jspClient="/include/menu.jsp";
        }
        
        else if(action.equals("afficherTousMagasins"))
        {
            afficherTousMagasins(request, response);
            jspClient="/Administrateur/listeMagasin.jsp";
        }
        
        else if(action.equals("creerMagasin"))
        {
            creerMagasin(request, response);
            jspClient="/Administrateur/listeMagasin.jsp";
        }
        
        else if(action.equals("modifierMagasin"))
        {
            modifierMagasin(request, response);
            jspClient="/Administrateur/listeMagasin.jsp";
        }            
        
        else if(action.equals("creerRayon"))
        {
            creerRayon(request, response);
            jspClient="/Administrateur/listeRayon.jsp";
        }
        
        else if(action.equals("versCreerRayon"))
        {
            versCreerRayon(request, response);
            jspClient="/Administrateur/creerRayon.jsp";
        }
        
        else if(action.equals("modifierRayon"))
        {
            modifierRayon(request, response);
            jspClient="/Administrateur/listeRayon.jsp";
        }
        
        else if(action.equals("versModifierRayon"))
        {
            versModifierRayon(request, response);
            jspClient="/Administrateur/modifierRayon.jsp";
        }
        
        else if(action.equals("versModifierMagasin"))
        {
            versModifierMagasin(request, response);
            jspClient="/Administrateur/modifierMagasin.jsp";
        }
        
        else if(action.equals("afficherTousRayonsParMagasin"))
        {
            afficherTousRayonsParMagasin(request, response);
            jspClient="/Administrateur/listeRayon.jsp";
        }
        
        else if(action.equals("versCreerMagasin"))
        {
            jspClient="/Administrateur/creerMagasin.jsp";
        }
        
        else if(action.equals("versCreerUtilisateur"))
        {
            jspClient="/Administrateur/creerEmploye.jsp";
            versCreerUtilisateur(request, response);
        }
   
        
        /////////////////////////////////////////////////
        //                Direction                    //
        
        else if(action.equals("redirigerMenuDirection"))
        {
            jspClient="/direction/index.jsp";
        }
        
        else if(action.equals("afficherTousEmployesDirection"))
        {
            afficherTousEmployes(request, response);
            jspClient="/direction/listeEmploye.jsp";
        }
        
        else if(action.equals("supprimerEmployeDirection"))
        {
            supprimerEmploye(request, response);
            jspClient="/direction/index.jsp";
        }
        
        /* À modifier
        else if(action.equals("modifierEmploye"))
        {
            modifierEmploye(request, response);
            jspClient="/modifierEmploye.jsp";
        }
        */
        
        else if(action.equals("versRechercheEmploye"))
        {
            jspClient="/direction/rechercherEmploye.jsp";
        }
        
        else if(action.equals("rechercherEmploye"))
        {
            rechercherEmploye(request, response);
            jspClient="/direction/listeEmploye.jsp";
        }
        
        else if(action.equals("versRechercheArticleParNom"))
        {
            jspClient="/direction/rechercherArticle.jsp";
        }
        
        else if(action.equals("rechercherArticleParNom"))
        {
            rechercherArticleParNom(request, response);
            jspClient="/direction/listeArticle.jsp";
        }
        
        else if(action.equals("versAjouterPromotion"))
        {
            versAjouterPromotion(request, response);
            jspClient="/direction/ajouterPromotion.jsp";
        }
        
        else if(action.equals("ajouterPromotion"))
        {
            ajouterPromotion(request, response);
            jspClient="/direction/listeArticle.jsp";
        }
        
        else if(action.equals("supprimerPromotion"))
        {
            annulerPromotion(request, response);
            jspClient="/direction/listeArticle.jsp";
        }
        
        /////////////////////////////////////////////////
        
        
        
      
        RequestDispatcher rd;
        rd = getServletContext().getRequestDispatcher(jspClient);
        rd.forward(request, response);
                
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Administrateur</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Administrateur at " + request.getContextPath() + "</h1>");
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

    protected void creerUtilisateur(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
    {
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String login = request.getParameter("login");
        String mdp = request.getParameter("mdp");
        String dateCreationCompte = request.getParameter("dateCreationCompte");
        String typeCompte = request.getParameter("typeCompte");
        String message;
        if(!(nom.trim().isEmpty()) && !(prenom.trim().isEmpty()) && !(login.trim().isEmpty()) && !(mdp.trim().isEmpty()) && !dateCreationCompte.trim().isEmpty() && !(typeCompte.trim().isEmpty()))
        {
            Date dateCreation = Date.valueOf(dateCreationCompte);
            TypeCompte typeDuCompte = TypeCompte.valueOf(typeCompte);            
            administrateur.creerEmploye(nom, prenom, login, mdp, dateCreation, typeDuCompte);
            message = "Utilisateur créé avec succès";
            Collection <Employe> employe = administrateur.afficherTousEmployes();
            request.setAttribute("employe", employe);
        }
        else
        {
            message = "Merci de saisir les champs précédés d'un astérisque";
            request.setAttribute("message", message);
        }
    }
    
    protected void afficherTousEmployes(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
    {
        Collection<Employe> e = administrateur.afficherTousEmployes();
        
        String message = "Voici la liste de tous les employés recensés";
        request.setAttribute("employe", e);
        request.setAttribute("message", message);        
    }   
 
        /* Requête à modifier
    
    protected void modifierEmploye(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
    {       
        
        String id = request.getParameter("id");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String login = request.getParameter("login");
        String mdp_1 = request.getParameter("mdp_1");
        String typeCompte = request.getParameter("typeCompte");
        String rayon = request.getParameter("rayon");
        String magasin = request.getParameter("magasin");
        String message;
        
        request.getSession().setAttribute("rayon", rayon);
        request.setAttribute("rayon", rayon);
        request.getSession().setAttribute("magasin", magasin);
        request.setAttribute("magasin", magasin);
        
        int idEmploye = Integer.valueOf(id);
        TypeCompte typeCompteEmploye = TypeCompte.valueOf(typeCompte);
        
        Employe e = administrateur.rechercherEmployeParId(idEmploye);
        administrateur.modifierEmploye(e, nom, prenom, login, mdp_1, typeCompteEmploye, magasin, rayon);
        
        
        
    }

        */
      
    protected void supprimerEmploye(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
    {
        String id = request.getParameter("id");
        int idEmploye = Integer.parseInt(id);
        Personne personne = administrateur.rechercherPersonneParId(idEmploye);
        administrateur.supprimerPersonne(personne);
    }
    
    protected void afficherTousMagasins(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
    {
        String message = "Voici la liste des magasins";
        Collection<Magasin> magasin = administrateur.afficherTousMagasins();
        request.setAttribute("magasin", magasin);
        request.setAttribute("message", message);
        
    }
    
    protected void creerMagasin(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
    {
        String nom = request.getParameter("nom");
        String libelle = request.getParameter("libelle");
        String rueNom = request.getParameter("rueNom");
        String rueComplement = request.getParameter("rueComplement");
        String codePostal = request.getParameter("codePostal");
        String ville = request.getParameter("ville");
        String message;
        
        int codePostalAdresse = Integer.parseInt(codePostal);
        message = "Votre magasin a bien été créé";
        Adresse adresse = administrateur.creerAdresse(libelle, rueNom, rueComplement, codePostalAdresse, ville);
        administrateur.creerMagasin(nom, adresse);        
        
        Collection<Magasin> magasin = administrateur.afficherTousMagasins();
        request.setAttribute("magasin", magasin);
    }
    
    protected void modifierMagasin(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
    {
        String id = request.getParameter("id");
        String nom = request.getParameter("nom");
        String message;
        
        int idMagasin = Integer.parseInt(id);
        Magasin magasin = administrateur.rechercherMagasinParId(idMagasin);
        administrateur.modifierMagasin(magasin, nom);
        message = "Votre magasin " + magasin.getNom() + " a bien été modifié.";
        
        Collection<Magasin> listeMagasins = administrateur.afficherTousMagasins();
        request.setAttribute("magasin", listeMagasins);
        request.setAttribute("message", message);
        
    }
    
    protected void selectionnerEmploye(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
    {
        String id = request.getParameter("id");
        int idEmploye = Integer.parseInt(id);
        Employe employe = administrateur.rechercherEmployeParId(idEmploye);
        request.setAttribute("employe", employe);
    }
    
    protected void creerRayon(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
    {
        // Il est nécessaire de faire appel à la méthode afficherTousMagasins pour récupérer la liste des magasins avant d'aller sur la page de création
        String nom = request.getParameter("nom");
        String id = request.getParameter("id");
        String message;
        
        int idMagasin = Integer.parseInt(id);
        Magasin magasin = administrateur.rechercherMagasinParId(idMagasin);
        administrateur.creerRayon(nom, magasin);
        Collection<Rayon> rayon = administrateur.rechercherListeRayon(magasin);
        request.setAttribute("rayon", rayon);
        message = "Le rayon " + nom + " a bien été créé";
        request.setAttribute("message", message);
        
    }
    
    // Sous-entend que l'utilisateur arrive sur une liste de magasins et sélectionne le magasin pour lequel il souhaite afficher les rayons
    protected void afficherTousRayonsParMagasin(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
    {
        String id = request.getParameter("id");
        int idMagasin = Integer.parseInt(id);
        Magasin magasin;
        magasin = administrateur.rechercherMagasinParId(idMagasin);
        Collection<Rayon> rayon = administrateur.rechercherListeRayon(magasin);
        request.setAttribute("rayon", rayon);
    }
    
    protected void modifierRayon(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
    {
        String id = request.getParameter("id");
        String nom = request.getParameter("nom");
        String message;
        
        int RayonId = Integer.parseInt(id);       
        Rayon rayonModifie = administrateur.rechercherRayonParId(RayonId);      
        administrateur.modifierRayon(rayonModifie, nom);
        
        Magasin magasin = rayonModifie.getLeMagasin();
        Collection<Rayon> rayon = administrateur.rechercherListeRayon(magasin);
        message = "Le rayon " + rayonModifie.getRayonNom() + " a bien été modifié";
        request.setAttribute("message", message);
        request.setAttribute("rayon", rayon);
    }
   
    protected void versModifierMagasin(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
    {
        String id = request.getParameter("id");
        int idMagasin = Integer.parseInt(id);
        Magasin m = administrateur.rechercherMagasinParId(idMagasin);
        request.setAttribute("magasin", m);
        request.setAttribute("message", m.getNom());
    }
    
    protected void versCreerRayon(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
    {
        String id = request.getParameter("id");
        int idMagasin = Integer.parseInt(id);
        Magasin m = administrateur.rechercherMagasinParId(idMagasin);
        request.setAttribute("magasin", m);
    }
    
    protected void versModifierRayon(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
    {
        String id = request.getParameter("id");
        
        int idRayon = Integer.parseInt(id);
        Rayon rayon = administrateur.rechercherRayonParId(idRayon);
        request.setAttribute("rayon", rayon);
    }
    
    protected void afficherListeArticlesParNom(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
    {
       
    }
    
    protected void versCreerUtilisateur(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
    {
        Collection<Magasin> magasin = administrateur.afficherTousMagasins();
        TypeCompte[] typeCompte = TypeCompte.values();
        ArrayList<TypeCompte> typeCompteList = new ArrayList<>();
        typeCompteList.add(typeCompte[0]);
        typeCompteList.add(typeCompte[1]);
        typeCompteList.add(typeCompte[2]);
        typeCompteList.add(typeCompte[3]);
        typeCompteList.add(typeCompte[4]);
        typeCompteList.add(typeCompte[6]);
        typeCompteList.add(typeCompte[8]);
        request.setAttribute("typeCompte", typeCompteList);
        request.setAttribute("magasin", magasin);        
    }
    
    protected void rechercherEmploye(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
    {
        String name = request.getParameter("nom");
        Collection<Employe> employe = direction.rechercherEmployeParNom(name);
        request.setAttribute("employe", employe);
    }
    
    protected void rechercherArticleParNom(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
    {
        String name = request.getParameter("nom");
        Collection<Article> article = direction.afficherArticleParLibelle(name);
        request.setAttribute("article", article);
    }
    
    protected void versAjouterPromotion(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
    {
        String id = request.getParameter("id");
        int referenceArticle = Integer.parseInt(id);
        Article article = direction.rechercherArticleParId(referenceArticle);
        request.setAttribute("article", article);
    }
    
    protected void ajouterPromotion(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
    {
        String nom = request.getParameter("nom");
        String id = request.getParameter ("id");
        String prixPromotion = request.getParameter("prixPromotion");
        
        int idArticle = Integer.parseInt(id);
        float prix = Float.parseFloat(prixPromotion);
        
        Article articleModifie = direction.rechercherArticleParId(idArticle);
        direction.ajouterPromotion(articleModifie, prix);
        Collection<Article> article = direction.afficherArticleParLibelle(nom);

        request.setAttribute("article", article);
    }
    
    protected void annulerPromotion(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
    {
        String id = request.getParameter("id");
        int idArticle = Integer.parseInt(id);
        Article articleModifie = direction.rechercherArticleParId(idArticle);
        direction.annulerPromotion(articleModifie);
        ArrayList<Article> articleList = new ArrayList<>();
        articleList.add(articleModifie);
        Collection<Article> article = (Collection<Article>) articleList;
        request.setAttribute("article", article);
    }
    
}
