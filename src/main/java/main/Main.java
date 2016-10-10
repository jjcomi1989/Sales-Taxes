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
    }
}
