package sample.lab4_2;

import sample.lab4_2.model.Auto;

public interface DAO {
    public void write(Auto car);

    public Auto read();
}
