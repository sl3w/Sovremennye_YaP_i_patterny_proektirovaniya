package osnov;

import java.awt.*;

public class F_square extends Figure {

    public F_square(Graphics2D g2) {
        super(g2);
    }

    @Override
    public void Ddraw() {
        g2.fillRect(x, y, width, height);
    }
}
