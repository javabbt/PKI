/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author SDKGAMES
 */
@Entity
@Table(name = "demande", catalog = "pki_bd", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Demande.findAll", query = "SELECT d FROM Demande d")
    , @NamedQuery(name = "Demande.findByIdDemande", query = "SELECT d FROM Demande d WHERE d.idDemande = :idDemande")
    , @NamedQuery(name = "Demande.findByMotif", query = "SELECT d FROM Demande d WHERE d.motif = :motif")
    , @NamedQuery(name = "Demande.findByValidite", query = "SELECT d FROM Demande d WHERE d.validite = :validite")
    , @NamedQuery(name = "Demande.findByIdtypeCertificat", query = "SELECT d FROM Demande d WHERE d.idtypeCertificat = :idtypeCertificat")
    , @NamedQuery(name = "Demande.findByIdUser", query = "SELECT d FROM Demande d WHERE d.idUser = :idUser")
    , @NamedQuery(name = "Demande.findByIdCertificat", query = "SELECT d FROM Demande d WHERE d.idCertificat = :idCertificat")
    , @NamedQuery(name = "Demande.findByEtatDemande", query = "SELECT d FROM Demande d WHERE d.etatDemande = :etatDemande")})
public class Demande implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_demande", nullable = false)
    private Integer idDemande;
    @Size(max = 250)
    @Column(name = "motif", length = 250)
    private String motif;
    @Column(name = "validite")
    @Temporal(TemporalType.DATE)
    private Date validite;
    @Column(name = "id_typeCertificat")
    private Integer idtypeCertificat;
    @Column(name = "id_user")
    private Integer idUser;
    @Column(name = "id_certificat")
    private Integer idCertificat;
    @Size(max = 20)
    @Column(name = "etatDemande", length = 20)
    private String etatDemande;
    @JoinColumn(name = "id_demande", referencedColumnName = "id_certificat", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Certificat certificat;
    @JoinColumn(name = "id_demande", referencedColumnName = "id_typeCertificat", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private TypeCertificat typeCertificat;
    @JoinColumn(name = "id_demande", referencedColumnName = "id_user", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private User user;

    public Demande() {
    }

    public Demande(Integer idDemande) {
        this.idDemande = idDemande;
    }

    public Integer getIdDemande() {
        return idDemande;
    }

    public void setIdDemande(Integer idDemande) {
        this.idDemande = idDemande;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public Date getValidite() {
        return validite;
    }

    public void setValidite(Date validite) {
        this.validite = validite;
    }

    public Integer getIdtypeCertificat() {
        return idtypeCertificat;
    }

    public void setIdtypeCertificat(Integer idtypeCertificat) {
        this.idtypeCertificat = idtypeCertificat;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdCertificat() {
        return idCertificat;
    }

    public void setIdCertificat(Integer idCertificat) {
        this.idCertificat = idCertificat;
    }

    public String getEtatDemande() {
        return etatDemande;
    }

    public void setEtatDemande(String etatDemande) {
        this.etatDemande = etatDemande;
    }

    public Certificat getCertificat() {
        return certificat;
    }

    public void setCertificat(Certificat certificat) {
        this.certificat = certificat;
    }

    public TypeCertificat getTypeCertificat() {
        return typeCertificat;
    }

    public void setTypeCertificat(TypeCertificat typeCertificat) {
        this.typeCertificat = typeCertificat;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDemande != null ? idDemande.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Demande)) {
            return false;
        }
        Demande other = (Demande) object;
        if ((this.idDemande == null && other.idDemande != null) || (this.idDemande != null && !this.idDemande.equals(other.idDemande))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Demande[ idDemande=" + idDemande + " ]";
    }
    
}
