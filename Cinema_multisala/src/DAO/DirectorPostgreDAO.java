package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;

import Entity.Director;
import Interfaces.DirectorDAO;

public class DirectorPostgreDAO implements DirectorDAO{
	public LinkedList<Director> findDirectors() {
		String Query = "SELECT * FROM registi r order  by r.nominativo asc";
		ConnectiondbPostgreDAO connection_db =new ConnectiondbPostgreDAO();
        Connection con=connection_db.get_connection();
        LinkedList<Director> list = new LinkedList<Director>();
        try {
            PreparedStatement ps = con.prepareStatement(Query);
            ResultSet rs =  ps.executeQuery();
            while (rs.next()) {
          	  Integer idactor = rs.getInt("id_regista");
          	  String name = rs.getString("nominativo");
          	  Integer country = rs.getInt("paese_di_origine");
          	  Date birth = rs.getDate("data_nascita");
          	  Director director = new Director(idactor,name,country,birth);
          	  list.add(director);
            }
            con.close();
        } catch(SQLException ex) {
        	ex.printStackTrace();
        }
		return list;
	}
	
	public Director findDirector(Integer iddirector) {
		String Query = "SELECT r.id_regista,r.nominativo,(select p.paese from paesi p where p.id_paese=r.paese_di_origine::smallint),r.data_nascita FROM registi r  where r.id_regista=?";
		ConnectiondbPostgreDAO connection_db =new ConnectiondbPostgreDAO();
        Connection con=connection_db.get_connection();
        Director director = new Director();
        try {
            PreparedStatement ps = con.prepareStatement(Query);
            ps.setInt(1, iddirector);
            ResultSet rs =  ps.executeQuery();
            if (!rs.next()) { 
            	  director.setName(rs.getString("nominativo"));
            	  director.setId_director(rs.getInt("id_regista"));
            	  director.setCountry(rs.getInt("paese"));
            	  director.setDateofbirth(rs.getDate("data_nascita"));
            	}
            con.close();
        } catch(SQLException ex) {
        	ex.printStackTrace();
        }
		return director;
	}
	
	public boolean insertDirector(Director director) {
		String Query = "INSERT INTO public.registi( nominativo, paese_di_origine, data_nascita) VALUES (?, ?, ?)";
		ConnectiondbPostgreDAO connection_db =new ConnectiondbPostgreDAO();
        Connection con=connection_db.get_connection();
        try {
            PreparedStatement ps = con.prepareStatement(Query);
            ps.setString(1, director.getName());
            ps.setInt(2, director.getCountry());
            ps.setDate(3, new java.sql.Date(director.getDateofbirth().getTime()));
            ps.execute();
            ps.close();
            con.close();
        } catch(SQLException ex) {
        	ex.printStackTrace();
        	return false;
        }
		return true;
	}
}
