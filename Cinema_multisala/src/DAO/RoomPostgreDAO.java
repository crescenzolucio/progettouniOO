package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

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
            	room.setDescription(rs.getString("descrizione"));
            	room.setSeats(rs.getInt("posti"));
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
            ps.setString(1, room.getDescription());
            ps.setInt(2, room.getTechaudio());
            ps.setInt(3, room.getTechproj());
            ps.setInt(4, room.getSeats());
            ps.execute();
            ps.close();
            con.close();
        } catch(SQLException ex) {
        	ex.printStackTrace();
        	return false;
        }
		return true;
	}
	
	public LinkedList<Room> getRooms() {
		String Query = "Select s.id_sala,s.descrizione,s.sistema_audio,(select t.audio from sistemi_audio t where t.id_sound=s.sistema_audio),"
				+ "s.tecnologia_proiezione,(select t.tecnologia from tecnologie_proiezione t where t.id_tec=s.tecnologia_proiezione),s.posti from sale s order by s.descrizione";
		Connectiondb connection_db =new Connectiondb();
        Connection con=connection_db.get_connection();
        LinkedList<Room> list = new LinkedList<Room>();
        try {
            PreparedStatement ps = con.prepareStatement(Query);
            ResultSet rs =  ps.executeQuery();

            while (rs.next()) {
            	  Room room =  new Room();
            	  room.setIdroom(rs.getInt("id_sala"));
            	  room.setDescription(rs.getString("descrizione"));
            	  room.setTechprojdesc(rs.getString("tecnologia"));
            	  room.setTechaudio(rs.getInt("sistema_audio"));
            	  room.setTechproj(rs.getInt("tecnologia_proiezione"));
            	  room.setTechaudiodesc(rs.getString("audio"));
            	  room.setSeats(rs.getInt("posti"));
            	  list.add(room);
            	}
            con.close();
        } catch(SQLException ex) {
        	ex.printStackTrace();
        }
		return list;
	}
	
	public Integer deleteRoom(Integer idroom) {
		String Query = "DELETE FROM SALE F WHERE F.ID_SALA=?";
		Connectiondb connection_db =new Connectiondb();
        Connection con=connection_db.get_connection();
        try {
            PreparedStatement ps = con.prepareStatement(Query);
            ps.setInt(1, idroom);
            return ps.executeUpdate();
        } catch(SQLException ex) {
        	ex.printStackTrace();
        	return -1;
        }
	}
}
