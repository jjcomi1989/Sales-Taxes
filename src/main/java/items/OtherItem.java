package items;

import tax.TaxPolicyInterface;

/**
 * Created by jjcomi1989 on 10/10/16.
 */

// Other extends Item

public class OtherItem extends Item {
    private TaxPolicyInterface taxPolicyInterface;

    public OtherItem(String description, float price, int quantity, boolean imported){
        super(description, price, quantity, imported);
        taxPolicyInterface = new TaxPolicy();
    }

    // Tax policy for Other -> all products not in Food, Book and Medical
    @Override
    public float getTaxValue(){
        return taxPolicyInterface.getOtherTax();
    }
}
