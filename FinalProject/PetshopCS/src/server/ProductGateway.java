package server;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Product;

public class ProductGateway {

	static Conn c=new Conn();
	
	public ProductGateway(){}

	public Product select(String cod){
		Product patient;
		String name = "";
        int id = 0, price=0, quantity=0;
		try{
			Statement s = Conn.myconnection.createStatement();
			ResultSet r = s.executeQuery("SELECT * FROM product WHERE id_product='" + cod + "'");
			while(r.next()){
				 id = Integer.parseInt(r.getString("id_product").toString());
				 name = r.getString("name").toString();
				 price = Integer.parseInt(r.getString("price").toString());
				 quantity = Integer.parseInt(r.getString("quantity").toString());

			 }
			
		}
		catch (SQLException e) {
		    throw new IllegalStateException("Cannot execute te query!", e);
		}
		patient = new Product(id, name, price, quantity);
		return patient;
	
	}

	public String insert(Product patient){
		try{
			Statement s = Conn.myconnection.createStatement();
			String sql = "INSERT INTO product(name, price, quantity)VALUES('"
			+ patient.getName() + "',  '" + patient.getPrice() + "', '" + patient.getQuantity() +  "')";
			s.executeUpdate(sql);
			return "Insert complete !";
		}
		catch (SQLException e) {
		    throw new IllegalStateException("Cannot execute te query!", e);
		}
	}

	public String update(Product patient){
		try{
			Statement s = Conn.myconnection.createStatement();
			String sql = "UPDATE product SET name='" + patient.getName() 
			+ "', price='" + patient.getPrice() 
			+ "', quantity='" + patient.getQuantity() 
			+ "'  WHERE id_product = '"+ patient.getId()+"'";
			s.executeUpdate(sql);
			return "Update complete !";
		}
		catch (SQLException e) {
		    throw new IllegalStateException("Cannot execute te query!", e);
		}	
	}

	public String delete(Product patient){
		try{
			Statement s = Conn.myconnection.createStatement();
			String sql = "DELETE FROM product WHERE id_product = '" + patient.getId() + "'";
			s.executeUpdate(sql);
			return "Delete complete!";
		}
		catch (SQLException e) {
		    throw new IllegalStateException("Cannot execute te query!", e);
		}	
	}
	
	public ArrayList<Product> selectAll(){
		ArrayList<Product> patients = new ArrayList<Product>();
        try
        {
        	Statement s = Conn.myconnection.createStatement();
			ResultSet r = s.executeQuery("SELECT * FROM product");
			while(r.next()){
				 patients.add(new Product(Integer.parseInt(r.getString("id_product").toString()),  r.getString("name").toString(),Integer.parseInt(r.getString("price").toString()), Integer.parseInt(r.getString("quantity").toString())));
			 }
        }
        catch(SQLException e) {
		    throw new IllegalStateException("Cannot execute te query!", e);
        }
        return patients;
	}
}
