package Interfaces;

import java.util.List;

import Entity.Film;

public interface FilmDAO {
	public String getFilm(Integer idfilm);
	public List<Film> getFilms();
	public Integer deleteFilm(Integer idfilm);
	public boolean insertFilm(Film film);
}
