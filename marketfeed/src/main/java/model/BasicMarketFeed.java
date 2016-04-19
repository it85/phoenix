package model;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

import contract.MarketFeed;
import data.CandleStick;
import data.PriceQuote;
import utility.Builder;

/**
 * Created by Isaac T on 3/6/2016.
 */
public class BasicMarketFeed implements MarketFeed{

    private String symbol;
    private long refreshRate;
    private YahooQuoteGenerator quoteGen;

    public BasicMarketFeed(String symbol, long refreshRate){
        this.symbol = symbol;
        this.refreshRate = refreshRate;

        this.quoteGen = new YahooQuoteGenerator(symbol);
    }

    public CandleStick getQuote() throws IOException {

        Deque<PriceQuote> quotes = getRealTimeQuotes();
        return Builder.createCandleStick(quotes);
    }

    private Deque<PriceQuote> getRealTimeQuotes() throws IOException{

        Deque<PriceQuote> quotes = new ArrayDeque<PriceQuote>();

        long elapsedTime = 0;

        while(elapsedTime < this.refreshRate){
            long t1 = System.nanoTime();

            PriceQuote rtq = quoteGen.getQuote();
            quotes.add(rtq);
            long t2 = System.nanoTime();

            long elapsed = t2-t1;

            long elapsedSeconds = elapsed/1000000000;
            elapsedTime += elapsedSeconds;
        }

        return quotes;

    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public long getRefreshRate() {
        return refreshRate;
    }

    public void setRefreshRate(long refreshRate) {
        this.refreshRate = refreshRate;
    }
}
