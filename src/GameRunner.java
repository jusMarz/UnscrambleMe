import java.util.Timer;
import java.util.TimerTask;
import java.util.Scanner;

public class GameRunner {
    public static void main(String[] args) throws InterruptedException {
        Scanner s = new Scanner(System.in);
//        Timer t = new Timer();


        System.out.println("Welcome to Word Jumble!");

        int i = 0;
        while (!((i == 2) || (i == 3)))
        {
            if (i == 1)
            {
                System.out.println("DAMN NERD!!!!!");
            }
        System.out.println("Would you like to 1) See the rules 2) Play a Standard Round or 3) Play a Custom Round ? (Type 1,2 or 3 )");
        i = Integer.parseInt(s.nextLine());
        }

        int wordlength;
        int timelength;

        if (i == 2)
        {
            wordlength = 6;
            timelength = 60;
        }
        else
        {

            System.out.println("Please enter in the length the Word Jumble should be! (Whole Numbers Only): ");
            wordlength = Integer.parseInt(s.nextLine());
            System.out.println("Please enter how much time you want the game to last (Whole Numbers Only): ");
            timelength = Integer.parseInt(s.nextLine());

        }

        GameLogic g = new GameLogic(wordlength,timelength);



        System.out.println("Alright! Your word jumble is " + wordlength + " letters long, and you have " + timelength + " second(s) to enter in as many words as you can find!");
       Thread.sleep(500);
        System.out.println("Get Ready..");
        Thread.sleep(1000);
        System.out.println("Set..");
        Thread.sleep(1000);
        System.out.println("GO!");
        s.close();

    }
}
