public class Coordinates {

    public double x, y;

    public Coordinates(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Coordinates(Coordinates c) {
        x = c.x;
        y = c.y;
    }

}
