package view;

import java.util.List;

import controller.BuyerController;
import model.Cart;
import model.Product;

public interface IDoctorView {

	void SetController(BuyerController controller, int id);

   // void SetCartsInGrid(List<Cart> consults);
    void SetProductsInList(List<Product> patients);
   // void EditConsult(String errorMsg);
    //void FindConsultations(String errorMsg);
    int GetSelectedProductFromList();
    //Cart GetSelectedCartFromGrid();
}
