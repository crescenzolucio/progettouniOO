package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Controllers.Controller;
import Entity.Room;
import Interfaces.ViewDAO;

public class ViewPostgreDAO implements ViewDAO{
	public TableModel ProfitableShowsView(){
		String Query = "SELECT * FROM spettacoli_renumerativi";
		Connectiondb connection_db =new Connectiondb();
		DefaultTableModel model = new DefaultTableModel();
        Connection con=connection_db.get_connection();
        try {
            PreparedStatement ps = con.prepareStatement(Query);
            ResultSet rs =  ps.executeQuery();

    		String[] columnNames = {"Film","Tickets Sold","Total Gain"};
    		model.setColumnIdentifiers(columnNames);
            while (rs.next()) { 
            	  String film = rs.getString("film");
            	  String ticketsold = rs.getString("biglietti_venduti");
            	  String totalgain = rs.getString("guadagno_totale");
            	  model.addRow(new Object[]{film, ticketsold, totalgain});
            	}
            con.close();
        } catch(SQLException ex) {
        	ex.printStackTrace();
        }
		return model;
	}
	
	public TableModel PrimeTimeView(){
		String Query = "SELECT * FROM orari_maggiore_affluenza";
		Connectiondb connection_db =new Connectiondb();
		DefaultTableModel model = new DefaultTableModel();
        Connection con=connection_db.get_connection();
        try {
            PreparedStatement ps = con.prepareStatement(Query);
            ResultSet rs =  ps.executeQuery();

    		String[] columnNames = {"Influx","Start time","End time"};
    		model.setColumnIdentifiers(columnNames);
            while (rs.next()) { 
            	  String influx = rs.getString("affluenza");
            	  String start = rs.getString("fasciainizio");
            	  String end = rs.getString("fasciafine");
            	  model.addRow(new Object[]{influx, start, end});
            	}
            con.close();
        } catch(SQLException ex) {
        	ex.printStackTrace();
        }
		return model;
	}
	public TableModel PrimeTimeRoomsView(){
		String Query = "SELECT * FROM affluenza_sale_orari_max";
		Controller control = new Controller();
		Connectiondb connection_db =new Connectiondb();
		DefaultTableModel model = new DefaultTableModel();
        Connection con=connection_db.get_connection();
        try {
            PreparedStatement ps = con.prepareStatement(Query);
            ResultSet rs =  ps.executeQuery();
    		String[] columnNames = {"Count","Room","Start","End"};
    		model.setColumnIdentifiers(columnNames);
            while (rs.next()) { 
            	  String count = rs.getString("conta");
            	  Room roomobj = control.nameRoom(Integer.parseInt(rs.getString("id_sala")));
            	  String room = roomobj.getDescrizione();
            	  String start = rs.getString("fasciainizio");
            	  String end = rs.getString("fasciafine");
            	  model.addRow(new Object[]{count, room, start,end});
            	}
            con.close();
        } catch(SQLException ex) {
        	ex.printStackTrace();
        }
		return model;
	}
}
