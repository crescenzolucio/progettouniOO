package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.LinkedList;

import Entity.Projection;
import Entity.Ticket;
import Interfaces.TicketDAO;

public class TicketPostgreDAO implements TicketDAO{
	public boolean buyTicket(Ticket ticket) {
		String Query = "INSERT INTO BIGLIETTI (id_proiezione, id_biglietto, sconto, prezzofinale) VALUES(?,?,?,?)";
		Connectiondb connection_db =new Connectiondb();
        Connection con=connection_db.get_connection();
        try {
            PreparedStatement ps = con.prepareStatement(Query);
            ps.setInt(1, ticket.getId_pj());
            ps.setInt(2, ticket.getId_ticket());
            ps.setInt(3, ticket.getDiscount());
            ps.setInt(4, ticket.getFinalprice());
            ps.execute();
            ps.close();
        } catch(SQLException ex) {
        	ex.printStackTrace();
        	return false;
        }
		return true;
	}
	
	public Integer lastTicket() {
		String Query = "Select max(b.id_biglietto) from biglietti b";
		Connectiondb connection_db =new Connectiondb();
        Connection con=connection_db.get_connection();
        LinkedList<Projection> list = new LinkedList<Projection>();
        try {
            PreparedStatement ps = con.prepareStatement(Query);
            ResultSet rs =  ps.executeQuery();

            if(rs.next()) return rs.getInt("max");
        } catch(SQLException ex) {
        	ex.printStackTrace();
        }
		return 0;
	}
}
