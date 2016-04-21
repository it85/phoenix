package algo;

import contract.Algorithm;
import data.CandleStick;
import type.Recommendation;

/**
 * A simple algorithm smoke test to prove usability
 */
public class SmokeTestAlgo implements Algorithm {

    public Recommendation run(CandleStick candleStick){
        return candleStick.getOpen() > 100 ? Recommendation.BUY : Recommendation.SELL;

    }
}
