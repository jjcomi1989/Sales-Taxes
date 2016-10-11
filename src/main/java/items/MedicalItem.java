package items;

import tax.TaxPolicyInterface;

/**
 * Created by jjcomi1989 on 10/10/16.
 */

//Medical extends Item

public class MedicalItem extends Item {
    private TaxPolicyInterface taxPolicyInterface;

    public MedicalItem(String description, float price, int quantity, boolean imported){
        super(description, price, quantity, imported);
        taxPolicyInterface = new TaxPolicy();
    }

    // Tax policy for Medical
    @Override
    public float getTaxValue(){
        return taxPolicyInterface.getMedicalTax();
    }
}
