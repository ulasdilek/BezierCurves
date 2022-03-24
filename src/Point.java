import java.awt.*;

public class Point {

    public static final int DEFAULT_R = 2;

    public int r;
    public Coordinates c;

    public Point(double x, double y) {
        r = DEFAULT_R;
        c = new Coordinates(x, y);
    }

    public Point(Coordinates c) {
        r = DEFAULT_R;
        this.c = c;
    }

    public void draw(Graphics2D g2) {
        g2.fillOval((int) c.x - r, (int) c.y - r, 2*r, 2*r);
    }

}
