package controller;

import controller.helper.NewUserViewHelper;
import model.DAO.Database;
import model.DAO.UserDAO;
import model.User;
import view.LoginView;
import view.NewUserView;


public class NewUserViewController {
    
    private final NewUserView view;
    private final NewUserViewHelper helper;
    
    public NewUserViewController(NewUserView view){
        this.view = view;
        this.helper = new NewUserViewHelper(view);
    }
    
    public void createNewUser(){
        //Verify if passwords match
        if(view.getNewPasswordField().getText().equals(view.getRepeatPasswordField().getText())){
            User user = helper.getModel();
            UserDAO userDAO = new UserDAO();
            for(User userList : Database.userDatabase){
                if(userDAO.userAndPasswordMatch(userList, user)){
                    helper.showMessage("Existing username or password, please enter a new username and password.");
                    helper.clearScreen();
                }
                else{
                    userDAO.insert(user);
                    
                    helper.showMessage("User registered successfully!");
                    
                //Back to login screen
                    LoginView loginView = new LoginView();
                    loginView.setVisible(true);
                    this.view.dispose();
            
                }
            }


            
        }else{
            helper.showMessage("Passwords doesn't match!");
            helper.clearScreen();
        }
    }
    
}
