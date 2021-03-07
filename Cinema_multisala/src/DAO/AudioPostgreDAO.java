package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import Entity.Audio;
import Interfaces.AudioDAO;

public class AudioPostgreDAO implements AudioDAO{
	public LinkedList<Audio> getAudios() {
		String Query = "SELECT * FROM sistemi_audio a order by a.audio asc";
		ConnectiondbPostgreDAO connection_db =new ConnectiondbPostgreDAO();
        Connection con=connection_db.get_connection();
        LinkedList<Audio> list = new LinkedList<Audio>();
        try {
            PreparedStatement ps = con.prepareStatement(Query);
            ResultSet rs =  ps.executeQuery();

            while (rs.next()) {
            	  Integer idaudio = rs.getInt("id_sound");
            	  Integer year = rs.getInt("anno");
            	  String description = rs.getString("audio");
            	  Audio audio = new Audio(idaudio,year,description);
            	  list.add(audio);
            	}
            con.close();
        } catch(SQLException ex) {
        	ex.printStackTrace();
        }
		return list;
	}
}
