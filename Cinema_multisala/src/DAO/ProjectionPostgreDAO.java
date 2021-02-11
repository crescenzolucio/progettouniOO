package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.LinkedList;
import Entity.Projection;
import Interfaces.ProjectionDAO;

public class ProjectionPostgreDAO implements ProjectionDAO{
	
	public LinkedList<Projection> findProjectionsToday() {
		String Query = "Select * from proiezioni p where p.inizio_proiezione::date=current_date";
		Connectiondb connection_db =new Connectiondb();
        Connection con=connection_db.get_connection();
        LinkedList<Projection> list = new LinkedList<Projection>();
        try {
            PreparedStatement ps = con.prepareStatement(Query);
            ResultSet rs =  ps.executeQuery();

            while (rs.next()) {
            	  Timestamp startprojection = rs.getTimestamp("inizio_proiezione");
            	  Timestamp endprojection = rs.getTimestamp("fine_proiezione");
            	  Integer price = rs.getInt("prezzo");
            	  Integer film = rs.getInt("id_film");
            	  Integer room = rs.getInt("id_sala");
            	  Integer idpj = rs.getInt("id_proiezione");

            	  Projection pj = new Projection(idpj,startprojection,endprojection,price,film,room);

            	  list.add(pj);
            	}
        } catch(SQLException ex) {
        }
		return list;
	}
	
	public Integer countOccupiedSeatsInProjection(Integer id_projection) {
		String Query = "select count(*) from biglietti b where b.id_proiezione="+id_projection;
		Connectiondb connection_db =new Connectiondb();
        Connection con=connection_db.get_connection();
        Integer count = 0;
        try {
            PreparedStatement ps = con.prepareStatement(Query);
            ResultSet rs =  ps.executeQuery();
            if (!rs.next()) { 
            	System.out.println("No projection found!");
			}else {
				count=rs.getInt("count");
			}
        } catch(SQLException ex) {
        }
		return count;
	}
}
