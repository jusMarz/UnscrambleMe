import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 * The DictionaryChecker represents a dictionary reader. A dictionary reader can read the dictionary and search for words.
 * Should've called this a WordSearcher
 */

public class DictionaryChecker {
    boolean wordValidity;

    /**
     * Constructor for the DictionaryChecker class. This creates a new instance of a Person given
     * no parameters, because anyone* can check a dictionary.
     */
    public DictionaryChecker() throws IOException
    {
        wordValidity = false;
    }

    /**
     * The isAWord method will determine the presence of a word in the dictionary.txt, given a word
     * @param thisWord a String representing a potential word
     */

    public boolean isAWord(String thisWord) throws IOException
    {
        wordValidity = false;
        BufferedReader b = new BufferedReader(new FileReader("src/dictionary.txt"));
        b.mark(1763167);
        for (String currentWord = b.readLine(); currentWord != null; currentWord = b.readLine())
        {
            if (currentWord.equals(thisWord.toUpperCase()))
            {
                wordValidity = true;
                {
                    break;
                }

            }

        }
        b.reset();
        return wordValidity;
    }
}
