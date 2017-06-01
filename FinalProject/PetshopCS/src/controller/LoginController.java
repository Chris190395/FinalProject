package controller;

import model.User;
import client.Client;
import view.AdministratorView;
import view.ILoginView;
import view.LoginView;
import view.RegularUserView;
import view.BuyerView;
import model.Packet;

public class LoginController {
	
	private ILoginView logView;
	private Client client;
	
	public LoginController(ILoginView logView)
	{
		this.client = new Client();
		logView.SetController(this);
	}
	
	public void SetView(ILoginView logView)
	{
		this.logView = logView;
	}
	
	public void ValidateLogin(String username, String password, LoginView login)
	{
		Boolean error = false;
     
        User user = new User();
        user.setUserName(null);
        Packet packet = new Packet(username, "getRole");
        try {
			user = (User)client.connectWithServer(packet);
		} catch (Exception e) {
			e.printStackTrace();
		}
        if(user.UserName != null)
        {
        	
        	if (user.getPassword().equals(password)==false)
        	{
        		logView.ValidateLog(false,"Incorrect password!");
        		error = true;
        	}
        	if (user.getUserName().equals(username)==false)
        	{
        		logView.ValidateLog(false,"Incorrect username!");
        		error = true;
        	}
        }
        else
        {
        	logView.ValidateLog(false,"Incorrect username!");
        	 error = true;
        }
        
        if (error == false)
        {
        	if (user.getType().equals("RegularUser"))
            {
                RegularUserView secretaryView = new  RegularUserView(login);
                RegularUserController secretaryController = new RegularUserController(secretaryView);
                secretaryController.SetView(secretaryView);
                login.setVisible(false);
                secretaryView.setVisible(true);
            }
            else
            {
                if (user.getType().equals("Buyer"))
                {
                    BuyerView doctorView = new BuyerView(login);
                    BuyerController doctorController = new BuyerController(doctorView, user.getId());
                    doctorController.SetView(doctorView);
                    login.setVisible(false);
                    doctorView.setVisible(true);
                }
                else
                {
                	if (user.getType().equals("Admin"))
                    {
                        AdministratorView adminView = new AdministratorView(login);
                        AdministratorController adminController = new AdministratorController(adminView);
                        adminController.SetView(adminView);
                        login.setVisible(false);
                        adminView.setVisible(true);
                    }
                }
            }
        }
	}

}
