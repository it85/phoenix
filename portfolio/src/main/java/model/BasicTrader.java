package model;

import java.math.BigDecimal;
import java.util.Date;

import contract.Trader;
import exception.InvalidBuyOrderException;
import exception.InvalidSellOrderException;

/**
 * A Trader instance which encapsulates a set of core behaviors necessary to manipulate a Portfolio, e.g buy and sell securities.
 * In addition, a Trader abstracts out from a Portfolio control behaviors unrelated to core Portfolio functionality, i.e. trailing-stop awareness, Regulation-T
 * @author Isaac T
 *
 */
public class BasicTrader implements Trader {

    private Portfolio portfolio;

    public BasicTrader(double startingBalance){
        this.portfolio = new Portfolio(startingBalance);
    }

    public void buy(String cusip, int shares, double price, Date date) throws InvalidBuyOrderException {
        this.portfolio.buy(cusip, shares, new BigDecimal(price), date);
    }

    public void sell(String cusip, int shares, double price, Date date) throws InvalidSellOrderException {
        this.portfolio.sell(cusip, shares, new BigDecimal(price), date);
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }
}
