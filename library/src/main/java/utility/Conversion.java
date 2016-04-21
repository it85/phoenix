package utility;

import type.CandleStickPeriod;

/**
 * Created by Isaac T on 4/20/2016.
 */
public class Conversion {

    public static CandleStickPeriod toCandleStickPeriod(String period){
        switch(period){
            case "ONE_MIN":     return CandleStickPeriod.ONE_MIN;
            case "TWO_MIN":     return CandleStickPeriod.TWO_MIN;
            case "THREE_MIN":   return CandleStickPeriod.THREE_MIN;
            case "FIVE_MIN":    return CandleStickPeriod.FIVE_MIN;
            case "TEN_MIN":     return CandleStickPeriod.TEN_MIN;
            case "FIFTEEN_MIN": return CandleStickPeriod.FIFTEEN_MIN;
            case "THIRTY_MIN":  return CandleStickPeriod.THIRTY_MIN;
            case "ONE_HR":      return CandleStickPeriod.FIVE_MIN;
            case "TWO_HR":      return CandleStickPeriod.TWO_HR;
            default:            throw new IllegalArgumentException("Unrecognized candlestick period");
        }
    }
}
