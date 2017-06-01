package view;

import java.util.ArrayList;

import controller.AdministratorController;
import model.User;

public interface IAdministratorView {

	void SetController(AdministratorController controler);
    void UpdateUserView();

    void SetUsersInGrid(ArrayList<User> users);
    void AddNewUser(String errorMsg);
    void DeleteUser(String errorMsg);
    void EditUser(String errorMsg);
    void FindUser(User user, Boolean error, String errorMsg);
    User GetSelectedUserFromGrid();
}
