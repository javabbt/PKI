/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.TypeCertificat;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author T.leo
 */
@Local
public interface TypeCertificatFacadeLocal {

    void create(TypeCertificat typeCertificat);

    void edit(TypeCertificat typeCertificat);

    void remove(TypeCertificat typeCertificat);

    TypeCertificat find(Object id);

    List<TypeCertificat> findAll();

    List<TypeCertificat> findRange(int[] range);

    int count();
    
}
