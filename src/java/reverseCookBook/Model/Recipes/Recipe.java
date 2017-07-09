/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reverseCookBook.Model.Recipes;

import java.util.ArrayList;
import java.util.List;
import reverseCookBook.Model.Ingredients.Ingredient;
import reverseCookBook.Model.RecipeCategories.RecipeCategory;

/**
 *
 * @author maimonlior
 */
public class Recipe {
    private String recipeName;
    private List<Ingredient> ingredientsList;
    private Directions directions;
    private RecipeCategory category;
    private int recipeID;
    static private int recipeIDCounter = 0;
    
    public Recipe(){
        this.recipeName = "Im_A_New_Recipe";
        this.ingredientsList = new ArrayList<>();
        this.directions = new Directions();
        //this.category = new RecipeCategory();
        recipeID = ++recipeIDCounter;
        
    }
    
    public void printRecipe(){
        System.out.println("The Recipe name is:" + this.recipeName);
        System.out.println("recipe id:" + this.recipeID);
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }
    
    
}
