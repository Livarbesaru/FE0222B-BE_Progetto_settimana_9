package com.film.dao;

import java.util.List;

import com.film.model.Film;

public interface FilmDao {
	public void aggiungiFilm(Film f);
	public void modificaFilm(Film f);
	public void eliminaFilm(Long idFilm);
	public List<Film> filmPerRegista(String nome,String cognome);
}
