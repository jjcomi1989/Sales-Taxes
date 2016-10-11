package basket;

import items.Item;
import java.util.List;
import java.util.Locale;

/**
 * Created by jjcomi1989 on 09/10/16.
 */

public class Receipt implements ReceiptInterface {
    private List<Item> itemList;
    private float totalSalesTax;
    private float totalAmount;

    Receipt(List<Item> itemList, float tax, float amount) {
        this.itemList = itemList;
        totalSalesTax = tax;
        totalAmount = amount;
    }

    public float getTotalSalesTax() {
        return totalSalesTax;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    // Print output as requested by the problem
    @Override
    public String toString() {
        String receipt = "";

        for(Item item: itemList)
        {
            receipt += item.getQuantity() + " " + item.getDescription() + ": " + String.format(Locale.US,"%.02f", item.getTaxedPrice()) + "\n";
        }

        receipt += "Total sales tax: " + String.format(Locale.US,"%.02f", getTotalSalesTax()) + "\n";
        receipt += "Total amount: " + String.format(Locale.US,"%.02f", getTotalAmount()) + "\n";

        return receipt;
    }

}
