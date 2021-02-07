package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connectiondb {

	public Connection get_connection() {
    	Connection conn = null;
    	String url = "jdbc:postgresql://localhost:5432/postgres";
    	Properties props = new Properties();
    	props.setProperty("user","postgres");
    	props.setProperty("password","1996");
    	props.setProperty("ssl","false");
		try {
			conn = DriverManager.getConnection(url, props);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return conn;
    }
}
