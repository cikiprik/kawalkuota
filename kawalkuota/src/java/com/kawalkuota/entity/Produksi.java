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
@Table(name = "produksi", catalog = "kawalkuota", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produksi.findAll", query = "SELECT p FROM Produksi p"),
    @NamedQuery(name = "Produksi.findByIdProduksi", query = "SELECT p FROM Produksi p WHERE p.idProduksi = :idProduksi"),
    @NamedQuery(name = "Produksi.findByTahun", query = "SELECT p FROM Produksi p WHERE p.tahun = :tahun"),
    @NamedQuery(name = "Produksi.findByKomoditi", query = "SELECT p FROM Produksi p WHERE p.komoditi = :komoditi"),
    @NamedQuery(name = "Produksi.findByJmlProduksi", query = "SELECT p FROM Produksi p WHERE p.jmlProduksi = :jmlProduksi")})
public class Produksi implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_produksi")
    private Integer idProduksi;
    @Column(name = "tahun")
    @Temporal(TemporalType.DATE)
    private Date tahun;
    @Size(max = 100)
    @Column(name = "komoditi")
    private String komoditi;
    @Column(name = "jml_produksi")
    private Integer jmlProduksi;

    public Produksi() {
    }

    public Produksi(Integer idProduksi) {
        this.idProduksi = idProduksi;
    }

    public Integer getIdProduksi() {
        return idProduksi;
    }

    public void setIdProduksi(Integer idProduksi) {
        this.idProduksi = idProduksi;
    }

    public Date getTahun() {
        return tahun;
    }

    public void setTahun(Date tahun) {
        this.tahun = tahun;
    }

    public String getKomoditi() {
        return komoditi;
    }

    public void setKomoditi(String komoditi) {
        this.komoditi = komoditi;
    }

    public Integer getJmlProduksi() {
        return jmlProduksi;
    }

    public void setJmlProduksi(Integer jmlProduksi) {
        this.jmlProduksi = jmlProduksi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProduksi != null ? idProduksi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produksi)) {
            return false;
        }
        Produksi other = (Produksi) object;
        if ((this.idProduksi == null && other.idProduksi != null) || (this.idProduksi != null && !this.idProduksi.equals(other.idProduksi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kawalkuota.entity.Produksi[ idProduksi=" + idProduksi + " ]";
    }
    
}
