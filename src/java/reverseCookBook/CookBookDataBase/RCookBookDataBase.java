/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reverseCookBook.CookBookDataBase;

import com.mongodb.MongoClient;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import reverseCookBook.Model.Users.User;

/**
 *
 * @author maimonlior
 */
public class RCookBookDataBase {
//    public List<Recipe> recipesList;
    public List<User> usersList;
    private Connection con;
    private Statement stmnt;
    MongoClient mongoClient = new MongoClient( "localhost", 27017);
    
    public RCookBookDataBase() {
//        recipesList = new ArrayList<>();
        usersList = new ArrayList<>();
//        
    }
    
//    public void printRecipesList(){
//        // Print the recipe from the list....
//        for(Recipe recipe : recipesList) {
//            recipe.printRecipe();
//        }
//    }
    
    public void printUsersList(){
        // Print the recipe from the list....
        usersList.stream().forEach((user) -> {
            user.printUser();
        });
    }
    
    public void connectToDataBase() throws SQLException, ClassNotFoundException{
        
        try {
                     
            try {
                Class.forName("org.apache.derby.jdbc.ClientDriver");
//                System.out.println("Successfully forName");
            } 
            catch(java.lang.ClassNotFoundException e) {
                System.out.println( e.getMessage( ) );
            }
            
            String host = "jdbc:derby://localhost:1527/Users";
            String uName = "mlv";
            String uPass= "020286";
            
            this.con = DriverManager.getConnection(host, uName, uPass);
            System.out.println("Successfully Connected");            
        }
        catch ( SQLException err ) {
            System.out.println( err.getMessage( ) );
        }
        
        
    }

    public ResultSet executeQueryFromDataBase(String SQL) throws SQLException {
        this.stmnt = con.createStatement( );    //default ResultSet: TYPE_FORWARD_ONLY
//        SQL = "SELECT * FROM Users";
        ResultSet rs;
        rs = stmnt.executeQuery( SQL );
        return rs;
    }
    
    public void CloseConnection()
    {
        try
        {
            this.con.close();
            System.out.println("Connection successfully closed");
        }
        catch (SQLException e)
        {
            System.out.println(e.toString());
        }
    }

    public Connection getCon() {
        return con;
    }

    public Statement getStmnt() {
        return stmnt;
    }
    
}
