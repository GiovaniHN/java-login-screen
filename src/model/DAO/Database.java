package model.DAO;

import java.util.ArrayList;
import model.User;

public class Database {
  
    public static ArrayList<User> userDatabase;
    
    public static void startDatabase(){
        userDatabase = new ArrayList<>();
        
        userDatabase.add(new User(0, "user", "user"));
    }
    
}
