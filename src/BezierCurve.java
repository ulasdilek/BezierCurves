import java.awt.*;
import java.util.ArrayList;

public class BezierCurve {

    double step;
    ArrayList<Point> points;
    Anchor[] anchors;
    Handle[] handles;

    public BezierCurve(Coordinates anchorA, Coordinates anchorB, Coordinates handleA, Coordinates handleB, int r, int accuracy ){
        anchors = new Anchor[] {new Anchor(anchorA, r), new Anchor(anchorB, r)};
        handles = new Handle[] {new Handle(handleA, r), new Handle(handleB, r)};
        setPoints();
        step = 1.0 / accuracy;
    }

    public BezierCurve(Coordinates[] anchors, Coordinates[] handles, int r, int accuracy ){
        if (anchors.length > 1 && handles.length >= 2 * (anchors.length - 1)) {
            this.anchors = new Anchor[anchors.length];
            this.handles = new Handle[handles.length];
            for (int i = 0; i < anchors.length - 1; i++) {
                this.anchors[i] = new Anchor (anchors[i], r);
                this.handles[2 * i] = new Handle (handles[2 * i], r);
                this.handles[2 * i + 1] = new Handle (handles[2 * i + 1], r);
            }
            this.anchors[anchors.length - 1] = new Anchor (anchors[anchors.length - 1], r);
            step = 1.0 / accuracy;
            setPoints();
        }
        else {
            System.err.println("anchors[] must have length L greater than 1 and handles[] must have length greater than 2(L-1)");
        }
    }

    public void setPoints() {
        points = new ArrayList<>();
        for(int i = 0; i < anchors.length - 1; i++) { // I need to skip the first and the last handles
            for (double t = 0; t <= 1; t += step) {
                Coordinates a = lerp(anchors[i    ].c, handles[i*2  ].c, t);

                Coordinates b = lerp(handles[i * 2].c, handles[i * 2 + 1].c, t);


                Coordinates c = lerp(handles[i * 2 + 1].c, anchors[i + 1].c, t);

                points.add(new Point (lerp(lerp(a, b, t), lerp(b, c, t), t)));
            }
        }
    }

    public void draw(Graphics2D g2) {
        g2.drawLine((int) anchors[0].c.x, (int) anchors[0].c.y, (int) handles[0].c.x, (int) handles[0].c.y);
        for (int i = 1; i < anchors.length - 1; i++) {
            g2.drawLine((int) anchors[i].c.x, (int) anchors[i].c.y, (int) handles[2*i - 1].c.x, (int) handles[2*i - 1].c.y);
            g2.drawLine((int) anchors[i].c.x, (int) anchors[i].c.y, (int) handles[2*i].c.x, (int) handles[2*i].c.y);
        }
        g2.drawLine((int) anchors[anchors.length - 1].c.x, (int) anchors[anchors.length - 1].c.y, (int) handles[2 * anchors.length - 3].c.x, (int) handles[2 * anchors.length - 3].c.y);
        for (Point  point  : points ) {
            point.draw(g2);
        }
        for (Handle handle : handles) {
            handle.draw(g2);
        }
        for (Anchor anchor : anchors) {
            anchor.draw(g2);
        }
    }

    private Coordinates lerp(Coordinates c1, Coordinates c2, double t) {
        return new Coordinates(c1.x + (c2.x - c1.x) * t , c1.y + (c2.y - c1.y) * t);
    }

}
