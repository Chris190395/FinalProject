package server;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.User;

public class UserGateway {

static Conn c=new Conn();
	
	public UserGateway(){}

	public User select(String cod){
		User user;
		String username = null, password = "", fname = "", lname = "", type = "";
        int id = 0;
		try{
			Statement s = Conn.myconnection.createStatement();
			ResultSet r = s.executeQuery("SELECT * FROM petshop_user WHERE username='" + cod + "'");
			while(r.next()){
				 id = Integer.parseInt(r.getString("id_user").toString());
				 username = r.getString("username").toString();
				 password = r.getString("password").toString();
				 fname = r.getString("first_name").toString();
				 lname = r.getString("last_name").toString();
				 type = r.getString("type").toString();
			 }
			
		}
		catch (SQLException e) {
		    throw new IllegalStateException("Cannot execute te query!", e);
		}
		user = new User(id, username, password, fname, lname, type);
		return user;
	
	}

	public String insert(User user){
		try{
			Statement s = Conn.myconnection.createStatement();
			String sql = "INSERT INTO petshop_user(username, password, first_name, last_name, type)VALUES('"
			+ user.getUserName() + "', '"+ user.getPassword() + "', '"+ user.getFirstName() + "',  '" + user.getLastName() + "', '"  + user.getType() + "')";
			s.executeUpdate(sql);
			return "Insert complete !";
		}
		catch (SQLException e) {
		    throw new IllegalStateException("Cannot execute te query!", e);
		}
	}

	public String update(User user){
		try{
			Statement s = Conn.myconnection.createStatement();
			String sql = "UPDATE petshop_user SET username='" + user.getUserName() 
			+ "', password='" + user.getPassword() 
			+ "', first_name='" + user.getFirstName() 
			+ "', last_name='" + user.getLastName() 
			+ "', type='"+ user.getType()+ "'  WHERE username = '"+ user.getUserName()+"'";
			s.executeUpdate(sql);
			return "Update complete !";
		}
		catch (SQLException e) {
		    throw new IllegalStateException("Cannot execute te query!", e);
		}	
	}

	public String delete(User user){
		try{
			Statement s = Conn.myconnection.createStatement();
			String sql = "DELETE FROM petshop_user WHERE username = '" + user.getUserName() + "'";
			s.executeUpdate(sql);
			return "Delete complete!";
		}
		catch (SQLException e) {
		    throw new IllegalStateException("Cannot execute te query!", e);
		}	
	}
	
	public ArrayList<User> selectAll(){
		ArrayList<User> users = new ArrayList<User>();
        try
        {
        	Statement s = Conn.myconnection.createStatement();
			ResultSet r = s.executeQuery("SELECT * FROM petshop_user");
			while(r.next()){
				 users.add(new User(Integer.parseInt(r.getString("id_user").toString()), r.getString("username").toString(), r.getString("password").toString(), r.getString("first_name").toString(), r.getString("last_name").toString(), r.getString("type").toString()));
			 }
        }
        catch(SQLException e) {
		    throw new IllegalStateException("Cannot execute te query!", e);
        }
        return users;
	}
}
