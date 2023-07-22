import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Location location = new Location() {
            @Override
            public boolean isDead() {
                return false;
            }
        };
        Game game = new Game();
        game.login();
    }
}