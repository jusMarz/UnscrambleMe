import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DictionaryChecker {
    boolean isIt;
    public DictionaryChecker() throws IOException
    {
        isIt = false;
    }
//    public String toString() {
//        return (""+isIt);
//    }
    BufferedReader b = new BufferedReader(new FileReader("C:/Users/BT_2S14_13/IdeaProjects/UnscrambleMe/dictionary.txt"));

    public boolean isAWord(String thisWord) throws IOException {
        String debug = "I NEVER GOT SET!?!?";
        for (String currentWord = b.readLine(); currentWord != null; currentWord = b.readLine())
        {
            debug = currentWord;
            if (currentWord.equals(thisWord.toUpperCase()))
            {
                isIt = true;
                {
                    debug = currentWord;
                    break;
                }

            }

        }
        System.out.println("Current Word: " + debug + ", the word: " + thisWord);
        return isIt;
    }
    public String theReadingProcess(String thisWord) throws IOException
    {
        for (String currentWord = b.readLine(); currentWord != null; currentWord = b.readLine())
        {

            if (currentWord.equals(thisWord.toUpperCase()))
            {
                isIt = true;
                break;
            }

        }
    return thisWord;
        }
}