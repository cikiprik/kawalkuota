/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kawalkuota.entity;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LENOVO
 */
@Entity
@Table(name = "data_lokasi", catalog = "kawalkuota", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DataLokasi.findAll", query = "SELECT d FROM DataLokasi d"),
    @NamedQuery(name = "DataLokasi.findByIdLokasi", query = "SELECT d FROM DataLokasi d WHERE d.idLokasi = :idLokasi"),
    @NamedQuery(name = "DataLokasi.findByLat", query = "SELECT d FROM DataLokasi d WHERE d.lat = :lat"),
    @NamedQuery(name = "DataLokasi.findByLng", query = "SELECT d FROM DataLokasi d WHERE d.lng = :lng"),
    @NamedQuery(name = "DataLokasi.findByNamaLokasi", query = "SELECT d FROM DataLokasi d WHERE d.namaLokasi = :namaLokasi")})
public class DataLokasi implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_lokasi")
    private Integer idLokasi;
    @Size(max = 30)
    @Column(name = "lat")
    private String lat;
    @Size(max = 30)
    @Column(name = "lng")
    private String lng;
    @Size(max = 30)
    @Column(name = "nama_lokasi")
    private String namaLokasi;
    @Lob
    @Size(max = 65535)
    @Column(name = "content")
    private String content;

    public DataLokasi() {
    }

    public DataLokasi(Integer idLokasi) {
        this.idLokasi = idLokasi;
    }

    public Integer getIdLokasi() {
        return idLokasi;
    }

    public void setIdLokasi(Integer idLokasi) {
        this.idLokasi = idLokasi;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getNamaLokasi() {
        return namaLokasi;
    }

    public void setNamaLokasi(String namaLokasi) {
        this.namaLokasi = namaLokasi;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLokasi != null ? idLokasi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DataLokasi)) {
            return false;
        }
        DataLokasi other = (DataLokasi) object;
        if ((this.idLokasi == null && other.idLokasi != null) || (this.idLokasi != null && !this.idLokasi.equals(other.idLokasi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kawalkuota.entity.DataLokasi[ idLokasi=" + idLokasi + " ]";
    }
    
}
