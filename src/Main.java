import java.io.FileNotFoundException;
import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {



        GameLogic g = new GameLogic(3,3);
        DictionaryChecker ex = new DictionaryChecker();
        Boolean hm = ex.isAWord("znnrgoi");
        System.out.println(hm);
        hm = g.PossibleWord("znnrgoi",
                "IOZNENRG");
        System.out.println(hm);
        System.out.print("No Points!");
        Thread.sleep(1000); // Just to give the user a chance to see "hello".
        String d = "";
        for (int del = 0; del <= "No Points!".length(); del++)
        {
            System.out.print("\b");
            d += " \b";
        }

        System.out.print("world");

    }
}