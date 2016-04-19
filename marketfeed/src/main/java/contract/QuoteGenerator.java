package contract;

import data.PriceQuote;

import java.io.IOException;

/**
 * Created by Isaac T on 3/6/2016.
 */
public interface QuoteGenerator {

    PriceQuote getQuote() throws IOException;

}
