/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author SDKGAMES
 */
@Entity
@Table(name = "typeCertificat", catalog = "pki_bd", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"nomTypeCertificat"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TypeCertificat.findAll", query = "SELECT t FROM TypeCertificat t")
    , @NamedQuery(name = "TypeCertificat.findByIdtypeCertificat", query = "SELECT t FROM TypeCertificat t WHERE t.idtypeCertificat = :idtypeCertificat")
    , @NamedQuery(name = "TypeCertificat.findByIdCertificat", query = "SELECT t FROM TypeCertificat t WHERE t.idCertificat = :idCertificat")
    , @NamedQuery(name = "TypeCertificat.findByNomTypeCertificat", query = "SELECT t FROM TypeCertificat t WHERE t.nomTypeCertificat = :nomTypeCertificat")})
public class TypeCertificat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_typeCertificat", nullable = false)
    private Integer idtypeCertificat;
    @Column(name = "id_certificat")
    private Integer idCertificat;
    @Size(max = 250)
    @Column(name = "nomTypeCertificat", length = 250)
    private String nomTypeCertificat;
    @JoinColumn(name = "id_typeCertificat", referencedColumnName = "id_certificat", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Certificat certificat;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "typeCertificat")
    private Demande demande;

    public TypeCertificat() {
    }

    public TypeCertificat(Integer idtypeCertificat) {
        this.idtypeCertificat = idtypeCertificat;
    }

    public Integer getIdtypeCertificat() {
        return idtypeCertificat;
    }

    public void setIdtypeCertificat(Integer idtypeCertificat) {
        this.idtypeCertificat = idtypeCertificat;
    }

    public Integer getIdCertificat() {
        return idCertificat;
    }

    public void setIdCertificat(Integer idCertificat) {
        this.idCertificat = idCertificat;
    }

    public String getNomTypeCertificat() {
        return nomTypeCertificat;
    }

    public void setNomTypeCertificat(String nomTypeCertificat) {
        this.nomTypeCertificat = nomTypeCertificat;
    }

    public Certificat getCertificat() {
        return certificat;
    }

    public void setCertificat(Certificat certificat) {
        this.certificat = certificat;
    }

    public Demande getDemande() {
        return demande;
    }

    public void setDemande(Demande demande) {
        this.demande = demande;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtypeCertificat != null ? idtypeCertificat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TypeCertificat)) {
            return false;
        }
        TypeCertificat other = (TypeCertificat) object;
        if ((this.idtypeCertificat == null && other.idtypeCertificat != null) || (this.idtypeCertificat != null && !this.idtypeCertificat.equals(other.idtypeCertificat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TypeCertificat[ idtypeCertificat=" + idtypeCertificat + " ]";
    }
    
}
