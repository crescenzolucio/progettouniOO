package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import Entity.Country;
import Interfaces.CountryDAO;

public class CountryPostgreDAO implements CountryDAO{
	public LinkedList<Country> getCountries() {
		String Query = "Select * from paesi p order by p.paese";
		ConnectiondbPostgreDAO connection_db =new ConnectiondbPostgreDAO();
        Connection con=connection_db.get_connection();
        LinkedList<Country> list = new LinkedList<Country>();
        try {
            PreparedStatement ps = con.prepareStatement(Query);
            ResultSet rs =  ps.executeQuery();

            while (rs.next()) {
            	  Country country =  new Country();
            	  country.setIdcountry(rs.getInt("id_paese"));
            	  country.setCountry(rs.getString("paese"));
            	  list.add(country);
            	}
            con.close();
        } catch(SQLException ex) {
        	ex.printStackTrace();
        }
		return list;
	}
}
