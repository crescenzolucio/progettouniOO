package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import Interfaces.UserDAO;

public class UserPostgreDAO implements UserDAO{

	public boolean findUser(String user) {
		String Query = "Select * from utenti u where u.username=?";
		ConnectiondbPostgreDAO connection_db =new ConnectiondbPostgreDAO();
        Connection con=connection_db.get_connection();
        boolean check = false;
        try {
            PreparedStatement ps = con.prepareStatement(Query);
            ps.setString(1, user);
            ResultSet rs =  ps.executeQuery();
            if (!rs.next()) { 
            	System.out.println("No records found");
			}else {
				System.out.println("User found");
				check = true;
			}
            con.close();
        } catch(SQLException ex) {
        }
		return check;
	}

	public boolean checkPassword(String user,String password) {
		String Query = "Select * from utenti u where u.username=?";
		ConnectiondbPostgreDAO connection_db =new ConnectiondbPostgreDAO();
        Connection con=connection_db.get_connection();
        boolean check = false;
        try {
            PreparedStatement ps = con.prepareStatement(Query);
            ps.setString(1, user);
            ResultSet rs =  ps.executeQuery();
            if (!rs.next()) { 
            	System.out.println("No records found");
			}else {
				if(password.equals(rs.getString("psw"))){
					check = true;
				}
			}
            con.close();
        } catch(SQLException ex) {
        }
		return check;
	}
	
	public boolean addUser(String user, String password, String email) {
		String Query = "INSERT INTO UTENTI VALUES (?,?,?)";
		ConnectiondbPostgreDAO connection_db =new ConnectiondbPostgreDAO();
        Connection con=connection_db.get_connection();
        boolean check = false;
        try {
            PreparedStatement ps = con.prepareStatement(Query);
            ps.setString(1, user);
            ps.setString(2, password);
            ps.setString(3, email);
            ps.executeUpdate();
            ps.close();
        } catch(SQLException ex) {
        }
		return check;
	}

}
