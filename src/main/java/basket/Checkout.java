package basket;

import items.Item;
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
        TaxCalculatorInterface taxCalculator = new TaxCalculator();
        payment = new Payment(taxCalculator);
    }

    public void processItemsInCart() {
        for(Item item : itemList) {
            float itemTaxAmount = payment.calculateTax(item.getPrice(), item.getTaxValue(), item.isImported());
            float itemTaxedPrice = payment.calcTotalItemPrice(item.getPrice(), itemTaxAmount);
            item.setTaxedPrice(itemTaxedPrice);
        }
    }

    public Receipt getReceipt() {
        float salesTaxes = payment.calculateSalesTaxes(itemList);
        float totalPayment = payment.calculateTotalPayment(itemList);
        receipt = payment.createReceipt(itemList, salesTaxes, totalPayment);
        return receipt;
    }

    public void printReceipt(Receipt receipt) {
        payment.printReceipt(receipt);
    }
}
