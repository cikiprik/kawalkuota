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
 * @author Yusrul <yusrul@kemenkeu.go.id>
 */
@Entity
@Table(name = "vkuota", catalog = "kawalkuota", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vkuota.findAll", query = "SELECT v FROM Vkuota v"),
    @NamedQuery(name = "Vkuota.findByIdIjin", query = "SELECT v FROM Vkuota v WHERE v.idIjin = :idIjin"),
    @NamedQuery(name = "Vkuota.findByNoIjin", query = "SELECT v FROM Vkuota v WHERE v.noIjin = :noIjin"),
    @NamedQuery(name = "Vkuota.findByTglIjin", query = "SELECT v FROM Vkuota v WHERE v.tglIjin = :tglIjin"),
    @NamedQuery(name = "Vkuota.findByNegara", query = "SELECT v FROM Vkuota v WHERE v.negara = :negara"),
    @NamedQuery(name = "Vkuota.findByPelBongkar", query = "SELECT v FROM Vkuota v WHERE v.pelBongkar = :pelBongkar")})
public class Vkuota implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "id_ijin")
    @Id
    private String idIjin;
    @Size(max = 100)
    @Column(name = "no_ijin")
    private String noIjin;
    @Column(name = "tgl_ijin")
    @Temporal(TemporalType.DATE)
    private Date tglIjin;
    @Size(max = 2)
    @Column(name = "negara")
    private String negara;
    @Size(max = 100)
    @Column(name = "pel_bongkar")
    private String pelBongkar;

    public Vkuota() {
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

    public Date getTglIjin() {
        return tglIjin;
    }

    public void setTglIjin(Date tglIjin) {
        this.tglIjin = tglIjin;
    }

    public String getNegara() {
        return negara;
    }

    public void setNegara(String negara) {
        this.negara = negara;
    }

    public String getPelBongkar() {
        return pelBongkar;
    }

    public void setPelBongkar(String pelBongkar) {
        this.pelBongkar = pelBongkar;
    }
    
}
