import java.io.FileNotFoundException;
import java.io.IOException;

public class GameLogic {

    String userWordInputs = " ";
    int gameScore;
    int gameWordLength;
    int gameTimeLength;
    String gameWordJumble;
    DictionaryChecker d = new DictionaryChecker();
    public GameLogic (int wordLength, int timeLength) throws IOException {
        gameScore = 0;
        gameWordLength = wordLength;
        gameTimeLength = timeLength;
        gameWordJumble = " ";
    }
    public String GetInputtedWords ()
    {
        return userWordInputs;
    }
    public int GetScore()
    {
        return gameScore;
    }
    public int GetWordLength()
    {
        return gameWordLength;
    }
    public int GetTimeLength()
    {
        return gameTimeLength;
    }
    public String GetWordJumble()
    {
        return gameWordJumble;
    }
    public void IncreaseScore(int scoreUp)
    {
        gameScore += scoreUp;
    }
    public void setGameWordJumble(String jumbleSet)
    {
        gameWordJumble = jumbleSet;
    }
    public void addInputtedWord(String word)
    {
        userWordInputs += word.toUpperCase() + " ";
    }
    public int wordScore(String word)
    {   String letter;
        int wordScore = 0;
        for (int i = 0;i < word.length();i++)
        {
            letter = (word.substring(i,i+1)).toUpperCase();
            if ("EAIONRTLSU".contains(letter))
            {
                wordScore += 1;
            }
            else if ("DG".contains(letter))
            {
                wordScore += 2;
            }
            else if ("DCMP".contains(letter))
            {
                wordScore += 3;
            }
            else if ("FHVWY".contains(letter))
            {
                wordScore += 4;
            }
            else if ("K".equals(letter))
            {
                wordScore += 5;
            }
            else if ("JX".contains(letter))
            {
                wordScore += 8;
            }
            else if ("QZ".contains(letter))
            {
                wordScore += 10;
            }
            else
                wordScore -= 1;
        }
        return wordScore;
    }

    public boolean PossibleWord(String thisWord, String inThisWordQuestionMark) throws IOException {
        boolean untilFalse;
        untilFalse = d.isAWord(thisWord);
        String letters = inThisWordQuestionMark;
        for (int i = 0; (i < thisWord.length()) && (untilFalse);i ++)
        {
            untilFalse = (letters.toUpperCase().contains(thisWord.substring(i,i+1).toUpperCase()));
            if (untilFalse)
            {
            letters = letters.toUpperCase().substring(0, letters.toUpperCase().indexOf(thisWord.substring(i,i+1).toUpperCase())) + letters.toUpperCase().substring(letters.toUpperCase().indexOf(thisWord.substring(i,i+1).toUpperCase())+1);
            }

        }
        untilFalse = (untilFalse && !(GetInputtedWords().contains(" "+thisWord.toUpperCase()+" ")));
        return untilFalse;
    }
    public void giveReasoning(String word) throws IOException {
        if (!(d.isAWord(word)))
        {
            System.out.print("Not a word! ");
        }
        else if(GetInputtedWords().contains(" "+word.toUpperCase()))
        {
            System.out.print("Repeat Word! ");
        }
        else
        {
            System.out.print("Not a possible word!");
        }
    }
    public String wordJumble (int length)
    {
        int whereAreYou;
        String wordString = "EEEEEEEEEEEEAAAAAAAAAIIIIIIIIIOOOOOOOONNNNNNRRRRRRTTTTTTLLLLSSSSUUUUDDDDGGGBBCCMMPPFFHHVVWWYYKJXQZ";
        String imInTheSoupStore = "";
        for (int i = 0; i <= length;i ++)
            {
                whereAreYou = (int) (Math.random() * (wordString.length()));
                imInTheSoupStore += wordString.charAt(whereAreYou);
                wordString = wordString.substring(0,whereAreYou) + wordString.substring(whereAreYou+1);
            }
        return imInTheSoupStore;
    }

   /* public void playGame (int length, int timer)
    {

         Scanner S = new Scanner(System.in);
        Timer T = new Timer();
       System.out.println("Welcome to Word Jumble! Would you like to 1) See the rules 2) Play a Standard Round or 3) Play a Custom Round ? (Type 1,2 or 3)");
       System.out.println("Alright! Your word jumble is " + length + " letters long, and you have " + timer + "seconds to enter in as many words as you can find!"); begone

       TimerTask g = new TimerTask()
        {
            int rimer = timer;
            String userInput;
            @Override
            public void run()
            {
                if (System.currentTimeMillis() - rimer >=
                        0)
                    return;  // Too late; skip this execution.
             userInput = S.nextLine();
             score += wordScore(userInput);
             // System.out.println("+" + wordScore(userInput) + " points!"); nuh uh
            }
        };

       // System.out.println("Your word jumble is: " + wordJumble(length) + "! ENTER NOW NOW NOW NOW NOW!!!!!!!!!!!!!"); no print statements lil bro

       T.schedule(g,timer,timer);
        // System.out.println("YOUR DONE LIL BRO!!!!!!! Your score is!!!! " + score); nope
    }
*/

}
