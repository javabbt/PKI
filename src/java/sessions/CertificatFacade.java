/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Certificat;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author T.leo
 */
@Stateless
public class CertificatFacade extends AbstractFacade<Certificat> implements CertificatFacadeLocal {

    @PersistenceContext(unitName = "PKIPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CertificatFacade() {
        super(Certificat.class);
    }
    
}
