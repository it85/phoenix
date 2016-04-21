package main;

import com.typesafe.config.Config;
import contract.Algorithm;
import contract.MarketFeed;
import contract.Trader;
import control.PhoenixStateControl;
import data.BasicTrader;

/**
 * Prepares the Phoenix analytics platform for execution by setting up configuration and initializing the various modules
 * in the platform, e.g. trader, marketfeed, etc.
 */
public class Launcher {

    private static Config config;

    private Trader trader;
    private MarketFeed marketFeed;
    private Algorithm algorithm;

    public void configure(){

    }

    public void run(){
//        phoenixStateControl.run();
    }

    private Trader initTrader(){
        double startingBalance = Double.parseDouble(config.getString("application.trader.startingBalance"));
        return new BasicTrader(startingBalance);
    }
}
