/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kawalkuota.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Yusrul <yusrul@kemenkeu.go.id>
 */
@Entity
@Table(name = "rekomendasi", catalog = "kawalkuota", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rekomendasi.findAll", query = "SELECT r FROM Rekomendasi r"),
    @NamedQuery(name = "Rekomendasi.findByIdRekomendasi", query = "SELECT r FROM Rekomendasi r WHERE r.idRekomendasi = :idRekomendasi"),
    @NamedQuery(name = "Rekomendasi.findByNoSurat", query = "SELECT r FROM Rekomendasi r WHERE r.noSurat = :noSurat"),
    @NamedQuery(name = "Rekomendasi.findByNpwp", query = "SELECT r FROM Rekomendasi r WHERE r.npwp = :npwp"),
    @NamedQuery(name = "Rekomendasi.findByTipe", query = "SELECT r FROM Rekomendasi r WHERE r.tipe = :tipe"),
    @NamedQuery(name = "Rekomendasi.findByTglawal", query = "SELECT r FROM Rekomendasi r WHERE r.tglawal = :tglawal"),
    @NamedQuery(name = "Rekomendasi.findByTglakhir", query = "SELECT r FROM Rekomendasi r WHERE r.tglakhir = :tglakhir"),
    @NamedQuery(name = "Rekomendasi.findByStatus", query = "SELECT r FROM Rekomendasi r WHERE r.status = :status")})
public class Rekomendasi implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_rekomendasi")
    private Integer idRekomendasi;
    @Size(max = 20)
    @Column(name = "no_surat")
    private String noSurat;
    @Size(max = 16)
    @Column(name = "npwp")
    private String npwp;
    @Size(max = 20)
    @Column(name = "tipe")
    private String tipe;
    @Column(name = "tglawal")
    @Temporal(TemporalType.DATE)
    private Date tglawal;
    @Column(name = "tglakhir")
    @Temporal(TemporalType.DATE)
    private Date tglakhir;
    @Size(max = 100)
    @Column(name = "status")
    private String status;

    public Rekomendasi() {
    }

    public Rekomendasi(Integer idRekomendasi) {
        this.idRekomendasi = idRekomendasi;
    }

    public Integer getIdRekomendasi() {
        return idRekomendasi;
    }

    public void setIdRekomendasi(Integer idRekomendasi) {
        this.idRekomendasi = idRekomendasi;
    }

    public String getNoSurat() {
        return noSurat;
    }

    public void setNoSurat(String noSurat) {
        this.noSurat = noSurat;
    }

    public String getNpwp() {
        return npwp;
    }

    public void setNpwp(String npwp) {
        this.npwp = npwp;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public Date getTglawal() {
        return tglawal;
    }

    public void setTglawal(Date tglawal) {
        this.tglawal = tglawal;
    }

    public Date getTglakhir() {
        return tglakhir;
    }

    public void setTglakhir(Date tglakhir) {
        this.tglakhir = tglakhir;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRekomendasi != null ? idRekomendasi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rekomendasi)) {
            return false;
        }
        Rekomendasi other = (Rekomendasi) object;
        if ((this.idRekomendasi == null && other.idRekomendasi != null) || (this.idRekomendasi != null && !this.idRekomendasi.equals(other.idRekomendasi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kawalkuota.entity.Rekomendasi[ idRekomendasi=" + idRekomendasi + " ]";
    }
    
}
