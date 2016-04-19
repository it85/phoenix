package algo;

import contract.Algorithm;
import type.Recommendation;

/**
 * A simple algorithm smoke test to prove usability
 */
public class SmokeTestAlgo implements Algorithm {

    public Recommendation run(double price){
        return price > 100 ? Recommendation.BUY : Recommendation.SELL;
    }
}
