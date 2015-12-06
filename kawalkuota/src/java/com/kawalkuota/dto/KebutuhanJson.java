/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kawalkuota.dto;

import java.util.Date;

/**
 *
 * @author LENOVO
 */
public class KebutuhanJson {
    private Integer idKebutuhan;
    private Date tahun;
    private String komoditi;
    private Integer jmlKebutuhan;
    private String aksi;

    /**
     * @return the idKebutuhan
     */
    public Integer getIdKebutuhan() {
        return idKebutuhan;
    }

    /**
     * @param idKebutuhan the idKebutuhan to set
     */
    public void setIdKebutuhan(Integer idKebutuhan) {
        this.idKebutuhan = idKebutuhan;
    }

    /**
     * @return the tahun
     */
    public Date getTahun() {
        return tahun;
    }

    /**
     * @param tahun the tahun to set
     */
    public void setTahun(Date tahun) {
        this.tahun = tahun;
    }

    /**
     * @return the komoditi
     */
    public String getKomoditi() {
        return komoditi;
    }

    /**
     * @param komoditi the komoditi to set
     */
    public void setKomoditi(String komoditi) {
        this.komoditi = komoditi;
    }

    /**
     * @return the jmlKebutuhan
     */
    public Integer getJmlKebutuhan() {
        return jmlKebutuhan;
    }

    /**
     * @param jmlKebutuhan the jmlKebutuhan to set
     */
    public void setJmlKebutuhan(Integer jmlKebutuhan) {
        this.jmlKebutuhan = jmlKebutuhan;
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
