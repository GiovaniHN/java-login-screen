package model.DAO;

import java.util.ArrayList;
import model.User;

public class Database {
  
    public static ArrayList<User> userDatabase;
    
    public static void startDatabase(){
        userDatabase = new ArrayList<>();
        
        userDatabase.add(new User(0, "default", "default"));
        userDatabase.add(new User(1, "user", "user"));
        userDatabase.add(new User(2, "123456", "123456"));
    }
    
}
