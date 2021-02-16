package Interfaces;

import java.util.List;
import Entity.Projection;

public interface ProjectionDAO {
	public List<Projection> findProjectionsToday();
	public Integer countOccupiedSeatsInProjection(Integer id_proiezione);
	public boolean insertProjection(Projection projection);
}
