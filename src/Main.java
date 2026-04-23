public class Main {
    public static void main(String[] args) {
        Statistics statistics = new Statistics();
        Game game = new Game(statistics);
        new Grid(game, statistics);
    }
}
