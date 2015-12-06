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
@Table(name = "pib", catalog = "kawalkuota", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pib.findAll", query = "SELECT p FROM Pib p"),
    @NamedQuery(name = "Pib.findByIdPib", query = "SELECT p FROM Pib p WHERE p.idPib = :idPib"),
    @NamedQuery(name = "Pib.findByCar", query = "SELECT p FROM Pib p WHERE p.car = :car"),
    @NamedQuery(name = "Pib.findByHs", query = "SELECT p FROM Pib p WHERE p.hs = :hs"),
    @NamedQuery(name = "Pib.findByUraian", query = "SELECT p FROM Pib p WHERE p.uraian = :uraian"),
    @NamedQuery(name = "Pib.findByJmlBarang", query = "SELECT p FROM Pib p WHERE p.jmlBarang = :jmlBarang"),
    @NamedQuery(name = "Pib.findBySatuan", query = "SELECT p FROM Pib p WHERE p.satuan = :satuan"),
    @NamedQuery(name = "Pib.findByTglPib", query = "SELECT p FROM Pib p WHERE p.tglPib = :tglPib"),
    @NamedQuery(name = "Pib.findByNmPerusahaan", query = "SELECT p FROM Pib p WHERE p.nmPerusahaan = :nmPerusahaan"),
    @NamedQuery(name = "Pib.findByNegAsal", query = "SELECT p FROM Pib p WHERE p.negAsal = :negAsal"),
    @NamedQuery(name = "Pib.findByPelBongkar", query = "SELECT p FROM Pib p WHERE p.pelBongkar = :pelBongkar")})
public class Pib implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_pib")
    private Integer idPib;
    @Basic(optional = false)
    @Size(min = 1, max = 100)
    @Column(name = "car")
    private String car;
    @Basic(optional = false)
    @Size(min = 1, max = 100)
    @Column(name = "hs")
    private String hs;
    @Basic(optional = false)
    @Size(min = 1, max = 255)
    @Column(name = "uraian")
    private String uraian;
    @Basic(optional = false)
    @Column(name = "jml_barang")
    private int jmlBarang;
    @Basic(optional = false)
    @Size(min = 1, max = 100)
    @Column(name = "satuan")
    private String satuan;
    @Basic(optional = false)
    @Column(name = "tgl_pib")
    @Temporal(TemporalType.DATE)
    private Date tglPib;
    @Basic(optional = false)
    @Size(min = 1, max = 100)
    @Column(name = "nm_perusahaan")
    private String nmPerusahaan;
    @Basic(optional = false)
    @Size(min = 1, max = 100)
    @Column(name = "neg_asal")
    private String negAsal;
    @Basic(optional = false)
    @Size(min = 1, max = 100)
    @Column(name = "pel_bongkar")
    private String pelBongkar;

    public Pib() {
    }

    public Pib(Integer idPib) {
        this.idPib = idPib;
    }

    public Pib(Integer idPib, String car, String hs, String uraian, int jmlBarang, String satuan, Date tglPib, String nmPerusahaan, String negAsal, String pelBongkar) {
        this.idPib = idPib;
        this.car = car;
        this.hs = hs;
        this.uraian = uraian;
        this.jmlBarang = jmlBarang;
        this.satuan = satuan;
        this.tglPib = tglPib;
        this.nmPerusahaan = nmPerusahaan;
        this.negAsal = negAsal;
        this.pelBongkar = pelBongkar;
    }

    public Integer getIdPib() {
        return idPib;
    }

    public void setIdPib(Integer idPib) {
        this.idPib = idPib;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String getHs() {
        return hs;
    }

    public void setHs(String hs) {
        this.hs = hs;
    }

    public String getUraian() {
        return uraian;
    }

    public void setUraian(String uraian) {
        this.uraian = uraian;
    }

    public int getJmlBarang() {
        return jmlBarang;
    }

    public void setJmlBarang(int jmlBarang) {
        this.jmlBarang = jmlBarang;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    public Date getTglPib() {
        return tglPib;
    }

    public void setTglPib(Date tglPib) {
        this.tglPib = tglPib;
    }

    public String getNmPerusahaan() {
        return nmPerusahaan;
    }

    public void setNmPerusahaan(String nmPerusahaan) {
        this.nmPerusahaan = nmPerusahaan;
    }

    public String getNegAsal() {
        return negAsal;
    }

    public void setNegAsal(String negAsal) {
        this.negAsal = negAsal;
    }

    public String getPelBongkar() {
        return pelBongkar;
    }

    public void setPelBongkar(String pelBongkar) {
        this.pelBongkar = pelBongkar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPib != null ? idPib.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pib)) {
            return false;
        }
        Pib other = (Pib) object;
        if ((this.idPib == null && other.idPib != null) || (this.idPib != null && !this.idPib.equals(other.idPib))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kawalkuota.entity.Pib[ idPib=" + idPib + " ]";
    }
    
}
