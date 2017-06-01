package server;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Cart;

public class CartGateway {

static Conn c=new Conn();
	
	public CartGateway(){}

	public ArrayList<Cart> select(String cod1, String cod2){
		ArrayList<Cart> carts = new ArrayList<Cart>();
		String  id_product = "" , id_buyer = "";
        int id = 0;
		try{
			Statement s = Conn.myconnection.createStatement();
			ResultSet r = s.executeQuery("SELECT * FROM cart WHERE id_product='" + cod1 + "' AND id_buyer='" + cod2 + "'");
			while(r.next()){
				
				 id = Integer.parseInt(r.getString("id_cart").toString());
				 id_product = r.getString("id_product").toString();
				 id_buyer = r.getString("id_buyer").toString();
				 
				 carts.add(new Cart(id, id_product, id_buyer));

			 }
			
		}
		catch (SQLException e) {
		    throw new IllegalStateException("Cannot execute te query!", e);
		}
		return carts;
	
	}

	public String insert(Cart consult){
		try{
			Statement s = Conn.myconnection.createStatement();
			String sql = "INSERT INTO cart(id_product, id_buyer)VALUES('"
			+ consult.getId_product() + "',  '" + consult.getId_buyer() +  "')";
			s.executeUpdate(sql);
			return "Insert complete !";
		}
		catch (SQLException e) {
		    throw new IllegalStateException("Cannot execute te query!", e);
		}
	}

	public String update(Cart consult){
		try{
			Statement s = Conn.myconnection.createStatement();
			String sql = "UPDATE cart SET id_product='" + consult.getId_product() 
			+ "', id_buyer='" + consult.getId_buyer() 
			+ "' WHERE id_cart = '"+ consult.getId()+"'";
			s.executeUpdate(sql);
			return "Update complete !";
		}
		catch (SQLException e) {
		    throw new IllegalStateException("Cannot execute te query!", e);
		}	
	}

	public String delete(Cart consult){
		try{
			Statement s = Conn.myconnection.createStatement();
			String sql = "DELETE FROM cart WHERE id_cart = '" + consult.getId() + "'";
			s.executeUpdate(sql);
			return "Delete complete!";
		}
		catch (SQLException e) {
		    throw new IllegalStateException("Cannot execute te query!", e);
		}	
	}
	
	public ArrayList<Cart> selectAll(){
		ArrayList<Cart> consultations = new ArrayList<Cart>();
        try
        {
        	Statement s = Conn.myconnection.createStatement();
			ResultSet r = s.executeQuery("SELECT * FROM cart");
			while(r.next()){
				 consultations.add(new Cart(Integer.parseInt(r.getString("id_cart").toString()),  r.getString("id_product").toString(), r.getString("id_buyer").toString()));
			 }
        }
        catch(SQLException e) {
		    throw new IllegalStateException("Cannot execute te query!", e);
        }
        if(consultations.size() > 0)
        	return consultations;
        return null;
	}
}
