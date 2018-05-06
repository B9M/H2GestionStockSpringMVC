package com.stock.mvc.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class MvtStk implements Serializable{
	
	public static final int ENTREE=1;
	public static final int SORTIE=2;
	
	@Id
	@GeneratedValue
	private Long idMvStk;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateMvtStk;
	
	@ManyToOne
	@JoinColumn(name="idArticle")
	private Article article;
	
	private BigDecimal quantite;
	
	private int typeMvt;

	public Long getIdMvStk() {
		return idMvStk;
	}

	public void setIdMvStk(Long idMvStk) {
		this.idMvStk = idMvStk;
	}

	public Date getDateMvtStk() {
		return dateMvtStk;
	}

	public void setDateMvtStk(Date dateMvtStk) {
		this.dateMvtStk = dateMvtStk;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public BigDecimal getQuantite() {
		return quantite;
	}

	public void setQuantite(BigDecimal quantite) {
		this.quantite = quantite;
	}

	public int getTypeMvt() {
		return typeMvt;
	}

	public void setTypeMvt(int typeMvt) {
		this.typeMvt = typeMvt;
	}
}
