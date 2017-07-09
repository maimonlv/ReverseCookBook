/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reverseCookBook.Model.Ingredients;

import reverseCookBook.DeclaredConstants.Constants.IngrediantsType;
import static reverseCookBook.DeclaredConstants.Constants.IngrediantsType.VAGETABLES;

/**
 *
 * @author maimonlior
 */
public class Ingredient {
    
    private IngrediantsType ingredientType;
    private String ingredientName;
    private IngredientsAmount amount;
    
    public Ingredient(){
        ingredientType = VAGETABLES;
        ingredientName = "Im A New Ingredient";
        amount = new IngredientsAmount();
        
    }
    
    public IngrediantsType getIngredientType() {
        return ingredientType;
    }

    public void setIngredientType(IngrediantsType ingredientType) {
        this.ingredientType = ingredientType;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public IngredientsAmount getAmount() {
        return amount;
    }

    public void setAmount(IngredientsAmount amount) {
        this.amount = amount;
    }
   
}
