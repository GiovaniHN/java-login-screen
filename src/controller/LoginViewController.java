package controller;

import controller.helper.LoginViewHelper;
import model.DAO.UserDAO;
import model.User;
import view.LoginView;
import view.MainScreen;
import view.NewUserView;


public class LoginViewController {
    
    private final LoginView view;
    private final LoginViewHelper helper;
    
    public LoginViewController(LoginView view){
        this.view = view;
        this.helper = new LoginViewHelper(view);
    }
    
    public void doLogin(){
        
        //Get user from screen
        User loginUser = helper.getModel();
        
        //Check if user exists in DB
        UserDAO userDAO = new UserDAO();
        User authenticatedUser = userDAO.selectByNameAndPassword(loginUser);
        
        //If exists, do login, if not, don't
        if(authenticatedUser != null){
            this.view.dispose();
            MainScreen mainSc = new MainScreen();
            mainSc.setVisible(true);

        }
        else{
            view.showMessage("Username doesn't exist.\n"
                    + "If you don't have an account, please click on 'New User' button.");
            helper.clearScreen();
        }
        
    }
    
    public void newUserScreen(){
        this.view.dispose();
        NewUserView newUserView = new NewUserView();
        newUserView.setVisible(true);
    }

}
