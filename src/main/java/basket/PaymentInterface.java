package basket;

import items.Item;
import java.util.List;

/**
 * Created by jjcomi1989 on 11/10/16.
 */
public interface PaymentInterface {
    public float calculateTax(float price, float tax, boolean imported);
    public float calcTotalItemPrice(float price, float tax);
    public float calculateSalesTaxes(List<Item> itemList);
    public float calculateTotalPayment(List<Item> itemList);
    public Receipt createReceipt(List<Item> itemList, float salesTaxes, float totalPayment);
    public void printReceipt(Receipt receipt);
}
