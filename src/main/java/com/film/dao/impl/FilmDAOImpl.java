package com.film.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.film.dao.FilmDao;
import com.film.model.Film;
import com.film.model.Regista;
import com.film.util.JpaUtil;

public class FilmDAOImpl implements FilmDao {
	
	EntityManager em;
	
	public void aggiungiFilm(Film f) {
		em = JpaUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = em.getTransaction();

		try {
			if((em.find(Regista.class, f.getRegista().getidRegista()))!=null) {
				f.setRegista(em.find(Regista.class, f.getRegista().getidRegista()));
			}
			if(f.getRegista().getListaFilm()==null) {
				f.getRegista().setListaFilm(new ArrayList<Film>());
				f.getRegista().getListaFilm().add(f);
			}
			else {
				f.getRegista().getListaFilm().add(f);
			}
			entityTransaction.begin();
			em.persist(f);
			entityTransaction.commit();

		} catch (Exception ex) {
			ex.printStackTrace();
			entityTransaction.rollback();
		} finally {
			em.close();
		}
	}

	public void modificaFilm(Film f) {
		em = JpaUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = em.getTransaction();

		try {
			if((em.find(Regista.class, f.getRegista().getidRegista()))!=null) {
				f.setRegista(em.find(Regista.class, f.getRegista().getidRegista()));
			}
			if(f.getRegista().getListaFilm()==null) {
				f.getRegista().setListaFilm(new ArrayList<Film>());
				f.getRegista().getListaFilm().add(f);
			}
			else {
				f.getRegista().getListaFilm().add(f);
			}
			entityTransaction.begin();
			em.merge(f);
			entityTransaction.commit();

		} catch (Exception ex) {
			ex.printStackTrace();
			entityTransaction.rollback();
		} finally {
			em.close();
		}
	}

	public void eliminaFilm(Long idFilm) {
		em = JpaUtil.getEntityManagerFactory().createEntityManager();
		em.remove(em.find(Film.class, idFilm));
	}

	public List<Film> filmPerRegista(String nome, String cognome) {
		em = JpaUtil.getEntityManagerFactory().createEntityManager();
		Query q=em.createQuery("select r from Regista r where r.nome = :nome and r.cognome = :cognome");
		
		q.setParameter("nome", nome);
		q.setParameter("cognome", cognome);
		List<Film> films=((Regista)q.getSingleResult()).getListaFilm();
		for(Film f:films) {
				f.setRegista(new Regista(f.getRegista().getNome(),f.getRegista().getCognome()));
		}
		
		return films;
	}

}
