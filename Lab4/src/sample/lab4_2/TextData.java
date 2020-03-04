package sample.lab4_2;

import sample.lab4_2.exceptions.DuplicateModelNameException;
import sample.lab4_2.model.Auto;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TextData implements DAO {
    public void write(Auto car) {
        try {
            FileWriter fileWriter = new FileWriter("auto.txt");

            fileWriter.write(car.getMarka() + "\n");
            fileWriter.write(car.getModelsCount() + "\n");
            String[] arrayNameModel = car.getModelsNameArray();
            double[] arrayCostModel = car.getPricesArray();
            int modelsCount = car.getModelsCount();
            for (int i = 0; i < modelsCount; i++) {
                fileWriter.write(arrayNameModel[i] + "\n");
                fileWriter.write(arrayCostModel[i] + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Auto read() {
        try {
            FileReader fileReader = new FileReader("auto.txt");
            Scanner scan = new Scanner(fileReader);

            String marka = scan.nextLine();
            int modelsCount = Integer.parseInt(scan.nextLine());
            Auto car = new Auto(marka);
            for (int i = 0; i < modelsCount; i++) {
                String modelName = scan.nextLine();
                double price = Double.parseDouble(scan.nextLine());
                car.addNewModel(modelName, price);
            }

            fileReader.close();
            return car;
        } catch (DuplicateModelNameException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
