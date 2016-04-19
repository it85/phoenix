package contract;

import java.io.IOException;

import data.CandleStick;

/**
 * Created by Isaac T on 3/6/2016.
 */
public interface MarketFeed {

    CandleStick getQuote() throws IOException;

}
