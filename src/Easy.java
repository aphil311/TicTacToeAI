import java.util.Random;

public class Easy extends Player {
    public Easy(String s, int v, Board b, int c) {
        super(s, v, b, c);
    }

    public void move() {
        // not the most efficient algorithm but not an issue with a 3x3
        Random generator = new Random();
        int x = generator.nextInt(3);
        int y = generator.nextInt(3);
        while (board.getPos(x, y) != 0) {
            x = generator.nextInt(3);
            y = generator.nextInt(3);
        }
        board.setPos(x, y, val, icon);
    }
}
