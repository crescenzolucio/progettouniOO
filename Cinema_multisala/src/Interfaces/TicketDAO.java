package Interfaces;

import Entity.Ticket;

public interface TicketDAO {
	public boolean buyTicket(Ticket ticket);
	public Integer lastTicket();
}
