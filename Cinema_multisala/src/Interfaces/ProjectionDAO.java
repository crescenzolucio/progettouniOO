package Interfaces;

import java.util.List;
import Entity.Projection;

public interface ProjectionDAO {
	public List<Projection> getProjectionsToday();
	public Integer countOccupiedSeatsInProjection(Integer id_proiezione);
	public boolean insertProjection(Projection projection);
	public List<Projection> getProjections();
	public Integer deleteProjection(Integer idpj);
}
