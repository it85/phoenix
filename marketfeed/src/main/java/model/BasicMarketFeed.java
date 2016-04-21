package model;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

import contract.MarketFeed;
import data.CandleStick;
import data.PriceQuote;
import type.CandleStickPeriod;
import utility.Builder;

/**
 * Created by Isaac T on 3/6/2016.
 */
public class BasicMarketFeed implements MarketFeed{

    private String symbol;
    private final long candleStickPeriod;
    private YahooQuoteGenerator quoteGen;

    private static final long ONE_MIN = 60;
    private static final long TWO_MIN = 120;
    private static final long THREE_MIN = 180;
    private static final long FIVE_MIN = 300;
    private static final long TEN_MIN = 600;
    private static final long FIFTEEN_MIN = 900;
    private static final long THIRTY_MIN = 1800;
    private static final long ONE_HR = 3600;
    private static final long TWO_HR = 7200;

    public BasicMarketFeed(String symbol, CandleStickPeriod period){
        this.symbol = symbol;
        this.candleStickPeriod = getRefreshRate(period);

        this.quoteGen = new YahooQuoteGenerator(symbol);
    }

    public CandleStick getQuote() throws IOException {

        Deque<PriceQuote> quotes = getRealTimeQuotes();
        return Builder.createCandleStick(quotes);
    }

    private Deque<PriceQuote> getRealTimeQuotes() throws IOException{

        Deque<PriceQuote> quotes = new ArrayDeque<PriceQuote>();

        long elapsedTime = 0;

        while(elapsedTime < this.candleStickPeriod){
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

    public long getCandleStickPeriod() {
        return candleStickPeriod;
    }

    private long getRefreshRate(CandleStickPeriod period){
        switch(period){
            case ONE_MIN:       return ONE_MIN;
            case TWO_MIN:       return TWO_MIN;
            case THREE_MIN:     return THREE_MIN;
            case FIVE_MIN:      return FIVE_MIN;
            case TEN_MIN:       return TEN_MIN;
            case FIFTEEN_MIN:   return FIFTEEN_MIN;
            case THIRTY_MIN:    return THIRTY_MIN;
            case ONE_HR:        return ONE_HR;
            case TWO_HR:        return TWO_HR;
            default:            throw new IllegalArgumentException("Unknown candlestick period specified");
        }
    }
}
