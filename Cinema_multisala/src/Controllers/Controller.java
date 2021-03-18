package Controllers;

import java.util.List;

import javax.swing.table.TableModel;

import DAO.ActorPostgreDAO;
import DAO.AudioPostgreDAO;
import DAO.CountryPostgreDAO;
import DAO.DirectorPostgreDAO;
import DAO.FilmPostgreDAO;
import DAO.GenrePostgreDAO;
import DAO.ProjectionPostgreDAO;
import DAO.RoomPostgreDAO;
import DAO.TechnologyPostgreDAO;
import DAO.TicketPostgreDAO;
import DAO.ViewPostgreDAO;
import Entity.Actor;
import Entity.Audio;
import Entity.Country;
import Entity.Director;
import Entity.Film;
import Entity.Genre;
import Entity.Projection;
import Entity.Room;
import Entity.Technology;
import Entity.Ticket;
import Interfaces.ActorDAO;
import Interfaces.AudioDAO;
import Interfaces.CountryDAO;
import Interfaces.DirectorDAO;
import Interfaces.FilmDAO;
import Interfaces.GenreDAO;
import Interfaces.ProjectionDAO;
import Interfaces.RoomDAO;
import Interfaces.TechnologyDAO;
import Interfaces.TicketDAO;
import Interfaces.ViewDAO;

public class Controller {
	//Actor
	public List<Actor> findActors(){
		ActorDAO actorDao = new ActorPostgreDAO();
		return actorDao.findActors();
	}
	public boolean insertActor(Actor actor) {
		ActorDAO actorDAO = new ActorPostgreDAO();
		return actorDAO.insertActor(actor);
	}
	public Actor getActor(Integer idactor) {
		ActorDAO ActorDAO = new ActorPostgreDAO();
		return ActorDAO.getActor(idactor);
	}
	//Audio
	public List<Audio> getAudios() {
		AudioDAO audioDAO = new AudioPostgreDAO();
		return audioDAO.getAudios();
	}
	//Technology
	public List<Technology> getTechnologies() {
		TechnologyDAO techDAO = new TechnologyPostgreDAO();
		return techDAO.getTechnologies();
	}
	public Technology getTechnology(Integer idtec){
		TechnologyDAO tecDAO = new TechnologyPostgreDAO();
		return tecDAO.getTechnology(idtec);
	}
	//Country
	public List<Country> getCountries() {
		CountryDAO countryDAO = new CountryPostgreDAO();
		return countryDAO.getCountries();
	}
	//Director
	public List<Director> findDirectors(){
		DirectorDAO directorDAO = new DirectorPostgreDAO();
		return directorDAO.findDirectors();
	}
	public Director findDirector(Integer iddirector) {
		DirectorDAO directorDAO = new DirectorPostgreDAO();
		return directorDAO.findDirector(iddirector);
	}
	public boolean insertDirector(Director director) {
		DirectorDAO directorDAO = new DirectorPostgreDAO();
		return directorDAO.insertDirector(director);
	}
	//Film
	public List<Film> getFilms(){
		FilmDAO filmDAO = new FilmPostgreDAO();
		return filmDAO.getFilms();
	}
	public Integer deleteFilm(Integer idfilm){
		FilmDAO filmDAO = new FilmPostgreDAO();
		return filmDAO.deleteFilm(idfilm);
	}
	public boolean insertFilm(Film film) {
		FilmDAO filmDAO = new FilmPostgreDAO();
		return filmDAO.insertFilm(film);
	}
	public Film getFilm(Integer idfilm) {
		FilmDAO filmDAO = new FilmPostgreDAO();
		return filmDAO.getFilm(idfilm);
	}
	//Genre
	public List<Genre> getGenres() {
		GenreDAO genreDAO = new GenrePostgreDAO();
		return genreDAO.getGenres();
	}
	public Genre getGenre(Integer idgenre) {
		GenreDAO GenreDAO = new GenrePostgreDAO();
		return GenreDAO.getGenre(idgenre);
	}
	//Projection
	public List<Projection> getProjectionsToday() {
		ProjectionDAO pjDAO = new ProjectionPostgreDAO();
		return pjDAO.getProjectionsToday();
	}
	public Integer seatsNotAvailableProjection(Integer id_projection) {
		ProjectionDAO pjDAO = new ProjectionPostgreDAO();
		return pjDAO.countOccupiedSeatsInProjection(id_projection);
	}
	public boolean insertProjection(Projection projection) {
		ProjectionDAO pjDAO = new ProjectionPostgreDAO();
		return pjDAO.insertProjection(projection);
	}
	public Integer deleteProjection(Integer idpj){
		ProjectionDAO ProjectionDAO = new ProjectionPostgreDAO();
		return ProjectionDAO.deleteProjection(idpj);
	}
	public List<Projection> getProjections() {
		ProjectionDAO pjDAO = new ProjectionPostgreDAO();
		return pjDAO.getProjections();
	}
	//Room
	public Room nameRoom(Integer idroom) {
		RoomDAO roomDAO = new RoomPostgreDAO();
		return roomDAO.getRoom(idroom);
	}
	public List<Room> getRooms() {
		RoomDAO roomDAO = new RoomPostgreDAO();
		return roomDAO.getRooms();
	}
	public boolean insertRoom(Room room) {
		RoomDAO roomDAO = new RoomPostgreDAO();
		return roomDAO.insertRoom(room);
	}
	public Integer deleteRoom(Integer idroom){
		RoomDAO roomDAO = new RoomPostgreDAO();
		return roomDAO.deleteRoom(idroom);
	}
	public Room getRoom(Integer idroom) {
		RoomDAO RoomDAO = new RoomPostgreDAO();
		return RoomDAO.getRoom(idroom);
	}
	//Ticket
	public boolean buyTicket(Ticket ticket) {
		TicketDAO ticketDAO = new TicketPostgreDAO();
		return ticketDAO.buyTicket(ticket);
	}
	public Integer lastTicket() {
		TicketDAO ticketDAO = new TicketPostgreDAO();
		return ticketDAO.lastTicket();
	}
	//Views
	public TableModel ProfitableShowsView() {
		ViewDAO views = new ViewPostgreDAO();
		return views.ProfitableShowsView();
	}
	public TableModel PrimeTimeView() {
		ViewDAO views = new ViewPostgreDAO();
		return views.PrimeTimeView();
	}
	public TableModel PrimeTimeRoomsView() {
		ViewDAO views = new ViewPostgreDAO();
		return views.PrimeTimeRoomsView();
	}
}
