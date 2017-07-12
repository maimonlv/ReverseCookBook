/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reverseCookBook;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import reverseCookBook.CookBookDataBase.RCookBookDataBaseConnector;
import reverseCookBook.Model.Recipes.Recipe;
import reverseCookBook.Model.Users.User;


/**
 *
 * @author maimonlior
 */
public class ReverseCookBook {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // TODO code application logic here
        RCookBookDataBaseConnector rCookBookDB;
        User user;
        Recipe oneRecipe;
        
        
        rCookBookDB = new RCookBookDataBaseConnector();
        rCookBookDB.connectToDataBase();
        
        for(int i = 0; i < 5; i++) {
            user = new User();
            oneRecipe = new Recipe();
            
//            rCookBookDB.recipesList.add(oneRecipe);
            rCookBookDB.usersList.add(user);
        }        
        
//      rCookBookDB.printRecipesList();
        rCookBookDB.printUsersList();
        //-----------------------------------------
        // Make Query from the database
        String SQL = "SELECT * FROM Users";
        ResultSet rs = rCookBookDB.executeQueryFromDataBase(SQL);
        while ( rs.next( ) ) {  // rs => next row
            int id_col = rs.getInt("ID");
            String first_name = rs.getString("First_Name");
            String last_name = rs.getString("Last_Name");
            String address = rs.getString("Address");
            Date birthDate = rs.getDate("Birthdate");
            System.out.println( id_col + " " + first_name + " " + last_name + " " + address + " " + birthDate);
        }
        
        //-----------------------------------------
        // Make Users DataBase Form
//        Connection con = rCookBookDB.getCon();
//        Statement stmt = rCookBookDB.getStmnt();
//        
//        UsersDatabase_Form usersForm = new UsersDatabase_Form(con, stmt, rs);
//        
//        try{
//            JFrame frame = new JFrame();
//            frame.setSize(500,450);
//            frame.setLocationRelativeTo(null);
//            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//            frame.setContentPane(usersForm);
//            frame.setVisible(true);
//        
//        }
//        catch(Exception e)
//        {
//            JOptionPane.showMessageDialog(null,"ERROR CLOSE");
//        }
//        
        //-----------------------------------------
        //rCookBookDB.CloseConnection();
    }            
}
