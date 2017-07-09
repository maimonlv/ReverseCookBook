/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reverseCookBook.Model.Users;

/**
 *
 * @author maimonlior
 */
public class User {
    private String firstName;
    private String familyName;
    private final int userID;
    private final String userName;
    private final String password;
    static private int userIDCounter = 0;
    
    public User(){
        firstName = "plony";
        familyName = "almony";
        userName = "plny";
        password = "";        
        userID = ++userIDCounter;
    }
    
    public void printUser() {
        System.out.println("user name:" + this.firstName + " " + this.familyName);
        System.out.println("user id:" + this.userID);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }
    
}
