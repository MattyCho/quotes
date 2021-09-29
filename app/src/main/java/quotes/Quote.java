package quotes;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
}
