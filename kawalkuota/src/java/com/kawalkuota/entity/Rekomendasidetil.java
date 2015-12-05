/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kawalkuota.entity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Yusrul <yusrul@kemenkeu.go.id>
 */
@Entity
@Table(name = "rekomendasidetil", catalog = "kawalkuota", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rekomendasidetil.findAll", query = "SELECT r FROM Rekomendasidetil r"),
    @NamedQuery(name = "Rekomendasidetil.findByIdDetil", query = "SELECT r FROM Rekomendasidetil r WHERE r.idDetil = :idDetil"),
    @NamedQuery(name = "Rekomendasidetil.findById", query = "SELECT r FROM Rekomendasidetil r WHERE r.id = :id"),
    @NamedQuery(name = "Rekomendasidetil.findByHscode", query = "SELECT r FROM Rekomendasidetil r WHERE r.hscode = :hscode"),
    @NamedQuery(name = "Rekomendasidetil.findByKuota", query = "SELECT r FROM Rekomendasidetil r WHERE r.kuota = :kuota"),
    @NamedQuery(name = "Rekomendasidetil.findByFlag", query = "SELECT r FROM Rekomendasidetil r WHERE r.flag = :flag")})
public class Rekomendasidetil implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_detil")
    private Integer idDetil;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private int id;
    @Size(max = 10)
    @Column(name = "hscode")
    private String hscode;
    @Column(name = "kuota")
    private BigInteger kuota;
    @Lob
    @Size(max = 65535)
    @Column(name = "keterangan")
    private String keterangan;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "flag")
    private String flag;

    public Rekomendasidetil() {
    }

    public Rekomendasidetil(Integer idDetil) {
        this.idDetil = idDetil;
    }

    public Rekomendasidetil(Integer idDetil, int id, String flag) {
        this.idDetil = idDetil;
        this.id = id;
        this.flag = flag;
    }

    public Integer getIdDetil() {
        return idDetil;
    }

    public void setIdDetil(Integer idDetil) {
        this.idDetil = idDetil;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHscode() {
        return hscode;
    }

    public void setHscode(String hscode) {
        this.hscode = hscode;
    }

    public BigInteger getKuota() {
        return kuota;
    }

    public void setKuota(BigInteger kuota) {
        this.kuota = kuota;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetil != null ? idDetil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rekomendasidetil)) {
            return false;
        }
        Rekomendasidetil other = (Rekomendasidetil) object;
        if ((this.idDetil == null && other.idDetil != null) || (this.idDetil != null && !this.idDetil.equals(other.idDetil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kawalkuota.entity.Rekomendasidetil[ idDetil=" + idDetil + " ]";
    }
    
}
