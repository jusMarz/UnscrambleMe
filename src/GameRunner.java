import java.util.Scanner;

public class GameRunner {
    public static void main(String[] args) throws InterruptedException {
        Scanner s = new Scanner(System.in);


        System.out.println("Welcome to Word Jumble!");

        int i = 0;
        while (!((i == 2) || (i == 3)))
        {
            if (i == 1)
            {
                System.out.println(
                        "The rules are simple!"
                        + "\n First, you are given a random assortment of letters, and you have to make as many words as you can by using the letters given."
                        + "\nYou can repeat the same letter however many times you want!"
                        + "\nThe less common each letter is, the more points you can score with each word!"
                        + "\nYou are also on a time limit, so make as many words as you can in the allotted time!"
                );
            }
        System.out.println("Would you like to 1) See the rules 2) Play a Standard Round or 3) Play a Custom Round ? (Type 1,2 or 3 )");
        i = Integer.parseInt(s.nextLine());
        }

        int wordLength;
        int timeLength;

        if (i == 2)
        {
            wordLength = 6;
            timeLength = 60000; // one minute
        }
        else
        {

            System.out.println("Please enter in the length the Word Jumble should be! (Whole Numbers Only): ");
            wordLength = Integer.parseInt(s.nextLine());
            System.out.println("Please enter how many seconds you want the game to last (Whole Numbers Only): ");
            timeLength = Integer.parseInt(s.nextLine()) * 1000;

        }

        GameLogic g = new GameLogic(wordLength, timeLength);
        g.setGameWordJumble(g.wordJumble(g.gameWordLength));
        String userInput;


        System.out.println("Alright! Your word jumble is: " + g.GetWordJumble() + "\nYou have " + g.gameTimeLength/1000 + " second(s) to enter in as many words as you can find! So..");
        Thread.sleep(500);
        System.out.println("Get Ready..");
        Thread.sleep(1000);
        System.out.println("Set..");
        Thread.sleep(2000);
        System.out.println("GO!");
        for (long i2 = System.currentTimeMillis() + g.GetTimeLength(); i2 > System.currentTimeMillis();)
        {

            userInput = s.nextLine();

            if (!(g.GetTimeLength() > System.currentTimeMillis() - i2))
             break;

            if (g.PossibleWord(userInput, g.GetWordJumble()))
            {
                g.IncreaseScore(g.wordScore(userInput));
                System.out.println("+" + g.wordScore(userInput) + " points!    ");
            }
            else
            {
                System.out.println("No points!");
            }

        }
        System.out.println("Times Up!\n Your score is: " + g.GetScore() + " !!!\n Your word jumble was: " + g.GetWordJumble());

    }
}
