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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LENOVO
 */
@Entity
@Table(name = "ijin", catalog = "kawalkuota", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ijin.findAll", query = "SELECT i FROM Ijin i"),
    @NamedQuery(name = "Ijin.findByIdIjin", query = "SELECT i FROM Ijin i WHERE i.idIjin = :idIjin"),
    @NamedQuery(name = "Ijin.findByNoIjin", query = "SELECT i FROM Ijin i WHERE i.noIjin = :noIjin"),
    @NamedQuery(name = "Ijin.findByTglAwal", query = "SELECT i FROM Ijin i WHERE i.tglAwal = :tglAwal"),
    @NamedQuery(name = "Ijin.findByTglAkhir", query = "SELECT i FROM Ijin i WHERE i.tglAkhir = :tglAkhir"),
    @NamedQuery(name = "Ijin.findByTglIjin", query = "SELECT i FROM Ijin i WHERE i.tglIjin = :tglIjin"),
    @NamedQuery(name = "Ijin.findByNmPerusahaan", query = "SELECT i FROM Ijin i WHERE i.nmPerusahaan = :nmPerusahaan"),
    @NamedQuery(name = "Ijin.findByGa", query = "SELECT i FROM Ijin i WHERE i.ga = :ga")})
public class Ijin implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "id_ijin")
    private String idIjin;
    @Basic(optional = false)
    @Size(min = 1, max = 100)
    @Column(name = "no_ijin")
    private String noIjin;
    @Basic(optional = false)
    @Column(name = "tgl_awal")
    @Temporal(TemporalType.DATE)
    private Date tglAwal;
    @Basic(optional = false)
    @Column(name = "tgl_akhir")
    @Temporal(TemporalType.DATE)
    private Date tglAkhir;
    @Basic(optional = false)
    @Column(name = "tgl_ijin")
    @Temporal(TemporalType.DATE)
    private Date tglIjin;
    @Basic(optional = false)
    @Size(min = 1, max = 100)
    @Column(name = "nm_perusahaan")
    private String nmPerusahaan;
    @Basic(optional = false)
    @Size(min = 1, max = 100)
    @Column(name = "ga")
    private String ga;

    public Ijin() {
    }

    public Ijin(String idIjin) {
        this.idIjin = idIjin;
    }

    public Ijin(String idIjin, String noIjin, Date tglAwal, Date tglAkhir, Date tglIjin, String nmPerusahaan, String ga) {
        this.idIjin = idIjin;
        this.noIjin = noIjin;
        this.tglAwal = tglAwal;
        this.tglAkhir = tglAkhir;
        this.tglIjin = tglIjin;
        this.nmPerusahaan = nmPerusahaan;
        this.ga = ga;
    }

    public String getIdIjin() {
        return idIjin;
    }

    public void setIdIjin(String idIjin) {
        this.idIjin = idIjin;
    }

    public String getNoIjin() {
        return noIjin;
    }

    public void setNoIjin(String noIjin) {
        this.noIjin = noIjin;
    }

    public Date getTglAwal() {
        return tglAwal;
    }

    public void setTglAwal(Date tglAwal) {
        this.tglAwal = tglAwal;
    }

    public Date getTglAkhir() {
        return tglAkhir;
    }

    public void setTglAkhir(Date tglAkhir) {
        this.tglAkhir = tglAkhir;
    }

    public Date getTglIjin() {
        return tglIjin;
    }

    public void setTglIjin(Date tglIjin) {
        this.tglIjin = tglIjin;
    }

    public String getNmPerusahaan() {
        return nmPerusahaan;
    }

    public void setNmPerusahaan(String nmPerusahaan) {
        this.nmPerusahaan = nmPerusahaan;
    }

    public String getGa() {
        return ga;
    }

    public void setGa(String ga) {
        this.ga = ga;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIjin != null ? idIjin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ijin)) {
            return false;
        }
        Ijin other = (Ijin) object;
        if ((this.idIjin == null && other.idIjin != null) || (this.idIjin != null && !this.idIjin.equals(other.idIjin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kawalkuota.entity.Ijin[ idIjin=" + idIjin + " ]";
    }
    
}
