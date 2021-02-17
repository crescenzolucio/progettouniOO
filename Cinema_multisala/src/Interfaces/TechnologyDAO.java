package Interfaces;

import java.util.List;

import Entity.Technology;

public interface TechnologyDAO {
	public List<Technology> getTechnologies();
	public Technology getTechnology(Integer idtech);
}
