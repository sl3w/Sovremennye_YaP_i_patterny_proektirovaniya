package osnov;

import java.awt.*;

public class F_cyrcle extends Figure {
    public F_cyrcle(Graphics2D g2) {
        super(g2);
    }

    @Override
    public void Ddraw() {
        g2.fillOval(x, y, width, height);
    }
}
