package com.Chain_3_1;

import com.interfaces.Vehicle;

import java.io.FileWriter;
import java.io.IOException;

public class ColumPrint implements Chain {
    private Chain nextChain;

    @Override
    public void setNextChain(Chain chain) {
        this.nextChain = chain;
    }

    @Override
    public void write(Vehicle vehicle) {
        if (vehicle.getLength() > 3){
            print(vehicle);
        } else if (nextChain != null) {
            nextChain.write(vehicle);
        }
    }

    private void print(Vehicle vehicle){
        FileWriter nFile = null;
        try {
            nFile = new FileWriter("colum.txt");
            nFile.write(vehicle.getNameModel() + "\n");
            nFile.write(vehicle.getLength() + "\n");
            String[] arrayNameModel =  vehicle.getNameModelArray();
            double[] arrayCostModel = vehicle.getCostModelArray();
            for (int i = 0; i < arrayNameModel.length; i++) {
                nFile.write(arrayNameModel[i] + "\n");
                nFile.write(arrayCostModel[i]+ "\n");
            }
            nFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
