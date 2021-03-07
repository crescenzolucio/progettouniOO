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
	
	public LinkedList<Projection> getProjectionsToday() {
		String Query = "Select * from proiezioni p where p.inizio_proiezione::date=current_date";
		ConnectiondbPostgreDAO connection_db =new ConnectiondbPostgreDAO();
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
            con.close();
        } catch(SQLException ex) {
        }
		return list;
	}
	
	public Integer countOccupiedSeatsInProjection(Integer id_projection) {
		String Query = "select count(*) from biglietti b where b.id_proiezione="+id_projection;
		ConnectiondbPostgreDAO connection_db =new ConnectiondbPostgreDAO();
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
            con.close();
        } catch(SQLException ex) {
        }
		return count;
	}
	
	public boolean insertProjection(Projection projection) {
		String Query = "INSERT INTO proiezioni(id_sala, id_film, prezzo, inizio_proiezione,fine_proiezione) VALUES (?, ?, ?, ?, ?);";
		ConnectiondbPostgreDAO connection_db =new ConnectiondbPostgreDAO();
        Connection con=connection_db.get_connection();
        try {
            PreparedStatement ps = con.prepareStatement(Query);
            ps.setInt(1, projection.getIdsala());
            ps.setInt(2, projection.getIdfilm());
            ps.setInt(3, projection.getPrice());
            ps.setTimestamp(4, projection.getStartpj());
            ps.setTimestamp(5, projection.getEndpj());
            ps.execute();
            ps.close();
            con.close();
        } catch(SQLException ex) {
        	ex.printStackTrace();
        	return false;
        }
		return true;
	}
	
	public LinkedList<Projection> getProjections() {
		String Query = "Select p.*,"
				+ "	(select s.descrizione from sale s where s.id_sala=p.id_sala),"
				+ "	(select f.titolo from film f where f.id_film=p.id_film) from proiezioni p ";
		ConnectiondbPostgreDAO connection_db =new ConnectiondbPostgreDAO();
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
            	  pj.setRoomdescription(rs.getString("descrizione"));
            	  pj.setFilmdescription(rs.getString("titolo"));
            	  list.add(pj);
            	}
            con.close();
        } catch(SQLException ex) {
        }
		return list;
	}

	public Integer deleteProjection(Integer idpj) {
		String Query = "DELETE FROM PROIEZIONI F WHERE F.ID_PROIEZIONE=?";
		ConnectiondbPostgreDAO connection_db =new ConnectiondbPostgreDAO();
        Connection con=connection_db.get_connection();
        try {
            PreparedStatement ps = con.prepareStatement(Query);
            ps.setInt(1, idpj);
            return ps.executeUpdate();
        } catch(SQLException ex) {
        	ex.printStackTrace();
        	return -1;
        }
	}
}
