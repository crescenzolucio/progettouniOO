package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.LinkedList;

import Entity.Film;
import Entity.Projection;
import Entity.Ticket;
import Interfaces.FilmDAO;

public class FilmPostgreDAO implements FilmDAO{
	public Film getFilm(Integer idfilm) {
		String Query = "Select f.*,r.nominativo from film f join registi r on r.id_regista = f.id_regista where  f.id_film=? order by f.titolo ";
		Connectiondb connection_db =new Connectiondb();
        Connection con=connection_db.get_connection();
        Film film = new Film();
        LinkedList<Integer> actors = new LinkedList<Integer>();
        LinkedList<Integer> genres = new LinkedList<Integer>();
        try {
            PreparedStatement ps = con.prepareStatement(Query);
            ps.setInt(1, idfilm);
            ResultSet rs =  ps.executeQuery();
              
            if (!rs.next()) { 
                System.out.println("No records found");
            }else {
          	  film.setId_film(rs.getInt("id_film"));
          	  film.setTitolo(rs.getString("titolo"));
          	  film.setAnno_produzione(rs.getInt("anno_produzione"));
          	  film.setId_registra(rs.getInt("id_regista"));
          	  film.setDurata_minuti(rs.getInt("durata_minuti"));
          	  film.setUrl_poster(rs.getString("url_poster"));
          	  film.setRegistaname(rs.getString("nominativo"));
          	  
              //get actors
              Query = "SELECT * FROM  attori_film A WHERE A.ID_FILM=?;";
              ps = con.prepareStatement(Query);
              ps.setInt(1, idfilm);
              rs =  ps.executeQuery();
              while (rs.next()) {
            	  actors.add(rs.getInt("id_attore"));
              }
              film.setActors(actors);
              
              //get genres
              Query = "SELECT * FROM  genere_film G WHERE G.ID_FILM=?;";
              ps = con.prepareStatement(Query);
              ps.setInt(1, idfilm);
              rs =  ps.executeQuery();
              while (rs.next()) {
            	  genres.add(rs.getInt("id_genere"));
              }
              film.setGenres(genres);
              
              ps.close();
              con.close();
      		}
            con.close();
        } catch(SQLException ex) {
        	ex.printStackTrace();
        }
		return film;
	}
	
	public LinkedList<Film> getFilms() {
		String Query = "Select f.*,r.nominativo from film f join registi r on r.id_regista = f.id_regista order by f.titolo";
		Connectiondb connection_db =new Connectiondb();
        Connection con=connection_db.get_connection();
        LinkedList<Film> list = new LinkedList<Film>();
        try {
            PreparedStatement ps = con.prepareStatement(Query);
            ResultSet rs =  ps.executeQuery();

            while (rs.next()) {
            	  Film film =  new Film();
            	  film.setId_film(rs.getInt("id_film"));
            	  film.setTitolo(rs.getString("titolo"));
            	  film.setAnno_produzione(rs.getInt("anno_produzione"));
            	  film.setId_registra(rs.getInt("id_regista"));
            	  film.setDurata_minuti(rs.getInt("durata_minuti"));
            	  film.setUrl_poster(rs.getString("url_poster"));
            	  film.setRegistaname(rs.getString("nominativo"));
            	  list.add(film);
            	}
            con.close();
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
            ps.executeUpdate();
            
            //delete actors
            Query = "DELETE FROM attori_film A WHERE A.ID_FILM=?";
            ps = con.prepareStatement(Query);
            ps.setInt(1, idfilm);
            ps.executeUpdate();
            
            //delete genres
            Query = "DELETE FROM genere_film G WHERE G.ID_FILM=?";
            ps = con.prepareStatement(Query);
            ps.setInt(1, idfilm);
            
            return ps.executeUpdate(); 
        } catch(SQLException ex) {
        	ex.printStackTrace();
        	return -1;
        }
	}
	
	public boolean insertFilm(Film film) {
		String Query = "INSERT INTO film(titolo, anno_produzione, id_regista, durata_minuti, url_poster) VALUES (?, ?, ?, ?, ?);";
		Connectiondb connection_db =new Connectiondb();
        Connection con=connection_db.get_connection();
        try {
            PreparedStatement ps = con.prepareStatement(Query,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, film.getTitolo());
            ps.setInt(2, film.getAnno_produzione());
            ps.setInt(3, film.getId_registra());
            ps.setInt(4, film.getDurata_minuti());
            ps.setString(5, film.getUrl_poster());
            ps.executeUpdate();
            
            //id insert
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            Integer index =rs.getInt(1);//idfilm generated
            //insert actors
            Query = "INSERT INTO attori_film(id_attore, id_film) VALUES (?, ?);";
            for (Integer idactor : film.getActors()) {
            	ps = con.prepareStatement(Query);
                ps.setInt(1, idactor);
                ps.setInt(2, index);
                ps.executeUpdate();
            }
            //insert genres
            Query = "INSERT INTO genere_film(id_genere, id_film)	VALUES (?, ?);";
            for (Integer idgenre : film.getGenres()) {
            	ps = con.prepareStatement(Query);
                ps.setInt(1, idgenre);
                ps.setInt(2, index);
                ps.executeUpdate();
            }
            
            ps.close();
            con.close();
        } catch(SQLException ex) {
        	ex.printStackTrace();
        	return false;
        }
		return true;
	}
}
