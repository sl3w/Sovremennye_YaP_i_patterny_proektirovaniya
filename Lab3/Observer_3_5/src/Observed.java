import java.awt.*;

public interface Observed {
    void  addObserved(Observer o);
    void  notifyObservers(int x, int y);
}
