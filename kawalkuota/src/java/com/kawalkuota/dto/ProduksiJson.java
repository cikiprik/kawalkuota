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
public class ProduksiJson {
    
    private Integer idProduksi;
    private Date tahun;
    private String komoditi;
    private Integer jmlProduksi;
    private String aksi;
    

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

    public String getAksi() {
        return aksi;
    }

    public void setAksi(String aksi) {
        this.aksi = aksi;
    }

}
