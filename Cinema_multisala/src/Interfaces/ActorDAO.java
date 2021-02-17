package Interfaces;

import java.util.List;

import Entity.Actor;
import Entity.Film;

public interface ActorDAO {
	public List<Actor> findActors();
	public boolean insertActor(Actor actor);
}
