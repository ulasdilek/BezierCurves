import javax.swing.*;
import java.awt.*;

public class Semih extends JPanel {

    BezierCurve bezierCurve;

    public Semih(int width, int height) {
        setPreferredSize(new Dimension(width, height));
        Coordinates[] anchors = new Coordinates[] { new Coordinates(10, 10 ),
                                                    new Coordinates(300,40 ),
                                                    new Coordinates(200,150),
                                                    new Coordinates(290,290)};
        Coordinates[] handles = new Coordinates[] { new Coordinates(100,0),
                                                    new Coordinates(250,15),
                                                    new Coordinates(320,65),
                                                    new Coordinates(200,50),
                                                    new Coordinates(200,190),
                                                    new Coordinates(320,361)};
//        Coordinates[] handles = new Coordinates[] { new Coordinates(100,0),
//                                                    new Coordinates(250,15),
//                                                    new Coordinates(320,65),
//                                                    new Coordinates(200,50),
//                                                    new Coordinates(200,190),
//                                                    new Coordinates(400,26),
//                                                    new Coordinates(146,189),
//                                                    new Coordinates(320,361)};
        bezierCurve = new BezierCurve(anchors, handles, 5, 200);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.black);
        g2.setStroke(new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        bezierCurve.draw(g2);
    }

}
