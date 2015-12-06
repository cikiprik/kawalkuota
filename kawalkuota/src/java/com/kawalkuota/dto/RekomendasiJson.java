/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kawalkuota.dto;

import java.util.Date;

/**
 *
 * @author Yusrul <yusrul@kemenkeu.go.id>
 */
public class RekomendasiJson {
    
    private Integer idRekomendasi;
    private String noSurat;
    private String npwp;
    private String tipe;
    private Date tglawal;
    private Date tglakhir;
    private String status;
    private String aksi;

    /**
     * @return the idRekomendasi
     */
    public Integer getIdRekomendasi() {
        return idRekomendasi;
    }

    /**
     * @param idRekomendasi the idRekomendasi to set
     */
    public void setIdRekomendasi(Integer idRekomendasi) {
        this.idRekomendasi = idRekomendasi;
    }

    /**
     * @return the noSurat
     */
    public String getNoSurat() {
        return noSurat;
    }

    /**
     * @param noSurat the noSurat to set
     */
    public void setNoSurat(String noSurat) {
        this.noSurat = noSurat;
    }

    /**
     * @return the npwp
     */
    public String getNpwp() {
        return npwp;
    }

    /**
     * @param npwp the npwp to set
     */
    public void setNpwp(String npwp) {
        this.npwp = npwp;
    }

    /**
     * @return the tipe
     */
    public String getTipe() {
        return tipe;
    }

    /**
     * @param tipe the tipe to set
     */
    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    /**
     * @return the tglawal
     */
    public Date getTglawal() {
        return tglawal;
    }

    /**
     * @param tglawal the tglawal to set
     */
    public void setTglawal(Date tglawal) {
        this.tglawal = tglawal;
    }

    /**
     * @return the tglakhir
     */
    public Date getTglakhir() {
        return tglakhir;
    }

    /**
     * @param tglakhir the tglakhir to set
     */
    public void setTglakhir(Date tglakhir) {
        this.tglakhir = tglakhir;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the aksi
     */
    public String getAksi() {
        return aksi;
    }

    /**
     * @param aksi the aksi to set
     */
    public void setAksi(String aksi) {
        this.aksi = aksi;
    }
    
}
