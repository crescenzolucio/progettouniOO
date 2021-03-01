package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import Entity.Genre;
import Interfaces.GenreDAO;

public class GenrePostgreDAO implements GenreDAO{
	public LinkedList<Genre> getGenres(){
			String Query = "Select * from generi g order by g.genere";
			Connectiondb connection_db =new Connectiondb();
	        Connection con=connection_db.get_connection();
	        LinkedList<Genre> list = new LinkedList<Genre>();
	        try {
	            PreparedStatement ps = con.prepareStatement(Query);
	            ResultSet rs =  ps.executeQuery();

	            while (rs.next()) {
	            	  Genre genre =  new Genre();
	            	  genre.setIdgenre(rs.getInt("id_genere"));
	            	  genre.setGenre(rs.getString("genere"));
	            	  list.add(genre);
	            	}
	            con.close();
	        } catch(SQLException ex) {
	        	ex.printStackTrace();
	        }
			return list;
	}
	public Genre getGenre(Integer idgenre) {
		String Query = "Select * from generi g where g.id_genere=?";
		Connectiondb connection_db =new Connectiondb();
        Connection con=connection_db.get_connection();
        Genre genre = new Genre();
        try {
            PreparedStatement ps = con.prepareStatement(Query);
            ps.setInt(1, idgenre);
            ResultSet rs =  ps.executeQuery();
            if (!rs.next()) { 
            	System.out.println("No records found");
			}else {
				genre.setIdgenre(idgenre);
				genre.setGenre(rs.getString("genere"));
			}
            con.close();
        } catch(SQLException ex) {
        }
		return genre;
	}
}
