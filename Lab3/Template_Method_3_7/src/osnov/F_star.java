package osnov;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class F_star extends Figure {
    public F_star(Graphics2D g2) {
        super(g2);
    }

    private int xPoints[] = {18, 30, 0, 36, 6};
    private int yPoints[] = {0, 36, 12, 12, 36};

    public GeneralPath getStar() {
        GeneralPath star = new GeneralPath();

        star.moveTo(xPoints[0] + x, yPoints[0] + y);
        for (int i = 1; i < xPoints.length; i++) {
            star.lineTo(xPoints[i] + x, yPoints[i] + y);
        }
        star.closePath();
        return star;
    }

    @Override
    public void Ddraw() {
        g2.fill(getStar());
    }
}
