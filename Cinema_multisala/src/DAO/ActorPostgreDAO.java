package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;

import Entity.Actor;
import Entity.Film;
import Interfaces.ActorDAO;

public class ActorPostgreDAO implements ActorDAO{
	
		public LinkedList<Actor> findActors() {
			String Query = "SELECT * FROM attori a order by a.nominativo asc";
			Connectiondb connection_db =new Connectiondb();
	        Connection con=connection_db.get_connection();
	        LinkedList<Actor> list = new LinkedList<Actor>();
	        try {
	            PreparedStatement ps = con.prepareStatement(Query);
	            ResultSet rs =  ps.executeQuery();

	            while (rs.next()) {
	            	  Integer idactor = rs.getInt("id_attore");
	            	  String name = rs.getString("nominativo");
	            	  Integer country = rs.getInt("paese_di_origine");
	            	  Date birth = rs.getDate("data_nascita");
	            	  Actor actor = new Actor(idactor,name,country,birth);
	            	  list.add(actor);
	            	}
	            con.close();
	        } catch(SQLException ex) {
	        	ex.printStackTrace();
	        }
			return list;
		}
		
		public boolean insertActor(Actor actor) {
			String Query = "INSERT INTO public.attori( nominativo, paese_di_origine, data_nascita) VALUES (?, ?, ?)";
			Connectiondb connection_db =new Connectiondb();
	        Connection con=connection_db.get_connection();
	        try {
	            PreparedStatement ps = con.prepareStatement(Query);
	            ps.setString(1, actor.getName());
	            ps.setInt(2, actor.getCountry());
	            ps.setDate(3, new java.sql.Date(actor.getDateofbirth().getTime()));
	            ps.execute();
	            ps.close();
	            con.close();
	        } catch(SQLException ex) {
	        	ex.printStackTrace();
	        	return false;
	        }
			return true;
		}
		
		public Actor getActor(Integer idactor) {
			String Query = "Select * from attori a where a.id_attore=?";
			Connectiondb connection_db =new Connectiondb();
	        Connection con=connection_db.get_connection();
	        Actor actor = new Actor();
	        try {
	            PreparedStatement ps = con.prepareStatement(Query);
	            ps.setInt(1, idactor);
	            ResultSet rs =  ps.executeQuery();
	            if (!rs.next()) { 
	            	System.out.println("No records found");
				}else {
					actor.setIdactor(idactor);
					actor.setName(rs.getString("nominativo"));
	            	actor.setCountry(rs.getInt("paese_di_origine"));
	            	actor.setDateofbirth(rs.getDate("data_nascita"));
				}
	            con.close();
	        } catch(SQLException ex) {
	        }
			return actor;
		}
}
