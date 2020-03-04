package sample.lab4_2;

import sample.lab4_2.model.Auto;

import java.io.*;

public class SerializeData implements DAO {
    public void write(Auto car) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("auto"))) {
            oos.writeObject(car);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Auto read() {
        Auto car = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("auto"))) {
            car = (Auto) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return car;
    }
}
