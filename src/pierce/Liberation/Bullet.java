package pierce.Liberation;

public class Bullet {
    public static int x, y;
    public int dx, dy;

    public Bullet() {
        dx = 2;
        dy = 0;//lowerOne(random.nextInt(4));
        x = 1337;//216;
        y = 300;
    }

    public void move() {
        x += dx;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
