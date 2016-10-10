package basket;

import items.Item;
import tax.TaxCalculator;
import tax.TaxCalculatorInterface;

import java.util.List;

/**
 * Created by jjcomi1989 on 11/10/16.
 */

public interface CheckoutInterface {
    public void processItemsInCart();
    public Receipt getReceipt();
    public void printReceipt(Receipt receipt);
}
