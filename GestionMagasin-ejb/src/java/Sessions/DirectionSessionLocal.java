/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessions;

import javax.ejb.Local;

/**
 *
 * @author houss
 */
@Local
public interface DirectionSessionLocal {

    public void demarrerUnePrommotion(int reference, float prixPromotion);

    public void cloturerPromotion(int reference);
    
}
