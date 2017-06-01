package controller;

import java.util.ArrayList;
import java.util.List;

import client.Client;
import model.Cart;
import model.Packet;
import model.Product;
import model.User;
import view.ISecretaryView;

public class RegularUserController {

	private ISecretaryView secretaryView;
    private Client client;
    private List<User> buyersList;
    private List<Product> productsList;
    private List<Cart> cartsList;
	
	public RegularUserController(ISecretaryView secretaryView)
	{
		secretaryView.SetController(this);
		client = new Client();
	}
	
	public void SetView(ISecretaryView secretaryView)
	{
		this.secretaryView = secretaryView;
		SetBuyers();
        SetProducts();
        SetCarts();
	}
	
    @SuppressWarnings("unchecked")
	public void SetBuyers()
    {
        buyersList = new ArrayList<User>();
        List<User> users = new ArrayList<User>();
        Packet packet = new Packet("", "findAllUsers");
        try {
			users = (ArrayList<User>)client.connectWithServer(packet);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
        for (User user : users)
        {
            if (user.Type.equals("Buyer"))
                buyersList.add(user);
        }
        secretaryView.SetBuyersInList(buyersList);
    }

    @SuppressWarnings("unchecked")
	public void SetProducts()
    {
        productsList = new ArrayList<Product>();
        Packet packet = new Packet("", "findAllProducts");
        try {
        	productsList = (ArrayList<Product>)client.connectWithServer(packet);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
        secretaryView.SetProductsInGrid(productsList);
    }

	@SuppressWarnings("unchecked")
	public void SetCarts()
    {
        cartsList = new ArrayList<Cart>();
        Packet packet = new Packet("", "findAllCarts");
        try {
        	cartsList = (ArrayList<Cart>)client.connectWithServer(packet);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
        secretaryView.SetCartsInGrid(cartsList);
    }

	public void AddNewProduct(String Name, int Price, int Quantity)
    {
       /* Patient newPatient = new Patient(id,firstName,lastName,cnp,address,DoB,phone);
     
        	Patient patient = new Patient();
        	Packet pack = new Packet(cnp, "findPatient");
        	try {
    			patient = (Patient)client.connectWithServer(pack);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
            if (patient.getCnp() == null)
            {
                this.secretaryView.AddNewPatient(newPatient, false, "Insert Complete!");
                Packet packet2 = new Packet(newPatient, "createPatient");
                try {
        			client.connectWithServer(packet2);
        		} catch (Exception e) {
        			e.printStackTrace();
        		}
                secretaryView.UpdatePatientView();
            }
            else
            {
                this.secretaryView.AddNewPatient(newPatient, true, "Patient already exist!");
            }*/
		
		
		int last = productsList.size();
        Product newpatient = new Product();
        if(last==0)
        	newpatient.Id = 1;
        else
        	newpatient.Id = productsList.get(last - 1).Id+1;
        
       
        newpatient.Price = Price;
        newpatient.Quantity =Quantity;

                this.secretaryView.AddNewProduct("Insert Complete!");
                Packet packet2 = new Packet(newpatient, "createProduct");
                try {
        			client.connectWithServer(packet2);
        		} catch (Exception ex) {
        			ex.printStackTrace();
        		}
                secretaryView.UpdateProductView();
           
       
    }

	public void EditProduct(String Name, int Price, int Quantity)
    {
        Product patient = secretaryView.GetSelectedProductFromGrid();
        if (patient != null)
        {
            patient.setName(Name);
            patient.setPrice(Price);
            patient.setQuantity(Quantity);
         
                this.secretaryView.EditProduct(false, "Edit Complete!");
            	Packet packet = new Packet(patient, "updateProduct");
                try {
        			client.connectWithServer(packet);
        		} catch (Exception e) {
        			e.printStackTrace();
        		}
                secretaryView.UpdateProductView();
          
    }
    }

    public void DeleteProduct()
    {
        Product patient = secretaryView.GetSelectedProductFromGrid();
        if (patient != null)
        {
        	Packet packet = new Packet(patient, "deleteProduct");
            try {
    			client.connectWithServer(packet);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
        	this.secretaryView.DeleteProduct(patient, false, "Delete complete!");
            secretaryView.UpdateProductView();
        }
    }

  /* public void FindProduct(String cnp)
    {

    	Product patient = new Product();
    	Packet packet = new Packet(cnp, "findPatient");
        try {
			patient = (Patient)client.connectWithServer(packet);
		} catch (Exception e) {
			e.printStackTrace();
		}
        if (patient.getCnp() != null)
        {
            secretaryView.FindPatient(patient, false, "Patient found!");
        }
        else
            secretaryView.FindPatient(patient, true, "Patient not found!");
    }
*/
    public void AddNewCart(String firstName, String lastName, int ID)
    {
        Cart newConsult = null;
        ValidateCart consultV = new ValidateCart(buyersList,productsList,cartsList,firstName,lastName, ID);
        consultV.validate();
        if (consultV.isValid() == true)
        {
           newConsult = consultV.getCart();
            if (newConsult != null)
            {
       
        
                this.secretaryView.AddNewCart(newConsult, false, "Insert Complete!");
                Packet packet = new Packet(newConsult, "createCart");
                try {
        			client.connectWithServer(packet);
        		} catch (Exception e) {
        			e.printStackTrace();
        		}
                secretaryView.UpdateCartView();
            }
            else
            {
                this.secretaryView.AddNewCart(newConsult, true, consultV.getErrorMsg());
            }
        }
        else
       {
            this.secretaryView.AddNewCart(newConsult, true, consultV.getErrorMsg());
        }
    }

   /* public void EditCart(String date)
    {
        Consultation consultation = secretaryView.GetSelectedConsultFromGrid();
        if (consultation != null)
        {
            consultation.setDate(date);
            Boolean valid = validateDate(date);
            if (valid == true)
            {
                this.secretaryView.EditConsult(false, "Edit Complete!");
                Packet packet = new Packet(consultation, "updateConsult");
                try {
        			client.connectWithServer(packet);
        		} catch (Exception e) {
        			e.printStackTrace();
        		}
                secretaryView.UpdateConsultationView();
            }
            else
            {
                this.secretaryView.EditConsult(true, "Try another date!");
            }
        }
    }*/

    public void DeleteCart()
    {
        Cart consult = secretaryView.GetSelectedCartFromGrid();
        if (consult != null)
        {
        	Packet packet = new Packet(consult, "deleteCart");
            try {
    			client.connectWithServer(packet);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
            this.secretaryView.DeleteCart(consult, false, "Delete complete!");
            secretaryView.UpdateCartView();
        }
    }


    public void SetFields(String id_product, String id_buyer)
    {
        String fname="", lname="";
        int idP, idD;
        idP = Integer.parseInt(id_product);
        idD = Integer.parseInt(id_buyer);
        for (User user : buyersList)
        {
            if (idD == user.Id)
            {
                fname = user.FirstName;
                lname = user.LastName;
            }
        }
       /* for (Patient patient : patientsList)
        {
            if (idP == patient.Id)
            {
                cnp = patient.Cnp;
            }
        }*/
        secretaryView.SetFields(fname, lname);
    }

   /*public Boolean validateDate(String date)
    {
        return true;
    }*/
	
	
}
