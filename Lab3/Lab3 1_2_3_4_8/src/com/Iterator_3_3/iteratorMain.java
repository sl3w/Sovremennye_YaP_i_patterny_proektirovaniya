package com.Iterator_3_3;

import com.Car;
import java.util.Iterator;

public class iteratorMain {
    public static void main(String[] args) {
        Car car = new Car("Итератор",5 );
        Iterator iterator = car.iterator();
        System.out.print("Название авто: ");
        System.out.println(car.getNameModel());
        System.out.println("Модели:");
        while (iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }
    }
}
