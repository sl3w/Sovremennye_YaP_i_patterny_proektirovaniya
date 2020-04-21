package com.Command_3_2;

import com.Car;

import java.io.FileWriter;

public interface Command {
    void execute(FileWriter fileWriter, Car car);
}
