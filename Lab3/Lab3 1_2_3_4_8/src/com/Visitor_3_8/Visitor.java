package com.Visitor_3_8;

import com.Car;
import com.Motorcycle;

public interface Visitor {
    void visit(Car car);
    void visit(Motorcycle motorcycle);
}
