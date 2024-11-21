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



    public boolean isAWord(String thisWord) throws IOException {
        BufferedReader b = new BufferedReader(new FileReader("C:/Users/BT_2S14_13/IdeaProjects/UnscrambleMe/dictionary.txt"));
        b.mark(1763167);
        for (String currentWord = b.readLine(); currentWord != null; currentWord = b.readLine())
        {
            if (currentWord.equals(thisWord.toUpperCase()))
            {
                isIt = true;
                {
                    break;
                }

            }

        }
        b.reset();
        return isIt;

    }
//    public String theReadingProcess(String thisWord) throws IOException
//    {
//        for (String currentWord = b.readLine(); currentWord != null; currentWord = b.readLine())
//        {
//
//            if (currentWord.equals(thisWord.toUpperCase()))
//            {
//                isIt = true;
//                break;
//            }
//
//        }
//    return thisWord;
//        }
}