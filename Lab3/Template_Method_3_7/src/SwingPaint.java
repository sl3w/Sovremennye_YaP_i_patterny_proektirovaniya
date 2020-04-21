import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SwingPaint {

    JButton closeBtn, startBtn;
    DrawArea drawArea;
    JComboBox jComboBox;
    ActionListener actionListener = new ActionListener() {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == closeBtn) {
                System.exit(0);
            } else if (e.getSource() == startBtn) {
                int k = jComboBox.getSelectedIndex();
                if (k == 0) drawArea.addCyrcle();
                if (k == 1) drawArea.addSquare();
                if (k == 2) drawArea.addStar();
            }
        }
    };

    public static void main(String[] args) {
        new SwingPaint().show();
    }

    public void show() {
        // create main frame
        JFrame frame = new JFrame("Swing Paint");
        Container content = frame.getContentPane();
        // set layout on content pane
        content.setLayout(new BorderLayout());
        // create draw area
        drawArea = new DrawArea();

        // add to content pane
        content.add(drawArea, BorderLayout.CENTER);

        // create controls to apply colors and call clear feature
        JPanel controls = new JPanel();

        startBtn = new JButton("Пуск");
        startBtn.addActionListener(actionListener);
        closeBtn = new JButton("Закрыть");
        closeBtn.addActionListener(actionListener);

        // add to content pane
        content.add(controls, BorderLayout.PAGE_START);
        jComboBox = new JComboBox(new String [] {"круг", "квадрат", "звезда"});

        jComboBox.setSelectedIndex(0);

        controls.add(jComboBox, BorderLayout.AFTER_LAST_LINE);
        frame.setSize(600, 400);
        // can close frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        controls.add(startBtn);
        controls.add(closeBtn);
        // show the swing paint result
        frame.setVisible(true);
        frame.setResizable(false);
    }
}