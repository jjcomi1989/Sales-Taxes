package items;

import tax.TaxPolicy;

/**
 * Created by jjcomi1989 on 10/10/16.
 */
public class FoodItem extends Item {

    public FoodItem(){
        super();
    }

    public FoodItem(String description, float price, int quantity, boolean imported){
        super(description, price, quantity, imported);
    }

    @Override
    public float getTaxValue(){
        return TaxPolicy.FOOD.getItemTax();
    }
}
