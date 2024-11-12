public class GameLogic {

    int Score;
    DictionaryChecker d = new DictionaryChecker();
    public GameLogic ()
    {
        Score = 0;
    }

    public int GetScore()
    {
        return Score;
    }
    public int WordScore (double rarityMultiplier, double lengthMultiplier, String word)
    {
        String letter;
        int wordScore = 0;
        for (int i = 0; i < word.length();i ++)
        {
            letter = (word.substring(i, i+1));
            letter = letter.toUpperCase();
            wordScore += ("ETAONRISHDLFCMUGYPWBVKJXZQ".indexOf(letter) ) * rarityMultiplier;
        }
        return wordScore +  (wordScore * (int) (word.length() * lengthMultiplier));
    }

    public boolean PossibleWord(String thisWord, String inThisWordQuestionMark)
    {
        boolean untilFalse;
        untilFalse = d.isAWord(thisWord);
        for (int i = 0; (i < thisWord.length()) && (untilFalse);i ++)
        {
            untilFalse = (inThisWordQuestionMark.contains(thisWord));

        }
        return untilFalse;
    }

    public String wordJumble (int length, double letterFrequency)
    {
        double allowedDegeneracy = 0;
        int whereAreYou = 0;
        String imInTheSoupStore = "";
        for (int i = 0; i <= length;i ++)
        {
            whereAreYou = (int) (Math.random() * 98);

//                if (whereAreYou > allowedDegeneracy)
//                {
//                    whereAreYou = allowedDegeneracy;
//                }


            //imInTheSoupStore += "ETAONRISHDLFCMUGYPWBVKJXZQ".charAt(Math.toIntExact(Math.round(whereAreYou)));
            imInTheSoupStore += "EEEEEEEEEEEEAAAAAAAAAIIIIIIIIIOOOOOOOONNNNNNRRRRRRTTTTTTLLLLSSSSUUUUDDDDGGGBBCCMMPPFFHHVVWWYYKJXQZ".charAt(whereAreYou);
            allowedDegeneracy += letterFrequency;
        }
        return imInTheSoupStore;
    }
}
