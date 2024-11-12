public class GameRunner {
    public static void main(String[] args) {

        GameLogic g = new GameLogic();
        DictionaryChecker d = new DictionaryChecker();
        System.out.println(g.WordScore(1, .2,"Gyat"));
        System.out.println(g.PossibleWord("where","rfewuihfiwhfuihwuifhuihweiuhw"));
        System.out.println(g.wordJumble(8,6));
        System.out.println(d.isAWord("dog"));
        d.jesusTakeTheKeyboard();


    }
}
