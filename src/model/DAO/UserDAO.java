package model.DAO;

import model.User;


public class UserDAO {
    
    private boolean userAndPasswordMatch(User user1, User user2){
        return user1.getUserName().equals(user2.getUserName()) 
                && user1.getPassword().equals(user2.getPassword());
    }
    
    public User selectByNameAndPassword(User user){
        for(User userList : Database.userDatabase){
            if(userAndPasswordMatch(userList, user)){
                return userList;
            }
        }
        return null;
    }
}
