/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Demande;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author T.leo
 */
@Stateless
public class DemandeFacade extends AbstractFacade<Demande> implements DemandeFacadeLocal {

    @PersistenceContext(unitName = "PKIPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DemandeFacade() {
        super(Demande.class);
    }
    
}
