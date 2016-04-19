package api;

import data.PriceQuote;
import model.YahooQuoteGenerator;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.IOException;

public class YahooQuoteGeneratorSmokeTest {

    private static YahooQuoteGenerator quoteGen;
    private final static String SYMBOL = "SPY";

    @Before
    public void setUp() throws Exception {
        quoteGen = new YahooQuoteGenerator("SPY");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testBasicQuoteGeneration() throws IOException {
        PriceQuote pq = quoteGen.getQuote();
        assertNotNull(pq);
        assertNotEquals("", pq.toString());
        assertNotEquals(0, pq.getPrice());
    }


}
