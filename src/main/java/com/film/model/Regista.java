package com.film.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Regista {

	private long idRegista;
	private String nome;
	private String cognome;
	private Date dataN;
	private Date dataM;
	private List<Film> listaFilm;
	
	public Regista(){}
	
	
	
	public Regista(String nome, String cognome) {
		super();
		this.nome = nome;
		this.cognome = cognome;
	}



	public Regista(String nome, String cognome, Date dataN, Date dataM, List<Film> listaFilm) {
		this.nome = nome;
		this.cognome = cognome;
		this.dataN = dataN;
		this.dataM = dataM;
		this.listaFilm = listaFilm;
	}



	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getidRegista() {
		return idRegista;
	}
	public void setidRegista(long id) {
		this.idRegista = id;
	}
	
	@Column(nullable=false)
	public String getNome() {
		return nome;
	}
	public void setNome(String name) {
		this.nome = name;
	}
	
	@Column(nullable=false)
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String surname) {
		this.cognome = surname;
	}
	
	@Column(nullable=false)
	@JsonFormat(pattern="yyyy")
    @Temporal(TemporalType.DATE)
	public Date getDataN() {
		return dataN;
	}
	public void setDataN(Date dataN) {
		this.dataN = dataN;
	}
	
	@JsonFormat(pattern="yyyy")
    @Temporal(TemporalType.DATE)
	public Date getDataM() {
		return dataM;
	}
	public void setDataM(Date dataM) {
		this.dataM = dataM;
	}
	
	@OneToMany(mappedBy = "regista")
	public List<Film> getListaFilm() {
		return listaFilm;
	}
	public void setListaFilm(List<Film> listaFilm) {
		this.listaFilm = listaFilm;
	}
	
	
	
}
