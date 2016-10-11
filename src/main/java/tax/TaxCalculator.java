package tax;

/**
 * Created by jjcomi1989 on 10/10/16.
 */
public class TaxCalculator implements  TaxCalculatorInterface {

    // This static var could be modified in order to change rounding rule
    private static final float ROUND = 0.05f;

    private float roundTax(float tax){
        return (float) Math.ceil(tax/ROUND)*ROUND;
    }

    // Tax calculator algorithm
    public float taxOnItem(float price, float localTax, boolean imported) {

        float tax = price * localTax;

        // If item is imported, apply addional sales taxes policy
        if (imported){
            tax += (price * TaxPolicy.IMPORTED.getItemTax());
        }

        // Round result up to the nearest 0.05f
        return roundTax(tax);
    }
}
