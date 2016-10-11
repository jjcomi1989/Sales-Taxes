import items.*;
import junit.extensions.TestSetup;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.apache.log4j.Logger;
import java.util.Currency;

import org.junit.Test;
import tax.Helper;
import tax.TaxCalculator;
import tax.TaxCalculatorInterface;
import tax.TaxPolicy;

/**
 * Created by jjcomi1989 on 11/10/16.
 */

public class MainTest extends TestCase {
    private static Logger logger = Logger.getRootLogger();
    private static Currency currencyForTest;

    public static TestSetup suite() {
        TestSetup setup = new TestSetup(new TestSuite(MainTest.class)) {
            protected void setUp() throws Exception {
                logger.info("Setup configuration for this test suite");
            }
        };
        return setup;
    }

    @Test
    public void testInput1() throws Exception {
        logger.info("Testing tax policy and values");

        TaxCalculatorInterface tax = new TaxCalculator();

        Item book = new BookItem("book", 12.49f, 1, false);
        float bookPrice = tax.taxOnItem(book.getPrice(), book.getTaxValue(), book.isImported()) + 12.49f;
        assertTrue(bookPrice == 12.49f);

        Item musicCd = new OtherItem("music CD", 14.99f, 1, false);
        float musicCdPrice = tax.taxOnItem(musicCd.getPrice(), musicCd.getTaxValue(), musicCd.isImported()) + 14.99f;
        assertTrue(musicCdPrice == 16.49f);

        Item chocoBar = new FoodItem("chocolate bar", 0.85f, 1, false);
        float chocoBarPrice = tax.taxOnItem(chocoBar.getPrice(), chocoBar.getTaxValue(), chocoBar.isImported()) + 0.85f;
        assertTrue(chocoBarPrice == 0.85f);

        float totalPrice = bookPrice + musicCdPrice + chocoBarPrice;
        assertTrue(totalPrice == 29.83f);

        logger.info("Testing sales taxes and helper truncate method");
        assertTrue(Helper.truncate(totalPrice - 12.49f - 14.99f - 0.85f) == 1.50f);
    }

    @Test
    public void testInput2() throws Exception {
        logger.info("Testing tax policy comparing computed price with problem price");

        TaxCalculatorInterface tax = new TaxCalculator();

        Item chocolateBox = new FoodItem("imported box of chocolates", 10.00f, 1, true);
        float chocolateBoxPrice = tax.taxOnItem(chocolateBox.getPrice(), chocolateBox.getTaxValue(), chocolateBox.isImported()) + 10.00f;
        assertTrue(chocolateBoxPrice == 10.50f);

        Item perfume = new OtherItem("imported bottle of perfume", 47.50f, 1, true);
        float perfumePrice = tax.taxOnItem(perfume.getPrice(), perfume.getTaxValue(), perfume.isImported()) + 47.50f;
        assertTrue(perfumePrice == 54.65f);

        float totalPrice = chocolateBoxPrice + perfumePrice;
        assertTrue(totalPrice == 65.15f);
        logger.info("Testing sales taxes and helper truncate method");
        assertTrue(Helper.truncate(totalPrice - 10.00f - 47.50f) == 7.65f);
    }

    @Test
    public void testInput3() throws Exception {
        logger.info("Testing tax policy comparing computed price with problem price");

        TaxCalculatorInterface tax = new TaxCalculator();

        Item perfumeBottleImp = new OtherItem("imported bottle of perfume", 27.99f, 1, true);
        float perfumeBottleImpPrice = tax.taxOnItem(perfumeBottleImp.getPrice(), perfumeBottleImp.getTaxValue(), perfumeBottleImp.isImported()) + 27.99f;
        assertTrue(perfumeBottleImpPrice == 32.19f);

        Item perfumeBottle = new OtherItem("bottle of perfume", 18.99f, 1, false);
        float perfumeBottlePrice = tax.taxOnItem(perfumeBottle.getPrice(), perfumeBottle.getTaxValue(), perfumeBottle.isImported()) + 18.99f;
        assertTrue(perfumeBottlePrice == 20.89f);

        Item pillsPacket = new MedicalItem("packet of headache pills", 9.75f, 1, false);
        float pillsPacketPrice = tax.taxOnItem(pillsPacket.getPrice(), pillsPacket.getTaxValue(), pillsPacket.isImported()) + 9.75f;
        assertTrue(pillsPacketPrice == 9.75f);

        Item impBoxChoco = new MedicalItem("imported box of chocolates", 11.25f, 1, true);
        float impBoxChocoPrice = tax.taxOnItem(impBoxChoco.getPrice(), impBoxChoco.getTaxValue(), impBoxChoco.isImported()) + 11.25f;
        assertTrue(impBoxChocoPrice == 11.85f);

        float totalPrice = perfumeBottleImpPrice + perfumeBottlePrice + pillsPacketPrice + impBoxChocoPrice;
        assertTrue(totalPrice == 74.68f);
        logger.info("Testing sales taxes and helper truncate method");
        assertTrue(Helper.truncate(totalPrice - 27.99f- 18.99f - 9.75f - 11.25f) == 6.70f);
    }
}
