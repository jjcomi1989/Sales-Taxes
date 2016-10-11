package items;

import tax.TaxPolicy;

/**
 * Created by jjcomi1989 on 10/10/16.
 */

//Food extends Item

public class FoodItem extends Item {

    public FoodItem(){
        super();
    }

    public FoodItem(String description, float price, int quantity, boolean imported){
        super(description, price, quantity, imported);
    }

    // Tax policy for Food
    @Override
    public float getTaxValue(){
        return TaxPolicy.FOOD.getItemTax();
    }
}
