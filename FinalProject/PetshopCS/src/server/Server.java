package server;

import java.io.EOFException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import model.Packet;
import model.Product;
import model.User;
import model.Cart;

public class Server {
	
	private static UserGateway userG = new UserGateway();
	private static ProductGateway patientG = new ProductGateway();
	private static CartGateway consultG = new CartGateway();
	
	public static void main(String arg[]) throws Exception {
		ServerSocket server=new ServerSocket(1700);
		try{
			while(true){
	  
				System.out.println("Waiting for clients...");
				Socket s = server.accept();
	    
				ObjectOutputStream os = new  ObjectOutputStream(s.getOutputStream());
				ObjectInputStream is = new ObjectInputStream(s.getInputStream());
	   
				Packet packet = new Packet();
	    
				try{
					packet = (Packet)is.readObject();
				}catch(EOFException ex){ ex.printStackTrace();}
		     
				Object object = new Object();
				User user;
				Product patient;
				Cart consult;
				String username, id_product, id_buyer;
				switch(packet.getCommand())
				{
					case "getRole" :
						username = (String)packet.getObject();
						object =(Object)userG.select(username);
						os.writeObject(object);
						break;
					case "createUser" : 
						user = (User) packet.getObject();
						userG.insert(user);
						break;
					case "updateUser" : 
			    		user = (User)packet.getObject();
			    		userG.update(user);
			    		break;
					case "deleteUser" : 
						user = (User)packet.getObject();
						userG.delete(user);
						break;
					case "findAllUsers" :
						ArrayList<User> users = new ArrayList<User>();
						users = userG.selectAll();
						os.writeObject(users);
						break;
					case "findUser" :
						username = (String)packet.getObject();
						object =(Object)userG.select(username);
						os.writeObject(object);
						break;
					case "createProduct" : 
						patient = (Product) packet.getObject();
						patientG.insert(patient);
						break;
					case "updateProduct" : 
						patient = (Product) packet.getObject();
						patientG.update(patient);
			    		break;
					case "deleteProduct" : 
						patient = (Product) packet.getObject();
						patientG.delete(patient);
						break;
					case "findAllProducts" :
						ArrayList<Product> patientsAll = new ArrayList<Product>();
						patientsAll = patientG.selectAll();
						os.writeObject(patientsAll);
						break;
					/*case "findProduct" :
						cnp = (String)packet.getObject();
						patient =(Patient)patientG.select(cnp);
						os.writeObject(patient);
						break;*/
					case "createCart" : 
						consult = (Cart) packet.getObject();
						consultG.insert(consult);
						break;
					case "updateCart" : 
						consult = (Cart) packet.getObject();
						consultG.update(consult);
			    		break;
					case "deleteCartt" : 
						consult = (Cart) packet.getObject();
						consultG.delete(consult);
						break;
					case "findAllCarts" :
						ArrayList<Cart> consultsAll = new ArrayList<Cart>();
						consultsAll = consultG.selectAll();
						os.writeObject(consultsAll);
						break;
					case "findConsult" :
						String receive = (String) packet.getObject();
						String [] tokens =  receive.split(",");
						id_product = tokens[0];
						id_buyer = tokens[1];
						ArrayList<Cart> consults = new ArrayList<Cart>();
						consults = consultG.select(id_product,id_buyer);
						os.writeObject(consults);
						break;
					default : 
			    		break;
				}
				os.close();
				is.close();
				s.close();
			}
		}
		finally{
	    server.close();
		}
	}
}
