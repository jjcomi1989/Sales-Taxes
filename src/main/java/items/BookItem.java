package items;

import tax.TaxPolicyInterface;

/**
 * Created by jjcomi1989 on 10/10/16.
 */

// Book extends item

public class BookItem extends Item {
    private TaxPolicyInterface taxPolicyInterface;

    public BookItem(String description, float price, int quantity, boolean imported){
        super(description, price, quantity, imported);
        taxPolicyInterface = new TaxPolicy();
    }

    // Tax policy for Book
    @Override
    public float getTaxValue(){
        return taxPolicyInterface.getBookTax();
    }
}
