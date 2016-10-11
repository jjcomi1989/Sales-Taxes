package tax;

/**
 * Created by jjcomi1989 on 10/10/16.
 */
public class TaxCalculator implements  TaxCalculatorInterface {

    // This static var could be modified in order to change rounding rule
    private static final float ROUND = 0.05f;

    private TaxPolicyInterface policy;

    public TaxCalculator(TaxPolicyInterface policy) {
        this.policy = policy;
    }

    private float roundTax(float tax){
        return (float) Math.ceil(tax/ROUND)*ROUND;
    }

    // Tax calculator algorithm
    public float taxOnItem(float price, float localTax, boolean imported) {

        float tax = price * localTax;

        // If item is imported, apply addional sales taxes policy
        if (imported){
            tax += (price * policy.getImportedTax());
        }

        // Round result up to the nearest 0.05f
        return roundTax(tax);
    }
}
