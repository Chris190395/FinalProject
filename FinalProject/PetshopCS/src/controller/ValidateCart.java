package controller;

import java.util.List;

import model.Cart;
import model.Product;
import model.User;

public class ValidateCart {

	private Boolean error;
    private List<User> buyers;
    private List<Product> products;
    private List<Cart> carts;
    private String errorMsg, fname, lname;
    private int id_buyer=0, id_product=0, ID = 0;

    public ValidateCart(List<User> buyers, List<Product> products,List<Cart> carts,String fname, String lname, int ID)
    {
        this.buyers = buyers;
        this.products = products;
        this.carts = carts;
        this.fname = fname;
        this.lname = lname;
        this.ID = ID;
        error = false;
        errorMsg = "";
    }

    public void validate()
    {
        error = false;
        validate_product();
        validate_buyer();
    }

   /* public void validate_date()
    {
    	String regex = "[0-9.: ]+";
        if (date.matches(regex) == false && date.length() != 16)
        {
            error = true;
            errorMsg = "Incorrect date!";
        }
    }
*/
    public void validate_product()
    {
        Product product = null;
        for (Product p : products)
        {
            if (p.Id == ID)
            {
                product = p;
            }
        }
        if (product == null)
        {
            error = true;
            errorMsg = "Incorrect id!";
        }
        else
        {
            id_product = product.Id;
        }
    }

    public void validate_buyer()
    {
        User doctor = new User();
        doctor.UserName = null;
        for (User user : buyers)
        {
            if(user.getFirstName().equals(fname) && user.getLastName().equals(lname))
            {
                doctor = user;
                System.out.println(fname + " " + lname);
            }
        }
        if (doctor.getUserName() == null)
        {
        	error = true;
            errorMsg = "Incorrect doctor!";
        }
        else
        {
        	id_buyer = doctor.Id;
        }
    }

    public Boolean isValid()
    {
        if (error == false)
        {
            return true;
        }
        return false;
    }

    public String getErrorMsg()
    {
        return errorMsg;
    }

    public Cart getCart()
    {
        if (error == false)
        {
            int last = carts.size();
            Cart consult = new Cart();
            consult.setId(carts.get(last - 1).getId() + 1);
            consult.setId_product("" + id_product);
            consult.setId_buyer("" + id_buyer);
            
            return consult;
        }
        return null;
    }
}
