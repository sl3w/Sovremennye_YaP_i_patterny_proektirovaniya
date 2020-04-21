package com.Memento_3_4;

import com.Car;
import com.exception.DuplicateModelNameException;
import com.exception.NoSuchModelNameException;

public class mementoMain {
    public static void main(String[] args) throws DuplicateModelNameException, NoSuchModelNameException {
        Car car = new Car("Машинка", 2);
        System.out.println(car.toString());
        System.out.println("================================================");
        Car.Memento memento = new Car.Memento();
        car.createMemento(memento);
        car.setNameModel("Новая машинка");
        car.addModel("super", 50);
        car.setNewNameModel("Model_1", "Model_99");

        System.out.println(car.toString());
        System.out.println("================================================");
        car.setMemento(memento);
        System.out.println(car.toString());
    }
}
