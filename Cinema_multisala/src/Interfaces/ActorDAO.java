package Interfaces;

import java.util.List;

import Entity.Actor;

public interface ActorDAO {
	public List<Actor> findActors();
	public boolean insertActor(Actor actor);
	public Actor getActor(Integer idactor);
}
