package control;

import contract.Algorithm;
import contract.MarketFeed;
import contract.Trader;

/**
 * Maintains and manages the actual state of the Phoenix analytics platform. PhoenixStateControl initializes the various
 * threads necessary and so forth.
 */
public class PhoenixStateControl {

    private final Trader trader;
    private final MarketFeed marketFeed;
    private final Algorithm algorithm;

    public PhoenixStateControl(Trader trader, MarketFeed marketFeed, Algorithm algorithm){
        this.trader = trader;
        this.marketFeed = marketFeed;
        this.algorithm = algorithm;
    }

    public void run(){
        // TODO: 4/20/2016 Initialize and run all necessary threads, i.e. marketfeed & trader
    }
}
