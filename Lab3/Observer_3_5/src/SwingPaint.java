import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class SwingPaint {
    DrawArea drawArea;

    public static void main(String[] args) {
        new SwingPaint().show();
    }

    public void show() {
        // create main frame
        JFrame frame = new JFrame("Observer");
        Container content = frame.getContentPane();
        // set layout on content pane
        content.setLayout(new BorderLayout());
        // create draw area
        drawArea = new DrawArea();

        drawArea.getObserved().addObserved(new Nose());
        drawArea.getObserved().addObserved(new Mouth());
        drawArea.getObserved().addObserved(new RightEye());
        drawArea.getObserved().addObserved(new LeftEye());

        // add to content pane
        content.add(drawArea, BorderLayout.CENTER);
        // create controls to apply colors and call clear feature

        frame.setSize(600, 500);
        // can close frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // show the swing paint result
        frame.setVisible(true);
        frame.setResizable(false);
    }
}