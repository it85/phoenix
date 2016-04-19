package contract;

import type.Recommendation;

/**
 * Defines the basic behavior(s) of an algorithm
 */
public interface Algorithm {

    public Recommendation run(double price);

}
