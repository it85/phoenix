package main;

import data.PriceQuote;
import model.YahooQuoteGenerator;

/**
 * Created by Isaac T on 4/18/2016.
 */
public class Main {

    public static void main(String[] args){

        YahooQuoteGenerator quoteGen = new YahooQuoteGenerator("SPY");
        PriceQuote pq = quoteGen.getQuote();

        System.out.println(pq.toString());


    }
}
