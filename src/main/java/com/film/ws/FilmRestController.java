package com.film.ws;

import java.util.List;

import com.film.dao.FilmDao;
import com.film.dao.impl.FilmDAOImpl;
import com.film.model.Film;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/film")
public class FilmRestController {

	
	@PostMapping("/inserisci")
	public ResponseEntity<String> salva(@RequestBody Film f) {
		FilmDao filmDAO = new FilmDAOImpl();
		String inc=BCrypt.hashpw((f.getIncasso()+""),BCrypt.gensalt());
		f.setIncasso(inc);
		filmDAO.aggiungiFilm(f);

		return new ResponseEntity<String>("Inserimento effettuato", HttpStatus.OK);
	}
	
	@PutMapping("/aggiorna")
	public ResponseEntity<String> aggiorna(@RequestBody Film f){
		FilmDao filmDAO = new FilmDAOImpl();
		filmDAO.modificaFilm(f);
		
		return new ResponseEntity<String>("Modifica effettuato", HttpStatus.OK);
	}
	@DeleteMapping("/elimina")
	public ResponseEntity<String> elimina(@RequestParam("id") Long id){
		FilmDao filmDAO = new FilmDAOImpl();
		filmDAO.eliminaFilm(id);
		
		return new ResponseEntity<String>("film eliminato", HttpStatus.OK);
	}
	@GetMapping("/prendi")
	public ResponseEntity<List<Film>> cerca(@RequestParam("nome") String nome, @RequestParam("cognome") String cognome){
		FilmDao filmDAO = new FilmDAOImpl();
		
		return new ResponseEntity<List<Film>>(filmDAO.filmPerRegista(nome, cognome), HttpStatus.OK);
	}
}
