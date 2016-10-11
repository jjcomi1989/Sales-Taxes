package items;

import tax.TaxPolicyInterface;

/**
 * Created by jjcomi1989 on 10/10/16.
 */

// This enum defines different kind of policies based on sales taxes problem. More could be addedd.

public class TaxPolicy implements TaxPolicyInterface {
    private static final float BOOK = 0.0f;
    private static final float FOOD = 0.0f;
    private static final float MEDICAL = 0.0f;
    private static final float OTHER = 0.10f;
    private static final float IMPORTED = 0.05f;

    @Override
    public float getBookTax() {
        return BOOK;
    }

    @Override
    public float getFoodTax() {
        return FOOD;
    }

    @Override
    public float getMedicalTax() {
        return MEDICAL;
    }

    @Override
    public float getOtherTax() {
        return OTHER;
    }

    @Override
    public float getImportedTax() {
        return IMPORTED;
    }
}
