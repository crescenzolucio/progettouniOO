package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Entity.Film;
import Entity.Room;
import Interfaces.RoomDAO;

public class RoomPostgreDAO implements RoomDAO{
	public Room getRoom(Integer idroom) {
		String Query = "Select * from sale s where s.id_sala=?";
		Connectiondb connection_db =new Connectiondb();
        Connection con=connection_db.get_connection();
        Room room = new Room();
        try {
            PreparedStatement ps = con.prepareStatement(Query);
            ps.setInt(1, idroom);
            ResultSet rs =  ps.executeQuery();
            
            if (!rs.next()) { 
                System.out.println("No records found");
            }else {
            	room.setDescrizione(rs.getString("descrizione"));
            	room.setPosti(rs.getInt("posti"));
            	room.setTechaudio(rs.getInt("tecnologia_proiezione"));
            	room.setTechproj(rs.getInt("sistema_audio"));      		
            }
            con.close();
        } catch(SQLException ex) {
        	ex.printStackTrace();
        }
		return room;
	}
	
	public boolean insertRoom(Room room) {
		String Query = "INSERT INTO sale(descrizione, sistema_audio, tecnologia_proiezione, posti) VALUES (?, ?, ?, ?);";
		Connectiondb connection_db =new Connectiondb();
        Connection con=connection_db.get_connection();
        try {
            PreparedStatement ps = con.prepareStatement(Query);
            ps.setString(1, room.getDescrizione());
            ps.setInt(2, room.getTechaudio());
            ps.setInt(3, room.getTechproj());
            ps.setInt(4, room.getPosti());
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
