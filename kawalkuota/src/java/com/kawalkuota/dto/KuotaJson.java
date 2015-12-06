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
public class KuotaJson {
    private int num;
    private String idIjin;
    private String noIjin;
    private Date tglIjin;
    private String negara;
    private String pelBongkar;
    private String aksi;

    /**
     * @return the idIjin
     */
    public String getIdIjin() {
        return idIjin;
    }

    /**
     * @param idIjin the idIjin to set
     */
    public void setIdIjin(String idIjin) {
        this.idIjin = idIjin;
    }

    /**
     * @return the noIjin
     */
    public String getNoIjin() {
        return noIjin;
    }

    /**
     * @param noIjin the noIjin to set
     */
    public void setNoIjin(String noIjin) {
        this.noIjin = noIjin;
    }

    /**
     * @return the tglIjin
     */
    public Date getTglIjin() {
        return tglIjin;
    }

    /**
     * @param tglIjin the tglIjin to set
     */
    public void setTglIjin(Date tglIjin) {
        this.tglIjin = tglIjin;
    }

    /**
     * @return the negara
     */
    public String getNegara() {
        return negara;
    }

    /**
     * @param negara the negara to set
     */
    public void setNegara(String negara) {
        this.negara = negara;
    }

    /**
     * @return the pelBongkar
     */
    public String getPelBongkar() {
        return pelBongkar;
    }

    /**
     * @param pelBongkar the pelBongkar to set
     */
    public void setPelBongkar(String pelBongkar) {
        this.pelBongkar = pelBongkar;
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

    /**
     * @return the num
     */
    public int getNum() {
        return num;
    }

    /**
     * @param num the num to set
     */
    public void setNum(int num) {
        this.num = num;
    }
}
