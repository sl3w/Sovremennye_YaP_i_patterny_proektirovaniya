package osnov;

import java.awt.*;

public abstract class Figure {
    public int borderX = 583;
    public int borderY = 330;

    public int width = 25;
    public int height = 25;

    public int route = 0;

    public int x = borderX - width;
    public int y = borderY - height;

    public Graphics2D g2;

    public Figure(Graphics2D g2) {
        this.g2 = g2;
    }

    public abstract void Ddraw();

    public void draw() {

        Ddraw();

        if (route == 0) {
            x--;
            y--;
        } else if (route == 1) {
            x++;
            y--;
        } else if (route == 2) {
            x++;
            y++;
        } else if (route == 3) {
            x--;
            y++;
        }

        // смена направления
        //=============
        //0           1
        //
        //3           2
        //=============
        // углы
        if (x == 0 && y == 0) route = 2;
        else if (x + width == borderX && y == 0) route = 3;
        else if (x + width == borderX && y + height == borderY) route = 0;
        else if (x == borderX && y + height == borderY) route = 1;
            //грани
        else if (x == 0 && route == 0) route = 1;
        else if (x == 0 && route == 3) route = 2;

        else if (x + width == borderX && route == 1) route = 0;
        else if (x + width == borderX && route == 2) route = 3;

        else if (y == 0 && route == 0) route = 3;
        else if (y == 0 && route == 1) route = 2;

        else if (y + height == borderY && route == 3) route = 0;
        else if (y + height == borderY && route == 2) route = 1;
    }
}
