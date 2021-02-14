package Interfaces;

import java.util.List;

import Entity.Director;

public interface DirectorDAO {
	public List<Director> findDirectors();
	public Director findDirector(Integer iddirector);
}
