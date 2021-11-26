package controller.helper;

import model.User;
import view.LoginView;


public class LoginViewHelper implements Helper{
    
    private final LoginView view;
    
    public LoginViewHelper(LoginView view){
        this.view = view;
    }
    
    @Override
    public User getModel(){
        String name = view.getUserTextField().getText();
        String password = view.getPasswordField().getText();
        
        User modelUser = new User(0, name, password);
        
        return modelUser;
    }

    @Override
    public void clearScreen() {
        view.getUserTextField().setText("");
        view.getPasswordField().setText("");
    }
}
