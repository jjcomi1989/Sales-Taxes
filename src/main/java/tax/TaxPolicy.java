package tax;

/**
 * Created by jjcomi1989 on 10/10/16.
 */

public enum TaxPolicy implements TaxPolicyInterface {
    BOOK(0.0f),
    FOOD(0.0f),
    MEDICAL(0.0f),
    OTHER(0.10f),
    IMPORTED(0.05f);

    private float itemTax;

    TaxPolicy(float itemTax) {
        this.itemTax = itemTax;
    }

    public float getItemTax() {
        return itemTax;
    }
}