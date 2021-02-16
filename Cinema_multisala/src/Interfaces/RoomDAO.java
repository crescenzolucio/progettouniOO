package Interfaces;

import java.util.List;

import Entity.Room;

public interface RoomDAO {
	public Room getRoom(Integer idroom);
	public boolean insertRoom(Room room);
	public List<Room> getRooms();
}
