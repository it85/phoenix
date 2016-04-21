package contract;

import data.CandleStick;
import type.Recommendation;

/**
 * Defines the basic behavior(s) of an algorithm
 */
public interface Algorithm {

    public Recommendation run(CandleStick candleStick);

}
