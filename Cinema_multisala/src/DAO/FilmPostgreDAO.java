package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.LinkedList;

import Entity.Film;
import Entity.Projection;
import Interfaces.FilmDAO;

public class FilmPostgreDAO implements FilmDAO{
	public String getFilm(Integer idfilm) {
		String Query = "Select f.titolo from film f where f.id_film=?";
		Connectiondb connection_db =new Connectiondb();
        Connection con=connection_db.get_connection();
        String titolo = "";
        try {
            PreparedStatement ps = con.prepareStatement(Query);
            ps.setInt(1, idfilm);
            ResultSet rs =  ps.executeQuery();
              
            if (!rs.next()) { 
                System.out.println("No records found");
            }else {
            	titolo = rs.getString("titolo");
      		}	  
        } catch(SQLException ex) {
        	ex.printStackTrace();
        }
		return titolo;
	}
	
	public LinkedList<Film> getFilms() {
		String Query = "Select * from film f";
		Connectiondb connection_db =new Connectiondb();
        Connection con=connection_db.get_connection();
        LinkedList<Film> list = new LinkedList<Film>();
        try {
            PreparedStatement ps = con.prepareStatement(Query);
            ResultSet rs =  ps.executeQuery();

            while (rs.next()) {
            	  Integer idfilm = rs.getInt("id_film");
            	  String titolo = rs.getString("titolo");
            	  Integer annoproduzione =  rs.getInt("anno_produzione");
            	  Integer idregista = rs.getInt("id_regista");
            	  Integer duratamin = rs.getInt("durata_minuti");
            	  String urlposter = rs.getString("url_poster");
            	  Film film = new Film(idfilm,titolo,annoproduzione,idregista,duratamin,urlposter);
            	  list.add(film);
            	}
        } catch(SQLException ex) {
        	ex.printStackTrace();
        }
		return list;
	}
	
	public Integer deleteFilm(Integer idfilm) {
		String Query = "DELETE FROM FILM F WHERE F.ID_FILM=?";
		Connectiondb connection_db =new Connectiondb();
        Connection con=connection_db.get_connection();
        try {
            PreparedStatement ps = con.prepareStatement(Query);
            ps.setInt(1, idfilm);
            return ps.executeUpdate();
        } catch(SQLException ex) {
        	ex.printStackTrace();
        	return -1;
        }
	}
}
