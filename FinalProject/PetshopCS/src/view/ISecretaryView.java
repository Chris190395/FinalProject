package view;
import model.Cart;
import model.Product;
import model.User;

import java.util.List;

import controller.RegularUserController;

public interface ISecretaryView {

	void SetController(RegularUserController controller);
	void UpdateProductView();
	void UpdateCartView();

    void SetProductsInGrid(List<Product> patients);
   // void AddNewPatient(Patient patient, Boolean error, String errorMsg);
    void AddNewProduct(String errorMsg);

    void DeleteProduct(Product patient, Boolean error, String errorMsg);
    void EditProduct(Boolean error, String errorMsg);
   // void FindPatient(Patient patient, Boolean error, String errorMsg);
    Product GetSelectedProductFromGrid();

    void SetBuyersInList(List<User> users);
    void SetCartsInGrid(List<Cart> consultations);
    void AddNewCart(Cart consult, Boolean error, String errorMsg);
    void DeleteCart(Cart consult, Boolean error, String errorMsg);
    void EditCart(Boolean error, String errorMsg);
    void SetFields(String fname, String lname);
    Cart GetSelectedCartFromGrid();
}
