package Interfaces;

import java.util.List;
import Entity.Projection;

public interface ProjectionDAO {
	public List<Projection> findProjectionsToday();
}
