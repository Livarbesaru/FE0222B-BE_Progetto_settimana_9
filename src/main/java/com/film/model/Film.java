package com.film.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Film {
	
	private Long idFilm;
	private String titolo;
	private Date anno;
	private Regista regista;
	private String incasso;
	private String tipo;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getIdFilm() {
		return idFilm;
	}
	public void setIdFilm(Long idFilm) {
		this.idFilm = idFilm;
	}
	
	@Column(nullable=false)
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
	@Column(nullable=false)
	@JsonFormat(pattern="yyyy")
    @Temporal(TemporalType.DATE)
	public Date getAnno() {
		return anno;
	}
	public void setAnno(Date anno) {
		this.anno = anno;
	}
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "idRegista")
	public Regista getRegista() {
		return regista;
	}
	public void setRegista(Regista regista) {
		this.regista = regista;
	}
	
	@Column(nullable=false)
	public String getIncasso() {
		return incasso;
	}
	public void setIncasso(String incasso) {
		this.incasso = incasso;
	}
	
	@Column(nullable=false)
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}
