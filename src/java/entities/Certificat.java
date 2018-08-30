/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author SDKGAMES
 */
@Entity
@Table(name = "certificat", catalog = "pki_bd", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"clePublic"})
    , @UniqueConstraint(columnNames = {"clePrivee"})
    , @UniqueConstraint(columnNames = {"numSerie"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Certificat.findAll", query = "SELECT c FROM Certificat c")
    , @NamedQuery(name = "Certificat.findByIdCertificat", query = "SELECT c FROM Certificat c WHERE c.idCertificat = :idCertificat")
    , @NamedQuery(name = "Certificat.findByVersion", query = "SELECT c FROM Certificat c WHERE c.version = :version")
    , @NamedQuery(name = "Certificat.findByNumSerie", query = "SELECT c FROM Certificat c WHERE c.numSerie = :numSerie")
    , @NamedQuery(name = "Certificat.findByIdUser", query = "SELECT c FROM Certificat c WHERE c.idUser = :idUser")
    , @NamedQuery(name = "Certificat.findByDateCreation", query = "SELECT c FROM Certificat c WHERE c.dateCreation = :dateCreation")
    , @NamedQuery(name = "Certificat.findByDateExpiration", query = "SELECT c FROM Certificat c WHERE c.dateExpiration = :dateExpiration")
    , @NamedQuery(name = "Certificat.findByDateRevoque", query = "SELECT c FROM Certificat c WHERE c.dateRevoque = :dateRevoque")
    , @NamedQuery(name = "Certificat.findByStatutCertificat", query = "SELECT c FROM Certificat c WHERE c.statutCertificat = :statutCertificat")
    , @NamedQuery(name = "Certificat.findByClePublic", query = "SELECT c FROM Certificat c WHERE c.clePublic = :clePublic")
    , @NamedQuery(name = "Certificat.findByClePrivee", query = "SELECT c FROM Certificat c WHERE c.clePrivee = :clePrivee")
    , @NamedQuery(name = "Certificat.findByContentCertificat", query = "SELECT c FROM Certificat c WHERE c.contentCertificat = :contentCertificat")})
public class Certificat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_certificat", nullable = false)
    private Integer idCertificat;
    @Size(max = 50)
    @Column(name = "version", length = 50)
    private String version;
    @Size(max = 50)
    @Column(name = "numSerie", length = 50)
    private String numSerie;
    @Column(name = "id_user")
    private Integer idUser;
    @Column(name = "dateCreation")
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
    @Column(name = "dateExpiration")
    @Temporal(TemporalType.DATE)
    private Date dateExpiration;
    @Column(name = "dateRevoque")
    @Temporal(TemporalType.DATE)
    private Date dateRevoque;
    @Column(name = "statutCertificat")
    private Integer statutCertificat;
    @Column(name = "clePublic")
    private Integer clePublic;
    @Column(name = "clePrivee")
    private Integer clePrivee;
    @Column(name = "contentCertificat")
    private Integer contentCertificat;
    @JoinColumn(name = "id_certificat", referencedColumnName = "id_user", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private User user;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "certificat")
    private TypeCertificat typeCertificat;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "certificat")
    private Demande demande;

    public Certificat() {
    }

    public Certificat(Integer idCertificat) {
        this.idCertificat = idCertificat;
    }

    public Integer getIdCertificat() {
        return idCertificat;
    }

    public void setIdCertificat(Integer idCertificat) {
        this.idCertificat = idCertificat;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(Date dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public Date getDateRevoque() {
        return dateRevoque;
    }

    public void setDateRevoque(Date dateRevoque) {
        this.dateRevoque = dateRevoque;
    }

    public Integer getStatutCertificat() {
        return statutCertificat;
    }

    public void setStatutCertificat(Integer statutCertificat) {
        this.statutCertificat = statutCertificat;
    }

    public Integer getClePublic() {
        return clePublic;
    }

    public void setClePublic(Integer clePublic) {
        this.clePublic = clePublic;
    }

    public Integer getClePrivee() {
        return clePrivee;
    }

    public void setClePrivee(Integer clePrivee) {
        this.clePrivee = clePrivee;
    }

    public Integer getContentCertificat() {
        return contentCertificat;
    }

    public void setContentCertificat(Integer contentCertificat) {
        this.contentCertificat = contentCertificat;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TypeCertificat getTypeCertificat() {
        return typeCertificat;
    }

    public void setTypeCertificat(TypeCertificat typeCertificat) {
        this.typeCertificat = typeCertificat;
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
        hash += (idCertificat != null ? idCertificat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Certificat)) {
            return false;
        }
        Certificat other = (Certificat) object;
        if ((this.idCertificat == null && other.idCertificat != null) || (this.idCertificat != null && !this.idCertificat.equals(other.idCertificat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Certificat[ idCertificat=" + idCertificat + " ]";
    }
    
}
