package model.DAO;

import model.User;


public class UserDAO {
    
    
    public void insert(User user){
        Database.userDatabase.add(user);
    }
    
    public boolean update(User user){
        
        for (int i = 0; i < Database.userDatabase.size(); i++) {
            if(userAndPasswordMatch(Database.userDatabase.get(i),user)){
                Database.userDatabase.set(i, user);
                return true;
            }
        }
        return false;      

    }
    
    public boolean userAndPasswordMatch(User user1, User user2){
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
