package model;

import java.io.Serializable;

public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int Id;
	public String UserName,Password, FirstName,LastName,Type;


	public User()
	{
		
	}
	
	public User(int id, String username, String pass, String fname, String lname, String type)
    {
        this.Id = id;
        this.UserName = username;
        this.Password = pass;
        this.FirstName = fname;
        this.LastName = lname;
        this.Type = type;
    }

	public int getId() {
	    	return Id;
	    }
	public void setId(int Id) {
		this.Id=Id;
    }
	public String getUserName() {
	    	return UserName;
	    }
	public void setUserName(String UserName) {
		this.UserName=UserName;
    }
	public String getPassword() {
    	return Password;
    }
	public void setPassword(String Password) {
		this.Password=Password;
    }
	public String getFirstName() {
    	return FirstName;
    }
	public void setFirstName(String FirstName) {
		this.FirstName=FirstName;
    }
	public String getLastName() {
    	return LastName;
    }
	public void setLastName(String LastName) {
		this.LastName=LastName;
    }
	public String getType() {
    	return Type;
    }
	public void setType(String Type) {
		this.Type=Type;
    }
}
