import java.awt.*;
import java.util.ArrayList;

public class ObservedBoss implements Observed {
    private ArrayList<Observer> obsList = new ArrayList<>();
    private Graphics2D g2;

    public void setG2(Graphics2D g2) {
        this.g2 = g2;
    }

    @Override
    public void addObserved(Observer o) {
        obsList.add(o);
    }

    @Override
    public void notifyObservers(int x, int y) {
        for (Observer o : obsList) {
            o.handleEvent(x, y, this.g2);
        }
        System.out.println("Обсерверы уведомлены");
    }
}
