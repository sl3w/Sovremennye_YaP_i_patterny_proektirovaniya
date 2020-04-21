import osnov.F_cyrcle;
import osnov.F_square;
import osnov.F_star;
import osnov.Figure;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JComponent;

/**
 * Component for drawing !
 *
 * @author sylsau
 *
 */
public class DrawArea extends JComponent {
    private Image image;
    private Graphics2D g2;

    private ArrayList<Figure> arrayList= new ArrayList<>();

    public DrawArea() {
        setDoubleBuffered(false);
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                System.out.println("x:" + e.getX() + " y:" +e.getY());
            }
        });
    }

    protected void paintComponent(Graphics g) {
        if (image == null) {
            // image to draw null ==> we create
            image = createImage(getSize().width, getSize().height);
            g2 = (Graphics2D) image.getGraphics();
            g2.setPaint(Color.blue);
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            clear();

            new Thread(() -> {
                try {
                    while (true){
                        Thread.sleep(3);
                        clear();
                        try{
                            for (Figure o: arrayList){
                                o.draw();
                            }
                        } catch (Exception e){
                        }
                        repaint();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        g.drawImage(image, 0, 0, null);
    }
    Random random = new Random();
    public void clear() {
        g2.setPaint(Color.white);
        g2.fillRect(0, 0, getSize().width, getSize().height);

        switch (random.nextInt(3)) {
            case 0:
                g2.setPaint(Color.blue);
                break;
            case 1:
                g2.setPaint(Color.green);
                break;
            case 2:
                g2.setPaint(Color.red);
                break;
            case 3:
                g2.setPaint(Color.yellow);
                break;
        }
    }

    public void addSquare() {
        arrayList.add(new F_square(g2));
    }
    public void addCyrcle() {
        arrayList.add(new F_cyrcle(g2));
    }
    public void addStar() {
        arrayList.add(new F_star(g2));
    }
}