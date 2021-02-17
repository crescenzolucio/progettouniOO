package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import Entity.Technology;
import Interfaces.TechnologyDAO;

public class TechnologyPostgreDAO implements TechnologyDAO{
	public LinkedList<Technology> getTechnologies() {
		String Query = "SELECT * FROM tecnologie_proiezione a order by a.tecnologia asc";
		Connectiondb connection_db =new Connectiondb();
        Connection con=connection_db.get_connection();
        LinkedList<Technology> list = new LinkedList<Technology>();
        try {
            PreparedStatement ps = con.prepareStatement(Query);
            ResultSet rs =  ps.executeQuery();

            while (rs.next()) {
            	  Integer idtec = rs.getInt("id_tec");
            	  Integer year = rs.getInt("anno");
            	  String description = rs.getString("tecnologia");
            	  Technology tec = new Technology(idtec,year,description);
            	  list.add(tec);
            	}
            con.close();
        } catch(SQLException ex) {
        	ex.printStackTrace();
        }
		return list;
	}
	
	public Technology getTechnology(Integer idtec) {
		String Query = "Select * from tecnologie_proiezione t where t.id_tec=?";
		Connectiondb connection_db =new Connectiondb();
        Connection con=connection_db.get_connection();
    	Technology tec = new Technology();  
        try {
            PreparedStatement ps = con.prepareStatement(Query);
            ps.setInt(1, idtec);
            ResultSet rs =  ps.executeQuery();

            if (!rs.next()) { 
                System.out.println("No records found");
            }else {
            	Integer idtech = rs.getInt("id_tec");
            	String  description = rs.getString("tecnologia");
            	Integer year =   rs.getInt("anno");
            	tec.setIdtecnology(idtech);
            	tec.setDescription(description);
            	tec.setYear(year);
      		}
            con.close();
        } catch(SQLException ex) {
        	ex.printStackTrace();
        }
		return tec;
	}
}
