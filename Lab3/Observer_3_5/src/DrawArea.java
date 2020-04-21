import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.QuadCurve2D;

import javax.swing.JComponent;

public class DrawArea extends JComponent {
    private boolean falgF = true;

    public ObservedBoss getObserved() {
        return observed;
    }

    private ObservedBoss observed = new ObservedBoss();

    // Изображение, на котором мы будем рисовать
    private Image image;
    // Graphics2D объект ==> используется для рисования на
    private Graphics2D g2;
    // Координаты мыши
    private int currentX, currentY;

    public DrawArea() {
        setDoubleBuffered(false);
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                System.out.println("x:" + e.getX() + " y:" + e.getY());
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                currentX = e.getX();
                currentY = e.getY();

                if (g2 != null) {
                    observed.notifyObservers(currentX, currentY);
                    repaint();
                }
            }
        });
    }

    protected void paintComponent(Graphics g) {
        if (image == null) {
            // изображение, чтобы нарисовать ноль ==> мы создаем
            image = createImage(getSize().width, getSize().height);
            g2 = (Graphics2D) image.getGraphics();

            observed.setG2(g2);
            // enable antialiasing
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            // clear draw area
            clear();
        }
        g.drawImage(image, 0, 0, null);
        if (falgF) {
            falgF = false;

            g2.setStroke(new BasicStroke(10.0f));

            g2.setPaint(Color.green);
            // лицо
            g2.drawOval(100, 70, 400, 340);

            g2.setPaint(Color.blue);
            // левый глаз
            g2.drawOval(180, 160, 80, 60);
            // правый глаз
            g2.drawOval(350, 160, 80, 60);
            // нос
            g2.drawLine(300, 220, 300, 290);

            //рот
            g2.setPaint(Color.red);
            QuadCurve2D q5 = new QuadCurve2D.Float();
            q5.setCurve(220, 320, 300, 420, 380, 320);
            g2.draw(q5);
        }
        repaint();
    }

    public void clear() {
        g2.setPaint(Color.white);
        g2.fillRect(0, 0, getSize().width, getSize().height);
        g2.setPaint(Color.black);
        repaint();
    }
}