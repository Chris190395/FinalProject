package controller;

import java.util.ArrayList;

import client.Client;
import model.Packet;
import model.User;
import view.IAdministratorView;

public class AdministratorController {

	private IAdministratorView adminView;
	private ArrayList<User> usersList;
	private Client client;
	
	public AdministratorController(IAdministratorView adminView)
	{
		adminView.SetController(this);
		this.client = new Client();
	}
	
	public void SetView(IAdministratorView adminView)
	{
		this.adminView = adminView;
		SetUsers();
	}
	
	@SuppressWarnings("unchecked")
	public void SetUsers()
    {
        usersList = new ArrayList<User>();
        Packet packet = new Packet("", "findAllUsers");
        try {
			usersList = (ArrayList<User>)client.connectWithServer(packet);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
        adminView.SetUsersInGrid(usersList);
    }


    public void AddNewUser(String userName, String password, String firstName, String lastName, String type)
    {
        int last = usersList.size();
        User newUser = new User();
        if(last==0)
        	newUser.Id = 1;
        else
        	newUser.Id = usersList.get(last - 1).Id+1;
        
        newUser.UserName = userName;
        newUser.Password = password;
        newUser.FirstName = firstName;
        newUser.LastName = lastName;
        newUser.Type = type;
        //ValidateUser userV = new ValidateUser(newUser);
        //userV.validate();
       // if (userV.isValid() == true)
       // {
        	User user = new User();
        	user.setUserName(null);
        	Packet packet1 = new Packet(userName, "findUser");
            try {
    			user = (User)client.connectWithServer(packet1);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
            System.out.println(user.getUserName());
            if (user.getUserName() == null)
            {
               // Encrypt e = new Encrypt(password);
                //newUser.Password = e.getEncriptedPass();
                this.adminView.AddNewUser("Insert Complete!");
                Packet packet2 = new Packet(newUser, "createUser");
                try {
        			client.connectWithServer(packet2);
        		} catch (Exception ex) {
        			ex.printStackTrace();
        		}
                adminView.UpdateUserView();
            }
            else
            {
                this.adminView.AddNewUser("User already exist!");
            }
        //}
        //else
       // {
        //    this.adminView.AddNewUser(userV.getErrorMsg());
        //}
    }

    public void EditUser(String userName, String password, String firstName, String lastName, String type)
    {
        User user = adminView.GetSelectedUserFromGrid();
        if (user != null)
        {
            user.UserName = userName;
            user.Password = password;
            user.FirstName = firstName;
            user.LastName = lastName;
            user.Type = type;
           // ValidateUser userV = new ValidateUser(user);
            //userV.validate();
          //  if (userV.isValid() == true)
            //{
                //Encrypt e = new Encrypt(password);
                //user.Password = e.getEncriptedPass();
                Packet packet = new Packet(user, "updateUser");
                try {
        			client.connectWithServer(packet);
        		} catch (Exception ex) {
        			ex.printStackTrace();
        		}
                this.adminView.EditUser("Edit complete");
                adminView.UpdateUserView();
           // }
           // else
           // {
           //     this.adminView.EditUser(userV.getErrorMsg());
            //}
        }
    }

    public void DeleteUser()
    {
        User user = adminView.GetSelectedUserFromGrid();
        if (user != null)
        {
        	Packet packet = new Packet(user, "deleteUser");
            try {
    			client.connectWithServer(packet);
    		} catch (Exception ex) {
    			ex.printStackTrace();
    		}
            this.adminView.DeleteUser("Delete complete!");
            adminView.UpdateUserView();
        }
    }

    public void FindUser(String username)
    {
        User user = null;
        Packet packet = new Packet(username, "findUser");
        try {
			user = (User)client.connectWithServer(packet);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
        if (user != null)
        {
            adminView.FindUser(user, false, "User found!");
        }
        else
            adminView.FindUser(user, true, "User not found!");
    }


}
