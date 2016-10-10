package main;

import basket.Checkout;
import basket.CheckoutInterface;
import basket.Receipt;
import items.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jjcomi1989 on 09/10/16.
 */

public class Main {

    public static void main(String [] args) throws IOException {

        List<Item> itemlist = new ArrayList<Item>();

        File inputFile = new File(args[0]);
        BufferedReader br = new BufferedReader(new FileReader(inputFile));
        String line;
        int index = 0;
        while ((line = br.readLine()) != null) {
            InputParser parser = new InputParser();
            Item item = parser.parser(line);
            itemlist.add(index, item);
            index++;
        }
        br.close();

        CheckoutInterface checkout = new Checkout(itemlist);
        checkout.processItemsInCart();
        Receipt receipt = checkout.getReceipt();
        checkout.printReceipt(receipt);


        /*Item item1 = new OtherItem("imported bottle of perfume", 27.99f, 1, true);
        Item item2 = new OtherItem("bottle of perfume", 18.99f, 1, false);
        Item item3 = new MedicalItem("packet of headache pills", 9.75f, 1, false);
        Item item4 = new FoodItem("box of imported chocolates", 11.25f, 1, true);

        itemlist.add(item1);
        itemlist.add(item2);
        itemlist.add(item3);
        itemlist.add(item4);*/
    }
}
