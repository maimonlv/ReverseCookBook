/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reverseCookBook.Model.Ingredients;

import java.util.List;
import reverseCookBook.DeclaredConstants.Constants.IngredientsType;
import static reverseCookBook.DeclaredConstants.Constants.IngredientsType.VAGETABLES;

/**
 *
 * @author maimonlior
 */
public class Ingredient {
    
    private IngredientsType ingredientType;
    private String ingredientName;
    private Integer amount;
    
    public Ingredient(){
        ingredientName = "Im A New Ingredient";
    }
    
    public IngredientsType getIngredientType() {
        return ingredientType;
    }

    public void setIngredientType(IngredientsType ingredientType) {
        this.ingredientType = ingredientType;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

}
