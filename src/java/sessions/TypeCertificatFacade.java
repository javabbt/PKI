/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.TypeCertificat;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author T.leo
 */
@Stateless
public class TypeCertificatFacade extends AbstractFacade<TypeCertificat> implements TypeCertificatFacadeLocal {

    @PersistenceContext(unitName = "PKIPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TypeCertificatFacade() {
        super(TypeCertificat.class);
    }
    
}
