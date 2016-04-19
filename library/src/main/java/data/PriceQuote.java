package data;

import java.sql.Timestamp;

/**
 * Created by Isaac T on 3/6/2016.
 */
public class PriceQuote {

    private final double price;
    private final double volume;
    private final Timestamp timeStamp;

    public PriceQuote(double price, double volume){
        this.price = price;
        this.volume = volume;
        this.timeStamp = new Timestamp(0);
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

    @Override
    public String toString() {
        return "PriceQuote{" +
                "price=" + price +
                ", volume=" + volume +
                ", timeStamp=" + timeStamp +
                '}';
    }
}
