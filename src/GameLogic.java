import java.io.IOException;
/**
 * The GameLogic class represents a game of Unscramble Me. A game consists of inputted words, a total score, a string of letters, and a time limit.
 */

public class GameLogic {

    String userWordInputs = " ";
    int gameScore;
    int gameWordLength;
    int gameTimeLength;
    String gameWordJumble;
    DictionaryChecker d = new DictionaryChecker();

    /**
     * Constructor for the GameLogic class. This creates a new instance of a game given
     * the below parameters.
     *
     * @param wordLength represents many letters will be given to the player.
     * @param timeLength represents the time limit for the player
     */

    public GameLogic (int wordLength, int timeLength) throws IOException
    {
        gameScore = 0;
        gameWordLength = wordLength;
        gameTimeLength = timeLength;
        gameWordJumble = " ";
    }
    /**
     * This method will return all the inputs the user has entered.
    */
    public String GetInputtedWords ()
    {
        return userWordInputs;
    }
    /**
     * This method will return the total amassed score the user has earned.
     */
    public int GetScore()
    {
        return gameScore;
    }
    /**
     * This method will return the number of letters the user was given to work with.
     */
    public int GetWordLength()
    {
        return gameWordLength;
    }
    /**
     * This method will return the time limit given to the user.
     */
    public int GetTimeLength()
    {
        return gameTimeLength;
    }
    /**
     * This method will return the letters given to the player.
     */
    public String GetWordJumble()
    {
        return gameWordJumble;
    }
    /**
     * This method will increase the gameScore.
     * @param scoreUp represents how much the score will increase.
     */
    public void IncreaseScore(int scoreUp)
    {
        gameScore += scoreUp;
    }
    /**
     * This method will set the letters the user will receive.
     * @param jumbleSet represents the string of letters the player gets to use.
     */
    public void setGameWordJumble(String jumbleSet)
    {
        gameWordJumble = jumbleSet;
    }
    /**
     * This method will add a word to a string of already entered words.
     * @param word represents the user's entered word.
     */
    public void addInputtedWord(String word)
    {
        userWordInputs += word.toUpperCase() + " ";
    }
    /**
     * This method will determine the score of a certain word.
     * @param word represents the word to be scored.
     */
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

    public boolean PossibleWord(String thisWord, String inThisWordQuestionMark) throws IOException
    {
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

    public void giveReasoning(String word) throws IOException
    {
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
        int letter;
        String wordString = "EEEEEEEEEEEEAAAAAAAAAIIIIIIIIIOOOOOOOONNNNNNRRRRRRTTTTTTLLLLSSSSUUUUDDDDGGGBBCCMMPPFFHHVVWWYYKJXQZ";
        String wordJumble = "";

        for (int i = 0; i <= length;i ++)
            {
                letter = (int) (Math.random() * (wordString.length()));
                wordJumble += wordString.charAt(letter);
                wordString = wordString.substring(0, letter) + wordString.substring(letter +1);
            }
        return wordJumble;
    }
}
