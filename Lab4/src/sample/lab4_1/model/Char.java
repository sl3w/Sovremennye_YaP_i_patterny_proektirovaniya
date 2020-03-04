package sample.lab4_1.model;

import java.util.ArrayList;
import java.util.Comparator;

public class Char {
    private static ArrayList<Point> graphic = new ArrayList<>();

    public static ArrayList<Point> getGraphic() {
        return graphic;
    }

    public static boolean addPoint(double x) {
        for (int i = 0; i < graphic.size(); i++) {
            if (graphic.get(i).getX() == x) {
                return false;
            }
        }

        graphic.add(new Point(x));
        graphic.sort(new Comparator<Point>(){
            @Override
            public int compare(Point point1, Point point2)
            {
                return  Double.compare(point1.getX(), point2.getX());
            }
        });
        return true;
    }

    public static void editPoint (double oldPoint, double newPoint){
        for (int i = 0; i < graphic.size(); i++) {
            if (graphic.get(i).getX() == oldPoint) {
                graphic.get(i).setX(newPoint);
            }
        }
    }

    public static void removePoint (Point point){
        graphic.remove(point);
    }
}
