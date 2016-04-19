package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import data.PriceQuote;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import contract.QuoteGenerator;
import utility.Builder;

/**
 * Created by Isaac T on 3/6/2016.
 */
public class YahooQuoteGenerator implements QuoteGenerator{

    String symbol;

    public YahooQuoteGenerator(String symbol){
        this.symbol = symbol.toLowerCase();
    }

    public PriceQuote getQuote() throws IOException{
        String json = getQuoteAsJson();

        String[] arr = new String[2];
        arr[0] = getLastTradePrice(json);
        arr[1] = getVolume(json);

        return Builder.createRealTimeQuote(arr);
    }

    private String getLastTradePrice(String json){

        String[] array1 = json.split("quote\":");
        String[] array = array1[1].split(",");

        for(String val : array){

            if(val.contains("LastTradePriceOnly\":")){
                String[] priceArray = val.split("\"");
                return priceArray[3];
            }
        }

        return "";
    }

    private String getVolume(String json){

        String[] array1 = json.split("quote\":");
        String[] array = array1[1].split(",");

        for(String val : array){

            if(val.contains("Volume\":")){
                String[] priceArray = val.split("\"");
                return priceArray[3];
            }
        }

        return "";
    }

    private String getQuoteAsJson() throws IOException{

        HttpClient httpClient = HttpClientBuilder.create().build();

        String url = this.getQueryString();

        HttpGet getRequest = new HttpGet(url);

        getRequest.addHeader("accept", "application/xml");

        HttpResponse response = httpClient.execute(getRequest);

        if (response.getStatusLine().getStatusCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
        }


        String finalString = "";

        BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
        String output;

        while ((output = br.readLine()) != null) {
            finalString = finalString + output;
        }

        return finalString;
    }

    private String getQueryString(){

        Config config = ConfigFactory.load("queryurls.conf");

        String configKey = "query.url." + this.symbol;
        return config.getString(configKey);
    }
}
