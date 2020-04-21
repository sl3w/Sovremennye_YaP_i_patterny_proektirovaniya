import java.awt.*;

public class LeftEye implements Observer {
    private boolean flag = false;

    @Override
    public void handleEvent(int x, int y, Graphics2D g2) {
        if (x > 170 && x < 270 && y > 150 && y < 230) {
            g2.setPaint(Color.white);
            g2.fillRect(150, 150, 120, 80); // очистка левого
            g2.setPaint(Color.blue);
            if (flag) {
                g2.drawOval(180, 160, 80, 60);// левые глаз
            } else {
                g2.drawLine(180, 190, 260, 190); //левый закрыт
            }
            flag = !flag;
        }
    }
}
