package items;

import tax.TaxPolicyInterface;

/**
 * Created by jjcomi1989 on 10/10/16.
 */

//Food extends Item

public class FoodItem extends Item {
    private TaxPolicyInterface taxPolicyInterface;

    public FoodItem(String description, float price, int quantity, boolean imported){
        super(description, price, quantity, imported);
        taxPolicyInterface = new TaxPolicy();
    }

    // Tax policy for Food
    @Override
    public float getTaxValue(){
        return taxPolicyInterface.getFoodTax();
    }
}
