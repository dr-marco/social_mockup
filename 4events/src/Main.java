public class Main {
    public static void main(String args[]) {
        SoccerGame game = new SoccerGame();
        for (String field:game.getFields())
            System.out.println(field);
    }
}
