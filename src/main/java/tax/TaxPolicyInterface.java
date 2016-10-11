package tax;

/**
 * Created by jjcomi1989 on 10/10/16.
 */

public interface TaxPolicyInterface {
    public float getBookTax();
    public float getFoodTax();
    public float getMedicalTax();
    public float getOtherTax();
    public float getImportedTax();
}
