package basket;

import items.Item;
import tax.Helper;
import tax.TaxCalculatorInterface;
import java.util.List;

/**
 * Created by jjcomi1989 on 09/10/16.
 */

public class Payment implements PaymentInterface {

    TaxCalculatorInterface taxCalculator;

    public Payment(TaxCalculatorInterface taxCalculator) {
        this.taxCalculator = taxCalculator;
    }

    // Calculate tax for a given item
    public float calculateTax(float price, float tax, boolean imported) {
        float itemTax = taxCalculator.taxOnItem(price, tax, imported);
        return Helper.truncate(itemTax);
    }

    // Calculate taxed price for a given item
    public float calcTotalItemPrice(float price, float tax) {
        return price + tax;
    }

    // Calculate total sales taxes
    public float calculateSalesTaxes(List<Item> itemList) {
        float totalTax = 0.0f;
        for(Item item : itemList) {
            totalTax += (item.getTaxedPrice() - item.getPrice());
        }
        return Helper.truncate(totalTax);
    }

    // Calculate total amount of payment
    public float calculateTotalPayment(List<Item> itemList) {
        float totalAmount = 0.0f;
        for(Item item : itemList) {
            totalAmount += item.getTaxedPrice();
        }
        return Helper.truncate(totalAmount);
    }

    // This method will create a receipt, It will be called from Checkout
    public Receipt createReceipt(List<Item> itemList, float salesTaxes, float totalPayment) {
        return new Receipt(itemList, salesTaxes, totalPayment);
    }

    public void printReceipt(Receipt receipt) {
        System.out.println(receipt.toString());
    }
}
