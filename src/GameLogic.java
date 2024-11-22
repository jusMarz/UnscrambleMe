import java.io.IOException;

public class GameLogic {

    String userWordInputs = " ";
    int gameScore;
    int gameWordLength;
    int gameTimeLength;
    String gameWordJumble;
    DictionaryChecker d = new DictionaryChecker();

    public GameLogic (int wordLength, int timeLength) throws IOException
    {
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
