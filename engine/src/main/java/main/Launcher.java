package main;

import algo.SmokeTestAlgo;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import contract.Algorithm;
import contract.MarketFeed;
import contract.Trader;
import control.PhoenixStateControl;
import data.BasicTrader;
import model.BasicMarketFeed;
import type.CandleStickPeriod;
import utility.Conversion;

/**
 * Prepares the Phoenix analytics platform for execution by setting up configuration and initializing the various modules
 * in the platform, e.g. trader, marketfeed, etc.
 */
public class Launcher {

    private static Config config = ConfigFactory.load("initialization.conf");

    private Trader trader;
    private MarketFeed marketFeed;
    private Algorithm algorithm;
    private PhoenixStateControl phoenixStateControl;

    // TODO: 4/20/2016 Implement a better way of initializing our variables possibly via some kind of framework, e.g. Guice?
    public void configure(){

        double startingBalance = Double.parseDouble(config.getString("application.trader.startingBalance"));
        trader = new BasicTrader(startingBalance);

        String symbol = config.getString("application.marketFeed.symbol");
        CandleStickPeriod candleStickPeriod = Conversion.toCandleStickPeriod(config.getString("application.marketFeed.candleStickPeriod"));
        marketFeed = new BasicMarketFeed(symbol, candleStickPeriod);

        algorithm = new SmokeTestAlgo();

    }

    public void initialize(){
        phoenixStateControl = new PhoenixStateControl(trader, marketFeed, algorithm);
    }

    public void run(){
        phoenixStateControl.run();
    }
}
