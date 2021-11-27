package controller.helper;

import javax.swing.JOptionPane;
import model.User;
import view.NewUserView;


public class NewUserViewHelper implements Helper{

    private final NewUserView view;
    
    public NewUserViewHelper(NewUserView view){
        this.view = view;
    }
    
    @Override
    public User getModel() {
        String name = view.getUsernameField().getText();
        String password = view.getNewPasswordField().getText();
        
        User modelUser = new User(0, name, password);
        
        return modelUser;    
    }

    @Override
    public void clearScreen() {
        view.getUsernameField().setText("");
        view.getNewPasswordField().setText("");
        view.getRepeatPasswordField().setText("");
    }
    
    public void showMessage(String msg){
        JOptionPane.showMessageDialog(null, msg);
    }
    
}
