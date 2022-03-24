import java.awt.*;

public class Anchor extends Point{

    public Anchor(double x, double y, int r) {
        super(x, y);
        this.r = r;
    }

    public Anchor(Coordinates c, int r) {
        super(c);
        this.r = r;
    }

}
