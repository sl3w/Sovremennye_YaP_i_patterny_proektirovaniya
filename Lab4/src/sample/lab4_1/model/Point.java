package sample.lab4_1.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Point {
    private double x;
    private double y;

    public Point(double x) {
        this.x = x;
        this.y = BigDecimal.valueOf(Math.pow(x, 3) + Math.sqrt(x)).setScale(3, RoundingMode.HALF_UP).doubleValue();
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
        this.y = BigDecimal.valueOf(Math.pow(x, 3) + Math.sqrt(x)).setScale(3, RoundingMode.HALF_UP).doubleValue();
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
