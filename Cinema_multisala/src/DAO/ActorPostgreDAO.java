package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;

import Entity.Actor;
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
	            	  Actor actor = new Actor(idactor,name,country.toString(),birth);
	            	  list.add(actor);
	            	}
	            con.close();
	        } catch(SQLException ex) {
	        	ex.printStackTrace();
	        }
			return list;
		}
}
