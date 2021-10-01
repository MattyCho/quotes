package quotes;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import com.google.gson.Gson;

public class Quote {
    ArrayList<Quote> quotes;
    ArrayList<String> tags = new ArrayList<>();
    String author;
    String likes;
    String text;

    public Quote(ArrayList<String> tags, String author, String likes, String text) {
        this.tags = tags;
        this.author = author;
        this.likes = likes;
        this.text = text;
    }

    public static String randomQuote(String path) throws IOException {
        File file = new File(path);
        // Read file
        FileReader quotesFileReader = new FileReader(file);

        Gson gson = new Gson();

        // Creates array of quotes
        Quote[] quote = gson.fromJson(quotesFileReader, Quote[].class);
        int x = (int) (Math.random()* quote.length);
        String someQuote = quote[x].author + "\n";
        someQuote += quote[x].text;
        System.out.println(someQuote);
        return someQuote;
    }

    public static String getQuoteFromAPI() throws IOException {
        URL swansonUrl = new URL("https://ron-swanson-quotes.herokuapp.com/v2/quotes");
        HttpURLConnection swansonUrlConnection = (HttpURLConnection) swansonUrl.openConnection();
        swansonUrlConnection.setRequestMethod("GET");
        InputStreamReader swansonInputStreamReader = new InputStreamReader(swansonUrlConnection.getInputStream());
        BufferedReader swansonBufferedReader = new BufferedReader(swansonInputStreamReader);
        String swansonData = swansonBufferedReader.readLine();
        System.out.println(swansonData);
        return swansonData;
    }
}
