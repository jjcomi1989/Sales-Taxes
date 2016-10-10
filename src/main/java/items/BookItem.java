package items;

import tax.TaxPolicy;

/**
 * Created by jjcomi1989 on 10/10/16.
 */

public class BookItem extends Item {

    public BookItem(){
        super();
    }

    public BookItem(String description, float price, int quantity, boolean imported){
        super(description, price, quantity, imported);
    }

    @Override
    public float getTaxValue(){
        return TaxPolicy.BOOK.getItemTax();
    }
}
