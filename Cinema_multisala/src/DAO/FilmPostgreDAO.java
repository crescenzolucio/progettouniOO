package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Interfaces.FilmDAO;

public class FilmPostgreDAO implements FilmDAO{
	public String getFilm(Integer idfilm) {
		String Query = "Select f.titolo from film f where f.id_film='"+idfilm+"'";
		Connectiondb connection_db =new Connectiondb();
        Connection con=connection_db.get_connection();
        String titolo = "";
        try {
            PreparedStatement ps = con.prepareStatement(Query);
            ResultSet rs =  ps.executeQuery();
            
            	  
            if (!rs.next()) { 
                System.out.println("No records found");
            }else {
            	titolo = rs.getString("titolo");
      		}	  
        } catch(SQLException ex) {
        }
		return titolo;
	}
}
