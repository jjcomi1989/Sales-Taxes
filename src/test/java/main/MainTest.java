package main;

import junit.extensions.TestSetup;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.apache.log4j.Logger;
import java.util.Currency;
import java.util.Locale;

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
                currencyForTest = Currency.getInstance(Locale.US);
            }
        };
        return setup;
    }
}
