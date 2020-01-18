/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;

import com.google.gson.Gson;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Array;
import java.util.Scanner;

import static org.junit.Assert.*;

public class AppTest {

    // test file read
    @Test
    public void readingFileTest() {
        String firstLine = App.readingFile("src/test/resources/test.json");
        String expected = "[  {    \"author\": \"Marilyn Monroe\",    \"likes\": \"18651 likes\",  },  {    \"author\": \"Charles Dickens\",    \"likes\": \"497 likes\",  }]";
        assertEquals(expected, firstLine);

    }

    //tests if file is empty what is happening
    @Test
    public void noFileTest() {
        String firstLine = App.readingFile("");
        String expected = "File is not found";
        assertEquals(expected, firstLine);
    }

    //test if the app randomly return the quote
    @Test
    public void randomQuoteTest() {
        String firstLine = App.readingFile("src/main/resources/quotes.json");
        String randomQuote = App.showRandomQuote(firstLine);
        System.out.println(randomQuote);

        assertNotNull(randomQuote);
    }

    @Test
    public void addQuoteToJsonTest() throws FileNotFoundException {
        QuoteWeb quote = new QuoteWeb(1, "Johnny Johnny yes papa");
        String path = "src/test/resources/newQuotesTest.json";
        App.addQuoteToJason(quote, path);

        Scanner scanner = new Scanner(new File(path));
        boolean expected = true;
        while (scanner.hasNextLine()) {
            if(scanner.nextLine().contains(quote.starWarsQuote)) {
                expected = true;
                break;
            } else {
                expected = false;
            }
        }
        assertTrue(expected);
    }
}
