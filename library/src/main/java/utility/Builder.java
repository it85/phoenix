package utility;

import java.sql.Timestamp;
import java.util.Deque;

import data.CandleStick;
import data.PriceQuote;

public class Builder {

    public static CandleStick createCandleStick(String[] arr) throws NumberFormatException, ArrayIndexOutOfBoundsException{

        Timestamp timeStamp = new Timestamp(Long.parseLong(arr[0]));
        double open = Double.parseDouble(arr[1]);
        double low = Double.parseDouble(arr[2]);
        double high = Double.parseDouble(arr[3]);
        double close = Double.parseDouble(arr[4]);
        double volume = Double.parseDouble(arr[5]);

        return new CandleStick(timeStamp, open, high, low, close, volume);
    }

    public static CandleStick createCandleStick(Deque<PriceQuote> quotes){

        Timestamp timeStamp = null;

        double open = quotes.getFirst().getPrice();
        double close = quotes.getLast().getPrice();
        double volume = quotes.getLast().getVolume() - quotes.getFirst().getVolume();

        double high = -1;
        for(PriceQuote quote : quotes){
            if(quote.getPrice() > high){
                high = quote.getPrice();
            }
        }

        double low = 99999999;
        for(PriceQuote quote : quotes){
            if(quote.getPrice() < low){
                low = quote.getPrice();
            }
        }

        return new CandleStick(timeStamp, open, high, low, close, volume);
    }

    public static PriceQuote createRealTimeQuote(String[] arr) throws NumberFormatException, ArrayIndexOutOfBoundsException{

        double price = Double.parseDouble(arr[0]);
        double volume = Double.parseDouble(arr[1]);

        return new PriceQuote(price, volume);
    }


}
