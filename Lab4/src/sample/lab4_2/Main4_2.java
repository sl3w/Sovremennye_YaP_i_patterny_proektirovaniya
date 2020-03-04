package sample.lab4_2;

import sample.lab4_2.exceptions.DuplicateModelNameException;
import sample.lab4_2.model.Auto;

import java.io.IOException;

public class Main4_2 {
    public static void main(String[] args) throws IOException, DuplicateModelNameException {
        Auto car = new Auto("carDao", 5);

        System.out.println("-------------------TEXT-------------------");
        DAO txtData = new TextData();
        txtData.write(car);
        Auto car2 = txtData.read();
        System.out.println(car2.toString());

        System.out.println("-----------------SERIALIZE----------------");
        DAO fileData = new SerializeData();
        fileData.write(car);
        car2 = fileData.read();
        System.out.println(car2.toString());
    }
}
