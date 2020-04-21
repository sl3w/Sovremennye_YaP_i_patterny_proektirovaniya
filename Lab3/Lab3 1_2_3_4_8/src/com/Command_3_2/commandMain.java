package com.Command_3_2;

import com.Car;

import java.io.FileWriter;
import java.io.IOException;

public class commandMain {
    public static void main(String[] args) throws IOException {
        Car car = new Car("Машинка",3);
        car.setPrintCommand(new rowCommand());
        FileWriter nFile = new FileWriter("rowCommand.txt");
        FileWriter nFile2 = new FileWriter("columnCommand.txt");
        car.print(nFile);
        car.setPrintCommand(new columCommand());
        car.print(nFile2);
    }
}
