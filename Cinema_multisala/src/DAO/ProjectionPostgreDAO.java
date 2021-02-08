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
            	  Timestamp inizioproiezione = rs.getTimestamp("inizio_proiezione");
            	  Timestamp fineproiezione = rs.getTimestamp("fine_proiezione");
            	  Integer prezzo = rs.getInt("prezzo");
            	  Integer film = rs.getInt("id_film");
            	  Integer sala = rs.getInt("id_sala");

            	  Projection pj = new Projection(inizioproiezione,fineproiezione,prezzo,film,sala);

            	  list.add(pj);
            	}
        } catch(SQLException ex) {
        }
		return list;
	}
}
