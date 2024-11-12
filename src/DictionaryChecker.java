import java.io.File;

public class DictionaryChecker {
    File a = new File("C:\\Users\\BT_2S14_13\\IdeaProjects\\UnscrambleMe\\src\\wordlist");
    public DictionaryChecker() {} // here to
    public boolean isAWord (String word)
    {
        if (a.toString().contains(word))
            return true;
        else
            return false;
//        FileWriter tempFile = new FileWriter("EveryWordInDictionaryIDK");
//        tempFile.write();
//
//        if (tempFile.toString().contains(Word) )
//        return true;
//        else
//            return false;



        //placeholder value - implement word checker later
    }
    public void jesusTakeTheKeyboard ()
    {
        System.out.println(a.toString());
    }


}
