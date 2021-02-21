package Interfaces;

import java.util.List;

import Entity.Genre;

public interface GenreDAO {
	public List<Genre> getGenres();
	public Genre getGenre(Integer idgenre);
}
