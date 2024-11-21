import java.io.IOException;
import java.util.Scanner;

public class GameRunner {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner s = new Scanner(System.in);


        System.out.println("Welcome to Word Jumble!");
        int i = 0;
        while (!((i == 2) || (i == 3)))
        {
            if (i == 1)
            {
                System.out.println
                        (
                        "The rules are simple!"
                        + "\n First, you are given a random assortment of letters, and you have to make as many words (without repeats) as you can by using the letters given."
                        + "\nYou can only use each letter once, so you can't spell BANANA with only BA!"
                        + "\nThe more rare each letter is, the more points you can score with each letter!"
                        + "\nYou are also on a time limit, so make as many words as you can in the allotted time!"
                        );
                Thread.sleep(1000);
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


        GameLogic gameLogic = new GameLogic(wordLength, timeLength);
        gameLogic.setGameWordJumble(gameLogic.wordJumble(gameLogic.gameWordLength));
        String userInput;



        System.out.println("\nAlright! Your word jumble is: " + gameLogic.GetWordJumble() );
        Thread.sleep(2000);
        System.out.println("\nYou have " + gameLogic.gameTimeLength/1000 + " second(s) to enter in as many words as you can find when I say go! Enter 0 to give up~");
        Thread.sleep(1500);
        System.out.print("Get Ready..");
        Thread.sleep(1000);
        System.out.print("Set..");
        Thread.sleep(1000);
        System.out.println("GO!");
        for (long i2 = System.currentTimeMillis() + gameLogic.GetTimeLength(); i2 > System.currentTimeMillis();)
        {

            userInput = s.nextLine();
            if (!(gameLogic.GetTimeLength() > System.currentTimeMillis() - i2) || (userInput.equals("0")))
             break;

            if (gameLogic.PossibleWord(userInput, gameLogic.GetWordJumble()))
            {
                gameLogic.IncreaseScore(gameLogic.wordScore(userInput));
                System.out.println("+" + gameLogic.wordScore(userInput) + " points!");
                gameLogic.addInputtedWord(userInput);

            }
            else
            {
                gameLogic.giveReasoning(userInput);
                System.out.println("No points!");
            }
        }
        System.out.println("ITS OVER!\n Your score is: " + gameLogic.GetScore() + " !!!\n Your word jumble was: " + gameLogic.GetWordJumble());

    }
}
