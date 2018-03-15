/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Entites.Autre.Adresse;
import Entites.Autre.Magasin;
import Entites.Autre.Rayon;
import Entites.Enum.TypeCompte;
import Entites.Personne.Employe;
import Sessions.AdministrateurLocal;
import facades.AgentDeLivraisonFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
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
public class Administrateur extends HttpServlet {

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
            jspClient="/Menu";
        }
        
        else if(action.equals("creerUtilisateur"))
        {
            creerUtilisateur(request, response);
            jspClient="/creerUtilisateur.jsp";
        }
        
        else if(action.equals("afficherTousEmployes"))
        {
            afficherTousEmployes(request, response);
            jspClient="/modifierEmploye.jsp";
        }
        
        else if(action.equals("afficherTousEmployesSupprimer"))
        {
            afficherTousEmployes(request, response);
            jspClient="/supprimerEmploye.jsp";
        }
        
        else if(action.equals("supprimerEmploye"))
        {
            supprimerEmploye(request, response);
            jspClient="/menuAdministrateur.jsp";
        }
        
        else if(action.equals("afficherTousMagasins"))
        {
            afficherTousMagasins(request, response);
            jspClient="/creerMagasin.jsp";
        }
        
        else if(action.equals("creerMagasin"))
        {
            creerMagasin(request, response);
            jspClient="/menuAdministrateur.jsp";
        }
        
      
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
        String magasin = request.getParameter("magasin");
        String rayon = request.getParameter("rayon");
        String message;
        String jspClient;
        if(!(nom.trim().isEmpty()) && !(prenom.trim().isEmpty()) && !(login.trim().isEmpty()) && !(mdp.trim().isEmpty()) && !dateCreationCompte.trim().isEmpty() && !(typeCompte.trim().isEmpty()))
        {
            Date dateCreation = Date.valueOf(dateCreationCompte);
            TypeCompte typeDuCompte = TypeCompte.valueOf(typeCompte);
            int idMagasin = Integer.valueOf(magasin);
            int idRayon = Integer.valueOf(rayon);
            
            administrateur.creerEmploye(nom, prenom, login, mdp, dateCreation, typeDuCompte, idMagasin, idRayon);
            message = "Utilisateur créé avec succès";
            // Nom du menu à changer
            jspClient ="Administrateur";
        }
        else
        {
            message = "Merci de saisir les champs précédés d'un astérisque";
            request.setAttribute("message", message);
            // Nom du menu à changer
            jspClient ="menuAdministrateur";
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
        Employe employe = administrateur.rechercherEmployeParId(idEmploye);
        administrateur.supprimerEmploye(employe);
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
        
    }
    
}
