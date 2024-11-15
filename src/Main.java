//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {



        GameLogic g = new GameLogic(3,3);
        Boolean d = g.PossibleWord("XXX", "asdsadsad");
        System.out.println(d);
    }
}