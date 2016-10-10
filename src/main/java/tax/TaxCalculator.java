package tax;

/**
 * Created by jjcomi1989 on 10/10/16.
 */
public class TaxCalculator implements  TaxCalculatorInterface {

    private static final float ROUND = 0.05f;

    private float roundTax(float tax){
        return (float) Math.ceil(tax/ROUND)*ROUND;
    }

    public float taxOnItem(float price, float localTax, boolean imported) {

        float tax = price * localTax;

        if (imported){
            tax += (price * TaxPolicy.IMPORTED.getItemTax());
        }

        return roundTax(tax);
    }
}
