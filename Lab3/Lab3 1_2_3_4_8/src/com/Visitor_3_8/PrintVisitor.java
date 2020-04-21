package com.Visitor_3_8;

import com.Car;
import com.Motorcycle;

public class PrintVisitor implements Visitor {
    @Override
    public void visit(Car car) {
        System.out.print("CarName: \"" + car.getNameModel() + "\" Models: ");
        String[] arrN = car.getNameModelArray();
        double[] arrD = car.getCostModelArray();
        for (int i = 0; i < arrN.length; i++) {
            System.out.print(" {" + arrN[i] + "___");
            System.out.print(arrD[i] + "}");
        }
    }

    @Override
    public void visit(Motorcycle motorcycle) {
        System.out.println("MotoName: \"" + motorcycle.getNameModel() + "\"");
        System.out.println("Models:");
        String[] arrN = motorcycle.getNameModelArray();
        double[] arrD = motorcycle.getCostModelArray();
        for (int i = 0; i < arrN.length; i++) {
            System.out.println(" {" + arrN[i] + "___" + arrD[i] + "}");
        }
    }
}
