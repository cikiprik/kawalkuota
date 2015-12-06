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
    @NamedQuery(name = "Rekomendasidetil.findByIdDetilRekomendasi", query = "SELECT r FROM Rekomendasidetil r WHERE r.idDetilRekomendasi = :idDetilRekomendasi"),
    @NamedQuery(name = "Rekomendasidetil.findByIdRekomendasi", query = "SELECT r FROM Rekomendasidetil r WHERE r.idRekomendasi = :idRekomendasi"),
    @NamedQuery(name = "Rekomendasidetil.findByHscode", query = "SELECT r FROM Rekomendasidetil r WHERE r.hscode = :hscode"),
    @NamedQuery(name = "Rekomendasidetil.findByKuota", query = "SELECT r FROM Rekomendasidetil r WHERE r.kuota = :kuota"),
    @NamedQuery(name = "Rekomendasidetil.findByFlag", query = "SELECT r FROM Rekomendasidetil r WHERE r.flag = :flag")})
public class Rekomendasidetil implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_detil_rekomendasi")
    private Integer idDetilRekomendasi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_rekomendasi")
    private int idRekomendasi;
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

    public Rekomendasidetil(Integer idDetilRekomendasi) {
        this.idDetilRekomendasi = idDetilRekomendasi;
    }

    public Rekomendasidetil(Integer idDetilRekomendasi, int idRekomendasi, String flag) {
        this.idDetilRekomendasi = idDetilRekomendasi;
        this.idRekomendasi = idRekomendasi;
        this.flag = flag;
    }

    public Integer getIdDetilRekomendasi() {
        return idDetilRekomendasi;
    }

    public void setIdDetilRekomendasi(Integer idDetilRekomendasi) {
        this.idDetilRekomendasi = idDetilRekomendasi;
    }

    public int getIdRekomendasi() {
        return idRekomendasi;
    }

    public void setIdRekomendasi(int idRekomendasi) {
        this.idRekomendasi = idRekomendasi;
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
        hash += (idDetilRekomendasi != null ? idDetilRekomendasi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rekomendasidetil)) {
            return false;
        }
        Rekomendasidetil other = (Rekomendasidetil) object;
        if ((this.idDetilRekomendasi == null && other.idDetilRekomendasi != null) || (this.idDetilRekomendasi != null && !this.idDetilRekomendasi.equals(other.idDetilRekomendasi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kawalkuota.entity.Rekomendasidetil[ idDetilRekomendasi=" + idDetilRekomendasi + " ]";
    }
    
}
