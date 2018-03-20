/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Entites.Personne.Administrateur;
import Entites.Personne.AgentDeLivraison;
import Entites.Personne.ChefDeRayon;
import Entites.Personne.Direction;
import Entites.Personne.EmployeDeCaisse;
import Entites.Personne.EmployeRayon;
import Entites.Personne.Fournisseur;
import Entites.Personne.GerantMagasin;
import Entites.Personne.Personne;
import Sessions.AdministrateurLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.ejb.EJBTransactionRolledbackException;
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
public class Authentication extends HttpServlet {

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
        
        // If-else inital permettant de diriger les requètes utilisateurs       
        // Jsp par defaut lorsque l'utilisateur exécute la solution
        
        if((action==null) || (action.equals("null")))
        {
            
            jspClient="/login.jsp";
            administrateur.creerAdminDemarrage();
            RequestDispatcher rd;
            rd = getServletContext().getRequestDispatcher(jspClient);
            rd.forward(request, response);
        }
  
        else if(action.equals("connexion")) {
            HttpSession session = request.getSession(true);
            String login = request.getParameter("userName");
            String password = request.getParameter("mdp");
            Personne p;
            if (!(login.trim().isEmpty()))
            {
                String message;
                try {
                    p = administrateur.authentification(login, password);
                    if (p instanceof Administrateur)
                    {
                        message = "Administrateur";
                        session.setAttribute("user", p);
                        request.setAttribute("message", message);
                        response.sendRedirect("Administrateur");
                    }
                    if (p instanceof ChefDeRayon)
                    {
                        ChefDeRayon r = (ChefDeRayon) p;
                        message = "Chef de rayon";
                        session.setAttribute("user", r);
                        request.setAttribute("message", message);
                        jspClient ="/login.jsp";
                    } 
                    if (p instanceof EmployeDeCaisse)
                    {
                        EmployeDeCaisse c = (EmployeDeCaisse) p;
                        message = "Employé de caisse";
                        session.setAttribute("user", c);
                        request.setAttribute("message", message);
                        jspClient ="/login.jsp";
                    }
                    if (p instanceof EmployeRayon)
                    {
                        EmployeRayon r = (EmployeRayon) p;
                        message = "Employé de rayon";
                        session.setAttribute("user", r);
                        request.setAttribute("message", message);
                        jspClient ="/login.jsp";
                    }
                    if (p instanceof GerantMagasin)
                    {
                        GerantMagasin g = (GerantMagasin) p;
                        message = "Gérant de magasin";
                        session.setAttribute("user", g);
                        request.setAttribute("message", message);
                        jspClient ="/login.jsp";
                    }
                    if (p instanceof AgentDeLivraison)
                    {
                        AgentDeLivraison a = (AgentDeLivraison) p;
                        message = "Agent de livraison";
                        session.setAttribute("user", a);
                        request.setAttribute("message", message);
                        jspClient ="/login.jsp";
                    }
                    if (p instanceof Direction)
                    {
                        Direction d = (Direction) p;
                        message = "Direction";
                        session.setAttribute("user", d);
                        request.setAttribute("message", message);
                        jspClient ="/login.jsp";
                    }
                    if (p instanceof Fournisseur)
                    {
                        Fournisseur f  = (Fournisseur) p;
                        message = "Fournisseur";
                        session.setAttribute("user", f);
                        request.setAttribute("message", message);
                        jspClient ="/login.jsp";
                    }
                }
                catch (EJBTransactionRolledbackException e)
                {
                    message = "Identifiant ou mot de passe invalide";
                    request.setAttribute("message", message);
                    jspClient ="/login.jsp";
                }
            }
            else
            {
                String message = "Le nom de compte et le mot de passe sont obligatoires";
                request.setAttribute("message", message);
                jspClient="login.jsp";
            }
        }              
        
        /*      
        RequestDispatcher rd;
        rd = getServletContext().getRequestDispatcher(jspClient);
        rd.forward(request, response);
        */
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Authentication</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Authentication at " + request.getContextPath() + "</h1>");
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

}
