/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessions;

import Entites.Autre.Rayon;
import Entites.Autre.RayonArticle;
import java.util.Date;
import javax.ejb.Local;

/**
 *
 * @author 6137220
 */
@Local
public interface EmployeDeRayonSessionLocal {

    public RayonArticle RechercheArticleParLibelle(Rayon r, String libelle);

    public RayonArticle RechercheArticleParReference(Rayon r, int reference);

    public void retirerStockPerime(Date date, Rayon r);
    
}
