package com.Command_3_2;

import com.Car;

import java.io.FileWriter;
import java.io.IOException;

public class columCommand implements Command{
    @Override
    public void execute(FileWriter nFile, Car car) {
        try {
            nFile.write(car.getNameModel() + "\n");
            nFile.write(car.getLength() + "\n");
            String[] arrayNameModel =  car.getNameModelArray();
            double[] arrayCostModel = car.getCostModelArray();
            for (int i = 0; i < arrayNameModel.length; i++) {
                nFile.write("Model: " + arrayNameModel[i] + "\n");
                nFile.write("Price: " + arrayCostModel[i]+ "\n");
            }
            nFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
