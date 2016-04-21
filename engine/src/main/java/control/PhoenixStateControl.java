package control;

import algo.SmokeTestAlgo;
import contract.Algorithm;
import contract.MarketFeed;
import contract.Trader;
import data.BasicTrader;
import model.BasicMarketFeed;
import type.CandleStickPeriod;

/**
 * Maintains and manages the actual state of the Phoenix analytics platform. PhoenixStateControl initializes the various
 * threads necessary and so forth.
 */
public class PhoenixStateControl {

    private final Trader trader;
    private final MarketFeed marketFeed;
    private final Algorithm algorithm;

    private final double startingBalance = 1000;    // TODO: 4/19/2016 These configurable fields like starting balance need to exist in a 'conf' file and have Launcher set up configuration

    public PhoenixStateControl(){
        this.trader = new BasicTrader(startingBalance);
        this.marketFeed = new BasicMarketFeed("spy", CandleStickPeriod.ONE_MIN);
        this.algorithm = new SmokeTestAlgo();
    }

    public void run(){
        // TODO: 4/19/2016 initialize all our threads and startup all our modules, e.g. marketfeed, trader, and algo instances
    }





}
