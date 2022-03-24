import java.awt.*;

public class Handle extends Point {

    public Handle(double x, double y, int r) {
        super(x, y);
        this.r = r;
    }

    public Handle(Coordinates c, int r) {
        super(c);
        this.r = r;
    }

    @Override
    public void draw (Graphics2D g2) {
        g2.setColor(Color.white);
        super.draw(g2);
        g2.setColor(Color.black);
        g2.drawOval((int) c.x - r, (int) c.y - r, 2*r, 2*r);
    }

}
