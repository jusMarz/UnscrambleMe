import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DictionaryChecker {
    boolean wordValidity;

    public DictionaryChecker() throws IOException
    {
        wordValidity = false;
    }

    public boolean isAWord(String thisWord) throws IOException
    {
        wordValidity = false;
        BufferedReader b = new BufferedReader(new FileReader("C:/Users/BT_2S14_13/IdeaProjects/UnscrambleMe/dictionary.txt"));
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