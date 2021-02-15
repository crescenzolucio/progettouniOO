package Interfaces;

import Entity.Room;

public interface RoomDAO {
	public Room getRoom(Integer idroom);
	public boolean insertRoom(Room room);
}
