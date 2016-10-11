package main;

import items.*;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jjcomi1989 on 10/10/16.
 */

public class InputParser {

    // Regular expression to catch quantity, name and price from the input
    private static final String ITEM_REGEX = "(\\d+)\\s((\\w+\\s)+)at\\s(\\d+.\\d+)";

    public Item parser(String input) {
        Item item;
        Matcher fileParsed = parse(input);
        String name = fileParsed.group(2).trim();
        String quantity = fileParsed.group(1);
        boolean isImported = false;
        // If name contains imported => Item is imported
        if(name.contains("imported")){
            isImported = true;
        }

        /* Useful to assign the right category to an item. Here we should use some NLP tools such as Stemmer and POS Tagger
           to analyze input description automatically and assign its category with some kind of probability based on terms frequencies;
         */
        
        if(name.contains("book")){
            item = new BookItem(name, Float.valueOf(fileParsed.group(4)), Integer.valueOf(quantity), isImported);
        }else if(name.contains("chocolate") || name.contains("chocolates")){
            item = new FoodItem(name, Float.valueOf(fileParsed.group(4)), Integer.valueOf(quantity), isImported);
        }else if(name.contains("headache pills")){
            item = new MedicalItem(name, Float.valueOf(fileParsed.group(4)), Integer.valueOf(quantity), isImported);
        }else{
            item = new OtherItem(name, Float.valueOf(fileParsed.group(4)), Integer.valueOf(quantity), isImported);
        }
        return item;
    }

    private Matcher parse(String description) {
        Pattern pattern = Pattern.compile(ITEM_REGEX);
        Matcher matcher = pattern.matcher(description);
        matcher.find();
        return matcher;
    }
}
