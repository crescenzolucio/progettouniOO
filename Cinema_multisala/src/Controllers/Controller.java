package Controllers;

import java.util.List;

import DAO.FilmPostgreDAO;
import DAO.ProjectionPostgreDAO;
import DAO.RoomPostgreDAO;
import DAO.UserPostgreDAO;
import Entity.Projection;
import Entity.Room;
import Entity.User;
import Interfaces.FilmDAO;
import Interfaces.ProjectionDAO;
import Interfaces.RoomDAO;
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
}
