package model;

import java.io.Serializable;

public class Product implements Serializable{

	private static final long serialVersionUID = 1L;
	public int Id;
	public String Name;
	public int Price;
	public int Quantity;


	public Product()
	{
		
	}


	public Product(int id, String name, int price, int quantity) {
		super();
		Id = id;
		Name = name;
		Price = price;
		Quantity = quantity;
	}


	public int getId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public int getPrice() {
		return Price;
	}


	public void setPrice(int price) {
		Price = price;
	}


	public int getQuantity() {
		return Quantity;
	}


	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	
	
}
