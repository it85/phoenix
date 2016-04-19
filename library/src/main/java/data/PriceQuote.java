package data;

import java.sql.Timestamp;

/**
 * Created by Isaac T on 3/6/2016.
 */
public class PriceQuote {

    private double price;
    private double volume;
    private  Timestamp timeStamp;

    public PriceQuote(double price, double volume){
        this.price = price;
        this.volume = volume;
    }

    public PriceQuote(Timestamp timeStamp, double price, double volume){
        this.timeStamp = timeStamp;
        this.price = price;
        this.volume = volume;
    }

    public double getPrice() {
        return price;
    }

    public double getVolume() {
        return volume;
    }

    public Timestamp getTimeStamp() {
        return timeStamp;
    }
}
