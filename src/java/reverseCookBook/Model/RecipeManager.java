/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reverseCookBook.Model;

import java.util.List;
import java.util.ListIterator;
import reverseCookBook.Model.Ingredients.Ingredient;
import reverseCookBook.Model.Recipes.Recipe;

/**
 *
 * @author maimonlior
 */
public class RecipeManager {
    private List<Recipe> recipesList;
    
    
    
    public List<Recipe> searchRecipeByIngredientsList(List<Ingredient> ingrLst){
        boolean currRecipeAdded = false;
        Recipe currRecipe = null;
        List<Recipe> resRecipeLst = null;
        ListIterator<Recipe> recipesListItr = null;
        ListIterator<Ingredient> ingredientsItr = null;
        //Obtaining list iterator
        recipesListItr = this.recipesList.listIterator();
        
        //System.out.println("Traversing the list in forward direction:");
        while(recipesListItr.hasNext()){
            currRecipe = recipesListItr.next();
            ingredientsItr = ingrLst.listIterator();
            while (ingredientsItr.hasNext() && (!currRecipeAdded)){
                if (currRecipe.isContainIngredient(ingredientsItr.next())){
                    resRecipeLst.add(currRecipe);
                    currRecipeAdded = true;
                }
            }
            currRecipeAdded = false;
//            System.out.println(recipesListItr.next());
        }
        
        return resRecipeLst;
    }
    
    
}
