package client;

import model.Packet;
import view.LoginView;

import java.io.EOFException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import controller.LoginController;

public class Client {

	Object object = new Object();
	
	public static void main(String arg[]) {
		
		LoginView log = new LoginView();
	    LoginController loginCtrl = new LoginController(log);
	    loginCtrl.SetView(log);
		log.setVisible(true);
	}

	public Object connectWithServer(Packet packet)throws Exception{
		try{
			  Socket s=new Socket("127.0.0.1",1700);
			  
		      ObjectOutputStream os = new ObjectOutputStream(s.getOutputStream());
		      ObjectInputStream is = new ObjectInputStream(s.getInputStream());
		      
		      os.writeObject(packet);
		      
		      try{
		    	  object = (Object) is.readObject();
		      }catch(EOFException ex){
		    	  
		      }
			  is.close();
		      os.close();
		      s.close();
		}catch(Exception e) {e.printStackTrace(); }
		return object;
	 }
}
