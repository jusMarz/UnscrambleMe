import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner s = new Scanner(System.in);
        DictionaryChecker d = new DictionaryChecker();
        while (true)
        {
            String Deez = s.nextLine();
            System.out.println(Deez + " is a word: " + d.isAWord(Deez));

        }
    }
}