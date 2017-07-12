/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reverseCookBook.CookBookDataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import reverseCookBook.Model.Recipes.Recipe;
import reverseCookBook.Model.Users.User;
import static reverseCookBook.DeclaredConstants.Constants.*;

/**
 *
 * @author maimonlior
 */
public class RCookBookDataBaseConnector {
//    public List<Recipe> recipesList;
    public List<User> usersList;
    private Connection con;
    private Statement stmnt;
    private PreparedStatement ps;

    public PreparedStatement getPs() {
        return ps;
    }
            
    public RCookBookDataBaseConnector() {
//        recipesList = new ArrayList<>();
        con = null;
        stmnt = null;
        ps = null;
        usersList = new ArrayList<>();
//        
    }
    
//    public void printRecipesList(){
//        // Print the recipe from the list....
//        for(Recipe recipe : recipesList) {
//            recipe.printRecipe();
//        }
//    }

    public void prepareStatement(String statement) throws SQLException{
            this.ps = con.prepareStatement(statement);
            
    }
        
    
    
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
            
            String host = USERS_LOCAL_HOST;
            String uName = USER_NAME_IN_USER_DATABASE;
            String uPass= PASSWORD_IN_USER_DATABASE;
            
            this.con = DriverManager.getConnection(host, uName, uPass);
            System.out.println("Successfully Connected To DATABASE: " + host);            
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

    public void setPreparedStmntString(int i, String value) {
        try {
            ps.setString(i, value);
        }
        catch (SQLException ex) {
            System.out.println("reverseCookBook.CookBookDataBase.RCookBookDataBaseConnector.setPreparedStmntString():");
            System.out.println(ex);
            Logger.getLogger(RCookBookDataBaseConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setPreparedStmntInt(int i, short i0) {
        try {
            ps.setShort(i, i0);
        }
        catch (SQLException ex) {
            System.out.println("reverseCookBook.CookBookDataBase.RCookBookDataBaseConnector.setPreparedStmntInt():");
            System.out.println(ex);
            Logger.getLogger(RCookBookDataBaseConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
