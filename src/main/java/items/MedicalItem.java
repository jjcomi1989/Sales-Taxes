package items;

import tax.TaxPolicy;

/**
 * Created by jjcomi1989 on 10/10/16.
 */

//Medical extends Item

public class MedicalItem extends Item {

    public MedicalItem(){
        super();
    }

    public MedicalItem(String description, float price, int quantity, boolean imported){
        super(description, price, quantity, imported);
    }

    // Tax policy for Medical
    @Override
    public float getTaxValue(){
        return TaxPolicy.MEDICAL.getItemTax();
    }
}
