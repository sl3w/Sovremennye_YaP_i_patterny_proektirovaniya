import java.awt.*;

public class RightEye implements Observer{
    private boolean flag = false;

    @Override
    public void handleEvent(int x, int y, Graphics2D g2) {
        if(x > 340 && x < 440 && y > 150 && y < 230){
            g2.setPaint(Color.white);
            g2.fillRect(320, 150, 120, 80); // очистка правого
            g2.setPaint(Color.blue);
            if(flag) {
                g2.drawOval(350, 160, 80, 60);// правый глаз
            } else {
                g2.drawLine(350, 190,430,190); //правый закрыт
            }
            flag = !flag;
        }
    }
}
