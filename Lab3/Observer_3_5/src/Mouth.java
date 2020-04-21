import java.awt.*;
import java.awt.geom.QuadCurve2D;

public class Mouth implements Observer {
    private boolean flag = false;

    @Override
    public void handleEvent(int x, int y, Graphics2D g2) {
        if (x > 190 && x < 410 && y > 315 && y < 390) {
            g2.setPaint(Color.white);
            g2.fillRect(190, 300, 220, 77); // очистка рта
            g2.setPaint(Color.red);
            if (flag) {
                QuadCurve2D q5 = new QuadCurve2D.Float();
                q5.setCurve(220, 320, 300, 420, 380, 320);
                g2.draw(q5);
            } else {
                g2.drawLine(220, 350, 380, 350);
            }
            flag = !flag;
        }
    }
}
