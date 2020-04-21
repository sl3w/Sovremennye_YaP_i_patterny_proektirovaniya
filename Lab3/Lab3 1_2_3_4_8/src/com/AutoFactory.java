package com;

import com.interfaces.TransportFactory;
import com.interfaces.Vehicle;

public class AutoFactory implements TransportFactory {
    public Vehicle createInstance(String nameModel, int length){
        return new Car(nameModel, length);
    }
}
