import javax.swing.*;

public class Main {

    public static void main (String[] args)
    {
        int w = 700;
        int h = 600;
        Semih semih = new Semih(w, h);
        JFrame frame = new JFrame("Bezier Curve");
        frame.add(semih);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
