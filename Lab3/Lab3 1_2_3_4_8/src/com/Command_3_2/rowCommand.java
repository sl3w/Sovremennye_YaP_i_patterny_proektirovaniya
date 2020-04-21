package com.Command_3_2;

import com.Car;

import java.io.FileWriter;
import java.io.IOException;

public class rowCommand implements Command{
    @Override
    public void execute(FileWriter nFile, Car car) {
        try {
            nFile.write(car.getNameModel() + " ");
            nFile.write(car.getLength() + " ");
            String[] arrayNameModel =  car.getNameModelArray();
            double[] arrayCostModel = car.getCostModelArray();
            for (int i = 0; i < arrayNameModel.length; i++) {
                nFile.write("[Model: " + arrayNameModel[i] + " - ");
                nFile.write("Price: " + arrayCostModel[i]+ "] ");
            }
            nFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
