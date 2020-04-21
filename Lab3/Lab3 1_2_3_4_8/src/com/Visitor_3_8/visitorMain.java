package com.Visitor_3_8;

import com.Car;
import com.Motorcycle;
import com.exception.DuplicateModelNameException;

public class visitorMain {
    public static void main(String[] args) throws DuplicateModelNameException {
        Car car = new Car("Машинка",3);
        car.accept(new PrintVisitor());
        System.out.println();
        System.out.println("==================================================================");
        Motorcycle motorcycle = new Motorcycle("Моцик",4);
        motorcycle.accept(new PrintVisitor());
    }
}
