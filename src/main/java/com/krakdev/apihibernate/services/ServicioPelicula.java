package com.krakdev.apihibernate.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.krakdev.apihibernate.entidades.Pelicula;
import com.krakdev.apihibernate.repository.PeliculaRepository;

@Service
public class ServicioPelicula {

	private final PeliculaRepository peliculaRepository;

	public ServicioPelicula(PeliculaRepository peliculaRepository) {
		this.peliculaRepository = peliculaRepository;
	}

	public Pelicula crear(Pelicula pelicula) {
		Pelicula pNueva = peliculaRepository.save(pelicula);
		return pNueva;
	}

	public List<Pelicula> listar() {
		return peliculaRepository.findAll();
	}

	public Pelicula buscarPorId(Long id) {
		return peliculaRepository.findById(id).orElse(null);
	}

	public Pelicula actualizar(Long id, Pelicula pelicula) {
		Pelicula existePel = buscarPorId(id);
		if (existePel != null) {
			return peliculaRepository.save(pelicula);
		}
		return null;
	}

	public boolean eliminar(Long id) {

		Pelicula existePel = buscarPorId(id);
		if (existePel != null) {
			peliculaRepository.deleteById(id);
			return true;
		}
		return false;
	}

	public List<Pelicula> buscarPorGenero(String genero) {
		return peliculaRepository.findByGenero(genero);
	}

	public List<Pelicula> buscarPorDisponible(boolean disponible) {
		return peliculaRepository.findByDisponible(disponible);
	}

	public List<Pelicula> buscarPorDirector(String director) {
		return peliculaRepository.findByDirector(director);
	}

}
