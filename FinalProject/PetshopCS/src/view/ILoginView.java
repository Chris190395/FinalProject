package view;

import controller.LoginController;

public interface ILoginView {

	void SetController(LoginController controler);
    void ValidateLog(Boolean valid, String errorMsg);
}
