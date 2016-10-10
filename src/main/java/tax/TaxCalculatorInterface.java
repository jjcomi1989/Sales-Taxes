package tax;

/**
 * Created by jjcomi1989 on 10/10/16.
 */
public interface TaxCalculatorInterface {
    public float taxOnItem(float price, float localTax, boolean imported);
}
