public class GameRunner {
    public static void main(String[] args) {

        GameLogic g = new GameLogic();
        DictionaryChecker d = new DictionaryChecker();
        for (int i = 0;i !=10; i++)
        {
            System.out.println(g.wordJumble(i));
        }

        g.playGame(10,100);
    }
}
