package Controllers;

import java.util.List;

import DAO.ActorPostgreDAO;
import DAO.DirectorPostgreDAO;
import DAO.FilmPostgreDAO;
import DAO.ProjectionPostgreDAO;
import DAO.RoomPostgreDAO;
import DAO.TicketPostgreDAO;
import DAO.UserPostgreDAO;
import Entity.Actor;
import Entity.Director;
import Entity.Film;
import Entity.Projection;
import Entity.Room;
import Entity.Ticket;
import Entity.User;
import Interfaces.ActorDAO;
import Interfaces.DirectorDAO;
import Interfaces.FilmDAO;
import Interfaces.ProjectionDAO;
import Interfaces.RoomDAO;
import Interfaces.TicketDAO;
import Interfaces.UserDAO;

public class Controller {
	public boolean searchUser(String user) {
		UserDAO usDAO = new UserPostgreDAO();
		return usDAO.findUser(user);
	}
	public boolean checkPasswordUser(String user,String password) {
		UserDAO usDAO = new UserPostgreDAO();
		return usDAO.checkPassword(user,password);
	}
	public boolean addInfoUser(User user) {
		UserDAO usDAO = new UserPostgreDAO();
		return usDAO.addUser(user.getUser(),user.getPassword(),user.getEmail());
	}
	public List<Projection> findProjections() {
		ProjectionDAO pjDAO = new ProjectionPostgreDAO();
		return pjDAO.findProjectionsToday();
	}
	public String nameFilm(Integer idfilm) {
		FilmDAO filmDAO = new FilmPostgreDAO();
		return filmDAO.getFilm(idfilm);
	}
	public Room nameRoom(Integer idroom) {
		RoomDAO roomDAO = new RoomPostgreDAO();
		return roomDAO.getRoom(idroom);
	}
	public Integer seatsNotAvailableProjection(Integer id_projection) {
		ProjectionDAO pjDAO = new ProjectionPostgreDAO();
		return pjDAO.countOccupiedSeatsInProjection(id_projection);
	}
	public boolean buyTicket(Ticket ticket) {
		TicketDAO ticketDAO = new TicketPostgreDAO();
		return ticketDAO.buyTicket(ticket);
	}
	public Integer lastTicket() {
		TicketDAO ticketDAO = new TicketPostgreDAO();
		return ticketDAO.lastTicket();
	}
	public List<Film> getFilms(){
		FilmDAO filmDAO = new FilmPostgreDAO();
		return filmDAO.getFilms();
	}
	public Integer deleteFilm(Integer idfilm){
		FilmDAO filmDAO = new FilmPostgreDAO();
		return filmDAO.deleteFilm(idfilm);
	}
	public List<Director> findDirectors(){
		DirectorDAO directorDAO = new DirectorPostgreDAO();
		return directorDAO.findDirectors();
	}
	public List<Actor> findActors(){
		ActorDAO actorDao = new ActorPostgreDAO();
		return actorDao.findActors();
	}
	public boolean insertFilm(Film film) {
		FilmDAO filmDAO = new FilmPostgreDAO();
		return filmDAO.insertFilm(film);
	}
	public Director findDirector(Integer iddirector) {
		DirectorDAO directorDAO = new DirectorPostgreDAO();
		return directorDAO.findDirector(iddirector);
	}
}
