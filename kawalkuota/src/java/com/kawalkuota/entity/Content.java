/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kawalkuota.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "content", catalog = "kawalkuota", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Content.findAll", query = "SELECT c FROM Content c"),
    @NamedQuery(name = "Content.findByIdContent", query = "SELECT c FROM Content c WHERE c.idContent = :idContent"),
    @NamedQuery(name = "Content.findByTitle", query = "SELECT c FROM Content c WHERE c.title = :title"),
    @NamedQuery(name = "Content.findByHeadline", query = "SELECT c FROM Content c WHERE c.headline = :headline")})
public class Content implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "link")
    private String link;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "kategori")
    private String kategori;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "id_content")
    private String idContent;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "headline")
    private String headline;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "content")
    private String content;

    public Content() {
    }

    public Content(String idContent) {
        this.idContent = idContent;
    }

    public Content(String idContent, String title, String headline, String content) {
        this.idContent = idContent;
        this.title = title;
        this.headline = headline;
        this.content = content;
    }

    public String getIdContent() {
        return idContent;
    }

    public void setIdContent(String idContent) {
        this.idContent = idContent;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
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
        hash += (idContent != null ? idContent.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Content)) {
            return false;
        }
        Content other = (Content) object;
        if ((this.idContent == null && other.idContent != null) || (this.idContent != null && !this.idContent.equals(other.idContent))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kawalkuota.entity.Content[ idContent=" + idContent + " ]";
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }
    
}
