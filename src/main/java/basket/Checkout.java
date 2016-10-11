package basket;

import items.Item;
import items.TaxPolicy;
import tax.TaxCalculator;
import tax.TaxCalculatorInterface;

import java.util.List;

/**
 * Created by jjcomi1989 on 10/10/16.
 */

public class Checkout implements CheckoutInterface {

    private PaymentInterface payment;
    private Receipt receipt;
    private List<Item> itemList;

    public Checkout(List<Item> itemList){
        this.itemList = itemList;
        TaxCalculatorInterface taxCalculator = new TaxCalculator(new TaxPolicy());
        payment = new Payment(taxCalculator);
    }

    public void processItemsInCart() {
        // Process all elements in cart
        for(Item item : itemList) {
            // Process calculate tax amount and taxed price for each item
            float itemTaxAmount = payment.calculateTax(item.getPrice(), item.getTaxValue(), item.isImported());
            float itemTaxedPrice = payment.calcTotalItemPrice(item.getPrice(), itemTaxAmount);
            // Store result to object
            item.setTaxedPrice(itemTaxedPrice);
        }
    }

    public Receipt getReceipt() {
        // Create receipt as an instance of receipt class, assign total sales taxes and total amount
        float salesTaxes = payment.calculateSalesTaxes(itemList);
        float totalPayment = payment.calculateTotalPayment(itemList);
        receipt = payment.createReceipt(itemList, salesTaxes, totalPayment);
        return receipt;
    }

    public void printReceipt(Receipt receipt) {
        payment.printReceipt(receipt);
    }
}
