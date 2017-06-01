package model;

import java.io.Serializable;

public class Cart implements Serializable{

	private static final long serialVersionUID = 1L;
	public int Id;
	public String id_product,id_buyer;


	public Cart()
	{
		
	}
	
	public Cart(int id, String id_product, String id_buyer)
    {
        this.Id = id;
        this.id_product = id_product;
        this.id_buyer = id_buyer;
       
    }

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getId_product() {
		return id_product;
	}

	public void setId_product(String id_product) {
		this.id_product = id_product;
	}

	public String getId_buyer() {
		return id_buyer;
	}

	public void setId_buyer(String id_buyer) {
		this.id_buyer = id_buyer;
	}


	
}
