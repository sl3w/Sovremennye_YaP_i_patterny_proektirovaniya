import java.awt.*;

public class Nose implements Observer {
    private boolean flag = false;

    @Override
    public void handleEvent(int x, int y, Graphics2D g2) {
        if (x > 290 && x < 310 && y > 210 && y < 295) {
            if (flag) {
                g2.setPaint(Color.blue);
            } else g2.setPaint(Color.red);
            flag = !flag;
            g2.drawLine(300, 220, 300, 290);
        }
    }
}
