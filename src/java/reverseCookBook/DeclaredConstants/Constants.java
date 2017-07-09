/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reverseCookBook.DeclaredConstants;

/**
 *
 * @author maimonlior
 */
public class Constants {
    
    private Constants(){
        // we want to prevente creating instances :)
    }
    
    //Examples:
//    public static final int MAXNUMPLAYERS = 6;
//    public static final String GOODLUCK = "GoodLuck";
//    public static final String[] PLAYERSIMAGESNAMES = {"shoe", "horse", "car", "hat", "ship", "thimble"};
//    
    
    public static final String[] INGREDIANTS = {"VAGETABLES", "FROOTS", "BREDS", "DRINKS", "MEET", "FISHES"};
    
    public enum IngrediantsType {
        VAGETABLES, FROOTS, BREDS, DRINKS, MEET, FISHES
    };
    
    
}