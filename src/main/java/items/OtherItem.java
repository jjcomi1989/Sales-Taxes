package items;

import tax.TaxPolicy;

/**
 * Created by jjcomi1989 on 10/10/16.
 */

// Other extends Item

public class OtherItem extends Item {

    public OtherItem(){
        super();
    }

    public OtherItem(String description, float price, int quantity, boolean imported){
        super(description, price, quantity, imported);
    }

    // Tax policy for Other -> all products not in Food, Book and Medical
    @Override
    public float getTaxValue(){
        return TaxPolicy.OTHER.getItemTax();
    }
}
