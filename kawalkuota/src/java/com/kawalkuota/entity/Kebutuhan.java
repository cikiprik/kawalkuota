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
 * @author LENOVO
 */
@Entity
@Table(name = "kebutuhan", catalog = "kawalkuota", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kebutuhan.findAll", query = "SELECT k FROM Kebutuhan k"),
    @NamedQuery(name = "Kebutuhan.findByIdKebutuhan", query = "SELECT k FROM Kebutuhan k WHERE k.idKebutuhan = :idKebutuhan"),
    @NamedQuery(name = "Kebutuhan.findByTahun", query = "SELECT k FROM Kebutuhan k WHERE k.tahun = :tahun"),
    @NamedQuery(name = "Kebutuhan.findByKomoditi", query = "SELECT k FROM Kebutuhan k WHERE k.komoditi = :komoditi"),
    @NamedQuery(name = "Kebutuhan.findByJmlKebutuhan", query = "SELECT k FROM Kebutuhan k WHERE k.jmlKebutuhan = :jmlKebutuhan")})
public class Kebutuhan implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_kebutuhan")
    private Integer idKebutuhan;
    @Column(name = "tahun")
    @Temporal(TemporalType.DATE)
    private Date tahun;
    @Size(max = 50)
    @Column(name = "komoditi")
    private String komoditi;
    @Column(name = "jml_kebutuhan")
    private Integer jmlKebutuhan;

    public Kebutuhan() {
    }

    public Kebutuhan(Integer idKebutuhan) {
        this.idKebutuhan = idKebutuhan;
    }

    public Integer getIdKebutuhan() {
        return idKebutuhan;
    }

    public void setIdKebutuhan(Integer idKebutuhan) {
        this.idKebutuhan = idKebutuhan;
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

    public Integer getJmlKebutuhan() {
        return jmlKebutuhan;
    }

    public void setJmlKebutuhan(Integer jmlKebutuhan) {
        this.jmlKebutuhan = jmlKebutuhan;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idKebutuhan != null ? idKebutuhan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kebutuhan)) {
            return false;
        }
        Kebutuhan other = (Kebutuhan) object;
        if ((this.idKebutuhan == null && other.idKebutuhan != null) || (this.idKebutuhan != null && !this.idKebutuhan.equals(other.idKebutuhan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kawalkuota.entity.Kebutuhan[ idKebutuhan=" + idKebutuhan + " ]";
    }
    
}
