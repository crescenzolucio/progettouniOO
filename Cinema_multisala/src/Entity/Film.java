package Entity;

import java.util.LinkedList;

public class Film {
	private Integer id_film;
	private String title;
	private Integer year_production;
	private Integer id_director;
	private String registaname;
	private Integer minutes;
	private String url_poster;
	private LinkedList<Integer> genres;
	private LinkedList<Integer> actors;
	public Integer getId_film() {
		return id_film;
	}
	public void setId_film(Integer id_film) {
		this.id_film = id_film;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getYear_production() {
		return year_production;
	}
	public void setYear_production(Integer year_production) {
		this.year_production = year_production;
	}
	public Integer getId_director() {
		return id_director;
	}
	public void setId_director(Integer id_director) {
		this.id_director = id_director;
	}
	public String getRegistaname() {
		return registaname;
	}
	public void setRegistaname(String registaname) {
		this.registaname = registaname;
	}
	public Integer getMinutes() {
		return minutes;
	}
	public void setMinutes(Integer minutes) {
		this.minutes = minutes;
	}
	public String getUrl_poster() {
		return url_poster;
	}
	public void setUrl_poster(String url_poster) {
		this.url_poster = url_poster;
	}
	public LinkedList<Integer> getGenres() {
		return genres;
	}
	public void setGenres(LinkedList<Integer> genres) {
		this.genres = genres;
	}
	public LinkedList<Integer> getActors() {
		return actors;
	}
	public void setActors(LinkedList<Integer> actors) {
		this.actors = actors;
	}
	public Film() {} 
	public Film(Integer id_film, String title, Integer year_production, Integer id_director, Integer minutes,
			String url_poster) {
		super();
		this.id_film = id_film;
		this.title = title;
		this.year_production = year_production;
		this.id_director = id_director;
		this.minutes = minutes;
		this.url_poster = url_poster;
	}
	@Override
	public String toString() {
		return  title;
	}
}
	
