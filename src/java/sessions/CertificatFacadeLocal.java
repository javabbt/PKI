/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Certificat;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author T.leo
 */
@Local
public interface CertificatFacadeLocal {

    void create(Certificat certificat);

    void edit(Certificat certificat);

    void remove(Certificat certificat);

    Certificat find(Object id);

    List<Certificat> findAll();

    List<Certificat> findRange(int[] range);

    int count();
    
}
