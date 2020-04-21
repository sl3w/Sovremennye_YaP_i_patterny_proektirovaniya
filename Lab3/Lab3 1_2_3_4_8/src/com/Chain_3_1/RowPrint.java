package com.Chain_3_1;

import com.interfaces.Vehicle;

import java.io.FileWriter;
import java.io.IOException;

public class RowPrint implements Chain {

    private Chain nextChain;

    @Override
    public void setNextChain(Chain chain) {
        this.nextChain = chain;
    }

    @Override
    public void write(Vehicle vehicle) {
        if (vehicle.getLength() <= 3){
            print(vehicle);
        } else  if (nextChain != null) {
            nextChain.write(vehicle);
        }
    }

    private void print(Vehicle vehicle){
        FileWriter nFile = null;
        try {
            nFile = new FileWriter("row.txt");
            nFile.write(vehicle.getNameModel() + " ");
            nFile.write(vehicle.getLength() + " ");
            String[] arrayNameModel =  vehicle.getNameModelArray();
            double[] arrayCostModel = vehicle.getCostModelArray();
            for (int i = 0; i < arrayNameModel.length; i++) {
                nFile.write(arrayNameModel[i] + " – ");
                nFile.write(arrayCostModel[i]+ " ");
            }
            nFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
