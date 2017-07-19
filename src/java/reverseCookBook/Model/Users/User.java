/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reverseCookBook.Model.Users;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author maimonlior
 */
public class User {
    private String firstName;
    private String familyName;
    private String userName;
    private String password;
    private String address;
    private String birthDate;
    private String email;
    private int age;
    private boolean isValid;

    private final int userID;
        
    static private int userIDCounter = 0;
    
    public User(){
        firstName = "plony";
        familyName = "almony";
        userName = "plony";
        password = "";        
        isValid = true;
        userID = ++userIDCounter;
    }

    public User(String fname, String lname, String addr, String bDate, String userName, String pass, String email) {
        this.firstName = fname;
        this.familyName = lname;
        this.address = addr;
        this.birthDate = bDate;
        this.userName = userName;
        this.password = pass;
        this.email = email;
        this.age = calcAgeByBirthDate(this.birthDate);
        isValid = true;
        userID = ++userIDCounter;
        printUser();
    }
        
    public void printUser() {
        System.out.println("user name:" + this.firstName + " " + this.familyName);
        System.out.println("user id:" + this.userID);
    }

    public boolean isIsValid() {
        return isValid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIsValid(boolean isValid) {
        this.isValid = isValid;
    }    
    
    public static int getUserIDCounter() {
        return userIDCounter;
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
    
    public void setUserName(String userName){
        this.userName = userName;
    }

    public int getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private int calcAgeByBirthDate(String birthDate) {
//        System.out.println("calcAgeByBirthDate:"+birthDate);
        int age = 0;
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");

        LocalDate date = LocalDate.parse(birthDate, formatter);
        
        int bYear = date.getYear();
        
        LocalDate today = LocalDate.now();
        int nowYear = today.getYear();

        age = nowYear - bYear;
        
        return age;
    }
    
}
