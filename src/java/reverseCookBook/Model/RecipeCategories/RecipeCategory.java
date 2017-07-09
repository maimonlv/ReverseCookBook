/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reverseCookBook.Model.RecipeCategories;

import java.util.ArrayList;
import java.util.List;
import reverseCookBook.Model.Recipes.Recipe;

/**
 *
 * @author maimonlior
 */
public class RecipeCategory {
    private String categoryName;
    private List<Recipe> recipesInCategory;   // references to recipes in this category
    
    public RecipeCategory(){
        this.categoryName = "Im_A_New_Recipe_Category";
        this.recipesInCategory = new ArrayList<>();
        
    }
    
}
