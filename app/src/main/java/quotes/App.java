/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException{
//        Quote.randomQuote("./app/src/main/resources/recentquotes.json");
        Quote.getQuoteFromAPI();
    }
}
